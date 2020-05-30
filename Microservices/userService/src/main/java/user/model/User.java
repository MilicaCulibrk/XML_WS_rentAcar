package user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.*;

@Entity(name="user_entity")
public class User {
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
}
