package searchService.dto;

import searchService.model.Search;

public class SearchDTO {

    private Long id;
    private float daily_price;
    private float mileage;
    private boolean cdw;
    private int child_seats;
    private String location;
    private Long fuel_type_id;
    private Long brand_id;
    private Long vehicle_model_id;
    private Long vehicle_class_id;
    private Long transmission_type_id;

    public SearchDTO(Search search) {
        this.id = search.getId();
        this.daily_price = search.getDaily_price();
        this.mileage = search.getMileage();
        this.cdw = search.isCdw();
        this.child_seats = search.getChild_seats();
        this.location = search.getLocation();
        this.fuel_type_id = search.getFuel_type().getId();
        this.brand_id = search.getBrand().getId();
        this.vehicle_model_id = search.getVehicle_class().getId();
        this.vehicle_class_id = search.getVehicle_class().getId();
        this.transmission_type_id = search.getTransmission_type().getId();
    }

    public SearchDTO(Long id, float daily_price, float mileage, boolean cdw, int child_seats, String location, Long fuel_type_id, Long brand_id, Long vehicle_model_id, Long vehicle_class_id, Long transmission_type_id) {
        this.id = id;
        this.daily_price = daily_price;
        this.mileage = mileage;
        this.cdw = cdw;
        this.child_seats = child_seats;
        this.location = location;
        this.fuel_type_id = fuel_type_id;
        this.brand_id = brand_id;
        this.vehicle_model_id = vehicle_model_id;
        this.vehicle_class_id = vehicle_class_id;
        this.transmission_type_id = transmission_type_id;
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
}
