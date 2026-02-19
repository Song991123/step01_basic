package com.ws06.dto;

public class InstallAccountDto extends AccountDto {
	private int period;
	private int amount;
	
	
	
	public InstallAccountDto() {
		super();
	}

	public InstallAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int period, int amount) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.period = period;
		this.amount = amount;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InstallAccountDto [period=");
		builder.append(period);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", getAccountSeq()=");
		builder.append(getAccountSeq());
		builder.append(", getAccountNumber()=");
		builder.append(getAccountNumber());
		builder.append(", getBalance()=");
		builder.append(getBalance());
		builder.append(", getUserSeq()=");
		builder.append(getUserSeq());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append("]");
		return builder.toString();
	}
	
	
}
