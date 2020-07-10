package searchService.mq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import searchService.dto.ImagesDTO;
import searchService.dto.ReservedDatesDTO;
import searchService.mq.enums.EntityEnum;
import searchService.mq.enums.OperationEnum;

import java.util.ArrayList;

public class AddDTO {

    private Long id;
    private String addvertiser_username;
    private float mileage;
    private float mileage_limit;
    private int child_seats;
    private boolean cdw;
    private String location;
    private float daily_price;
    private AttributeDTO brand;
    private AttributeDTO vehicle_model;
    private AttributeDTO vehicle_class;
    private AttributeDTO fuel_type;
    private AttributeDTO transmission_type;
    private Long priceListId;

    private OperationEnum operation;
    private EntityEnum entity;
    private ArrayList<ImagesDTO> images;
    private ArrayList<ReservedDatesDTO> dates;

    public AddDTO() {

    }

    public AddDTO(@JsonProperty("id") Long id,
                                @JsonProperty("addvertiser_username") String addvertiser_username,
                                @JsonProperty("mileage") float mileage,
                                @JsonProperty("mileage_limit") float mileage_limit,
                                @JsonProperty("child_seats") int child_seats,
                                @JsonProperty("cdw") boolean cdw,
                                @JsonProperty("location") String location,
                                @JsonProperty("daily_price") float daily_price,
                                @JsonProperty("brand") AttributeDTO brand,
                                @JsonProperty("vehicle_model") AttributeDTO vehicle_model,
                                @JsonProperty("vehicle_class") AttributeDTO vehicle_class,
                                @JsonProperty("fuel_type") AttributeDTO fuel_type,
                                @JsonProperty("transmission_type") AttributeDTO transmission_type,
                                @JsonProperty("operation") OperationEnum operation,
                                @JsonProperty("entity") EntityEnum entity,
                                @JsonProperty("images") ArrayList<ImagesDTO> images,
                                @JsonProperty("dates") ArrayList<ReservedDatesDTO> dates,
                                @JsonProperty("priceListId") Long priceListId) {
        this.id = id;
        this.addvertiser_username = addvertiser_username;
        this.mileage = mileage;
        this.mileage_limit = mileage_limit;
        this.child_seats = child_seats;
        this.cdw = cdw;
        this.location = location;
        this.daily_price = daily_price;
        this.brand = brand;
        this.vehicle_model = vehicle_model;
        this.vehicle_class = vehicle_class;
        this.fuel_type = fuel_type;
        this.transmission_type = transmission_type;
        this.operation = operation;
        this.entity = entity;
        this.images = images;
        this.dates = dates;
        this.priceListId = priceListId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddvertiser_username() {
        return addvertiser_username;
    }

    public void setAddvertiser_username(String addvertiser_username) {
        this.addvertiser_username = addvertiser_username;
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

    public int getChild_seats() {
        return child_seats;
    }

    public void setChild_seats(int child_seats) {
        this.child_seats = child_seats;
    }

    public boolean isCdw() {
        return cdw;
    }

    public void setCdw(boolean cdw) {
        this.cdw = cdw;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getDaily_price() {
        return daily_price;
    }

    public void setDaily_price(float daily_price) {
        this.daily_price = daily_price;
    }

    public AttributeDTO getBrand() {
        return brand;
    }

    public void setBrand(AttributeDTO brand) {
        this.brand = brand;
    }

    public AttributeDTO getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(AttributeDTO vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public AttributeDTO getVehicle_class() {
        return vehicle_class;
    }

    public void setVehicle_class(AttributeDTO vehicle_class) {
        this.vehicle_class = vehicle_class;
    }

    public AttributeDTO getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(AttributeDTO fuel_type) {
        this.fuel_type = fuel_type;
    }

    public AttributeDTO getTransmission_type() {
        return transmission_type;
    }

    public void setTransmission_type(AttributeDTO transmission_type) {
        this.transmission_type = transmission_type;
    }

    public OperationEnum getOperation() {
        return operation;
    }

    public void setOperation(OperationEnum operation) {
        this.operation = operation;
    }

    public EntityEnum getEntity() {
        return entity;
    }

    public void setEntity(EntityEnum entity) {
        this.entity = entity;
    }

    public ArrayList<ImagesDTO> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImagesDTO> images) {
        this.images = images;
    }

    public ArrayList<ReservedDatesDTO> getDates() {
        return dates;
    }

    public void setDates(ArrayList<ReservedDatesDTO> dates) {
        this.dates = dates;
    }

    public Long getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Long priceListId) {
        this.priceListId = priceListId;
    }
}
