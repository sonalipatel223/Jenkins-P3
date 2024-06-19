package in.co.rays.project_3.dto;

import java.util.Date;

public class JobDTO extends BaseDTO{
	
	
	
	private String title;
	private Date dateOfOpning;
	private String experience;
	private String status;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateOfOpning() {
		return dateOfOpning;
	}

	public void setDateOfOpning(Date dateOfOpning) {
		this.dateOfOpning = dateOfOpning;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getKey() {
		
		return status+"";
	}

	@Override
	public String getValue() {
		
		return status+"";
	}

}
