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
    
    public boolean verify(String username) throws NotFoundException {
        if (!this.companyRepository.existsByUsername(username)) {
            return false;
        }
        return true;

    }
}
