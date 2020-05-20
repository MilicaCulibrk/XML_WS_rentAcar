package user.model;

//@Entity
public class Company {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "name", nullable = false)
    private String name;

    //@Column(name = "email", nullable = false)
    private String email;

    //@Column(name = "password", nullable = false)
    private String password;

    //@Column(name = "address", nullable = false)
    private String address;

    //@Column(name = "city", nullable = false)
    private String city;

    //@Column(name = "phone_number", nullable = false)
    private String phone_number;

    //@Column(name = "company_number", nullable = false)
    private String company_number;

    public Company(){
        super();
    }


    public Company(Long id, String name, String email, String password, String address, String city, String phone_number, String company_number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.phone_number = phone_number;
        this.company_number = company_number;
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


}