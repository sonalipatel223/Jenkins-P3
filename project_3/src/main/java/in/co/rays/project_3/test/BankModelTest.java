package in.co.rays.project_3.test;

import java.util.Iterator;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import in.co.rays.project_3.dto.BankDTO;
import in.co.rays.project_3.model.BankModelHibImp;

public class BankModelTest {

	public static void main(String[] args) {
		//testAdd();
		//testUpdate();
		//testDelete();
		//testFindByPk();
		//testSearch();

	}

	private static void testSearch() {
		BankDTO dto=new BankDTO();
		BankModelHibImp model=new BankModelHibImp();
		List list=model.search(dto, 0, 0);
		Iterator<BankDTO>it=list.iterator();
		while(it.hasNext()) {
			dto=(BankDTO)it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getcName());
			System.out.println(dto.getAccount());
			System.out.println(dto.getAmount());
			
		}
		
		
	}

	private static void testFindByPk() {
		BankModelHibImp model=new BankModelHibImp();
		BankDTO dto=model.finfByPk(1);
		System.out.println(dto.getId());
		System.out.println(dto.getcName());
		System.out.println(dto.getAccount());
		System.out.println(dto.getAmount());
		
		
	}

	private static void testDelete() {
		BankDTO dto=new BankDTO();
		dto.setId(2L);
		BankModelHibImp model=new BankModelHibImp();
		model.delete(dto);
		
	}

	private static void testUpdate() {
		BankDTO dto=new BankDTO();
		        dto.setId(1L);
				dto.setcName("ram");
				dto.setAccount("8765456543000");
				dto.setAmount("5456");
				BankModelHibImp model=new BankModelHibImp();
				model.update(dto);
	}

	private static void testAdd() {
		BankDTO dto=new BankDTO();
		//dto.setId(1L);
		dto.setcName("rohit");
		dto.setAccount("545654345");
		dto.setAmount("5456");
		BankModelHibImp model=new BankModelHibImp();
		 long pk = model.save(dto);
	}

}
