
package addvertisment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pricelist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "daily_price", nullable = false)
   private float dailyPrice;
   @Column(name = "overlimit_price", nullable = false)
   private float overlimitPrice;
   @Column(name = "cdw_price", nullable = false)
   private float cdwPrice;
   @Column(name = "discount", nullable = false)
   private float discount;
   @Column(name = "number_of_days", nullable = false)
   private int numberOfDays;
   @Column(name = "username", nullable = false)
   public String username;

public Pricelist(float dailyPrice, float overlimitPrice, float cdwPrice, float discount, int numberOfDays,
		String username) {
	super();
	this.dailyPrice = dailyPrice;
	this.overlimitPrice = overlimitPrice;
	this.cdwPrice = cdwPrice;
	this.discount = discount;
	this.numberOfDays = numberOfDays;
	this.username = username;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public float getDailyPrice() {
	return dailyPrice;
}
public void setDailyPrice(float dailyPrice) {
	this.dailyPrice = dailyPrice;
}
public float getOverlimitPrice() {
	return overlimitPrice;
}
public void setOverlimitPrice(float overlimitPrice) {
	this.overlimitPrice = overlimitPrice;
}
public float getCdwPrice() {
	return cdwPrice;
}
public void setCdwPrice(float cdwPrice) {
	this.cdwPrice = cdwPrice;
}
public float getDiscount() {
	return discount;
}
public void setDiscount(float discount) {
	this.discount = discount;
}
public int getNumberOfDays() {
	return numberOfDays;
}
public void setNumberOfDays(int numberOfDays) {
	this.numberOfDays = numberOfDays;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Pricelist() {
	super();
	// TODO Auto-generated constructor stub
}

}