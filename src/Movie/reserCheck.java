package Movie;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class reserCheck {
	MovieReservation resCheck;

	public static List<String> _infoList;

	// 예매 확인 메소드
	public static void abc() throws InputMismatchException, IOException {
		try {
			_infoList = MovieReservation.infoList;

			System.out.println("---------예매 확인---------");
			System.out.println("영화 : " + _infoList.get(0));
			System.out.println("선택하신 좌석은 [" + _infoList.get(1) + "] 입니다.");
			System.out.println("사용하신 포인트는 " + _infoList.get(2) + "원 입니다.");
			System.out.println("결제하신 금액은 " + (10000 - (Integer.parseInt(_infoList.get(2)))) + "원 입니다"); // 포인트 사용해야함

		} catch (NullPointerException e) {
			System.out.println("예매 내역이 없습니다.");
		}
	}
}