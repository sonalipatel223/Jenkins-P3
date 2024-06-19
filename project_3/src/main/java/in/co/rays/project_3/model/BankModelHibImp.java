package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.BankDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.util.HibDataSource;

public class BankModelHibImp implements BankModelInt{

	@Override
	public long save(BankDTO dto) {
		
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		session.save(dto);
		tx.commit();

		dto.getId();
		session.close();
		return dto.getId();
	}

	@Override
	public void update(BankDTO dto) {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();
		

		
	}

	@Override
	public void delete(BankDTO dto) {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();
		
		
	}

	@Override
	public BankDTO finfByPk(long pk) {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		BankDTO dto=(BankDTO)session.get(BankDTO.class, pk);
		
		return dto;
	}

	@Override
	public List search(BankDTO dto, int pageNo, int pageSize) {
		Session session =HibDataSource.getSession();
		Criteria criteria=session.createCriteria(BankDTO.class);
		if (dto != null) {
			
			if (dto.getcName() != null && dto.getcName().length() > 0) {
				criteria.add(Restrictions.like("cName", dto.getcName() + "%"));
			}
			if (dto.getAccount() != null && dto.getAccount().length() > 0) {
				criteria.add(Restrictions.like("account", dto.getAccount() + "%"));
			}
			
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		List list=criteria.list();
		session.close();
		return list;
	}
	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		List list = null;
		
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(BankDTO.class);
			
			list = criteria.list();

		
			session.close();

		return list;
	}

	

	

}
