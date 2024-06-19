package in.co.rays.project_3.model;


import java.util.List;

import in.co.rays.project_3.dto.QualityDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface QualityModelInt {
	
	public long add(QualityDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(QualityDTO dto)throws ApplicationException;
	public void update(QualityDTO dto)throws ApplicationException,DuplicateRecordException;
	public QualityDTO findByPK(long pk)throws ApplicationException;
	public QualityDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(QualityDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(QualityDTO dto)throws ApplicationException;
	public List getRoles(QualityDTO dto)throws ApplicationException;
	

}