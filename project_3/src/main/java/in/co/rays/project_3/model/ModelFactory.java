package in.co.rays.project_3.model;

import java.util.HashMap;
import java.util.ResourceBundle;

/**        
 * ModelFactory decides which model implementation run
 * 
 * @author Sonali Patel
 */
public final class ModelFactory {

	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.project_3.bundle.system");
	private static final String DATABASE = rb.getString("DATABASE");

	private static ModelFactory mFactory = null;
	private static HashMap modelCache = new HashMap();

	private ModelFactory() {
		// default constructer......!!!
	}

	public static ModelFactory getInstance() {
		if (mFactory == null) {
			mFactory = new ModelFactory();
		}
		return mFactory;
	}

	public MarksheetModelInt getMarksheetModel() {
		MarksheetModelInt marksheetModel = (MarksheetModelInt) modelCache.get("marksheetModel");
		if (marksheetModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				marksheetModel = new MarksheetModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				marksheetModel = new MarksheetModelJDBCImpl();
			}
			modelCache.put("marksheetModel", marksheetModel);
		}
		return marksheetModel;
	}

	public CollegeModelInt getCollegeModel() {
		CollegeModelInt collegeModel = (CollegeModelInt) modelCache.get("collegeModel");
		if (collegeModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				collegeModel = new CollegeModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				collegeModel = new CollegeModelJDBCImpl();
			}
			modelCache.put("collegeModel", collegeModel);
		}
		return collegeModel;
	}

	public RoleModelInt getRoleModel() {
		RoleModelInt roleModel = (RoleModelInt) modelCache.get("roleModel");
		if (roleModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				roleModel = new RoleModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				roleModel = new RoleModelJDBCImpl();
			}
			modelCache.put("roleModel", roleModel);
		}
		return roleModel;
	}

	public UserModelInt getUserModel() {

		UserModelInt userModel = (UserModelInt) modelCache.get("userModel");
		if (userModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				userModel = new UserModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				userModel = new UserModelJDBCImpl();
			}
			modelCache.put("userModel", userModel);
		}

		return userModel;
	}

	public StudentModelInt getStudentModel() {
		StudentModelInt studentModel = (StudentModelInt) modelCache.get("studentModel");
		if (studentModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				studentModel = new StudentModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				studentModel = new StudentModelJDBCImpl();
			}
			modelCache.put("studentModel", studentModel);
		}

		return studentModel;
	}

	public CourseModelInt getCourseModel() {
		CourseModelInt courseModel = (CourseModelInt) modelCache.get("courseModel");
		if (courseModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				courseModel = new CourseModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				courseModel = new CourseModelJDBCImpl();
			}
			modelCache.put("courseModel", courseModel);
		}

		return courseModel;
	}

	public TimetableModelInt getTimetableModel() {

		TimetableModelInt timetableModel = (TimetableModelInt) modelCache.get("timetableModel");

		if (timetableModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				timetableModel = new TimetableModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				timetableModel = new TimetableModelJDBCImpl();
			}
			modelCache.put("timetableModel", timetableModel);
		}

		return timetableModel;
	}

	public SubjectModelInt getSubjectModel() {
		SubjectModelInt subjectModel = (SubjectModelInt) modelCache.get("subjectModel");
		if (subjectModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				subjectModel = new SubjectModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				subjectModel = new SubjectModelJDBCImpl();
			}
			modelCache.put("subjectModel", subjectModel);
		}

		return subjectModel;
	}

	public FacultyModelInt getFacultyModel() {
		FacultyModelInt facultyModel = (FacultyModelInt) modelCache.get("facultyModel");
		if (facultyModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				facultyModel = new FacultyModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				facultyModel = new FacultyModelJDBCImpl();
			}
			modelCache.put("facultyModel", facultyModel);
		}

		return facultyModel;
	}

	public BankModelInt getBankModel() {
		BankModelInt BankModel = (BankModelInt) modelCache.get("BankModel");
		if (BankModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				BankModel = new BankModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				BankModel = new BankModelHibImp();
			}
			modelCache.put("BankModel", BankModel);
		}
		return BankModel;

	}

	
	public PaymentInt getPaymentModel() {
		PaymentInt PaymentModel=(PaymentInt) modelCache.get("PaymentModel");
		if(PaymentModel==null) {
			if("Hibernate".equals(DATABASE)) {
				PaymentModel=new PaymentHibInt();
			}
			if("JDBC".equals(DATABASE)) {
				PaymentModel=new PaymentHibInt();
			}
			modelCache.put("PaymentModel", PaymentModel);
		}
		return PaymentModel;
	}
	
	
	
	public EmployeeModelInt getEmployeeModel() {
		EmployeeModelInt employeeModel = (EmployeeModelInt) modelCache.get("employeeModel");
		if (employeeModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				employeeModel = new EmployeeModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				employeeModel = new EmployeeModelHibImp();
			}
			modelCache.put("employeeModel", employeeModel);
		}

		return employeeModel;
	}
	
	
	public OrderModelInt getOrderModel() {
		OrderModelInt orderModel = (OrderModelInt) modelCache.get("orderModel");
		if (orderModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				orderModel = new OrderModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				orderModel = new OrderModelHibImp();
			}
			modelCache.put("orderModel", orderModel);
		}

		return orderModel;
	}


	
	public QualityModelInt getQualityModel() {
		QualityModelInt qualityModel = (QualityModelInt) modelCache.get("qualityModel");
		if (qualityModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				qualityModel = new QualityModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				qualityModel = new QualityModelHibImp();
			}
			modelCache.put("qualityModel", qualityModel);
		}

		return qualityModel;
	}



	public ShoppingModelInt getShoppingModel() {
		ShoppingModelInt shoppingModel = (ShoppingModelInt) modelCache.get("shoppingModel");
		if (shoppingModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				shoppingModel = new ShoppingModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				shoppingModel = new ShoppingModelHibImp();
			}
			modelCache.put("shoppingModel", shoppingModel);
		}

		return shoppingModel;
	}
	public ProductModelInt getProductModel() {
		ProductModelInt productModel = (ProductModelInt) modelCache.get("productModel");
		if (productModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				productModel = new ProductModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				productModel = new ProductModelHibImp();
			}
			modelCache.put("productModel", productModel);
		}

		return productModel;
	}
	
	public WishModelInt getWishModel() {
		WishModelInt wishModel = (WishModelInt) modelCache.get("wishModel");
		if (wishModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				wishModel = new WishModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				wishModel = new WishModelHibImp();
			}
			modelCache.put("wishModel", wishModel);
		}
		return wishModel;
	}
		public JobModelInt getJobModel() {
			JobModelInt jobModel = (JobModelInt) modelCache.get("jobModel");
			if (jobModel == null) {
				if ("Hibernate".equals(DATABASE)) {
					jobModel = new JobModelHibImp();
				}
				if ("JDBC".equals(DATABASE)) {
					jobModel = new JobModelHibImp();
				}
				modelCache.put("jobModel", jobModel);
			}

		return jobModel;
	}

		public StatusModelInt getStatusModel() {
			StatusModelInt statusModel = (StatusModelInt) modelCache.get("statusModel");
			if (statusModel == null) {
				if ("Hibernate".equals(DATABASE)) {
					statusModel = new StatusModelHibImp();
				}
				if ("JDBC".equals(DATABASE)) {
					statusModel = new StatusModelHibImp();
				}
				modelCache.put("statusModel", statusModel);
			}

		return statusModel;
	}

		public ClientModelInt getClientModel() {
			ClientModelInt clientModel = (ClientModelInt) modelCache.get("clientModel");
			if (clientModel == null) {
				if ("Hibernate".equals(DATABASE)) {
					clientModel = new ClientModelHibImp();
				}
				if ("JDBC".equals(DATABASE)) {
					clientModel = new ClientModelHibImp();
				}
				modelCache.put("clientModel", clientModel);
			}

		return clientModel;
	}
		public PriorityModelInt getPriorityModel() {
			PriorityModelInt priorityModel = (PriorityModelInt) modelCache.get("priorityModel");
			if (priorityModel == null) {
				if ("Hibernate".equals(DATABASE)) {
					priorityModel = new PriorityModelHibImp();
				}
				if ("JDBC".equals(DATABASE)) {
					priorityModel = new PriorityModelHibImp();
				}
				modelCache.put("priorityModel", priorityModel);
			}

		return priorityModel;
	}
		
		public IssueModelInt getIssueModel() {
			IssueModelInt issueModel = (IssueModelInt) modelCache.get("issueModel");
			if (issueModel == null) {
				if ("Hibernate".equals(DATABASE)) {
					issueModel = new IssueModelHibImp();
				}
				if ("JDBC".equals(DATABASE)) {
					issueModel = new IssueModelHibImp();
				}
				modelCache.put("issueModel", issueModel);
			}

		return issueModel;
	}

		
		public ProjectModelInt getProjectModel() {
			ProjectModelInt projectModel = (ProjectModelInt) modelCache.get("projectModel");
			if (projectModel == null) {
				if ("Hibernate".equals(DATABASE)) {
					projectModel = new ProjectModelHibImp();
				}
				if ("JDBC".equals(DATABASE)) {
					projectModel = new ProjectModelHibImp();
				}
				modelCache.put("projectModel", projectModel);
			}

		return projectModel;
	}
		
		
		public FieldModelInt getFieldModel() {
			FieldModelInt fieldModel = (FieldModelInt) modelCache.get("fieldModel");
			if (fieldModel == null) {
				if ("Hibernate".equals(DATABASE)) {
					fieldModel = new FieldModelHibImp();
				}
				if ("JDBC".equals(DATABASE)) {
					fieldModel = new FieldModelHibImp();
				}
				modelCache.put("fieldModel", fieldModel);
			}

		return fieldModel;
	}
		
		public SalaryModelInt getSalaryModel() {
			SalaryModelInt salaryModel = (SalaryModelInt) modelCache.get("salaryModel");
			if (salaryModel == null) {
				if ("Hibernate".equals(DATABASE)) {
					salaryModel = new SalaryModelHibImp();
				}
				if ("JDBC".equals(DATABASE)) {
					salaryModel = new SalaryModelHibImp();
				}
				modelCache.put("salaryModel", salaryModel);
			}

		return salaryModel;
	}
		
		
		public DoctorModelInt getDoctorModel() {
			DoctorModelInt doctorModel = (DoctorModelInt) modelCache.get("doctorModel");
			if (doctorModel == null) {
				if ("Hibernate".equals(DATABASE)) {
					doctorModel = new DoctorModelHibImp();
				}
				if ("JDBC".equals(DATABASE)) {
					doctorModel = new DoctorModelHibImp();
				}
				modelCache.put("doctorModel", doctorModel);
			}

		return doctorModel;
	}
		
		public PrescriptionModelInt getPrescriptionModel() {
			PrescriptionModelInt prescriptionModel = (PrescriptionModelInt) modelCache.get("prescriptionModel");
			if (prescriptionModel == null) {
				if ("Hibernate".equals(DATABASE)) {
					prescriptionModel = new PrescriptionModelHibImp();
				}
				if ("JDBC".equals(DATABASE)) {
					prescriptionModel = new PrescriptionModelHibImp();
				}
				modelCache.put("prescriptionModel", prescriptionModel);
			}

		return prescriptionModel;
	}
		
		
		public PatientModelInt getPatientModel() {
			PatientModelInt patientModel = (PatientModelInt) modelCache.get("patientModel");
			if (patientModel == null) {
				if ("Hibernate".equals(DATABASE)) {
					patientModel = new PatientModelHibImp();
				}
				if ("JDBC".equals(DATABASE)) {
					patientModel = new PatientModelHibImp();
				}
				modelCache.put("patientModel", patientModel);
			}

		return patientModel;
	}

}


