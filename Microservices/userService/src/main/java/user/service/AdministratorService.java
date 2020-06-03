package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import user.repository.AdministratorRepository;
import user.repository.UserRepository;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;
    
    public boolean verify(String email) throws NotFoundException {
        if (!this.administratorRepository.existsByEmail(email)) {
            return false;
        }
        return true;

    }
}
