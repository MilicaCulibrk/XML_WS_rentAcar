package addvertisment.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Addvertisment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/*
    //@Column(name = "addvertiser_id", nullable = false)
    //koji user/firma ga kreira
    private Long addvertiser_id;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Brand brand;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Model model;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public TransmissionType transmission_type;
*/
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public FuelType fuel_type;
/*
    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public VehicleClass vehicle_class;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public PriceList price_list;

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

    //@OneToMany(mappedBy = "addvertisment", fetch = FetchType.LAZY)
    public List<Grade> grades;

    //@OneToMany(mappedBy = "addvertisment", fetch = FetchType.LAZY)
    public List<Comment> comments;

    //@OneToMany(mappedBy = "addvertisment", fetch = FetchType.LAZY)
    public List<ReservedDate> reservedDates;

*/

    public Addvertisment(){
        super();
    }

    /*
    public Addvertisment(Long id, Long addvertiser_id, Brand brand, Model model, TransmissionType transmission_type, FuelType fuel_type, VehicleClass vehicle_class, PriceList price_list, float mileage, float mileage_limit, boolean cdw, int child_seats, String location, List<Grade> grades, List<Comment> comments, List<ReservedDate> reservedDates) {
        this.id = id;
        this.addvertiser_id = addvertiser_id;
        this.brand = brand;
        this.model = model;
        this.transmission_type = transmission_type;
        this.fuel_type = fuel_type;
        this.vehicle_class = vehicle_class;
        this.price_list = price_list;
        this.mileage = mileage;
        this.mileage_limit = mileage_limit;
        this.cdw = cdw;
        this.child_seats = child_seats;
        this.location = location;
        this.grades = grades;
        this.comments = comments;
        this.reservedDates = reservedDates;
    }
*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public Long getAddvertiser_id() {
        return addvertiser_id;
    }

    public void setAddvertiser_id(Long addvertiser_id) {
        this.addvertiser_id = addvertiser_id;
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
*/
    public FuelType getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(FuelType fuel_type) {
        this.fuel_type = fuel_type;
    }
/*
    public VehicleClass getVehicle_class() {
        return vehicle_class;
    }

    public void setVehicle_class(VehicleClass vehicle_class) {
        this.vehicle_class = vehicle_class;
    }

    public PriceList getPrice_list() {
        return price_list;
    }

    public void setPrice_list(PriceList price_list) {
        this.price_list = price_list;
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

    public List<ReservedDate> getReservedDates() {
        return reservedDates;
    }

    public void setReservedDates(List<ReservedDate> reservedDates) {
        this.reservedDates = reservedDates;
    } */





}
