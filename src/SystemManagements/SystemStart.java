package SystemManagements;

import java.util.Scanner;
import login.Login;
import Movie.MovieHome;
import Movie.MovieList;

public class SystemStart {
	
	// 싱글톤 사용
	private static SystemStart instance = new SystemStart();
	private SystemStart(){}
	public static SystemStart getInstance() {
		return instance;
	} 
	

//	public static void main(String[] args) {
//		SystemStart startEXE = SystemStart.getInstance();
//		startEXE.systemStart();
//	}
//	
	public void systemStart(){	
		
		//반복문
		while (true) {
			
			for(int i = 0; i<1000000000;i++);
			Scanner scanStart = new Scanner(System.in);
			System.out.println("------------------");
			System.out.println("     관리자 모드입니다.");
			System.out.println("------------------");
			System.out.println("  원하시는 메뉴를 선택해 주세요.");
//			System.out.println("1. 매출 관리");
			System.out.println("1. 직원 관리");
			System.out.println("2. 고객 관리");
			System.out.println("3. 영화 관리");
			System.out.println("4. 로그 아웃");
			System.out.println("------------------");
			System.out.print(("선택 : "));
			
			int selNumber;
		
			// 번호를 잘 못 입력하였을 경우 오류 메세지 출력
			try{selNumber = scanStart.nextInt();
				scanStart.nextLine();
				
				if((selNumber<1) || (selNumber>4)) {
						systemStart();
				}
				else {
					
					switch(selNumber) {
					
					
					// 0번 매출 관리 실행 -- 구현x
					case 0:{				
						break;
						
					// 1번 직원 관리 실행
					}case 1:{
						EmployeeManagements e = new EmployeeManagements();
						e.listCall();
					break; 
						
					// 2번 고객 관리 실행	
					}case 2:{
						CustomerManagements e = new CustomerManagements();
						e.customerList();
						break; 
					
					// 3번 영화관 관리
					}case 3:{
						MovieHome movie = new MovieHome();
						movie.movieHomeStart();
						break; 
				
					// 4번 로그아웃
					}case 4 :{ 
						Login loginStart = Login.getInstance();
						loginStart.systemStart();
						break;
					}
					}
				}
			}
			catch(Exception e) {
				System.out.println("숫자를 다시 입력해주세요\n");
			}
		}
	}
}
