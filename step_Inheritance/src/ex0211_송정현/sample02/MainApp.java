package ex0211_송정현.sample02;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee[] employee = new Employee[5];
		
		employee[0] = new FullTime(10, "유재석", "개그우먼", 0 , "2013-05-01", "무한도전",8500,200);
		employee[1] = new FullTime(20, "박명수", "가수",10, "2013-06-20", "무한도전",7500,100);
		employee[2] = new FullTime(30, "정준하", "예능인",10 , "2013-06-22", "무한도전",6000,0);
		
		employee[3] = new PartTime(40, "노홍철", "예능인",20 , "2014-05-01", "무한도전",20000);
		employee[4] = new PartTime(50, "하하", "가수",30 , "2014-05-02", "무한도전",25000);
		
		
		System.out.println("************* Emp 정보 *************");
		for(Employee e : employee) {
			System.out.println(e);
		}
		
		
		System.out.println("************* Message *************");
		for(Employee e : employee) {
			e.message();
		}
		
	}

}
class Employee{
	// 필드 선언 ====================
	private int 		empNo;
	private String 	eName;
	private String	job;
	private int			mgr;
	private String	hiredate;
	private String	deptName;
	// ======================/
	
	// Constructor ===================
	public Employee() {
		
	}
	public Employee(int empNo, String eName, String job, int mgr, String hiredate, String deptName) {
		this.empNo      = empNo;
		this.eName       = eName;
		this.job				= job;
		this.mgr	        = mgr;
		this.hiredate 	= hiredate;
		this.deptName  = deptName;
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
		// ==========================/
		
		// METHOD ========================
		public void message() {
			System.out.println(eName + "은 직원입니다.");
		}
		
		public String toString() {
			return String.format(" %s | %s | %s | %s | %s | %s", 
						empNo,
						eName,
						job,
						mgr,
						hiredate,
						deptName
						);
		}
		// =============================/
}
class FullTime extends Employee{
	// 필드 선언 ====================
	private int			salary;
	private int			bonus;
	// ======================/
	
	
	// Constructor ===================
	public FullTime() {
		
	}
	public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int salary, int bonus) {
		setEmpNo(empNo);
		seteName(eName);
		setJob(job);
		setMgr(mgr);
		setHiredate(hiredate);
		setDeptName(deptName);
		setSalary(salary);
		setBonus(bonus);
	}
	// ==========================/
	
	// GETTER ======================
	public int getSalary() {
		return salary;
	}
	public int getBonus() {
		return bonus;
	}
	// ==========================/
	
	// SETTER ======================
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	// ==========================/
	
	// METHOD ========================
	public void message() {
		System.out.println(geteName() + "은 정규직입니다.");
	}
	
	public String toString() {
		return String.format(" %s | %s | %s | %s | %s | %s | %s | %s ", 
					getEmpNo(),
					geteName(),
					getJob(),
					getMgr(),
					getHiredate(),
					getDeptName(),
					getSalary(),
					getBonus()
					);
	}
	
	
}

class PartTime extends Employee{
	// 필드 선언 ====================
		private int			timePay;
		// ==========================/
		
		// Constructor ===================
			public PartTime() {
				
			}
			public PartTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int timePay) {
				setEmpNo(empNo);
				seteName(eName);
				setJob(job);
				setMgr(mgr);
				setHiredate(hiredate);
				setDeptName(deptName);
				setTimePay(timePay);
			}
			// GETTER ======================
			public int getTimePay() {
				return timePay;
			}
			
			// ==========================/
			
			
			// SETTER ======================
			public void setTimePay(int timePay) {
				this.timePay = timePay;
			}
			// ==========================/
			
			// METHOD ========================
			public void message() {
				System.out.println(geteName() + "은 비정규직입니다.");
			}
			
			public String toString() {
				return String.format(" %s | %s | %s | %s | %s | %s", 
						getEmpNo(),
						geteName(),
						getJob(),
						getMgr(),
						getHiredate(),
						getDeptName(),
						getTimePay());
			}
}






