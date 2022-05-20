package customer;

import java.util.Scanner;

public class Mypage {
	
	Member member;

	public void printmypage(Member member1) {
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
		System.out.println("6. 처음으로 가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
			
			
		int num = sc.nextInt();
	
		switch(num) {
		case 1: //내 정보 관리
			
			Myinfo myinfo = new Myinfo();
			myinfo.printMyinfo(member);
			break;	
			
//		case 2:	//예매 티켓확인
//
//			
//			break;
			
			
//		case 3: //포인트 확인
//
//			
//			break;
					
		case 4: //회원탈퇴
			MemberOut memberOut = new MemberOut();
			memberOut.memberOutprint();
			break;
			
		case 5: //뒤로가기
			printmypage(member);
			
		case 6: //처음으로 가기
			MemberStart.First(member);
	
		}
				
		}	
		
	}


