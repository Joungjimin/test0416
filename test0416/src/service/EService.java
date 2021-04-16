package service;

import java.util.List;
import java.util.Scanner;

import dao.EDao;
import dto.EDto;

public class EService {
	Scanner sc = new Scanner(System.in);
	
	public void addEmp() {
		EDao dao = EDao.getInstance();
		
		System.out.println("등록할 직원의 Id:");
		String emId= sc.next();
		System.out.println("등록할 직원의 firstName:");
		String firstName= sc.next();
		System.out.println("등록할 직원의 lastName:");
		String lastName= sc.next();
		System.out.println("등록할 직원의 email:");
		String email= sc.next();
		System.out.println("등록할 직원의 phoneNum:");
		String phoneNum= sc.next();
		
		System.out.println("등록할 직원의 JOBID:");
		String jobId= sc.next();
		System.out.println("등록할 직원의 salary:");
		int salary= sc.nextInt();
		System.out.println("등록할 직원의 commissionPct:");
		int commissionPct= sc.nextInt();
		System.out.println("등록할 직원의 managerId:");
		String managerId= sc.next();
		System.out.println("등록할 직원의 departmentId:");
		int departmentId= sc.nextInt();
		
		EDto dto = new EDto(emId,firstName,lastName,email,phoneNum
				,jobId,salary,commissionPct,managerId,departmentId);
		boolean check= dao.addEmp(dto);
		if(check) {
			System.out.println("추가 성공");
		}
		else {
			System.out.println("추가 실패");
		}
	}
	public void fineAll() {
		EDao dao = EDao.getInstance();
		List<EDto> list = dao.findAll();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	public void updateEmp() {
		EDao dao = EDao.getInstance();
		System.out.println("수정할 사원 id");
		String emId = sc.next();
		System.out.println("수정될 전화 번호: ");
		String phoneNum = sc.next();
		
		boolean check=dao.updateEmp(emId,phoneNum);
		if(check) {
			System.out.println("수정 성공");
		}
		else {
			System.out.println("수정 실패");
		}
		
	}
	
	public void searchEmp() {
		EDao dao = EDao.getInstance();
		System.out.println("검색할 사원의 id");
		String emId = sc.next();
		
		EDto dto = dao.searchEmp(emId);
		System.out.println(dto.toString());
	}
}
