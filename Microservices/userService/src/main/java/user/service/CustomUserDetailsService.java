package user.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import user.model.Administrator;
import user.model.Company;
import user.model.User;
import user.repository.AdministratorRepository;
import user.repository.CompanyRepository;
import user.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	protected final Log LOGGER = LogFactory.getLog(getClass());
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	AdministratorRepository administratorRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(username);
		Company c = companyRepository.findByEmail(username);
		Administrator admin = administratorRepository.findByEmail(username);
		
		if(user!= null) {
			return user;
		} else if(c!= null) {
			return c;
		} else if(admin!= null) {
			return admin;
		} else
		return null;
	}
}
