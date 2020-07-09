package addvertisment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import addvertisment.model.Addvertisment;
import addvertisment.model.Pricelist;
import addvertisment.repository.AddvertismentRepository;
import addvertisment.repository.PricelistRepository;

@Service
public class PricelistService {

	@Autowired
	private PricelistRepository pricelistRepository;
    @Autowired
    private AddvertismentRepository addvertismentRepository;
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
        pricelistRepository.save(p);
        for (Addvertisment add : addvertismentRepository.findAll()) {
			if (add.getPriceList().getId().equals(p.getId())){
				add.setPriceList(p);
				add.setPrice(p.getDailyPrice());
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
			if(add.priceList.getId().equals(id))
				addvertismentRepository.deleteById(add.getId());
		}
		pricelistRepository.deleteById(id);
		return pricelistRepository.findAll();
	}

}
