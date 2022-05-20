package login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import SystemManagements.SystemStart;

// Login 회원 /관리자   암호
public class Login {
	private static Login instance = new Login();
	private Login(){}
	public static Login getInstance() {
		return instance;} //싱글톤

	//처음 실행  메인메소드
	public static void main(String[] args) {
		Login loginStart = Login.getInstance();
		loginStart.systemStart();
		}
		
	// 실제로 실행되는 메소드, 회원 / 관리자 분기점
	public void systemStart() {
		//반복 시작
		while (true) {
			//시간 지연
			for(int i = 0; i<1000000000; i++) {};
			
			System.out.println("-----------------");
			System.out.println("[회원 / 관리자 로그인] ");
			System.out.println("-----------------");
			System.out.println("1. 회원");
			System.out.println("2. 관리자");
			System.out.println("3. 시스템 종료");
			System.out.println("-----------------");
			System.out.print("선택 : ");

			
			try {
			
				Scanner sc = new Scanner(System.in);
				switch (sc.nextInt()) 
				{
				// 회원 로그인
				case 1: { 
					CustomerLogin.customerLogin();				
					break;
				}
				// 관리자
				case 2: { 
					if (AdminLogin.adminLogin()) {
						SystemStart.getInstance().systemStart();
					}
					break;
				}
				
				// 시스템 종료
				case 3: { 
					System.out.println("시스템 종료");
					System.exit(0);
					}
				}
			}catch (FileNotFoundException e) {
				System.out.println("오류가 났습니다. 오류번호 01");
				
			} catch (IOException e) {
				System.out.println("오류가 났습니다. 오류번호 02");

			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
			} 

		}
	}
}
