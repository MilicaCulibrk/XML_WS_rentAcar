package user.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserDTO {

    private String name;
    
    private String surname;
    private String username;

    private String email;
    
        private String password;
    
        private String address;
    
        private String city;
    
       private String phone_number;
       private Boolean active;
	public UserDTO(String name, String surname, String email, String password, String address, String city,
			String phone_number) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;

		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.phone_number = phone_number;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
       
       
}
