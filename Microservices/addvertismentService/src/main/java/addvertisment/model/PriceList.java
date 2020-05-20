package addvertisment.model;

import java.util.List;

//@Entity
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

}
