package addvertisment.soap;

import addvertisment.dto.AddvertismentDTO;
import addvertisment.dto.ImageDTO;
import addvertisment.dto.ReservedDateDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.SoapAddSync;
import addvertisment.repository.SoapAddSyncRepository;
import addvertisment.service.AddvertismentService;
import localhost._8087.add_schema.AddRequest;
import localhost._8087.add_schema.AddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;

@Endpoint
public class AddEndPoint {
    private static final String NAMESPACE_URI = "http://localhost:8087/add-schema";

   // private CountryRepository countryRepository;
    @Autowired
    private AddvertismentService addvertismentService;

    @Autowired
    private SoapAddSyncRepository repository;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addRequest")
    @ResponsePayload
    public AddResponse getCountry(@RequestPayload AddRequest request) {
        AddResponse response = new AddResponse();
        AddvertismentDTO addvertismentDTO = new AddvertismentDTO();
        addvertismentDTO.setImages(new ArrayList<>());
        for (String image : request.getAdd().getImages()){
            ImageDTO imageDTO = new ImageDTO();
            imageDTO.setUrl(image);
            addvertismentDTO.getImages().add(imageDTO);
        }
        addvertismentDTO.setArrayEvents(new ArrayList<>());
        for (String date : request.getAdd().getReservedDates()){
            ReservedDateDTO dateDTO =  new ReservedDateDTO();
            dateDTO.setOneDate(date);
            addvertismentDTO.getArrayEvents().add(dateDTO);
        }
        addvertismentDTO.setAddvertiser_id(request.getAdd().getAddvertiserId());
        addvertismentDTO.setTransmission_type_id(request.getAdd().getTransmissionTypeId());
        addvertismentDTO.setVehicle_model_id(request.getAdd().getVehicleModelId());
        addvertismentDTO.setVehicle_class_id(request.getAdd().getVehicleClassId());
        addvertismentDTO.setFuel_type_id(request.getAdd().getFuelTypeId());
        addvertismentDTO.setBrand_id(request.getAdd().getBrandId());
        addvertismentDTO.setPrice(request.getAdd().getPrice());
        addvertismentDTO.setLocation(request.getAdd().getLocation());
        addvertismentDTO.setCdw(request.getAdd().isCdw());
        addvertismentDTO.setMileage_limit(request.getAdd().getMileageLimit());
        addvertismentDTO.setMileage(request.getAdd().getMileage());
        addvertismentDTO.setChild_seats(request.getAdd().getChildSeats());
        Addvertisment addvertisment =  addvertismentService.createAddvertisment(addvertismentDTO);

        this.saveSync(addvertisment.getId(), request.getAdd().getId() );

        response.setMsId(addvertisment.getId());
        response.setAgentId(request.getAdd().getId());
        return response;
    }
    public void saveSync (Long ms_id, Long agent_id){
        SoapAddSync soapAddSync = new SoapAddSync();
        soapAddSync.setAgentApp_id(agent_id);
        soapAddSync.setMsApp_id(ms_id);
        repository.save(soapAddSync);
    }
}
