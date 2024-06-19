package in.co.rays.project_3.dto;

public class BankDTO extends BaseDTO {
	private String cName;
	private String account;
	private String amount;
	

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return cName+" ";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return cName;
	}

}
