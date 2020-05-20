package addvertisment.model;

import java.util.List;

//@Entity(name="price_list")
public class PriceList {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "user_id", nullable = false)
    //koji user/firma ga kreira(bila bi ManyToOne veza)
    private int user_id;

    //@OneToMany(mappedBy = "price_list", fetch = FetchType.LAZY)
    public List<Addvertisment> addvertisments;

    //@Column(name = "daily_price", nullable = false)
    private float daily_price;

    //@Column(name = "overlimit_price", nullable = false)
    private float overlimit_price;

    //@Column(name = "cdw_price", nullable = false)
    private float cdw_price;

    //@Column(name = "discount", nullable = false)
    private float discount;

    public PriceList(Long id, int user_id, List<Addvertisment> addvertisments, float daily_price, float overlimit_price, float cdw_price, float discount) {
        this.id = id;
        this.user_id = user_id;
        this.addvertisments = addvertisments;
        this.daily_price = daily_price;
        this.overlimit_price = overlimit_price;
        this.cdw_price = cdw_price;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<Addvertisment> getAddvertisments() {
        return addvertisments;
    }

    public void setAddvertisments(List<Addvertisment> addvertisments) {
        this.addvertisments = addvertisments;
    }

    public float getDaily_price() {
        return daily_price;
    }

    public void setDaily_price(float daily_price) {
        this.daily_price = daily_price;
    }

    public float getOverlimit_price() {
        return overlimit_price;
    }

    public void setOverlimit_price(float overlimit_price) {
        this.overlimit_price = overlimit_price;
    }

    public float getCdw_price() {
        return cdw_price;
    }

    public void setCdw_price(float cdw_price) {
        this.cdw_price = cdw_price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
