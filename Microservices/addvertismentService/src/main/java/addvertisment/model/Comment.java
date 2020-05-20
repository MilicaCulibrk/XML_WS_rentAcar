package addvertisment.model;

//@Entity
public class Comment {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "user_id", nullable = false)
    private Long user_id;

    //@Column(name = "text", nullable = false)
    private String text;

    //@Column(name = "accepted", nullable = false)
    private boolean accepted;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Addvertisment addvertisment;

    public Comment(){
        super();
    }

    public Comment(Long id, Long user_id, String text, boolean accepted, Addvertisment addvertisment) {
        this.id = id;
        this.user_id = user_id;
        this.text = text;
        this.accepted = accepted;
        this.addvertisment = addvertisment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_email() {
        return user_id;
    }

    public void setUser_email(Long user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Addvertisment getAddvertisment() {
        return addvertisment;
    }

    public void setAddvertisment(Addvertisment addvertisment) {
        this.addvertisment = addvertisment;
    }
}
