package agentBackend.soap;

import agentBackend.dto.AddvertismentDTO;
import agentBackend.dto.ImageDTO;
import agentBackend.dto.ReservedDateDTO;
import agentBackend.model.Pricelist;
import agentBackend.model.SoapAddSync;
import agentBackend.model.SoapPriceListSync;
import agentBackend.repository.SoapAddSyncRepository;
import agentBackend.repository.SoapPriceListRepository;
import agentBackend.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.ArrayList;
import java.util.List;

public class PriceListClient extends WebServiceGatewaySupport {


    @Autowired
    private SoapPriceListRepository priceListRepository;

    public PricelistResponse createPriceList(Pricelist pricelist)  {

        PricelistRequest request = new PricelistRequest();
        PricelistSoap pricelistSoap = new PricelistSoap();
        pricelistSoap.setId(pricelist.getId());
        pricelistSoap.setDailyPrice(pricelist.getDailyPrice());
        pricelistSoap.setCdwPrice(pricelist.getDailyPrice());
        pricelistSoap.setDiscount(pricelist.getDiscount());
        pricelistSoap.setOverlimitPrice(pricelist.getOverlimitPrice());
        pricelistSoap.setNumberOfDays(pricelist.getNumberOfDays());
        pricelistSoap.setUsername(pricelist.getUsername());
        request.setPricelist(pricelistSoap);

        PricelistResponse response = (PricelistResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://add-service:8087/ws/add-schema", request,
                        new SoapActionCallback("http://add-service:8087/ws/add-schema/pricelistRequest"));


        this.saveSyncPriceList(response.getMsId(), response.getAgentId());
        return response;
    }
    public void deletePriceList(Long id)  {

       DeletepricelistRequest request = new DeletepricelistRequest();

       SoapPriceListSync sync = priceListRepository.findByAgentAppId(id);
       request.setMsId(sync.getMsAppId());
       priceListRepository.delete(sync);

      getWebServiceTemplate().marshalSendAndReceive("http://add-service:8087/ws/add-schema", request,
                        new SoapActionCallback("http://add-service:8087/ws/add-schema/deletepricelistRequest"));
    }




    public void saveSyncPriceList (Long ms_id, Long agent_id){
        SoapPriceListSync sync = new SoapPriceListSync();
        sync.setAgentAppId(agent_id);
        sync.setMsAppId(ms_id);
        priceListRepository.save(sync);
    }


}
