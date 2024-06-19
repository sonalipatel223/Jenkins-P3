package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.PaymentDTO;


public interface PaymentInt {
	public long save(PaymentDTO dto);
	public void update(PaymentDTO dto);
	public void delete(PaymentDTO dto);
	public PaymentDTO finfByPk(long pk);
	public List search(PaymentDTO dto,int pageNo,int pageSize);
	

}
