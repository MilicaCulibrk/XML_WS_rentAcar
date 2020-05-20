package addvertisment.model;

import java.util.Date;

//@Entity
public class ReservedDate {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "date_from", nullable = false)
    private Date date_from;

    //@Column(name = "date_to", nullable = false)
    private Date date_to;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Addvertisment addvertisment;

    public ReservedDate(){
        super();
    }


    public ReservedDate(Long id, Date date_from, Date date_to, Addvertisment addvertisment) {
        this.id = id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.addvertisment = addvertisment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public Addvertisment getAddvertisment() {
        return addvertisment;
    }

    public void setAddvertisment(Addvertisment addvertisment) {
        this.addvertisment = addvertisment;
    }
}
