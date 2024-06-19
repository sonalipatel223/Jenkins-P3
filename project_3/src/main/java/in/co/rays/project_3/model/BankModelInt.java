package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.BankDTO;
import in.co.rays.project_3.exception.ApplicationException;

public interface BankModelInt {
	public long save(BankDTO dto);
	public void update(BankDTO dto);
	public void delete(BankDTO dto);
	public BankDTO finfByPk(long pk);
	public List search(BankDTO dto,int pageNo,int pageSize);
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
}
