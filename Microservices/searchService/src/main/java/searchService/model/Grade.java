package searchService.model;

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
    public Search search;

    public Grade(){
        this.number = 0;
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


}
