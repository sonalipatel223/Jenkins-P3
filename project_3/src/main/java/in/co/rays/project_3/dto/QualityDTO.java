package in.co.rays.project_3.dto;

import java.util.Date;

public class QualityDTO extends BaseDTO{
	private String name;
private String product;
private String quality;
private Date date;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public String getQuality() {
	return quality;
}
public void setQuality(String quality) {
	this.quality = quality;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String getKey() {
	// TODO Auto-generated method stub
	return quality+"";
}
@Override
public String getValue() {
	// TODO Auto-generated method stub
	return quality+"";
}

}
