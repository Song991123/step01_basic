package com.ws04.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ws04.dto.AccountDto;
import com.ws04.dto.UserDto;

/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */


//자동 import 단축키 = ctrl + shift + 영문o
public class BankService {
	List<AccountDto> accountList = new ArrayList<>();
	List<UserDto> userList = new ArrayList<>();
	
	/**
	 * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 리스트에 저장한다
	 * */
	public BankService() {
		
		// 각 배열방에 고객과 계좌를 생성한다.
		 //고객 4명
		 userList.add(new UserDto(100, "장희정", "8253jang@daum.net", "010-8875-8253", false));
		 userList.add(new UserDto(200, "이효리", "lee@daum.net", "010-2222-3333", false));
		 userList.add(new UserDto(300, "송중기", "song@naver.com", "010-5554-2222", false));
		 userList.add(new UserDto(400, "삼순이", "sam@daum.com", "010-2222-2222", false));
		 
		 //계좌는 6개 정도
		 accountList.add(new AccountDto(1, "1111-11111", 1000000, 100));
		 accountList.add(new AccountDto(2, "2222-22222", 250000, 100));
		 accountList.add(new AccountDto(3, "3333-33333", 350000, 100));
		 
		 accountList.add(new AccountDto(4, "4444-44444", 150000, 200));
		 accountList.add(new AccountDto(5, "5555-55555", 250000, 200));
		 
		 accountList.add(new AccountDto(6, "6666-66666", 350000, 300));
		 
	}//생성자 끝
	
    /**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	public List<AccountDto> getAccountList(int userSeq) {
		List<AccountDto> userAccounts  = new ArrayList<>();
		
		for(AccountDto account : accountList) {
			if(account.getUserSeq() == userSeq) userAccounts.add(account);
		}
		
		return userAccounts;
	}
	
	/**
	 * 모든 계좌 정보를 조회한다.
	 * */
	public List<AccountDto> getAccountList() {
		
		return accountList;
	}
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	public UserDto getUserDetail(int userSeq) {
		for(UserDto user : userList) {
			if(user.getUserSeq() == userSeq) return user;
		}
		return null;
	}
	
	/**
	 * 잔액 기준으로 정렬한다.
	 * */
	public List<AccountDto> getAccountListSortByBalance(){
		List<AccountDto> copyList = new ArrayList<AccountDto>(accountList);
		Collections.sort(copyList); //Comparable Interface 이용
		
		return copyList;
	}
	
	/**
	 * UserSeq 기준으로 정렬한다.
	 * + 만약 사용자 번호가 같으면, 잔액을 기준으로 내림차순을 한다.
	 * */
	public List<AccountDto> getAccountListSortByUserSeq(){
		List<AccountDto> copyList = new ArrayList<AccountDto>(accountList);
		Collections.sort(copyList, 
				(e1, e2) -> e1.getUserSeq() == e2.getUserSeq() ? e1.getBalance() - e2.getBalance() : e1.getUserSeq() - e2.getUserSeq()); //Comparator Interface 이용
		
		return copyList;
	}
	
}










