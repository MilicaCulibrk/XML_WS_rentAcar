package rent.soap;

import localhost._8084.request_schema.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.dto.PurchaseDTO;
import rent.model.Request;
import rent.model.SoapRentSync;
import rent.repository.SoapRentSyncRepository;
import rent.service.RequestService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class RentEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8084/request-schema";

    @Autowired
    private RequestService requestService;

    @Autowired
    private SoapRentSyncRepository repository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "orderRequest")
    @ResponsePayload
    public OrderResponse getCountry(@RequestPayload OrderRequest request) {


        OrderResponse response = new OrderResponse();
        List<PurchaseDTO> purchaseDTOList = new ArrayList<>();
        for (Purchase purchase : request.getPurchaseList()){
            purchaseDTOList.add(this.createDTO(purchase));
        }

        if (request.isBundle()){
            Request request1 = requestService.createBundleRequest(purchaseDTOList);
            response.getMsRequestId().add(request1.getId());
        } else{
            ArrayList<Request> requests = requestService.createRequest(purchaseDTOList);
            for (Request r : requests){
                response.getMsRequestId().add(r.getId());
            }
        }
        for (int i=0; i<request.getAgentRequestId().size(); i++){
            SoapRentSync sync = new SoapRentSync();
            sync.setAgentApp_id(request.getAgentRequestId().get(i));
            sync.setMsApp_id(response.getMsRequestId().get(i));
            repository.save(sync);
        }
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "editStatusRequest")
    @ResponsePayload
    public void setStatus(@RequestPayload EditStatusRequest request) throws ParseException {
        //EditStatusResponse response = new EditStatusResponse();
        if (request.getStatus().equals("ACCEPT")){
              requestService.updateRequest(request.getMsId());
        }else {
            requestService.updateDeclineRequest(request.getMsId());
        }
     //   return response;
    }


    public PurchaseDTO createDTO (Purchase purchase){

        PurchaseDTO purchaseDTO =  new PurchaseDTO();
        //purchaseDTO.setId(purchase.getId());
        purchaseDTO.setClient(purchase.getClient());
        purchaseDTO.setId_add(purchase.getIdAdd());
        purchaseDTO.setOwner("ss");
        purchaseDTO.setOrdered(purchase.isOrdered());
        purchaseDTO.setDate_from(purchase.getDateFrom());
        purchaseDTO.setDate_to(purchase.getDateTo());
        purchaseDTO.setBrand_model(purchase.getBrandModel());
        return purchaseDTO;
    }
}
