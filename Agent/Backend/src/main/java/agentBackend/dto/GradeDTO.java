package agentBackend.dto;

import agentBackend.model.Grade;

public class GradeDTO {

    private Long id;

    private Long user_id;

    private Integer number;

    public Long add_id;

	public GradeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GradeDTO(Grade grade) {
		this.id = grade.getId();
		this.user_id = grade.getUser_id();
		this.number = grade.getNumber();
		this.add_id = grade.getAddvertisment().getId();

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Long getAdd_id() {
		return add_id;
	}

	public void setAdd_id(Long add_id) {
		this.add_id = add_id;
	}


    
    
}

