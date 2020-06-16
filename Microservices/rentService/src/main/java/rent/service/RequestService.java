package rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import rent.dto.PurchaseDTO;
import rent.dto.RequestDTO;
import rent.model.Purchase;
import rent.model.Request;
import rent.repository.PurchaseRepository;
import rent.repository.RequestRepository;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


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
        purchase.setOwner(p.getOwner());
        purchase.setBrand_model(p.getBrand_model());
        return purchase;
    }

    public Request createBundleRequest(List<PurchaseDTO> purchases){

        Request request = new Request();
        request.setStatus("PENDING");
        for (PurchaseDTO p : purchases){
            Purchase purchase = this.createPurchase(p);
            purchase.setRequest(request);
            purchaseRepository.save(purchase);

        }
        requestRepository.save(request);
        return request;
    }

    public ArrayList<Request> createRequest(List<PurchaseDTO> purchases){

        ArrayList<Request> requests = new ArrayList();
        List<Purchase> purchasesForRequest = new ArrayList();
        for (PurchaseDTO p : purchases){
            Request request = new Request();
            request.setStatus("PENDING");
            Purchase purchase = this.createPurchase(p);
            purchase.setRequest(request);
            purchasesForRequest.add(purchase);
            //request.setPurchaseList(purchasesForRequest);
            purchaseRepository.save(purchase);
            requestRepository.save(request);
            requests.add(request);
        }
        return requests;
    }
    public void  deleteRequest (Long id){
        Request request = requestRepository.findById(id).orElse(null);
        if (request == null){
            throw new NoSuchElementException();
        }
        requestRepository.deleteById(id);
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

	public ArrayList<RequestDTO> getAllRequestsFrom(String username) {
		// TODO Auto-generated method stub
        List<Request> requests = new ArrayList<>();
        requests = requestRepository.findAll();
        ArrayList<RequestDTO> requestDTOS = new ArrayList<>();
        for(Request r : requests){
        	if(username.equals(r.getPurchaseList().get(0).getOwner())){
        		requestDTOS.add(new RequestDTO(r));
        	}
        }
        return  requestDTOS;	}

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

        for (Purchase purchaseAccepted : request.purchaseList) {
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
        for (Purchase purchase : request.purchaseList) {
			purchase.setOrdered(false);
	        purchaseRepository.save(purchase);
		}
        requestRepository.save(request);
	}
}