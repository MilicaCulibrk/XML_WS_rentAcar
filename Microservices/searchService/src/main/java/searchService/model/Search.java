package searchService.model;


import java.util.Date;
import java.util.List;


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

    //@Column(name = "daily_price", nullable = false)
    public float daily_price;

    //@Column(name = "mileage", nullable = false)
    private float mileage;

    //@Column(name = "cdw", nullable = false)
    private boolean cdw;

    //@Column(name = "child_seats", nullable = false)
    private int child_seats;

    //@Column(name = "location", nullable = false)
    private String location;

    //@Column(name = "location", nullable = false)
    private Date date_from;

    //@Column(name = "location", nullable = false)
    private Date date_from;

    public Search(Long id, Brand brand, Model model, TransmissionType transmission_type, FuelType fuel_type, VehicleClass vehicle_class, float daily_price, float mileage, boolean cdw, int child_seats, String location, Date date_from, Date date_from1) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.transmission_type = transmission_type;
        this.fuel_type = fuel_type;
        this.vehicle_class = vehicle_class;
        this.daily_price = daily_price;
        this.mileage = mileage;
        this.cdw = cdw;
        this.child_seats = child_seats;
        this.location = location;
        this.date_from = date_from;
        this.date_from = date_from1;
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

    public float getDaily_price() {
        return daily_price;
    }

    public void setDaily_price(float daily_price) {
        this.daily_price = daily_price;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
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

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }
}
