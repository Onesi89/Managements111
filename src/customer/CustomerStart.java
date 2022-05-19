package customer;

import java.util.Scanner;

public class CustomerStart {
	private static CustomerStart instance = new CustomerStart();
	private CustomerStart(){}
	public static CustomerStart getInstance() {
		return instance;
	} // 싱글톤 사용
	
	
	public static void main(String[] args) {
		CustomerStart startEXE = new CustomerStart();
		startEXE.systemStart();
	}
	
	public void systemStart() {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("1. 마이 페이지");
		System.out.println("2. 영화 예매");
		System.out.println("3. 스낵 구매");
		System.out.println("4. 이벤트");

		switch (number) {
		case 1: {
			System.out.println("마이페이지로 이동합니다."); // 회원 정보 확인(이름부터... 마일리지,등급), 회원 수정 
			break;
		}
		case 2: {
			System.out.println("영화 예매 페이지로 이동합니다."); // 영화 예매, 좌석, 시간, 결제, 예매 내역 확인, 취소
			break;
		}
		case 3: {
			System.out.println("스낵 구매 페이지로 이동합니다."); // 스낵 구매, 장바구니, 추가
			break;

		}
		case 4: {
			System.out.println("이벤트 페이지로 이동합니다."); //게임 쿠폰 등
			break;

		}

		}

	}

}