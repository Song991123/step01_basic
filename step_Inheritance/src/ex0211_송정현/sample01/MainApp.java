package ex0211_송정현.sample01;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FullTime [] full = new FullTime[3];
		PartTime [] part = new PartTime[2];

		
		full[0] = new FullTime(10, "유재석", "개그우먼", 0 , "2013-05-01", "무한도전",8500,200);
		full[1] = new FullTime(20, "박명수", "가수",10, "2013-06-20", "무한도전",7500,100);
		full[2] = new FullTime(30, "정준하", "예능인",10 , "2013-06-22", "무한도전",6000,0);
		
		part[0] = new PartTime(40, "노홍철", "예능인",20 , "2014-05-01", "무한도전",20000);
		part[1] = new PartTime(50, "하하", "가수",30 , "2014-05-02", "무한도전",25000);
		
		//출력화면을 보고 코딩...
		System.out.println("************* FullTime 정보 *************");
		for(FullTime f : full) {
			System.out.println(f);
		}
		System.out.println();
		
		System.out.println("************* ParTime 정보 *************");
		for(PartTime p : part) {
			System.out.println(p);
		}
		System.out.println();
		
		System.out.println("************* Message *************");
		for(FullTime f : full) {
			f.message();
		}
		for(PartTime p : part) {
			p.message();
		}
	}

}
class FullTime{
	// 필드 선언 ====================
	private int 		empNo;
	private String 	eName;
	private String	job;
	private int			mgr;
	private String	hiredate;
	private String	deptName;
	private int			salary;
	private int			bonus;
	// ======================/
	
	// Constructor ===================
	public FullTime() {
		
	}
	public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int salary, int bonus) {
		this.empNo      = empNo;
		this.eName       = eName;
		this.job				= job;
		this.mgr	        = mgr;
		this.hiredate 	= hiredate;
		this.deptName  = deptName;
		this.salary		    = salary;
		this.bonus	    = bonus;
	}
	
	// ==========================/
	
	
	// GETTER ======================
	public int getEmpNo() {
		return empNo;
	}
	public String geteName() {
		return eName;
	}
	public String getJob() {
		return job;
	}
	public int getMgr() {
		return mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public String getDeptName() {
		return deptName;
	}
	public int getSalary() {
		return salary;
	}
	public int getBonus() {
		return bonus;
	}
	// ==========================/
	
	// SETTER ======================
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	// ==========================/
	
	// METHOD ========================
	public void message() {
		System.out.println(eName + "은 정규직입니다.");
	}
	
	public String toString() {
		return String.format(" %s | %s | %s | %s | %s | %s | %s | %s ", 
					empNo,
					eName,
					job,
					mgr,
					hiredate,
					deptName,
					salary,
					bonus
					);
	}
	
	
}


class PartTime{
	// 필드 선언 ====================
	private int 		empNo;
	private String 	eName;
	private String	job;
	private int			mgr;
	private String	hiredate;
	private String	deptName;
	private int			timePay;
	// ==========================/
	
	// Constructor ===================
		public PartTime() {
			
		}
		public PartTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int timePay) {
			this.empNo      = empNo;
			this.eName       = eName;
			this.job				= job;
			this.mgr	        = mgr;
			this.hiredate 	= hiredate;
			this.deptName  = deptName;
			this.timePay		= timePay;
		}
		// GETTER ======================
		public int getEmpNo() {
			return empNo;
		}
		public String geteName() {
			return eName;
		}
		public String getJob() {
			return job;
		}
		public int getMgr() {
			return mgr;
		}
		public String getHiredate() {
			return hiredate;
		}
		public String getDeptName() {
			return deptName;
		}
		public int getTimePay() {
			return timePay;
		}
		
		// ==========================/
		
		
		// SETTER ======================
		public void setEmpNo(int empNo) {
			this.empNo = empNo;
		}
		public void seteName(String eName) {
			this.eName = eName;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public void setMgr(int mgr) {
			this.mgr = mgr;
		}
		public void setHiredate(String hiredate) {
			this.hiredate = hiredate;
		}
		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}
		public void setTimePay(int timePay) {
			this.timePay = timePay;
		}
		// ==========================/
		
		// METHOD ========================
		public void message() {
			System.out.println(eName + "은 비정규직입니다.");
		}
		
		public String toString() {
			return String.format(" %s | %s | %s | %s | %s | %s", 
						empNo,
						eName,
						job,
						mgr,
						deptName,
						timePay);
		}
		
		
		
}




