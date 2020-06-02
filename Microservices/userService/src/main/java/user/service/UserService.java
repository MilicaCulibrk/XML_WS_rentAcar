package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import user.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean verify(String email) throws NotFoundException {
        if (!this.userRepository.existsByEmail(email)) {
            return false;
        }

        return true;
    }
}
