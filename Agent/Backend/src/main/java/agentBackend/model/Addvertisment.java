package agentBackend.model;

import java.util.List;


import javax.persistence.*;

@Entity
public class Addvertisment {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   public Company company;

   @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   public Brand brand;

   @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   public VehicleModel vehicle_model;

   @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   public TransmissionType transmission_type;

   @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   public FuelType fuel_type;

   @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   public VehicleClass vehicle_class;

   @OneToMany(mappedBy = "addvertisment", fetch = FetchType.LAZY)
   public List<ReservedDate> reservedDates;

   @OneToMany(mappedBy = "addvertisment", fetch = FetchType.LAZY)
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

   @Column(name = "daily_price", nullable = false)
   private float daily_price;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "addvertisment", fetch = FetchType.LAZY)
   public List<Grade> grades;

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   public List<Comment> comments;


   public float getDaily_price() {
      return daily_price;
   }

   public void setDaily_price(float daily_price) {
      this.daily_price = daily_price;
   }
//public java.util.Collection<Comment> comment;
   //public java.util.Collection<Grade> grade;
   //public Order order;

   @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
   @JoinColumn(name = "pricelist")
   public Pricelist pricelist;


   public Addvertisment() {
   }

   public Pricelist getPricelist() {
	return pricelist;
}

public void setPricelist(Pricelist priceList) {
	this.pricelist = pricelist;
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

public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Company getCompany() {
      return company;
   }

   public void setCompany(Company company) {
      this.company = company;
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

   public void setVehicle_model(VehicleModel vehicle_model) {
      this.vehicle_model = vehicle_model;
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

   public List<ReservedDate> getReservedDates() {
      return reservedDates;
   }

   public void setReservedDates(List<ReservedDate> reservedDates) {
      this.reservedDates = reservedDates;
   }

   public List<Image> getImages() {
      return images;
   }

   public void setImages(List<Image> images) {
      this.images = images;
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

}