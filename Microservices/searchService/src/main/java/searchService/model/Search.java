package searchService.model;


import java.util.Date;

//@Entity
public class Search {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Brand brand;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Model model;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public TransmissionType transmission_type;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public FuelType fuel_type;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public VehicleClass vehicle_class;

    //@Column(name = "price", nullable = false)
    private float price;

    //@Column(name = "mileage", nullable = false)
    private float mileage;

    //@Column(name = "mileage_limit", nullable = false)
    private float mileage_limit;

    //@Column(name = "cdw", nullable = false)
    private boolean cdw;

    //@Column(name = "child_seats", nullable = false)
    private int child_seats;

    //@Column(name = "location", nullable = false)
    private String location;

    //@Column(name = "dateTo", nullable = false)
    private Date dateTo;

    //@Column(name = "dateFrom", nullable = false)
    private Date dateFrom;

    public Search(){
        super();
    }

    public Search(Long id, Brand brand, Model model, TransmissionType transmission_type, FuelType fuel_type, VehicleClass vehicle_class, float price, float mileage, float mileage_limit, boolean cdw, int child_seats, String location, Date dateTo, Date dateFrom) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.transmission_type = transmission_type;
        this.fuel_type = fuel_type;
        this.vehicle_class = vehicle_class;
        this.price = price;
        this.mileage = mileage;
        this.mileage_limit = mileage_limit;
        this.cdw = cdw;
        this.child_seats = child_seats;
        this.location = location;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public TransmissionType getTransmission_type() {
        return transmission_type;
    }

    public void setTransmission_type(TransmissionType transmission_type) {
        this.transmission_type = transmission_type;
    }

    public FuelType getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(FuelType fuel_type) {
        this.fuel_type = fuel_type;
    }

    public VehicleClass getVehicle_class() {
        return vehicle_class;
    }

    public void setVehicle_class(VehicleClass vehicle_class) {
        this.vehicle_class = vehicle_class;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public float getMileage_limit() {
        return mileage_limit;
    }

    public void setMileage_limit(float mileage_limit) {
        this.mileage_limit = mileage_limit;
    }

    public boolean isCdw() {
        return cdw;
    }

    public void setCdw(boolean cdw) {
        this.cdw = cdw;
    }

    public int getChild_seats() {
        return child_seats;
    }

    public void setChild_seats(int child_seats) {
        this.child_seats = child_seats;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }
}
