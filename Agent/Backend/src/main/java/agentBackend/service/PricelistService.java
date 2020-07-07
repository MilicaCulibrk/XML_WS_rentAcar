package agentBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agentBackend.dto.GradeDTO;
import agentBackend.model.Grade;
import agentBackend.model.Pricelist;
import agentBackend.repository.PricelistRepository;
@Service
public class PricelistService {

	@Autowired
	private PricelistRepository pricelistRepository;
	
	public List<Pricelist> getAllPricelists() {
		// TODO Auto-generated method stub
		return pricelistRepository.findAll();
	}

	public Pricelist createPricelist(Pricelist pricelist) {
		// TODO Auto-generated method stub
		return null;
	}

}
