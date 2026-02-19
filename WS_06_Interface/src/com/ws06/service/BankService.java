package com.ws06.service;

import java.util.List;

import com.ws06.dto.AccountDto;
import com.ws06.dto.UserDto;

public interface BankService {
	
	public List<AccountDto> getAccountList(int userSeq);
	
	public List<AccountDto> getAccountList();
	
	public UserDto getUserDetail(int userSeq);
	
	public List<AccountDto> getAccountListSortByBalance();
	
	public List<AccountDto> getAccountListSortByUserSeq();
}
