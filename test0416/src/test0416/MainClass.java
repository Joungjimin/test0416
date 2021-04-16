package test0416;

import java.util.Scanner;

import service.EService;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		EService es = new EService();
		
		boolean check=true;
		while(check) {
			System.out.println("1. 등록");
	        System.out.println("2. 출력");
	        System.out.println("3. 수정");
	        System.out.println("4. 검색");
	        System.out.println("5. 종료");
	        System.out.print(">>> ");
	        
	        int key = sc.nextInt();
	        switch (key) {
	        
			case 1:
				//등록
				es.addEmp();
				break;
			case 2:
				//출력
				es.fineAll();
				break;
			case 3:
				//수정
				es.updateEmp();
				break;
			case 4:
				//검색 
				es.searchEmp();
				break;
			case 5:
				System.out.println("프로그램 종료");
				check = false;
				break;
			}
		}
		
	}

}
