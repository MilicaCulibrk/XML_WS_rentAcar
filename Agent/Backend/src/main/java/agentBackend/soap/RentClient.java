package agentBackend.soap;
import agentBackend.dto.PurchaseDTO;
import agentBackend.model.SoapAddSync;
import agentBackend.model.SoapRentSync;
import agentBackend.repository.SoapAddSyncRepository;
import agentBackend.repository.SoapRentSyncRepository;
import agentBackend.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.ArrayList;
import java.util.List;


public class RentClient  extends WebServiceGatewaySupport {

    @Autowired
    private SoapRentSyncRepository rentSyncRepository;

    @Autowired
    private SoapAddSyncRepository addSyncRepository;

    public OrderResponse getOrder(List<PurchaseDTO> purchaseDTOList, boolean bundle, ArrayList<Long> agentRequestId) {

        OrderRequest request = new OrderRequest();
        for (PurchaseDTO purchaseDTO : purchaseDTOList){
            request.getPurchaseList().add(this.cratePuchaseForSoap(purchaseDTO));
        }
        request.setBundle(bundle);
        request.getAgentRequestId().addAll(agentRequestId);
        OrderResponse response = (OrderResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8084/ws/request-schema", request,
                        new SoapActionCallback(
                                "http://localhost:8084/ws/request-schema/orderRequest"));

        for (int i=0; i< agentRequestId.size(); i++){
            SoapRentSync sync = new SoapRentSync();
            sync.setAgentApp_id(agentRequestId.get(i));
            sync.setMsApp_id(response.getMsRequestId().get(i));
            rentSyncRepository.save(sync);
        }
        return response;
    }
    public void editStatus(Long agent_id, String status) {

        EditStatusRequest request = new EditStatusRequest();
        List<SoapRentSync> sync = rentSyncRepository.findAll();
        Long ms_id = null;
        for (SoapRentSync s : sync){
            if (s.getAgentApp_id().equals(agent_id)){
                ms_id = s.getMsApp_id();
            }
        }
        request.setMsId(ms_id);
        request.setStatus(status);
        getWebServiceTemplate().marshalSendAndReceive("http://localhost:8084/ws/request-schema", request,
                        new SoapActionCallback("http://localhost:8084/ws/request-schema/orderRequest"));
        //return response;
    }
    public Purchase cratePuchaseForSoap (PurchaseDTO purchaseDTO){

        Purchase purchase = new Purchase();

        List<SoapAddSync> soapAddSyncs = addSyncRepository.findAll();
        for (SoapAddSync sync : soapAddSyncs){
            if (sync.getAgentApp_id().equals(purchaseDTO.getId_add())){
                purchase.setIdAdd(sync.getMsApp_id());
            }
        }
        purchase.setClient(purchaseDTO.getClient());
        purchase.setOwner(purchaseDTO.getOwner());

        purchase.setDateFrom(purchaseDTO.getDate_from());
        purchase.setDateTo(purchaseDTO.getDate_to());
        purchase.setBrandModel(purchaseDTO.getBrand_model());
        return purchase;
    }
}
