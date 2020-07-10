package agentBackend.soap;

import agentBackend.dto.AddvertismentDTO;
import agentBackend.dto.ImageDTO;
import agentBackend.dto.ReservedDateDTO;
import agentBackend.model.ReservedDate;
import agentBackend.model.SoapAddSync;
import agentBackend.repository.SoapAddSyncRepository;
import agentBackend.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.ArrayList;
import java.util.List;

public class AddClient extends WebServiceGatewaySupport {

    @Autowired
    private SoapAddSyncRepository repository;

    public AddResponse createAdd(AddvertismentDTO addvertismentDTO)  {

        AddRequest request = new AddRequest();
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
        add.setAddvertiserId(addvertismentDTO.getOwner());
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
        add.setPrice(addvertismentDTO.getDaily_price());
        add.setPriceListId(addvertismentDTO.getPricelist().getId());
        request.setAdd(add);
       // request.setFuelTypeName(fuelTypeDTO.getFuel_type_name());
        AddResponse response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8087/ws/add-schema", request,
                        new SoapActionCallback("http://localhost:8087/ws/add-schema/addRequest"));

        this.saveSync(response.getMsId(), response.getAgentId());
        return response;
    }
    public void saveSync (Long ms_id, Long agent_id){
        SoapAddSync soapAddSync = new SoapAddSync();
        soapAddSync.setAgentApp_id(agent_id);
        soapAddSync.setMsApp_id(ms_id);
        repository.save(soapAddSync);
    }
}
