package login;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import customer.CustomerStart;
import customer.Member;
import customer.MemberArray;
import customer.MemberStart;


public class CustomerLogin {
	static File path1 = new File("data");
	static File path = new File("data/test.txt");
	
	private static CustomerLogin instance = new CustomerLogin();
	private CustomerLogin(){}
	public static CustomerLogin getInstance() {
		return instance;}
	
	
	public static void customerLogin() throws IOException {
		
		//반복문 시작
		out:
		while (true) {
			
			System.out.println("-------------------------"); // 구분선

			try {
				
				Scanner sc = new Scanner(System.in);
				// 아래의 경로가 없으면 생성해라.

				if (!(path1.exists())) {
					path1.mkdir();
				}
				if (!(path.exists())) {
					path.createNewFile();
				}
				
				System.out.println("   [회원 로그인 페이지]");
				System.out.println("1. 로그인  2. 회원 가입  3.뒤로 가기");
		
				System.out.println("-------------------------");
				System.out.print("선택 :");
				int number = sc.nextInt();
				
				switch (number) 
				{
				case 2: {
					MemberArray member = new MemberArray();
					member.addToList();
					break;
					}
				case 3: {
					break out;
					}
				case 1: {
					customerLogin1();
					break;
					}
				default: {
					System.out.println("번호를 잘못 입력하셨습니다. 처음으로 돌아갑니다.");

					}
				}
			} catch (IOException e) {
				System.out.println("출력 오류입니다.");
			}

		}
	}
	
	
	public static void customerLogin1() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ID를 입력해주세요.");
		String mId = sc.next();
		
		System.out.println("비밀번호를 입력해주세요.");
		String mPw = sc.next();

		MemberArray memberArray = new MemberArray();

		Member member1 = memberArray.check(mId, mPw);
		
		// 고객정보있어야함 내용있어야함.
		if (member1 != null) {
			MemberStart.First(member1); 

		}

	}

}


		
