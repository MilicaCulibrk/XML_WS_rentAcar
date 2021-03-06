package searchService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "search", fetch = FetchType.LAZY)
    public List<Images> images;

    @Column(name = "daily_price", nullable = false)
    private float daily_price;

    @Column(name = "mileage", nullable = false)
    private float mileage;

    @Column(name = "mileage_limit", nullable = false)
    private float mileage_limit;

    @Column(name = "cdw", nullable = false)
    private boolean cdw;

    @Column(name = "child_seats", nullable = false)
    private Integer child_seats;

    @Column(name = "location", nullable = false)
    private String location;


    @Column(name = "owner", nullable = false)
    private String owner;

    @OneToMany(mappedBy = "search", fetch = FetchType.LAZY)
    public List<ReservedDates> reservedDates;


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

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
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

    public Integer getChild_seats() {
        return child_seats;
    }

    public void setChild_seats(Integer child_seats) {
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<ReservedDates> getReservedDates() {
        return reservedDates;
    }

    public void setReservedDates(List<ReservedDates> reservedDates) {
        this.reservedDates = reservedDates;
    }
}
