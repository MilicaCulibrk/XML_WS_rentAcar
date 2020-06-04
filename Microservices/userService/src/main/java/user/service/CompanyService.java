package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import user.repository.CompanyRepository;
import user.repository.UserRepository;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    
    public boolean verify(String email) throws NotFoundException {
        if (!this.companyRepository.existsById(Long.parseLong(email))) {
            return false;
        }
        return true;
    }
    public boolean verifyL(String email) throws NotFoundException {
        if (!this.companyRepository.existsByEmail(email)) {
            return false;
        }
        return true;

    }
}
