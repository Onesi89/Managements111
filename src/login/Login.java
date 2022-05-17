package login;

import SystemManagements.SystemStart;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Login 회원 /관리자   암호
public class Login {
	private static Login instance = new Login();
	private Login(){}
	public static Login getInstance() {
		return instance;} //싱글톤

	
	public static void main(String[] args) {
		Login startLoin = Login.getInstance();
		Login.systemStart();
		}
		
	
	public static void systemStart() {
		while (true) {
			System.out.println("-----------------");
			System.out.println("회원 / 관리자 \n로그인 ");
			System.out.println("1. 회원");
			System.out.println("2. 관리자");
			System.out.print("선택 : ");


			try {
				Scanner sc = new Scanner(System.in);
				switch (sc.nextInt()) {
				case 1: { // 회원 로그인 -- 받아야함
					break;
				}
				case 2: {
					if (AdminLogin.adminLogin()) {
						SystemStart.getInstance().systemStart();
					} else {
						System.out.println("처음부터 다시해주세요");
					}
					break;
				}
				case 3: { // 시스템 종료
					System.out.println("시스템 종료");
					System.exit(0);
				}
				}
			} catch (IOException e) {
				System.out.println("파일이 잘못되었습니다.");

			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
			}

		}
	}
}
