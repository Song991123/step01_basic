package com.ws06.dto;

public class SavingAccountDto extends AccountDto {
	private int transferFee;

	
	public SavingAccountDto() {
		super();
	}


	public SavingAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int transferFee) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.transferFee = transferFee;
	}


	public int getTransferFee() {
		return transferFee;
	}


	public void setTransferFee(int transferFee) {
		this.transferFee = transferFee;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SavingAccountDto [transferFee=");
		builder.append(transferFee);
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
