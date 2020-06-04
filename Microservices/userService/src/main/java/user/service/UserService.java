package user.service;

import java.util.List;
import java.util.Optional;

import javax.xml.bind.ValidationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

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
        if (!this.userRepository.existsById(Long.parseLong(email))) {
            return false;
        }

        return true;
    }
    public boolean verifyL(String email) throws NotFoundException {
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
	
    public List<User> getAllUsers() {
        //List<User> fuelTypesDTOlist = new ArrayList<>();
        List<User> users = userRepository.findAll();
      //  for (User user : u) {
       //     fuelTypesDTOlist.add(new FuelTypeDTO(fuelType));
       // }
        return users;
    }

	public void deleteUser(Long id) throws ValidationException {
		// TODO Auto-generated method stub
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()){
            throw new ValidationException("Fuel type with that id doesn't exist!");
        }

        userRepository.delete(user.get());
	}
}
