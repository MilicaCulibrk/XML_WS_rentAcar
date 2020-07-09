package addvertisment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.HashMap;
import java.util.List;

@Entity
public class Addvertisment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "addvertiser_id", nullable = false)
    //koji user/firma ga kreira
    private String addvertiser_id;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnore
    public Brand brand;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnore
    public VehicleModel vehicle_model;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnore
    public TransmissionType transmission_type;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnore
    public FuelType fuel_type;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnore
    public VehicleClass vehicle_class;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addvertisment", fetch = FetchType.LAZY)
    public List<ReservedDate> reservedDates;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addvertisment", fetch = FetchType.LAZY)
    public List<Image> images;

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

    @Column(name = "price", nullable = false)
    private float price;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "pricelist")
    public Pricelist pricelist;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addvertisment", fetch = FetchType.LAZY)
    public List<Grade> grades;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Comment> comments;


    public Addvertisment(){
        super();
    }



    public Pricelist getPricelist() {
        return pricelist;
    }



    public void setPricelist(Pricelist priceList) {
        this.pricelist = priceList;
    }



    public List<Grade> getGrades() {
        return grades;
    }



    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }



    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<ReservedDate> getReservedDates() {
        return reservedDates;
    }

    public void setReservedDates(List<ReservedDate> reservedDates) {
        this.reservedDates = reservedDates;
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

    public Addvertisment(Long id, Brand brand, VehicleModel vehicle_model, TransmissionType transmission_type, FuelType fuel_type, VehicleClass vehicle_class, List<ReservedDate> reservedDates, List<Image> images, float mileage, float mileage_limit, boolean cdw, int child_seats, String location, float price, String addvertiser_id) {
        this.id = id;
        this.brand = brand;
        this.vehicle_model = vehicle_model;
        this.transmission_type = transmission_type;
        this.fuel_type = fuel_type;
        this.vehicle_class = vehicle_class;
        this.reservedDates = reservedDates;
        this.images = images;
        this.mileage = mileage;
        this.mileage_limit = mileage_limit;
        this.cdw = cdw;
        this.child_seats = child_seats;
        this.location = location;
        this.price = price;
        this.addvertiser_id = addvertiser_id;
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

    public VehicleModel getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(VehicleModel model) {
        this.vehicle_model = model;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getAddvertiser_id() {
        return addvertiser_id;
    }

    public void setAddvertiser_id(String addvertiser_id) {
        this.addvertiser_id = addvertiser_id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }



    /*
    public PriceList getPrice_list() {
        return price_list;
    }

    public void setPrice_list(PriceList price_list) {
        this.price_list = price_list;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

  */



}