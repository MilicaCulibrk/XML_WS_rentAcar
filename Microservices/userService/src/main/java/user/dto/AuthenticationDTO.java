package user.dto;

public class AuthenticationDTO {
	private String username;
	private String password;
	private String role;
	private Long id;
	private Boolean active;
	
	public AuthenticationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
