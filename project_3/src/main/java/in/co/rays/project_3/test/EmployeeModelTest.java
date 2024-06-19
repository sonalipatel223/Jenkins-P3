package in.co.rays.project_3.test;

import java.text.SimpleDateFormat;

import in.co.rays.project_3.dto.EmployeeDTO;
import in.co.rays.project_3.model.EmployeeModelHibImp;
import in.co.rays.project_3.model.EmployeeModelInt;

public class EmployeeModelTest {
	public static EmployeeModelInt model = new EmployeeModelHibImp();

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
		EmployeeDTO dto = new EmployeeDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		dto.setName("abc");
		dto.setDepartment("it");
		
		dto.setDateOfJoining(sdf.parse("20-04-1999"));
		dto.setLastEmployeeName("shgdhjadbc");;
		System.out.println("add");
		long pk = model.add(dto);
		System.out.println(pk + "data successfully insert");
	}

}
