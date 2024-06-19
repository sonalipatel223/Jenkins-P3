package in.co.rays.project_3.dto;

public class ClientDTO extends BaseDTO{
	
	
	private String name;
	private String address;
	private Long phone;
	private String priority;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String getKey() {
		
		return priority+"";
	}

	@Override
	public String getValue() {
		
		return priority+"";
	}

}
