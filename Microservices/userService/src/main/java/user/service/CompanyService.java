package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import user.dto.CompanyDTO;
import user.dto.UserDTO;
import user.model.Company;
import user.model.User;
import user.repository.CompanyRepository;


import javax.xml.bind.ValidationException;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
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

    public void registerCompany(CompanyDTO companyDTO) throws ValidationException {

        List<Company> companyList = companyRepository.findAll();
        for(Company c: companyList){
            if(c.getUsername().equals(companyDTO.getUsername())){
                throw new ValidationException("Company with this username already exists!");
            }
        }

        Company company = newDTOtoReal(companyDTO);
        companyRepository.save(company);
    }

    public Company newDTOtoReal(CompanyDTO dto){
        Company real = new Company();
        real.setName(dto.getName());
        real.setEmail(dto.getEmail());
        real.setUsername(dto.getUsername());
        real.setPassword(passwordEncoder.encode(dto.getPassword()));
        real.setAddress(dto.getAddress());
        real.setCity(dto.getCity());
        real.setPhone_number(dto.getPhone_number());
        real.setCompany_number(dto.getCompany_number());
        return real;
    }
}
