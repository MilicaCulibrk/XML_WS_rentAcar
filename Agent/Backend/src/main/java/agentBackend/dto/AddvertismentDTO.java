package agentBackend.dto;

import agentBackend.model.Addvertisment;
import agentBackend.model.Image;

import java.util.ArrayList;

public class AddvertismentDTO {

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
    private ArrayList<ImageDTO> images;
    private ArrayList<ReservedDateDTO> arrayEvents;

    public AddvertismentDTO(Long id, Long fuel_type_id, Long brand_id, Long vehicle_model_id, Long vehicle_class_id, Long transmission_type_id, float mileage, float mileage_limit, boolean cdw, int child_seats, String location, float price, ArrayList<ImageDTO> images, ArrayList<ReservedDateDTO> arrayEvents, String username) {
        this.id = id;
        this.fuel_type_id = fuel_type_id;
        this.brand_id = brand_id;
        this.vehicle_model_id = vehicle_model_id;
        this.vehicle_class_id = vehicle_class_id;
        this.transmission_type_id = transmission_type_id;
        this.mileage = mileage;
        this.mileage_limit = mileage_limit;
        this.cdw = cdw;
        this.child_seats = child_seats;
        this.location = location;
        this.daily_price = getDaily_price();
        this.images = images;
        this.arrayEvents = arrayEvents;
        this.owner = username;
    }


    public AddvertismentDTO(Addvertisment addvertisment) {
        this.id = addvertisment.getId();
        this.daily_price = addvertisment.getDaily_price();
        this.mileage = addvertisment.getMileage();
        this.mileage_limit = addvertisment.getMileage_limit();
        this.cdw = addvertisment.isCdw();
        this.child_seats = addvertisment.getChild_seats();
        this.location = addvertisment.getLocation();
        this.fuel_type_id = addvertisment.getFuel_type().getId();
        this.fuel_type_name = addvertisment.getFuel_type().getFuel_type_name();
        this.brand_id = addvertisment.getBrand().getId();
        this.brand_name = addvertisment.getBrand().getBrand_name();
        this.vehicle_model_id = addvertisment.getVehicle_class().getId();
        this.vehicle_model_name = addvertisment.getVehicle_model().getVehicle_model_name();
        this.vehicle_class_id = addvertisment.getVehicle_class().getId();
        this.vehicle_class_name = addvertisment.getVehicle_class().getVehicle_class_name();
        this.transmission_type_id = addvertisment.getTransmission_type().getId();
        this.transmission_type_name = addvertisment.getTransmission_type().getTransmission_type_name();
        this.owner = addvertisment.getCompany().getUsername();
        this.arrayEvents = new ArrayList<>();
        this.images = new ArrayList<>();

        for(Image i : addvertisment.getImages()){
            images.add(new ImageDTO(i));
        }
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

    public Long getFuel_type_id() {
        return fuel_type_id;
    }

    public void setFuel_type_id(Long fuel_type_id) {
        this.fuel_type_id = fuel_type_id;
    }

    public String getFuel_type_name() {
        return fuel_type_name;
    }

    public void setFuel_type_name(String fuel_type_name) {
        this.fuel_type_name = fuel_type_name;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public Long getVehicle_model_id() {
        return vehicle_model_id;
    }

    public void setVehicle_model_id(Long vehicle_model_id) {
        this.vehicle_model_id = vehicle_model_id;
    }

    public String getVehicle_model_name() {
        return vehicle_model_name;
    }

    public void setVehicle_model_name(String vehicle_model_name) {
        this.vehicle_model_name = vehicle_model_name;
    }

    public Long getVehicle_class_id() {
        return vehicle_class_id;
    }

    public void setVehicle_class_id(Long vehicle_class_id) {
        this.vehicle_class_id = vehicle_class_id;
    }

    public String getVehicle_class_name() {
        return vehicle_class_name;
    }

    public void setVehicle_class_name(String vehicle_class_name) {
        this.vehicle_class_name = vehicle_class_name;
    }

    public Long getTransmission_type_id() {
        return transmission_type_id;
    }

    public void setTransmission_type_id(Long transmission_type_id) {
        this.transmission_type_id = transmission_type_id;
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

    public ArrayList<ImageDTO> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageDTO> images) {
        this.images = images;
    }

    public ArrayList<ReservedDateDTO> getArrayEvents() {
        return arrayEvents;
    }

    public void setArrayEvents(ArrayList<ReservedDateDTO> arrayEvents) {
        this.arrayEvents = arrayEvents;
    }
}
