package user.service;

import java.util.List;

import javax.xml.bind.ValidationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import user.dto.UserDTO;
import user.model.User;
import user.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
    public boolean verify(String email) throws NotFoundException {
        if (!this.userRepository.existsByEmail(email)) {
            return false;
        }

        return true;
    }

	public void registerUser(UserDTO userDTO) throws ValidationException {
		// TODO Auto-generated method stub
        List<User> userList = userRepository.findAll();
        for(User u: userList){
            if(u.getEmail().equals(userDTO.getEmail())){
                throw new ValidationException("User with this email already exists!");
            }
        }

        User user = new User(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setNumber_of_addvertisment(0);
        userRepository.save(user);
	}
}
