
package in.co.rays.project_3.dto;

import java.util.Date;

public class ProductDTO extends BaseDTO {

	private String name;
	private String product;
	private String quantity;
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
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
		return product+"";
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return product+"";
	}

}