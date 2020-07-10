package addvertisment.dto;

public class AddvertismentRentDTO {

    private Long id;
    private float mileage_limit;
    private float priceByKm;

    public AddvertismentRentDTO(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getMileage_limit() {
        return mileage_limit;
    }

    public void setMileage_limit(float mileage_limit) {
        this.mileage_limit = mileage_limit;
    }

    public float getPriceByKm() {
        return priceByKm;
    }

    public void setPriceByKm(float priceByKm) {
        this.priceByKm = priceByKm;
    }
}
