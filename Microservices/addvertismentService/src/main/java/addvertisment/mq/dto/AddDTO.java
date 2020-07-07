package addvertisment.mq.dto;

import addvertisment.dto.AddvertismentDTO;
import addvertisment.dto.ImageDTO;
import addvertisment.dto.ReservedDateDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.Image;
import addvertisment.model.ReservedDate;
import addvertisment.mq.enums.EntityEnum;
import addvertisment.mq.enums.OperationEnum;

import java.util.ArrayList;
import java.util.List;


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

    private OperationEnum operation;
    private EntityEnum entity;
    private ArrayList<ImageDTO> images;
    private ArrayList<ReservedDateDTO> dates;

    public AddDTO(){}

    public AddDTO(Addvertisment addvertisment) {
        this.id = addvertisment.getId();
        this.addvertiser_username = addvertisment.getAddvertiser_id();
        this.mileage = addvertisment.getMileage();
        this.mileage_limit = addvertisment.getMileage_limit();
        this.child_seats = addvertisment.getChild_seats();
        this.cdw = addvertisment.isCdw();
        this.location = addvertisment.getLocation();
        this.daily_price = addvertisment.getPrice();
        this.brand = new AttributeDTO(addvertisment.getBrand().getId(), addvertisment.getBrand().getBrand_name(), addvertisment.getBrand().getId());
        this.vehicle_model = new AttributeDTO(addvertisment.getVehicle_model().getId(), addvertisment.getVehicle_model().getVehicle_model_name(), addvertisment.getBrand().getId());
        this.vehicle_class = new AttributeDTO(addvertisment.getVehicle_class().getId(), addvertisment.getVehicle_class().getVehicle_class_name(), addvertisment.getBrand().getId());
        this.fuel_type = new AttributeDTO(addvertisment.getFuel_type().getId(), addvertisment.getFuel_type().getFuel_type_name(), addvertisment.getBrand().getId());
        this.transmission_type = new AttributeDTO(addvertisment.getTransmission_type().getId(), addvertisment.getTransmission_type().getTransmission_type_name(), addvertisment.getBrand().getId());

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

    public ArrayList<ImageDTO> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageDTO> images) {
        this.images = images;
    }

    public ArrayList<ReservedDateDTO> getDates() {
        return dates;
    }

    public void setDates(ArrayList<ReservedDateDTO> dates) {
        this.dates = dates;
    }
}