package in.co.rays.project_3.dto;

public class PriorityDTO extends BaseDTO{
	
	
	private String priority;
	
	

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
