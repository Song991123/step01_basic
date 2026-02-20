package ex0220.set;

import java.util.Objects;

public class Member {
	private String name;
	private int		 age;
	private String addr;
	
	
	public Member() {
		super();
	}


	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}

	// set에 넣는 용으로 기준을 다시 세운다 ===========================
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member m) {
			if(name.equals(m.getName()) && age == m.getAge()){
				return true; //중복
			}
		}
		return false;
	}


	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	
}
