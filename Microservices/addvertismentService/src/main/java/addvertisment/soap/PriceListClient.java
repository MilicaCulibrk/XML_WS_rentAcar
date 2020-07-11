package addvertisment.soap;

import addvertisment.model.Pricelist;
import addvertisment.model.SoapPriceListSync;
import addvertisment.repository.SoapPriceListRepository;
import agentBackend.wsdl.PricelistMSRequest;
import agentBackend.wsdl.PricelistMSResponse;
import agentBackend.wsdl.PricelistSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class PriceListClient extends WebServiceGatewaySupport {


    @Autowired
    private SoapPriceListRepository priceListRepository;

    public PricelistMSResponse createPriceList(Pricelist pricelist)  {

        PricelistMSRequest request = new PricelistMSRequest();
        PricelistSoap pricelistSoap = new PricelistSoap();
        pricelistSoap.setId(pricelist.getId());
        pricelistSoap.setDailyPrice(pricelist.getDailyPrice());
        pricelistSoap.setCdwPrice(pricelist.getDailyPrice());
        pricelistSoap.setDiscount(pricelist.getDiscount());
        pricelistSoap.setOverlimitPrice(pricelist.getOverlimitPrice());
        pricelistSoap.setNumberOfDays(pricelist.getNumberOfDays());
        pricelistSoap.setUsername(pricelist.getUsername());
        request.setPricelist(pricelistSoap);

        PricelistMSResponse response = (PricelistMSResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://agent:8081/ws/add-schema", request,
                        new SoapActionCallback("http://agent:8081/ws/add-schema/pricelistMSRequest"));


        this.saveSyncPriceList(response.getMsId(), response.getAgentId());
        return response;
    }

    public void saveSyncPriceList (Long ms_id, Long agent_id){
        SoapPriceListSync sync = new SoapPriceListSync();
        sync.setAgentAppId(agent_id);
        sync.setMsAppId(ms_id);
        priceListRepository.save(sync);
    }


}
