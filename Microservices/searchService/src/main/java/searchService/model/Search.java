package searchService.model;

import javax.persistence.*;

@Entity
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Brands brand;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public VehicleModels vehicleModel;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public TransmissionTypes transmission_type;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public FuelTypes fuel_type;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public VehicleClasses vehicle_class;

    @Column(name = "daily_price", nullable = false)
    private float daily_price;

    @Column(name = "mileage", nullable = false)
    private float mileage;

    @Column(name = "mileage_limit", nullable = false)
    private float mileage_limit;

    @Column(name = "cdw", nullable = false)
    private boolean cdw;

    @Column(name = "child_seats", nullable = false)
    private int child_seats;

    @Column(name = "location", nullable = false)
    private String location;

    //@Column(name = "location", nullable = false)
    //private Date date_from;

    //@Column(name = "location", nullable = false)
    //private Date date_to;

    public Search(){
        super();
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public VehicleModels getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModels vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public TransmissionTypes getTransmission_type() {
        return transmission_type;
    }

    public void setTransmission_type(TransmissionTypes transmission_type) {
        this.transmission_type = transmission_type;
    }

    public FuelTypes getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(FuelTypes fuel_type) {
        this.fuel_type = fuel_type;
    }

    public VehicleClasses getVehicle_class() {
        return vehicle_class;
    }

    public void setVehicle_class(VehicleClasses vehicle_class) {
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

    public float getMileage_limit() {
        return mileage_limit;
    }

    public void setMileage_limit(float mileage_limit) {
        this.mileage_limit = mileage_limit;
    }

    /*public Date getDate_from() {
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
    } */
}
