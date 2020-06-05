package searchService.dto;

import searchService.model.ReservedDates;

public class ReservedDatesDTO {

    private Long id;
    private String oneDate;

    public ReservedDatesDTO(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOneDate() {
        return oneDate;
    }

    public void setOneDate(String oneDate) {
        this.oneDate = oneDate;
    }

    public ReservedDatesDTO(Long id, String oneDate) {
        this.id = id;
        this.oneDate = oneDate;
    }
    public ReservedDatesDTO(ReservedDates reservedDate) {
        this.id = reservedDate.getId();
        this.oneDate = reservedDate.getOneDate();
    }
}
