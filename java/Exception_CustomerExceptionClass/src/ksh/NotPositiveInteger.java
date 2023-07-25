package ksh;

public class NotPositiveInteger extends Exception {
	
	private static final int ERR_CODE = 503;
	
	public NotPositiveInteger(String msg) {
		super(msg);
	}
	
	public int getErrCode() {
		return ERR_CODE;
	}
}
