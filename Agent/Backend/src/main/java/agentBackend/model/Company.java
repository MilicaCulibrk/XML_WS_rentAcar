package agentBackend.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name="company")
public class Company implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name", nullable = false)
   private String name;

   @Column(name = "email", nullable = false)
   private String email;

   @Column(name = "username", nullable = false)
   private String username;

   @Column(name = "password", nullable = false)
   private String password;

   @Column(name = "address", nullable = false)
   private String address;

   @Column(name = "city", nullable = false)
   private String city;

   @Column(name = "phone_number", nullable = false)
   private String phone_number;

   @Column(name = "company_number", nullable = false)
   private String company_number;

   @OneToMany(fetch = FetchType.LAZY)
   @JoinColumn(name = "addvertisment_id")
   public List<Addvertisment> addvertisments;

   //public java.util.List<PriceList> priceList;

   public Company() {
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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }


   public void setUsername(String username) {
      this.username = username;
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

   public String getCompany_number() {
      return company_number;
   }

   public void setCompany_number(String company_number) {
      this.company_number = company_number;
   }

   public List<Addvertisment> getAddvertisments() {
      return addvertisments;
   }

   public void setAddvertisments(List<Addvertisment> addvertisments) {
      this.addvertisments = addvertisments;
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
}