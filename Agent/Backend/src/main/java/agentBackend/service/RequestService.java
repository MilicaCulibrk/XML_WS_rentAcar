package agentBackend.service;

import agentBackend.dto.PurchaseDTO;
import agentBackend.dto.RequestDTO;
import agentBackend.model.Purchase;
import agentBackend.model.Request;
import agentBackend.repository.PurchaseRepository;
import agentBackend.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;


    public Purchase createPurchase(PurchaseDTO p){

        Purchase purchase = new Purchase();
        purchase.setDate_from(p.getDate_from());
        purchase.setDate_to(p.getDate_to());
        purchase.setId_add(p.getId_add());
        purchase.setOrdered(false);
        purchase.setClient(p.getClient());
        purchase.setOwner("ss");
        purchase.setBrand_model(p.getBrand_model());
        return purchase;
    }

    public Request createBundleRequest(List<PurchaseDTO> purchases){

        Request request = new Request();
        request.setStatus("PENDING");
        requestRepository.save(request);
        for (PurchaseDTO p : purchases){
            Purchase purchase = this.createPurchase(p);
            purchase.setRequest(request);
            purchaseRepository.save(purchase);
        }

        return request;
    }

    public ArrayList<Request> createRequest(List<PurchaseDTO> purchases){

        ArrayList<Request> requests = new ArrayList();
        List<Purchase> purchasesForRequest = new ArrayList();
        for (PurchaseDTO p : purchases){
            Request request = new Request();
            request.setStatus("PENDING");
            Request request1 = requestRepository.save(request);
            Purchase purchase = this.createPurchase(p);
            purchase.setRequest(request1);
            purchase.setOwner("ss");
            purchasesForRequest.add(purchase);
            purchaseRepository.save(purchase);
            requests.add(request1);
        }
        return requests;
    }
    public void  deleteRequest (Long id){
        Request request = requestRepository.findById(id).orElse(null);
        if (request == null){
            throw new NoSuchElementException();
        }
        for (Purchase p : request.getPurchaseList()) {
			purchaseRepository.delete(p);
		}
        requestRepository.delete(request);
    }

    public ArrayList<RequestDTO> getAllRequests(){
        List<Request> requests = new ArrayList<>();
        requests = requestRepository.findAll();
        ArrayList<RequestDTO> requestDTOS = new ArrayList<>();
        for(Request r : requests){
            requestDTOS.add(new RequestDTO(r));
        }
        return  requestDTOS;
    }

    public RequestDTO getRequest(Long id){
        Request request = requestRepository.findById(id).orElse(null);
        if (request == null){
            throw new NoSuchElementException();
        }
        return new RequestDTO(request);
    }


	public ArrayList<RequestDTO> getAllRequestsTo(String username) {
		// TODO Auto-generated method stub
        List<Request> requests = new ArrayList<>();
        requests = requestRepository.findAll();
        ArrayList<RequestDTO> requestDTOS = new ArrayList<>();
        for(Request r : requests){
        	if(username.equals(r.getPurchaseList().get(0).getOwner())){
        		requestDTOS.add(new RequestDTO(r));
        	}
        }
        return  requestDTOS;	
    }

	
	public ArrayList<RequestDTO> getAllRequestsFrom(String username) {
		// TODO Auto-generated method stub
        List<Request> requests = new ArrayList<>();
        requests = requestRepository.findAll();
        ArrayList<RequestDTO> requestDTOS = new ArrayList<>();
        for(Request r : requests){
        	if(username.equals(r.purchaseList.get(0).getClient())){
        		requestDTOS.add(new RequestDTO(r));
        	}
        }
        return  requestDTOS;
    }

    public void updateRequest(Long id) throws ParseException {
        // TODO Auto-generated method stub
        Request request = requestRepository.findById(id).orElse(null);
        if (request == null){
            throw new NoSuchElementException();
        }
        request.setStatus("PAID");
        requestRepository.save(request);

        // !!!!!!!!!!!!! takodje je potrebno pristupiti tom oglasu i staviti zauzete datume iz requesta !!!!!!!!!!!!!!!!!!!!!!!!


        ArrayList<Long> ids = new ArrayList<>();
        List<Purchase> purchaseList = purchaseRepository.findAllByRequest(request);
        for (Purchase purchaseAccepted : purchaseList) {
            purchaseAccepted.setOrdered(true);
            purchaseRepository.save(purchaseAccepted);

            Date startDateAccepted = new SimpleDateFormat("yyyy-MM-dd").parse(purchaseAccepted.getDate_from());
            Date endDateAccepted = new SimpleDateFormat("yyyy-MM-dd").parse(purchaseAccepted.getDate_to());
            List<Purchase> purchases = new ArrayList<>();
            purchases = purchaseRepository.findByIdAdd(purchaseAccepted.getId_add());
            for (Purchase purchase : purchases) {
                if(!purchase.getOrdered()) {
                    Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(purchase.getDate_from());
                    Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(purchase.getDate_to());
                    if (!((startDate.before(startDateAccepted) && endDate.before(startDateAccepted)) || (startDate.after(endDateAccepted) && endDate.after(endDateAccepted)))) {
                        ids.add(purchase.getRequest().getId());
                    }
                }
            }
        }

        for (Long long1 : ids) {
            if(!long1.equals(request.getId())){
                Request requestDecline  =  requestRepository.findById(long1).get();
                requestDecline.setStatus("CANCELED");
                requestRepository.save(requestDecline);
            }
        }

    }

    public void updateDeclineRequest(Long id) {
        // TODO Auto-generated method stub
        Request request = requestRepository.findById(id).orElse(null);
        if (request == null){
            throw new NoSuchElementException();
        }
        request.setStatus("CANCELED");
        List<Purchase> purchaseList = purchaseRepository.findAllByRequest(request);
        for (Purchase purchase : purchaseList) {
            purchase.setOrdered(false);
            purchaseRepository.save(purchase);
        }
        requestRepository.save(request);
    }
}

