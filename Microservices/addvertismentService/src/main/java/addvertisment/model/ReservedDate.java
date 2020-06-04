package addvertisment.model;

import java.util.Date;
import javax.persistence.*;

@Entity(name="reserved_date")
public class ReservedDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "oneDate", nullable = false)
    private String oneDate;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="addvertisment")
    public Addvertisment addvertisment;

    public ReservedDate(){
        super();
    }


    public ReservedDate(Long id, String oneDate, Addvertisment addvertisment) {
        this.id = id;
        this.oneDate = oneDate;
        this.addvertisment = addvertisment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOneDate() {
        return oneDate;
    }

    public void setOneDate(String oneDate) {
        this.oneDate = oneDate;
    }

    public Addvertisment getAddvertisment() {
        return addvertisment;
    }

    public void setAddvertisment(Addvertisment addvertisment) {
        this.addvertisment = addvertisment;
    }
}
