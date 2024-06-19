package in.co.rays.project_3.test;

import java.text.SimpleDateFormat;

import in.co.rays.project_3.dto.OrderDTO;
import in.co.rays.project_3.model.OrderModelHibImp;
import in.co.rays.project_3.model.OrderModelInt;

public class OrderModelTest {
	public static OrderModelInt model = new OrderModelHibImp();

	public static void main(String[] args) throws Exception {
		testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		//testSearch();

	}

	

	private static void testAdd() throws Exception {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		// System.out.println("heellloooooo");
		OrderDTO dto = new OrderDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		dto.setName("abc");
		dto.setProduct("ghgh");
		dto.setQuality("dffghad");
		//dto.setDate("12-12-2001");
		
		System.out.println("add");
		long pk = model.add(dto);
		System.out.println(pk + "data successfully insert");
	}
}