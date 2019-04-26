public class Account {

	private Client client;
	private Bank bank;
	private String accountID;
	private float amount;

	public Account(Client client, Bank bank, String accountID, float amount) {
		super();
		this.client = client;
		this.bank = bank;
		this.accountID = accountID;
		this.amount = amount;
	}

	public Account() {
		super();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public static Account getCuenta1() {
		Account account = new Account();
		account.setClient(Client.createClientA());
		account.setBank(Bank.getBancoSantander());
		account.setAccountID("00491111222233334444");
		account.setAmount(100.0f);
		return account;
	}

	public static Account getCuenta1a() {
		Account account = new Account();
		account.setClient(Client.createClientA());
		account.setBank(Bank.getBancoSantander());
		account.setAccountID("00492222333344445555");
		account.setAmount(200.0f);
		return account;
	}

	public static Account getCuenta2() {
		Account account = new Account();
		account.setClient(Client.createClientB());
		account.setBank(Bank.getCaixaBank());
		account.setAccountID("21001111222233334444");
		account.setAmount(0.0f);
		return account;
	}

	public boolean isPayerClientTheSameAsPayeeClient(Account account) {
		boolean sameClient = getClient().getNationalID().equalsIgnoreCase(account.getClient().getNationalID());
		return sameClient;
	}

	public boolean doTransferToOtherAccounts(Account destination, float amountToTransfer) {
		if (canDoTransfer(amountToTransfer)) {
			substractMoneyToAmount(amountToTransfer);
			destination.addMoneyToAmount(amountToTransfer);
			return true;
		}
		return false;
	}

	public boolean doTransferToMyAccounts(Account destination, float amountToTransfer) {
		if (canDoTransfer(amountToTransfer)) {
			substractMoneyToAmount(amountToTransfer);
			destination.addMoneyToAmount(amountToTransfer);
			return true;
		}
		return false;
	}

	public void addMoneyToAmount(float amountToTransfer) {
		setAmount(getAmount() + amountToTransfer);
	}

	public void substractMoneyToAmount(float amountToTransfer) {
		setAmount(getAmount() - amountToTransfer);
	}

	public boolean canDoTransfer(float amountToTransfer) {
		return getAmount() - amountToTransfer > 0;
	}

	public boolean isSameClientAndSameBank(Account account) {
		boolean sameClient = isPayerClientTheSameAsPayeeClient(account);
		boolean sameBank = getBank().getBankID().equalsIgnoreCase(account.getBank().getBankID());

		return sameClient && sameBank;
	}

	/**
	 * TDD refactoring
	 */

	// For step 1, no doLocalTransfer method is defined

	// For step 2, min. code to check and pass the test
	public boolean doLocalTransferWithInitialImplementation(Account origin, Account destination,
			float amountToTransfer) {
		if (getAmount() - amountToTransfer > 0
				&& (origin.getClient().getNationalID().equalsIgnoreCase(destination.getClient().getNationalID()))
				&& (origin.getBank().getBankID().equalsIgnoreCase(destination.getBank().getBankID()))) {
			origin.setAmount(origin.getAmount() - amountToTransfer);
			destination.setAmount(destination.getAmount() + amountToTransfer);
			return true;
		}
		return false;
	}

	// For step 3, code refactoring and re-launch the tests
	public boolean doTransfer(Operations.Operation operation, Account destination, float amountToTransfer) {
		if (canDoTransfer(amountToTransfer)) {
			substractMoneyToAmount(amountToTransfer);
			destination.addMoneyToAmount(amountToTransfer);
			return true;
		}
		return false;
	}

}
