package customer;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Movie.reserCheck;

public class Mypage {
	
	Member member;

	public void printmypage(Member member1, int k) throws InputMismatchException, IOException {
	
			
			out: while (true) {	
				if (Myinfo.i == 0) {
					
				member = member1;

				Scanner sc = new Scanner(System.in);

				System.out.println("==============================");
				System.out.println("마이페이지");

				System.out.println("==============================");
				System.out.println("1. 내 정보 관리");
				System.out.println("2. 예매 티켓확인");
				System.out.println("3. 포인트확인");
				System.out.println("4. 회원탈퇴");
				System.out.println("5. 뒤로가기");
				System.out.println("==============================");
				System.out.print("메뉴 선택 : ");

				int num = sc.nextInt();

				switch (num) {
				case 1: // 내 정보 관리

					Myinfo myinfo = new Myinfo();
					myinfo.printMyinfo(member);
					break;

				 case 2: //예매 티켓확인
					reserCheck.abc();
				
				
				 break;

				 case 3: //포인트 확인
					 System.out.println(member.getmName() + " 포인트는" 
							 	+ member.getmPoint());
				
				 break;

				case 4: // 회원탈퇴
					MemberOut memberOut = new MemberOut();
					MemberOut.MemInfo a= memberOut.new MemInfo();
					a.delMemlist(member);
					
					break;

				case 5: // 로그아웃
					break out;
				}

			}else {
				Myinfo.i = 0;
				break out;}
			}
		}
	}
