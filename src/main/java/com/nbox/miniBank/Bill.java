package main.java.com.nbox.miniBank;

import java.util.Calendar;

public class Bill {
	private String billId;
	private String userId;
	private double cash;
	
	public Bill(String userId, double cash) {
		super();
		this.billId = generateBillId();
		this.userId = userId;
		this.cash = cash;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(float cash) {
		this.cash = cash;
	}
	
	private String generateBillId(){
		Calendar date = Calendar.getInstance();
		String billId = ""+date.get(Calendar.YEAR)+date.get(Calendar.MONTH)+date.get(Calendar.DAY_OF_MONTH)
				 +date.get(Calendar.HOUR_OF_DAY)+date.get(Calendar.MINUTE)+date.get(Calendar.SECOND)+date.get(Calendar.MILLISECOND);
		while (billId.length()<16){
			billId +=0;
		}
		return billId;
	}
}
