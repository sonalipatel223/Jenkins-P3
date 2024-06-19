package in.co.rays.project_3.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.project_3.dto.PaymentDTO;
import in.co.rays.project_3.model.PaymentHibInt;

public class PaymentModelTest {

	public static void main(String[] args) {
		//testadd();
		//testUpdate();
		//testFindByPk();
		//testDelete();
		testSearch();
		
	}

	private static void testSearch() {
		PaymentDTO dto=new PaymentDTO();
		PaymentHibInt model=new PaymentHibInt();
		List list=model.search(dto, 0, 0);
		Iterator<PaymentDTO>it=list.iterator();
		while(it.hasNext()) {
			dto=it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			System.out.println(dto.getAmount());
		}
	}

	private static void testDelete() {
		PaymentHibInt model=new PaymentHibInt();
		PaymentDTO dto=new PaymentDTO();
		dto.setId(4L);
		model.delete(dto);
		
		
	}

	private static void testFindByPk() {
		PaymentHibInt model=new PaymentHibInt();
		PaymentDTO dto=model.finfByPk(2);
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getAmount());
		
	}

	private static void testUpdate() {
		PaymentDTO dto=new PaymentDTO();
		dto.setId(2L);
		dto.setName("dev");
		dto.setType("gpay");
		dto.setAmount(567839);
		PaymentHibInt model=new PaymentHibInt();
		model.update(dto);
		
		
	}

	private static void testadd() {
		PaymentDTO dto=new PaymentDTO();
		//dto.setId(1L);
		dto.setName("rahul");
		dto.setType("case");
		dto.setAmount(56789);
		PaymentHibInt model=new PaymentHibInt();
		long pk=model.save(dto);
		
	}

}
