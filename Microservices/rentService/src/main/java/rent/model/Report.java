package rent.model;

public class Report {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "km", nullable = false)
    private float km;

    //@Column(name = "comment", nullable = false)
    private float comment;

    //join table
    private Order order;
}