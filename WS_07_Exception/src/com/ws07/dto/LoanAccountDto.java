package com.ws07.dto;

public class LoanAccountDto extends AccountDto {
	private String mortgage;

	
	
	public LoanAccountDto() {
		super();
	}

	public LoanAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, String mortgage) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.mortgage = mortgage;
	}

	public String getMortgage() {
		return mortgage;
	}

	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanAccountDto [mortgage=");
		builder.append(mortgage);
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
