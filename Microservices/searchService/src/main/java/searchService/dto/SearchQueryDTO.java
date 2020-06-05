package searchService.dto;

import java.util.List;

public class SearchQueryDTO {

    private List<String> selectBrand;
    private List<String> selectModel;
    private List<String> selectClass;
    private List<String> selectTransmission;
    private List<String> selectGas;
    private List<String> selectLocation;
    private boolean cdw;
    private boolean mileageLimit;
    private List<Integer> selectChildSeats;


    public SearchQueryDTO(){}


    public SearchQueryDTO(List<String> selectBrand, List<String> selectModel, List<String> selectClass, List<String> selectTransmission, List<String> selectGas, List<String> selectLocation, boolean cdw, boolean mileageLimit, List<Integer> selectChildSeats) {
        this.selectBrand = selectBrand;
        this.selectModel = selectModel;
        this.selectClass = selectClass;
        this.selectTransmission = selectTransmission;
        this.selectGas = selectGas;
        this.selectLocation = selectLocation;
        this.cdw = cdw;
        this.mileageLimit = mileageLimit;
        this.selectChildSeats = selectChildSeats;
    }

    public List<String> getSelectBrand() {
        return selectBrand;
    }

    public void setSelectBrand(List<String> selectBrand) {
        this.selectBrand = selectBrand;
    }

    public List<String> getSelectModel() {
        return selectModel;
    }

    public void setSelectModel(List<String> selectModel) {
        this.selectModel = selectModel;
    }

    public List<String> getSelectClass() {
        return selectClass;
    }

    public void setSelectClass(List<String> selectClass) {
        this.selectClass = selectClass;
    }

    public List<String> getSelectTransmission() {
        return selectTransmission;
    }

    public void setSelectTransmission(List<String> selectTransmission) {
        this.selectTransmission = selectTransmission;
    }

    public List<String> getSelectGas() {
        return selectGas;
    }

    public void setSelectGas(List<String> selectGas) {
        this.selectGas = selectGas;
    }

    public List<String> getSelectLocation() {
        return selectLocation;
    }

    public void setSelectLocation(List<String> selectLocation) {
        this.selectLocation = selectLocation;
    }

    public boolean isCdw() {
        return cdw;
    }

    public void setCdw(boolean cdw) {
        this.cdw = cdw;
    }

    public boolean isMileageLimit() {
        return mileageLimit;
    }

    public void setMileageLimit(boolean mileageLimit) {
        this.mileageLimit = mileageLimit;
    }

    public List<Integer> getSelectChildSeats() {
        return selectChildSeats;
    }

    public void setSelectChildSeats(List<Integer> selectChildSeats) {
        this.selectChildSeats = selectChildSeats;
    }
}
