package addvertisment.dto;

import java.util.ArrayList;

import addvertisment.model.Addvertisment;
import addvertisment.model.Image;
import addvertisment.model.Pricelist;
import addvertisment.model.ReservedDate;
import addvertisment.mq.enums.OperationEnum;


public class AddvertismentDTO {

    private Long id;
    private Long fuel_type_id;
    private Long brand_id;
    private Long vehicle_model_id;
    private Long vehicle_class_id;
    private Long transmission_type_id;
    private float mileage;
    private float mileage_limit;
    private boolean cdw;
    private int child_seats;
    private String location;
    private float price;
    private String addvertiser_id;
    private ArrayList<ImageDTO> images;
    private ArrayList<ReservedDateDTO> arrayEvents;
    private int number_of_purchases;

    private Pricelist pricelist;


    public AddvertismentDTO(Addvertisment addvertisment) {
        this.id = addvertisment.getId();
        this.fuel_type_id =addvertisment.getFuel_type().getId();
        this.brand_id = addvertisment.getBrand().getId();
        this.vehicle_model_id = addvertisment.getVehicle_model().getId();
        this.vehicle_class_id = addvertisment.getVehicle_class().getId();
        this.transmission_type_id = addvertisment.getTransmission_type().getId();
        this.mileage = addvertisment.getMileage();
        this.mileage_limit = addvertisment.getMileage_limit();
        this.cdw = addvertisment.isCdw();
        this.child_seats = addvertisment.getChild_seats();
        this.location = addvertisment.getLocation();
        this.price = addvertisment.getPrice();
        this.addvertiser_id = addvertisment.getAddvertiser_id();


        this.arrayEvents = new ArrayList<>();
        this.images = new ArrayList<>();

        for(Image i : addvertisment.getImages()){
            images.add(new ImageDTO(i));
        }
        for(ReservedDate r : addvertisment.getReservedDates()){
            arrayEvents.add(new ReservedDateDTO(r));
        }

        this.number_of_purchases = 0;
        this.pricelist = addvertisment.getPricelist();
    }

    public Pricelist getPricelist() {
		return pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}

	public String getAddvertiser_id() {
        return addvertiser_id;
    }

    public void setAddvertiser_id(String addvertiser_id) {
        this.addvertiser_id = addvertiser_id;
    }

    public AddvertismentDTO(){
        super();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

	public int getNumber_of_purchases() {
        return number_of_purchases;
    }

    public void setNumber_of_purchases(int number_of_purchases) {
        this.number_of_purchases = number_of_purchases;
    }
}
