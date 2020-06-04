package addvertisment.model;

import javax.persistence.*;

@Entity(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="addvertisment")
    public Addvertisment addvertisment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Addvertisment getAddvertisment() {
        return addvertisment;
    }

    public void setAddvertisment(Addvertisment addvertisment) {
        this.addvertisment = addvertisment;
    }

    public Image(){
        super();
    }

    public Image(Long id, String url, Addvertisment addvertisment) {
        this.id = id;
        this.url = url;
        this.addvertisment = addvertisment;
    }
}
