package agentBackend.dto;

import java.util.ArrayList;

import agentBackend.model.Addvertisment;
import agentBackend.model.Grade;
import agentBackend.model.Image;
import agentBackend.model.Pricelist;
import agentBackend.model.ReservedDate;

public class AddvertismentDisplayDTO {
    private Long id;
    private String fuel_type_name;
    private String brand_name;
    private String vehicle_model_name;
    private String vehicle_class_name;
    private String transmission_type_name;
    private float mileage;
    private float mileage_limit;
    private boolean cdw;
    private int child_seats;
    private String location;
    private float price;
    private Long addvertiser_id;
    private ArrayList<ImageDTO> images;
    private ArrayList<ReservedDateDTO> arrayEvents;
    private int number_of_comments;
    private float average_grade;
    private int number_of_purchases;
    private Pricelist pricelist;
    public AddvertismentDisplayDTO(Addvertisment addvertisment) {
        this.id = addvertisment.getId();
        this.fuel_type_name = addvertisment.getFuel_type().getFuel_type_name();
        this.brand_name = addvertisment.getBrand().getBrand_name();
        this.vehicle_model_name = addvertisment.getVehicle_model().getVehicle_model_name();
        this.vehicle_class_name = addvertisment.getVehicle_class().getVehicle_class_name();
        this.transmission_type_name = addvertisment.getTransmission_type().getTransmission_type_name();
        this.mileage = addvertisment.getMileage();
        this.mileage_limit = addvertisment.getMileage_limit();
        this.cdw = addvertisment.isCdw();
        this.child_seats = addvertisment.getChild_seats();
        this.location = addvertisment.getLocation();
        this.price = addvertisment.getDaily_price();
        this.addvertiser_id = addvertisment.getCompany().getId();

        this.arrayEvents = new ArrayList<>();
        this.images = new ArrayList<>();

        for(Image i : addvertisment.getImages()){
            images.add(new ImageDTO(i));
        }
        for(ReservedDate r : addvertisment.getReservedDates()){
            arrayEvents.add(new ReservedDateDTO(r));
        }

        this.number_of_comments = addvertisment.getComments().size();

        float sumGrades = 0;
        if(addvertisment.getGrades().size() != 0){
            for(Grade g: addvertisment.getGrades()){
                sumGrades = sumGrades + g.getNumber();
            }
            this.average_grade = sumGrades/(float) addvertisment.getGrades().size();
        }else {
            this.average_grade = 0;
        }
        this.pricelist = addvertisment.getPricelist();
        this.number_of_purchases = 0;

    }

    public AddvertismentDisplayDTO(){
        super();
    }
    public Pricelist getPricelist() {
 		return pricelist;
 	}

 	public void setPricelist(Pricelist pricelist) {
 		this.pricelist = pricelist;
 	}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuel_type_name() {
        return fuel_type_name;
    }

    public void setFuel_type_name(String fuel_type_name) {
        this.fuel_type_name = fuel_type_name;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getAddvertiser_id() {
        return addvertiser_id;
    }

    public void setAddvertiser_id(Long addvertiser_id) {
        this.addvertiser_id = addvertiser_id;
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

    public int getNumber_of_comments() {
        return number_of_comments;
    }

    public void setNumber_of_comments(int number_of_comments) {
        this.number_of_comments = number_of_comments;
    }

    public float getAverage_grade() {
        return average_grade;
    }

    public void setAverage_grade(float average_grade) {
        this.average_grade = average_grade;
    }

    public int getNumber_of_purchases() {
        return number_of_purchases;
    }

    public void setNumber_of_purchases(int number_of_purchases) {
        this.number_of_purchases = number_of_purchases;
    }
}
