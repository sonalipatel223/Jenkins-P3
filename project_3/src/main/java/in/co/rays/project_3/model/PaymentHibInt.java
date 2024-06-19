package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.PaymentDTO;
import in.co.rays.project_3.util.HibDataSource;

public class PaymentHibInt implements PaymentInt{

	@Override
	public long save(PaymentDTO dto) {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		session.save(dto);
		
		dto.getId();
		tx.commit();
		session.close();
		return dto.getId();
	}

	@Override
	public void update(PaymentDTO dto) {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();
		
	}

	@Override
	public void delete(PaymentDTO dto) {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();
		
	}

	@Override
	public PaymentDTO finfByPk(long pk) {
		Session session=HibDataSource.getSession();
		PaymentDTO dto=(PaymentDTO)session.get(PaymentDTO.class, pk);
		return dto;
	}

	@Override
	public List search(PaymentDTO dto, int pageNo, int pageSize) {
		Session session=HibDataSource.getSession();
		Criteria criteria=session.createCriteria(PaymentDTO.class);
		if(dto !=null) {
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
			if (dto.getType() != null && dto.getType().length() > 0) {
				criteria.add(Restrictions.like("type", dto.getType() + "%"));
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

}
