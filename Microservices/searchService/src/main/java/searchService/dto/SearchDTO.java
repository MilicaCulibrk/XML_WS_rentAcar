package searchService.dto;

import searchService.model.Search;

public class SearchDTO {

    private Long id;
    private float daily_price;
    private float mileage;
    private float mileage_limit;
    private boolean cdw;
    private int child_seats;
    private String location;
    private Long fuel_type_id;
    private String fuel_type_name;
    private Long brand_id;
    private String brand_name;
    private Long vehicle_model_id;
    private String vehicle_model_name;
    private Long vehicle_class_id;
    private String vehicle_class_name;
    private Long transmission_type_id;
    private String transmission_type_name;
    private String owner;

    public SearchDTO(Search search) {
        this.id = search.getId();
        this.daily_price = search.getDaily_price();
        this.mileage = search.getMileage();
        this.mileage_limit = search.getMileage_limit();
        this.cdw = search.isCdw();
        this.child_seats = search.getChild_seats();
        this.location = search.getLocation();
        this.fuel_type_id = search.getFuel_type().getId();
        this.fuel_type_name = search.getFuel_type().getFuel_type_name();
        this.brand_id = search.getBrand().getId();
        this.brand_name = search.getBrand().getBrand_name();
        this.vehicle_model_id = search.getVehicle_class().getId();
        this.vehicle_model_name = search.getVehicleModel().getVehicle_model_name();
        this.vehicle_class_id = search.getVehicle_class().getId();
        this.vehicle_class_name = search.getVehicle_class().getVehicle_class_name();
        this.transmission_type_id = search.getTransmission_type().getId();
        this.transmission_type_name = search.getTransmission_type().getTransmission_type_name();
        this.owner = search.getOwner();
    }

    public SearchDTO(Long id, float daily_price, float mileage, float mileage_limit, boolean cdw, int child_seats, String location, Long fuel_type_id, String fuel_type_name, Long brand_id, String brand_name, Long vehicle_model_id, String vehicle_model_name, Long vehicle_class_id, String vehicle_class_name, Long transmission_type_id, String transmission_type_name) {
        this.id = id;
        this.daily_price = daily_price;
        this.mileage = mileage;
        this.mileage_limit = mileage_limit;
        this.cdw = cdw;
        this.child_seats = child_seats;
        this.location = location;
        this.fuel_type_id = fuel_type_id;
        this.fuel_type_name = fuel_type_name;
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.vehicle_model_id = vehicle_model_id;
        this.vehicle_model_name = vehicle_model_name;
        this.vehicle_class_id = vehicle_class_id;
        this.vehicle_class_name = vehicle_class_name;
        this.transmission_type_id = transmission_type_id;
        this.transmission_type_name = transmission_type_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getFuel_type_id() {
        return fuel_type_id;
    }

    public void setFuel_type_id(Long fuel_type_id) {
        this.fuel_type_id = fuel_type_id;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public Long getVehicle_model_id() {
        return vehicle_model_id;
    }

    public void setVehicle_model_id(Long vehicle_model_id) {
        this.vehicle_model_id = vehicle_model_id;
    }

    public Long getVehicle_class_id() {
        return vehicle_class_id;
    }

    public void setVehicle_class_id(Long vehicle_class_id) {
        this.vehicle_class_id = vehicle_class_id;
    }

    public Long getTransmission_type_id() {
        return transmission_type_id;
    }

    public void setTransmission_type_id(Long transmission_type_id) {
        this.transmission_type_id = transmission_type_id;
    }

    public float getMileage_limit() {
        return mileage_limit;
    }

    public void setMileage_limit(float mileage_limit) {
        this.mileage_limit = mileage_limit;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getVehicle_model_name() {
        return vehicle_model_name;
    }

    public void setVehicle_model_name(String vehicle_model_name) {
        this.vehicle_model_name = vehicle_model_name;
    }

    public String getFuel_type_name() {
        return fuel_type_name;
    }

    public void setFuel_type_name(String fuel_type_name) {
        this.fuel_type_name = fuel_type_name;
    }

    public String getVehicle_class_name() {
        return vehicle_class_name;
    }

    public void setVehicle_class_name(String vehicle_class_name) {
        this.vehicle_class_name = vehicle_class_name;
    }

    public String getTransmission_type_name() {
        return transmission_type_name;
    }

    public void setTransmission_type_name(String transmission_type_name) {
        this.transmission_type_name = transmission_type_name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
