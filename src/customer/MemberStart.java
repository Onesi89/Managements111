package customer;

import java.util.Scanner;

public class MemberStart {


//	public static void main(String[] args) {
//		First();
//	}
	
	public static void First(Member member1) {
		Member member = member1;
		
		System.out.println(member.getmId());
		System.out.println(member.getmName());
		System.out.println(member.getmAddress());
		System.out.println(member.getmBirth());
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("==============================");
		System.out.println("1. 예매하기");
		System.out.println("2. 상품");
		System.out.println("3. 마이페이지");
		System.out.println("4. 로그아웃");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		
		
		int num = sc.nextInt();
	    
		switch(num) {
//		case 1:
//
//			
//			break;
//			
//		case 2:
//
//
//			break;

		case 3:
			Mypage.printmypage();
			break;
			
//		case 4:
//			
//			
//			
//			break;
		}
		System.out.println();
	}
}


