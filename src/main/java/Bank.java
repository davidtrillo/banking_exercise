
public class Bank {

	private String bankID;

	public Bank(String bankID) {
		super();
		this.bankID = bankID;
	}

	public Bank() {
		super();
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public static Bank getBancoSantander() {
		Bank bank = new Bank();
		bank.setBankID("0049");
		return bank;
	}

	public static Bank getCaixaBank() {
		Bank bank = new Bank();
		bank.setBankID("2100");
		return bank;
	}

}
