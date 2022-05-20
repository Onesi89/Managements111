package customer;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Movie.MovieReservation;
import Movie.Snack12;

public class MemberStart {

	public static void First(Member member1) {
		Member member = member1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("  [회원 페이지]");
		System.out.println("==============================");
		System.out.println("1. 예매하기");
		System.out.println("2. 상품");
		System.out.println("3. 마이페이지");
		System.out.println("4. 로그아웃");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		
		try {
		
		int num = sc.nextInt();
	    
		switch(num) {
    	case 1:
    		MovieReservation reservation = new MovieReservation(); 
    		reservation.reservation();

		break;
		
		case 2:
//			snack가면 
			Snack12 snack = new Snack12();
			snack.make(member);

			break;

		case 3:
			Mypage mypage = new Mypage();
			mypage.printmypage(member);
			break;
			
//		case 4:
//			
//			
//			
//			break;
		}
			System.out.println();
		} catch(IOException e) {
			System.out.println("입출력 오류입니다.");
		} catch(InputMismatchException e) {
			System.err.println("잘못 입력하셨습니다.");
		}
	}
}


