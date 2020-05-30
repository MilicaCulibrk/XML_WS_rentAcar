package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import user.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public boolean verify(String email) throws NotFoundException {
        if (!this.userRepository.existsByEmail(email)) {
            throw new NotFoundException("Consumer with that id does not exist!");
        }

        return true;
    }
}
