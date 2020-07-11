package rent.soap;



import agentBackend.wsdl.EditStatusRequest;
import agentBackend.wsdl.OrderRequest;
import agentBackend.wsdl.OrderResponse;
import agentBackend.wsdl.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import rent.dto.PurchaseDTO;
import rent.model.SoapRentSync;
import rent.repository.SoapRentSyncRepository;

import java.util.ArrayList;
import java.util.List;

public class RentClient extends WebServiceGatewaySupport {


    @Autowired
    private SoapRentSyncRepository rentSyncRepository;


    public OrderResponse getOrder(List<PurchaseDTO> purchaseDTOList, boolean bundle, ArrayList<Long> msRequestId) {

        OrderRequest request = new OrderRequest();
     //   ArrayList<Long> msRequestIdForSS = new ArrayList<>();
        for (PurchaseDTO purchaseDTO : purchaseDTOList){
            request.getPurchaseList().add(this.cratePuchaseForSoap(purchaseDTO));

        }
        request.setBundle(bundle);
        request.getMsRequestId().addAll(msRequestId);
        OrderResponse response = (OrderResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://agent:8081/ws/request-schema", request,
                        new SoapActionCallback(
                                "http://agent:8081/ws/request-schema/orderRequest"));

        for (int i=0; i< msRequestId.size(); i++){
            SoapRentSync sync = new SoapRentSync();
            sync.setMsApp_id(msRequestId.get(i));
            sync.setAgentApp_id(response.getAgentRequestId().get(i));
            rentSyncRepository.save(sync);
        }
        return response;
    }
    public void editStatus(Long ms_id, String status) {

        EditStatusRequest request = new EditStatusRequest();
        List<SoapRentSync> sync = rentSyncRepository.findAll();
        Long agent_id = null;
        for (SoapRentSync s : sync){
            if (s.getMsApp_id().equals(ms_id)){
                agent_id = s.getAgentApp_id();
            }
        }
        request.setAgentId(agent_id);
        request.setStatus(status);
        getWebServiceTemplate().marshalSendAndReceive("http://agent:8081/ws/request-schema", request,
                new SoapActionCallback("http://agent:8081/ws/request-schema/orderRequest"));
        //return response;
    }
    public Purchase cratePuchaseForSoap (PurchaseDTO purchaseDTO){

        Purchase purchase = new Purchase();

        purchase.setIdAdd(purchaseDTO.getId_add());
        purchase.setClient(purchaseDTO.getClient());
        purchase.setOwner(purchaseDTO.getOwner());
        purchase.setDateFrom(purchaseDTO.getDate_from());
        purchase.setDateTo(purchaseDTO.getDate_to());
        purchase.setBrandModel(purchaseDTO.getBrand_model());
        return purchase;
    }
}
