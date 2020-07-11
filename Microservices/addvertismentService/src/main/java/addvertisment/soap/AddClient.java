package addvertisment.soap;


import addvertisment.dto.AddvertismentDTO;
import addvertisment.dto.ImageDTO;
import addvertisment.dto.ReservedDateDTO;
import addvertisment.model.SoapAddSync;
import addvertisment.repository.SoapAddSyncRepository;
import agentBackend.wsdl.Add;
import agentBackend.wsdl.AddMSRequest;
import agentBackend.wsdl.AddMSResponse;
import agentBackend.wsdl.PricelistSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.ArrayList;
import java.util.List;

public class AddClient extends WebServiceGatewaySupport {

    @Autowired
    private SoapAddSyncRepository repository;

    public AddMSResponse createAdd(AddvertismentDTO addvertismentDTO)  {

        AddMSRequest request = new AddMSRequest();
        Add add = new Add();
        List<String> images = new ArrayList<>();
        for (ImageDTO imageDTO : addvertismentDTO.getImages()){
            add.getImages().add(imageDTO.getUrl());
        }
        List<String> dates = new ArrayList<>();
        for (ReservedDateDTO date : addvertismentDTO.getArrayEvents()){
            add.getReservedDates().add(date.getOneDate());
        }
        add.setId(addvertismentDTO.getId());
        add.setAddvertiserId(addvertismentDTO.getAddvertiser_id());
        add.setBrandId(addvertismentDTO.getBrand_id());
        add.setCdw(addvertismentDTO.isCdw());
        add.setChildSeats(addvertismentDTO.getChild_seats());
        add.setFuelTypeId(addvertismentDTO.getFuel_type_id());
        add.setTransmissionTypeId(addvertismentDTO.getTransmission_type_id());
        add.setVehicleClassId(addvertismentDTO.getVehicle_class_id());
        add.setVehicleModelId(addvertismentDTO.getVehicle_model_id());
        add.setLocation(addvertismentDTO.getLocation());
        add.setMileage(addvertismentDTO.getMileage());
        add.setMileageLimit(addvertismentDTO.getMileage_limit());
        add.setPrice(addvertismentDTO.getPrice());
        add.setPriceListId(addvertismentDTO.getPricelist().getId());
        request.setAdd(add);
       // request.setFuelTypeName(fuelTypeDTO.getFuel_type_name());
        AddMSResponse response = (AddMSResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://agent:8081/ws/add-schema", request,
                        new SoapActionCallback("http://agent:8081/ws/add-schema/addMSRequest"));

        this.saveSync(response.getMsId(), response.getAgentId());
        return response;
    }



    public void saveSync (Long ms_id, Long agent_id){
        SoapAddSync soapAddSync = new SoapAddSync();
        soapAddSync.setAgentAppId(agent_id);
        soapAddSync.setMsAppId(ms_id);
        repository.save(soapAddSync);
    }
}
