package in.co.rays.project_3.dto;

import java.util.Date;

public class OrderDTO extends BaseDTO{
	
	private String name;
	private String quality;
	private String product;
	private Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String getKey() {
		return quality+"";
	}
	@Override
	public String getValue() {
		return quality;
	}
	

}
