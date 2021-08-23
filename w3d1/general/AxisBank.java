package assignments.w3d1.general;

public class AxisBank extends BankInfo {

	@Override
	public void deposit() {
		super.deposit();
		System.out.println("Deposit method-Axis bank");
	}

	public static void main(String[] args) {

		BankInfo obj = new AxisBank();

		obj.savings();
		obj.fixed();
		obj.deposit();

	}

}
