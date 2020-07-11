package agentBackend.soap;


import agentBackend.dto.AddvertismentDTO;
import agentBackend.dto.ImageDTO;
import agentBackend.dto.ReservedDateDTO;
import agentBackend.model.Addvertisment;
import agentBackend.model.Pricelist;
import agentBackend.model.SoapAddSync;
import agentBackend.model.SoapPriceListSync;
import agentBackend.repository.AddvertismentRepository;
import agentBackend.repository.PricelistRepository;
import agentBackend.repository.SoapAddSyncRepository;
import agentBackend.repository.SoapPriceListRepository;
import agentBackend.service.AddvertismentService;
import agentBackend.service.PricelistService;
import localhost._8081.add_schema.AddMSRequest;
import localhost._8081.add_schema.AddMSResponse;
import localhost._8081.add_schema.PricelistMSRequest;
import localhost._8081.add_schema.PricelistMSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;

@Endpoint
public class AddEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8081/add-schema";

    // private CountryRepository countryRepository;
    @Autowired
    private AddvertismentService addvertismentService;

    @Autowired
    private SoapAddSyncRepository repository;

    @Autowired
    private PricelistService pricelistService;

    @Autowired
    private SoapPriceListRepository priceListRepository;

    @Autowired
    private PricelistRepository realpricelistRepository;

    @Autowired
    private AddvertismentRepository addvertismentRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addMSRequest")
    @ResponsePayload
    public AddMSResponse getCountry(@RequestPayload AddMSRequest request) {
        AddMSResponse response = new AddMSResponse();
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
        SoapPriceListSync sync = priceListRepository.findByAgentAppId(request.getAdd().getPriceListId());
        Pricelist pricelist = realpricelistRepository.findById(sync.getMsAppId()).orElse(null);
        addvertismentDTO.setOwner(request.getAdd().getAddvertiserId());
        addvertismentDTO.setPricelist(pricelist);
        addvertismentDTO.setTransmission_type_id(request.getAdd().getTransmissionTypeId());
        addvertismentDTO.setVehicle_model_id(request.getAdd().getVehicleModelId());
        addvertismentDTO.setVehicle_class_id(request.getAdd().getVehicleClassId());
        addvertismentDTO.setFuel_type_id(request.getAdd().getFuelTypeId());
        addvertismentDTO.setBrand_id(request.getAdd().getBrandId());
        addvertismentDTO.setDaily_price(request.getAdd().getPrice());
        addvertismentDTO.setLocation(request.getAdd().getLocation());
        addvertismentDTO.setCdw(request.getAdd().isCdw());
        addvertismentDTO.setMileage_limit(request.getAdd().getMileageLimit());
        addvertismentDTO.setMileage(request.getAdd().getMileage());
        addvertismentDTO.setChild_seats(request.getAdd().getChildSeats());
        Addvertisment addvertisment =  addvertismentService.createAddvertisment(addvertismentDTO);

        this.saveSync(addvertisment.getId(), request.getAdd().getId() );

        response.setAgentId(addvertisment.getId());
        response.setMsId(request.getAdd().getId());
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pricelistMSRequest")
    @ResponsePayload
    public PricelistMSResponse getPriceList(@RequestPayload PricelistMSRequest request) {
        PricelistMSResponse response = new PricelistMSResponse();
        //napravi dto i prosledi servisu sta traba

        Pricelist pricelist = new Pricelist();
        pricelist.setDailyPrice(request.getPricelist().getDailyPrice());
        pricelist.setOverlimitPrice(request.getPricelist().getOverlimitPrice());
        pricelist.setCdwPrice(request.getPricelist().getCdwPrice());
        pricelist.setDiscount(request.getPricelist().getDiscount());
        pricelist.setNumberOfDays(request.getPricelist().getNumberOfDays());
        pricelist.setUsername(request.getPricelist().getUsername());
        Pricelist pricelist1 = pricelistService.createPricelistSoap(pricelist);

        this.saveSyncPriceList(pricelist1.getId(), request.getPricelist().getId() );

        response.setMsId(pricelist1.getId());
        response.setAgentId(request.getPricelist().getId());
        return response;
    }
    public void saveSyncPriceList (Long ms_id, Long agent_id){
        SoapPriceListSync sync = new SoapPriceListSync();
        sync.setAgentAppId(agent_id);
        sync.setMsAppId(ms_id);
        priceListRepository.save(sync);
    }

    public void saveSync (Long ms_id, Long agent_id){
        SoapAddSync soapAddSync = new SoapAddSync();
        soapAddSync.setAgentApp_id(agent_id);
        soapAddSync.setMsApp_id(ms_id);
        repository.save(soapAddSync);
    }
}
