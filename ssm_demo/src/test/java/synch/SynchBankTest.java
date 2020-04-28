package synch;

import java.text.SimpleDateFormat;

public class SynchBankTest {
	
//	public static final int NACCOUNTS = 100;
	public static final int NACCOUNTS = 5;
	public static final double INITIAL_BALANCE = 1000 * 2;
	public static final double MAX_AMOUNT = 1000;
	public static final int DELAY = 10;
	
	public static final ThreadLocal<SimpleDateFormat> dateFormat =
			ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
//	public static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
//		SimpleDateFormat sdf = new SimpleDateFormat();
//	};
			
	
	public static void main(String[] args) {
		Bank bank = new Bank(NACCOUNTS,INITIAL_BALANCE);
		for(int i = 0 ; i < NACCOUNTS ; i++) {
			int fromAccout = i;
			System.out.println("i:"+i);
			Runnable r = ()->{
				try {
					while(true) {
						int toAccount = (int)(bank.size()*Math.random());
						double amount = MAX_AMOUNT * Math.random();
						bank.transfer(fromAccout, toAccount, amount);
						Thread.sleep((int)(DELAY * Math.random()));
					}
				}catch (Exception e) {
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
	}
}
