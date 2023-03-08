
public class InsufficientFundException extends Exception{
	private static final long serialVersionUID = 90803043979919831L;
	public InsufficientFundException() {
		super("잔액 부족");
	}
	public InsufficientFundException(String msg) {
		super(msg);
	}
}
