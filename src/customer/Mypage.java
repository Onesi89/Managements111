package customer;

import java.util.Scanner;

public class Mypage {
	
	//마이페이지 화면출력
	public static void printmypage() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("마이페이지에 들어왔습니다. 번호를 선택해주세요.");
		
		System.out.println("==============================");
		System.out.println("1. 내 정보 관리");
		System.out.println("2. 예매 티켓확인");
		System.out.println("3. 리뷰관리");
		System.out.println("4. 포인트확인");
		System.out.println("5. 회원탈퇴");
		System.out.println("6. 뒤로가기");
		System.out.println("7. 처음으로 가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
			
			
		int num = sc.nextInt();
	
		switch(num) {
		case 1: //내 정보 관리
			
			Myinfo myinfo = new Myinfo();
			myinfo.printMyinfo();
			break;	
			
//		case 2:	//예매 티켓확인
//
//			
//			
//			break;
			
		case 3: // 리뷰관리
			Review review = new Review();
			review.printReview();
			break;
			
//		case 4: //포인트 확인
//
//			
//			break;
					
		case 5: //회원탈퇴
			MemberOut memberOut = new MemberOut();
			memberOut.memberOutprint();
			break;
			
		case 6: //뒤로가기
			MemberStart.First();
			
		case 7: //처음으로 가기
			MemberStart.First();
	
		}
				
		}	
		
	}


