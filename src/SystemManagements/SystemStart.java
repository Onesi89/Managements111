package SystemManagements;

import java.util.Scanner;

public class SystemStart {
	public static void main(String[] args) {
		SystemStart a = new SystemStart();
		a.systemStart();
	}
	
	public void systemStart(){	
		while (true) {
			Scanner scanStart = new Scanner(System.in);
			System.out.println("------------------");
			System.out.println("     관리자 모드입니다.");
			System.out.println("------------------");
			System.out.println("원하시는 메뉴를 선택해 주세요.");
			System.out.println("1. 매출 관리");
			System.out.println("2. 직원 관리");
			System.out.println("3. 고객 관리");
			System.out.println("4. 영화관 관리");
			System.out.println("5. 로그 아웃");
			System.out.println("------------------");
			System.out.print(("선택 : "));
			
			int selNumber;
			
			try{selNumber = scanStart.nextInt();// 번호를 잘 못 입력하였을 경우 오류 메세지 출력
				scanStart.nextLine();
				if((selNumber<1) || (selNumber>5)) {
					throw new Exception();
				}else {
					switch(selNumber) {
					case 1:{				
						break; // 1번 매출 관리 실행
					}case 2:{
						EmployeeManagements e = new EmployeeManagements();
						e.employeeList();
						break; // 2번 직원 관리 실행
					}case 3:{
						CustomerManagements e = new CustomerManagements();
						e.customerList();
						break; // 3번 고객 관리 실행
					}case 4:{
						break; // 4번 영화관 관리
					}default :
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("\n 53 systemStart n숫자를 다시 입력해주세요\n");
			}
		}	
	} 
}
