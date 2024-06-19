package in.co.rays.project_3.test;

import java.text.SimpleDateFormat;

import in.co.rays.project_3.dto.ProductDTO;
import in.co.rays.project_3.model.ProductModelHibImp;
import in.co.rays.project_3.model.ProductModelInt;

public class ProductModelTest {
	public static ProductModelInt model = new ProductModelHibImp();

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
		ProductDTO dto = new ProductDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		dto.setName("abc");
		dto.setProduct("hgfha");;
		dto.setQuantity("sgdhgw");;
		dto.setDate(sdf.parse("20-04-1999"));
		
		System.out.println("add");
		long pk = model.add(dto);
		System.out.println(pk + "data successfully insert");
	}

}
