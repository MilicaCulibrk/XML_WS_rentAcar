package addvertisment.model;

//@Entity
public class Grade {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "user_id", nullable = false)
    private Long user_id;

    //@Column(name = "number", nullable = false)
    private int number;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Addvertisment addvertisment;

    public Grade(){
        this.number = 0;
    }

    public Grade(Long id, Long user_id, int number, Addvertisment addvertisment) {
        this.id = id;
        this.user_id = user_id;
        this.number = number;
        this.addvertisment = addvertisment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Addvertisment getAddvertisment() {
        return addvertisment;
    }

    public void setAddvertisment(Addvertisment addvertisment) {
        this.addvertisment = addvertisment;
    }
}
