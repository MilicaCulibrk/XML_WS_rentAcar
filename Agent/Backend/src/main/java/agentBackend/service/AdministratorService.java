package agentBackend.service;

import agentBackend.repository.AdministratorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public boolean verify(String username) throws NotFoundException {
        if (!this.administratorRepository.existsByUsername(username)) {
            return false;
        }
        return true;

    }

}
