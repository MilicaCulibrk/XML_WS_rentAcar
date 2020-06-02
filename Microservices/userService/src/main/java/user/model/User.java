package user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import user.dto.UserDTO;

import java.util.Collection;

import javax.persistence.*;

@Entity(name="user_entity")
public class User implements UserDetails{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "surname", nullable = true)
    private String surname;
    
    @Column(name = "email", nullable = true)
    private String email;
    
    @Column(name = "password", nullable = true)
        private String password;
    
    @Column(name = "address", nullable = true)
        private String address;
    
    @Column(name = "city", nullable = true)
        private String city;
    
    @Column(name = "phone_number", nullable = true)
       private String phone_number;
    
    //max number of published ads is 3
    @Column(name = "number_of_addvertisment", nullable = true)
        private int number_of_addvertisment;

    
    
    public User(Long id, String name, String surname, String email, String password, String address, String city,
			String phone_number, int number_of_addvertisment) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.phone_number = phone_number;
		this.number_of_addvertisment = number_of_addvertisment;
	}
    
    public User(UserDTO user) {
		super();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.address = user.getAddress();
		this.city = user.getCity();
		this.phone_number = user.getPhone_number();
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

/*    public String getPassword() {
        return password;
    }*/

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getNumber_of_addvertisment() {
        return number_of_addvertisment;
    }

    public void setNumber_of_addvertisment(int number_of_addvertisment) {
        this.number_of_addvertisment = number_of_addvertisment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
}
