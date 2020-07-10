package agentBackend.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agentBackend.model.Addvertisment;
import agentBackend.model.Pricelist;
import agentBackend.repository.AddvertismentRepository;
import agentBackend.repository.PricelistRepository;
@Service
public class PricelistService {

	@Autowired
	private PricelistRepository pricelistRepository;
	
    @Autowired
    private AddvertismentRepository addvertismentRepository;

    @Autowired
    private AddvertismentService addvertismentService;

	private Pricelist pricelistSoap;


	public Pricelist getPricelistSoap() {
		return pricelistSoap;
	}

	public void setPricelistSoap(Pricelist pricelistSoap) {
		this.pricelistSoap = pricelistSoap;
	}

	public List<Pricelist> getAllPricelists() {
		// TODO Auto-generated method stub
		return pricelistRepository.findAll();
	}


	public List<Pricelist> createPricelist(Pricelist pricelist) {
		// TODO Auto-generated method stub
		Pricelist p;

		try{
			p = pricelistRepository.findById(pricelist.getId()).get();

		} catch (Exception e) {
			p = new Pricelist();
		}
        p.setCdwPrice(pricelist.getCdwPrice());
        p.setDailyPrice(pricelist.getDailyPrice());
        p.setDiscount(pricelist.getDiscount());
        p.setNumberOfDays(pricelist.getNumberOfDays());
        p.setOverlimitPrice(pricelist.getOverlimitPrice());
        p.setUsername(pricelist.getUsername());
        this.pricelistSoap = pricelistRepository.save(p);
        for (Addvertisment add : addvertismentRepository.findAll()) {
			if (add.getPricelist().getId().equals(p.getId())){
				add.setPricelist(p);
				add.setDaily_price(p.getDailyPrice());
				addvertismentRepository.save(add);
			}
		}
        return pricelistRepository.findAll();
	}


	public List<Pricelist> deletePricelist(Long id) {
		// TODO Auto-generated method stub
		Pricelist p = pricelistRepository.findById(id).get();
        if (p == null){
            throw new NoSuchElementException();
        }
        for (Addvertisment add : addvertismentRepository.findAll()) {
			if(add.pricelist.getId().equals(id)) {
				try {
					addvertismentService.deleteAddvertisment(add.getId());
				} catch (ValidationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		pricelistRepository.deleteById(id);
		return pricelistRepository.findAll();
	}

}
