package dto;

public class EDto {
	private String emId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNum;
	private String jobId;
	
	private int salary;
	private int commissionPct;
	
	private String managerId;
	
	private int departmentId;
	
	public EDto() {
		super();
	}
	public EDto(String emId, String firstName, String lastName, String email, String phoneNum, 
			String jobId, int salary, int commissionPct, String managerId, int departmentId) {
		super();
		this.emId = emId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNum = phoneNum;
	
		this.jobId = jobId;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
	}
	public String getEmId() {
		return emId;
	}
	public void setEmId(String emId) {
		this.emId = emId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(int commissionPct) {
		this.commissionPct = commissionPct;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "EDto [emId=" + emId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNum=" + phoneNum + ", =" + ", jobId=" + jobId + ", salary=" + salary
				+ ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentId=" + departmentId
				+ "]";
	}
	
}
