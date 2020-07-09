package addvertisment.soap;

import addvertisment.dto.AddvertismentDTO;
import addvertisment.dto.ImageDTO;
import addvertisment.dto.ReservedDateDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.Pricelist;
import addvertisment.model.SoapAddSync;
import addvertisment.model.SoapPriceListSync;
import addvertisment.repository.SoapAddSyncRepository;
import addvertisment.repository.SoapPriceListRepository;
import addvertisment.service.AddvertismentService;
import addvertisment.service.PricelistService;
import localhost._8087.add_schema.AddRequest;
import localhost._8087.add_schema.AddResponse;
import localhost._8087.pricelist_schema.PricelistRequest;
import localhost._8087.pricelist_schema.PricelistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;


@Endpoint
public class PriceListEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8087/priceList-schema";

    // private CountryRepository countryRepository;
    @Autowired
    private PricelistService pricelistService;

    @Autowired
    private SoapPriceListRepository repository;


   /* @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pricelistRequest")
    @ResponsePayload
    public PricelistResponse getCountry(@RequestPayload PricelistRequest request) {
        PricelistResponse response = new PricelistResponse();
        //napravi dto i prosledi servisu sta traba

        Pricelist pricelist = new Pricelist();
        pricelist.setDailyPrice(request.getPricelist().getDailyPrice());
        pricelist.setOverlimitPrice(request.getPricelist().getOverlimitPrice());
        pricelist.setCdwPrice(request.getPricelist().getCdwPrice());
        pricelist.setDiscount(request.getPricelist().getDiscount());
        pricelist.setNumberOfDays(request.getPricelist().getNumberOfDays());
        pricelist.setUsername(request.getPricelist().getUsername());



        //sacuvaj sinhronizaciju
       // this.saveSync(addvertisment.getId(), request.getAdd().getId() );

       // response.setMsId(addvertisment.getId());
      //  response.setAgentId(request.getAdd().getId());
        return response;
    }
    public void saveSync (Long ms_id, Long agent_id){
        SoapPriceListSync sync = new SoapPriceListSync();
        sync.setAgentApp_id(agent_id);
        sync.setMsApp_id(ms_id);
        repository.save(sync);
    }*/
}
