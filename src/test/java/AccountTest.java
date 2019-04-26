import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	private Account payer;
	private Account payee;

	@Before
	public void loadTestData() {
		payer = Account.getCuenta1();
		payee = Account.getCuenta2();
	}

	@Test
	public void checkIfPayerClientIsTheSameThanPayeeClient() {
		/*
		 * Assert.assertEquals("checkIfPayerClientIsTheSameThanPayeeClient()",
		 * payer.getClient().getNationalID(), payee.getClient().getNationalID());
		 */

		Assert.assertTrue("checkIfPayerClientIsTheSameThanPayeeClient()",
				payer.getClient().getNationalID().equalsIgnoreCase(payee.getClient().getNationalID()));
	}

	@Test
	public void checkIfOriginAmountItIsCorrectAfterTransfer() {
		float previousAmount = payer.getAmount();
		float amountToPay = 50.f;
		float expectedResult = previousAmount - amountToPay;

		boolean result = payer.doTransferToOtherAccounts(payee, amountToPay);
		Assert.assertEquals("checkIfOriginAmountItIsCorrectAfterTransfer()", payer.getAmount(), expectedResult, 0);
	}

	@Test
	public void checkIfDestinationAmountItIsCorrectAfterTransfer() {
		float previousAmount = payee.getAmount();
		float amountToPay = 50.f;
		float expectedResult = previousAmount + amountToPay;

		boolean result = payer.doTransferToOtherAccounts(payee, amountToPay);
		Assert.assertEquals("checkIfDestinationAmountItIsCorrectAfterTransfer()", payee.getAmount(), expectedResult, 0);
	}

	@Test
	public void checkIfOriginAccountCanDoTransfer_OK() {
		float amountToPay = 50.f;
		Assert.assertTrue("checkIfOriginAccountCanDoTransfer_OK()", payer.canDoTransfer(amountToPay));
	}

	@Test
	public void checkIfOriginAccountCanDoTransfer_KO() {
		float amountToPay = 200.f;
		Assert.assertTrue("checkIfOriginAccountCanDoTransfer_KO()", payer.canDoTransfer(amountToPay));
	}

	@Test
	public void checkIfTransferItIsForTheSameClientAndSameBank() {
		Account payer1a = Account.getCuenta1a();
		boolean sameClientAndBank = payer.isSameClientAndSameBank(payer1a);
		Assert.assertTrue("checkIfTransferItIsForTheSameClientAndSameBank()", sameClientAndBank);

		float amountToMove = 80.f;
		boolean result = payer.doTransferToMyAccounts(payer1a, amountToMove);
		Assert.assertTrue("checkIfTransferItIsForTheSameClientAndSameBank()", result);
	}

	/**
	 * TDD approach result
	 */

	/**
	 * Step 1. Do a test, even if it throws an error
	 * 
	 */
	@Test
	public void checkIfTransferItIsForTheSameClientAndSameBankWithTDD_Step1() {
		Account payer1a = Account.getCuenta1a();
		float amountToMove = 80.f;
		// doLocalTransfer is not defined at this point

		// FIXME
		// The next lines are commented just to avoid compilation errors.
		// boolean result = payer.doLocalTransfer(payer, payer1a, amountToMove);
		// Assert.assertTrue("checkIfTransferItIsForTheSameClientAndSameBankWithTDD_Step1()",
		// result);
	}

	@Test
	public void checkIfTransferItIsForTheSameClientAndSameBankWithTDD_Step2() {
		Account payer1a = Account.getCuenta1a();
		float amountToMove = 80.f;
		// doLocalTransferWithInitialImplementation has the minimum code for tests the
		// functionality
		boolean result = payer.doLocalTransferWithInitialImplementation(payer, payer1a, amountToMove);
		Assert.assertTrue("checkIfTransferItIsForTheSameClientAndSameBankWithTDD_Step2()", result);
	}

	@Test
	public void checkIfTransferItIsForTheSameClientAndSameBankWithTDD_Step3() {
		Account payer1a = Account.getCuenta1a();
		boolean sameClientAndBank = payer.isSameClientAndSameBank(payer1a);
		Assert.assertTrue("checkIfTransferItIsForTheSameClientAndSameBankWithTDD_Step3()", sameClientAndBank);

		float amountToMove = 80.f;
		// doTransfer method has been refactored
		boolean result = payer.doTransfer(Operations.Operation.LOCAL_BANK_TRANSFER, payer1a, amountToMove);
		Assert.assertTrue("checkIfTransferItIsForTheSameClientAndSameBankWithTDD_Step3()", result);
	}

}
