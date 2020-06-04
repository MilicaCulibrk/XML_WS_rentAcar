package addvertisment.dto;

import addvertisment.model.ReservedDate;

public class ReservedDateDTO {
    private Long id;
    private String oneDate;

    public ReservedDateDTO(){
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

    public ReservedDateDTO(Long id, String oneDate) {
        this.id = id;
        this.oneDate = oneDate;
    }
    public ReservedDateDTO(ReservedDate reservedDate) {
        this.id = reservedDate.getId();
        this.oneDate = reservedDate.getOneDate();
    }
}
