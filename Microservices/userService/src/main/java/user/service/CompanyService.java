package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import user.model.Company;
import user.repository.CompanyRepository;


import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    
    public boolean verify(String username) throws NotFoundException {
        if (!this.companyRepository.existsByUsername(username)) {
            return false;
        }
        return true;

    }

    public List<Company> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies;
    }
}
