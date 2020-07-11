
package agentBackend.model;

import agentBackend.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity(name="user_entity")
public class User implements UserDetails {
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

   @Column(name = "username", nullable = false)
   private String username;

   @Column(name = "email", nullable = true)
   private String email;

   @Column(name = "active", nullable = true)
   private Boolean active;

   @Column(name = "password", nullable = true)
   private String password;

   @Column(name = "address", nullable = true)
   private String address;

   @Column(name = "city", nullable = true)
   private String city;

   @Column(name = "phone_number", nullable = true)
   private String phone_number;

   @Column(name = "number_of_addvertisment", nullable = true)
   private int number_of_addvertisment;

   /*
   public java.util.List<Order> order;
   public java.util.Collection<Grade> grade;
   public java.util.Collection<Comment> comment;
   public java.util.Collection<PriceList> priceList;

    */

   public User(Long id, String name, String surname, String email, String password, String address, String city,
               String phone_number, int number_of_addvertisment, Boolean active) {
      super();
      this.id = id;
      this.name = name;
      this.surname = surname;
      this.username = username;
      this.email = email;
      this.password = password;
      this.address = address;
      this.city = city;
      this.phone_number = phone_number;
      this.number_of_addvertisment = number_of_addvertisment;
      this.active = active;
   }

   public User(UserDTO user) {
      super();
      this.name = user.getName();
      this.surname = user.getSurname();
      this.username = user.getUsername();
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

   public Boolean isActive() {
      return active;
   }

   public void setActive(Boolean active) {
      this.active = active;
   }

   public void setUsername(String username) {
      this.username = username;
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
      return this.username;
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