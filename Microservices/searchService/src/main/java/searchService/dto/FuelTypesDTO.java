package searchService.dto;

import searchService.model.FuelTypes;

public class FuelTypesDTO {

    private Long id;
    private String fuel_type_name;

    public FuelTypesDTO(Long id, String fuel_type_name) {
        this.id = id;
        this.fuel_type_name = fuel_type_name;
    }

    public FuelTypesDTO(FuelTypes fuelType) {
        this.id = fuelType.getId();
        this.fuel_type_name = fuelType.getFuel_type_name();
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

}
