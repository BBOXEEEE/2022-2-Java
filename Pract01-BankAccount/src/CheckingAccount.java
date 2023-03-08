/**
 * CheckingAccount.java
 * @version 2022년 9월 
 * @author 2019136056 박세현 
 * BankAccount 클래스를 상속받아 입출금 시 발생하는 수수료를 계산하여 잔액에서 차감하는 클래스 
 */

public class CheckingAccount extends BankAccount {
	private int transCount = 0; 	// 입출금 횟수 
	public static final int FREE_TRANS = 3;		// 무료 송금 횟수 
	public static final int TRANS_FEE = 100;	// 송금 수수료 
	
	public CheckingAccount() {}					// 자식 클래스 생성자 정의 시 부모 클래스도 고려하여 자식 클래스의 생성자 작성 
	public CheckingAccount(int amount) {
		super(amount);
	}
	
	// @Override : 컴파일러를 똑똑하게 만들어줌. 오타 등 부모 메소드에 없는 메소드 재정의 시 오류 메시지 
	@Override public void deposit(int amount) {		// 자식 메소드가 부모 메소드를 재정의할 때, 부모 메소드를 완전히 무시하지 않고 
		super.deposit(amount);						// 부모 메소드의 코드를 활용하면서 추가적인 기능 작성 
		++transCount;
	}
	@Override public void withdraw(int amount) throws InsufficientFundException {
		super.withdraw(amount);
		++transCount;
	}
	public void deductFee() throws InsufficientFundException {
		if(transCount > FREE_TRANS) {
			int fees = TRANS_FEE * (transCount - FREE_TRANS);
			super.withdraw(fees);
		}
		transCount = 0;
	}
}
