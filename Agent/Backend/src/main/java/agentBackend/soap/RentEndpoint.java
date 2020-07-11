package agentBackend.soap;





import agentBackend.dto.PurchaseDTO;
import agentBackend.model.Request;
import agentBackend.model.SoapAddSync;
import agentBackend.model.SoapRentSync;
import agentBackend.repository.SoapAddSyncRepository;
import agentBackend.repository.SoapRentSyncRepository;
import agentBackend.service.RequestService;
import localhost._8081.request_schema.EditStatusRequest;
import localhost._8081.request_schema.OrderRequest;
import localhost._8081.request_schema.OrderResponse;
import localhost._8081.request_schema.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class RentEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8081/request-schema";

    @Autowired
    private RequestService requestService;

    @Autowired
    private SoapRentSyncRepository repository;

    @Autowired
    private SoapAddSyncRepository addSyncRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "orderRequest")
    @ResponsePayload
    public OrderResponse getCountry(@RequestPayload OrderRequest request) {


        OrderResponse response = new OrderResponse();
        List<PurchaseDTO> purchaseDTOList = new ArrayList<>();
        for (Purchase purchase : request.getPurchaseList()) {
            purchaseDTOList.add(this.createDTO(purchase));
        }

        if (request.isBundle()) {
            Request request1 = requestService.createBundleRequest(purchaseDTOList);
            response.getAgentRequestId().add(request1.getId());
        } else {
            ArrayList<Request> requests = requestService.createRequest(purchaseDTOList);
            for (Request r : requests) {
                response.getAgentRequestId().add(r.getId());
            }
        }
        for (int i = 0; i < request.getMsRequestId().size(); i++) {
            SoapRentSync sync = new SoapRentSync();
            sync.setAgentApp_id(response.getAgentRequestId().get(i));
            sync.setMsApp_id(request.getMsRequestId().get(i));
            repository.save(sync);
        }
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "editStatusRequest")
    @ResponsePayload
    public void setStatus(@RequestPayload EditStatusRequest request) throws ParseException {
        //EditStatusResponse response = new EditStatusResponse();
        if (request.getStatus().equals("ACCEPT")) {
            requestService.updateRequest(request.getAgentId());
        } else {
            requestService.updateDeclineRequest(request.getAgentId());
        }
        //   return response;
    }


    public PurchaseDTO createDTO(Purchase purchase) {

        PurchaseDTO purchaseDTO = new PurchaseDTO();
        List<SoapAddSync> soapAddSyncs = addSyncRepository.findAll();
        for (SoapAddSync sync : soapAddSyncs) {
            if (sync.getMsApp_id().equals(purchase.getIdAdd())) {
                purchaseDTO.setId_add(sync.getAgentApp_id());
            }
        }

            purchaseDTO.setClient(purchase.getClient());
            purchaseDTO.setOwner(purchase.getOwner());
            purchaseDTO.setOrdered(purchase.isOrdered());
            purchaseDTO.setDate_from(purchase.getDateFrom());
            purchaseDTO.setDate_to(purchase.getDateTo());
            purchaseDTO.setBrand_model(purchase.getBrandModel());
            return purchaseDTO;
       }
}