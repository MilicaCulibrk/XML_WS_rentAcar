package addvertisment.soap;

import addvertisment.dto.AddvertismentDTO;
import addvertisment.dto.ImageDTO;
import addvertisment.dto.ReservedDateDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.Pricelist;
import addvertisment.model.SoapAddSync;
import addvertisment.model.SoapPriceListSync;
import addvertisment.repository.AddvertismentRepository;
import addvertisment.repository.PricelistRepository;
import addvertisment.repository.SoapAddSyncRepository;
import addvertisment.repository.SoapPriceListRepository;
import addvertisment.service.AddvertismentService;
import addvertisment.service.PricelistService;
import localhost._8087.add_schema.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Endpoint
public class AddEndPoint {
    private static final String NAMESPACE_URI = "http://localhost:8087/add-schema";

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
        SoapPriceListSync sync = priceListRepository.findByAgentAppId(request.getAdd().getPriceListId());
        Pricelist pricelist = realpricelistRepository.findById(sync.getMsAppId()).orElse(null);
        addvertismentDTO.setAddvertiser_id(request.getAdd().getAddvertiserId());
        addvertismentDTO.setPricelist(pricelist);
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


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pricelistRequest")
    @ResponsePayload
    public PricelistResponse getPriceList(@RequestPayload PricelistRequest request) {
        PricelistResponse response = new PricelistResponse();
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
/*    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "editAddRequest")
    @ResponsePayload
    public void editAdd(@RequestPayload EditAddRequest request) throws ValidationException {

        SoapAddSync sync = repository.findByAgentAppId(request.getAdd().getId());
        SoapPriceListSync priceListSync = priceListRepository.findByAgentAppId(request.getPriceList().getId());

        Pricelist pricelist = new Pricelist();
        pricelist.setId(priceListSync.getMsAppId());
        pricelist.setDailyPrice(request.getPriceList().getDailyPrice());
        pricelist.setOverlimitPrice(request.getPriceList().getOverlimitPrice());
        pricelist.setCdwPrice(request.getPriceList().getCdwPrice());
        pricelist.setDiscount(request.getPriceList().getDiscount());
        pricelist.setNumberOfDays(request.getPriceList().getNumberOfDays());
        pricelist.setUsername(request.getPriceList().getUsername());


        AddvertismentDTO addvertismentDTO = new AddvertismentDTO();
        addvertismentDTO.setId(sync.getMsAppId());
        addvertismentDTO.setAddvertiser_id(request.getAdd().getAddvertiserId());
        addvertismentDTO.setPricelist(pricelist);
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

        this.addvertismentService.updateAddvertisment(addvertismentDTO);
    }*/
   /* @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletepricelistRequest")
    @ResponsePayload
    public void deletePriceList(@RequestPayload DeletepricelistRequest request) {

        //napravi dto i prosledi servisu sta traba
        SoapPriceListSync sync = priceListRepository.findByMsAppId(request.getMsId());
        System.out.println("BROOOJ IDDD" + request.getMsId() );
        Pricelist p = realpricelistRepository.findById(request.getMsId()).get();
        if (p == null){
            throw new NoSuchElementException();
        }
        this.realpricelistRepository.delete(p);
        this.priceListRepository.delete(sync);
    }*/
    public void saveSyncPriceList (Long ms_id, Long agent_id){
        SoapPriceListSync sync = new SoapPriceListSync();
        sync.setAgentAppId(agent_id);
        sync.setMsAppId(ms_id);
        priceListRepository.save(sync);
    }

    public void saveSync (Long ms_id, Long agent_id){
        SoapAddSync soapAddSync = new SoapAddSync();
        soapAddSync.setAgentAppId(agent_id);
        soapAddSync.setMsAppId(ms_id);
        repository.save(soapAddSync);
    }
}
