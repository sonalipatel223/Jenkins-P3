package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.EmployeeDTO;



public interface EmployeeInt {
	public long save(EmployeeDTO dto);
	public void update(EmployeeDTO dto);
	public void delete(EmployeeDTO dto);
	public EmployeeDTO finfByPk(long pk);
	public List search(EmployeeDTO dto,int pageNo,int pageSize);
	

}
