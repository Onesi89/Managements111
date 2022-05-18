package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Myinfo {

	// 내정보관리 화면출력
	public void printMyinfo() {

		Scanner sc = new Scanner(System.in);

		System.out.println("내정보 관리에 들어왔습니다. 번호를 선택하여 주세요.");
		System.out.println("==============================");

		mMember(); // 이름■생년월일■주소■연락처■이메일

		System.out.println();
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 주소 변경");
		System.out.println("3. 휴대폰 번호 변경");
		System.out.println("4. 이메일 변경");
		System.out.println("5. 뒤로가기");
		System.out.println("6. 처음으로 돌아가기");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");

		int num = sc.nextInt();

		switch (num) {
		case 1: // 비밀번호 변경
			editPassword();
			break;
//		case 2: // 주소 변경
//			editAddress();
//			break;
//		case 3: // 휴대폰 번호 변경
//			editPhoneNumber();
//			break;
//		case 4: // 이메일 변경
//			editEmail();
		case 5: // 뒤로가기
			Mypage.printmypage();
		case 6: // 처음으로 돌아가기
			MemberStart.First();
		}

	}

	// 이름■생년월일■주소■연락처■이메일
	private void mMember() {

		File file = new File("C:\\DDGCinema-master\\DDGCinema-master\\[02] 데이터 파일\\고객정보.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = null;

			try {
				int i;
				List<Member> list = new ArrayList<>();
				while ((str = br.readLine()) != null) {
					String[] m = str.split("■");// 한 줄이 m[0], m[1], m[2]...m[9]로 나누어짐
					Member member = new Member(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9]);
					list.add(member);

					if (m[1].equals("xmpcg866")) {
						System.out.println("이름 :" + Member.mName);
						System.out.println("생년월일 :" + Member.mBirth);
						System.out.println("주소 :" + Member.mAddress);
						System.out.println("연락처 :" + Member.mPhone);
						System.out.println("이메일 :" + Member.mEmail);
						System.out.println("등급 :" + Member.mGrade);
					}
				}

				br.close();
			} catch (NullPointerException e) {
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
		} catch (Exception e) {
		}
	}
	// 비밀번호
	// -----------------------------------------------------------------------------

	// 비밀번호 변경메뉴
	private void editPassword() {
		Scanner sc = new Scanner(System.in);

		System.out.println("비밀번호 변경에 들어왔습니다. 변경할 비밀번호를 입력하세요.");
		System.out.println("비밀번호는 8자리 이상 특수문자(!@#$%^&*), 영어 대문자, 소문자만 사용가능합니다.");
		System.out.println("==============================");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 처음으로가기");
		System.out.println("==============================");
		System.out.print("입력(변경할 비밀번호 or 숫자 입력) : ");

		// 변경할 데이터 입력 또는 메뉴 선택
		String input = sc.nextLine();

		if (input.equals("1")) {// 뒤로가기

			printMyinfo();

		} else if (input.equals("2")) {// 처음으로가기

			MemberStart.First();

		} else {
			passwordEdit(input); // 변경하는 메소드

		}

	}

		// 비밀번호 변경
		private void passwordEdit(String input) {

			// 현재 고객정보 목록 불러오기
			String path = "C:\\DDGCinema-master\\DDGCinema-master\\[02] 데이터 파일\\고객정보.txt";
			File dir = new File(path);

			// 파일 읽어 오고 list에 저장
			ArrayList<String> list = new ArrayList<String>();
			

			BufferedReader reader;
			try {
				reader = new BufferedReader(
						new FileReader("C:\\DDGCinema-master\\DDGCinema-master\\[02] 데이터 파일\\고객정보.txt"));

				

				try {
					String line = null;
					while ((line = reader.readLine()) != null) {
                       //!!!!!!
						list.add(line + "\n");

					}
					reader.close();
				} catch (IOException e) {
				}

			} catch (FileNotFoundException e) {
			} 
			
			// 비밀번호 유효성 검사
			if (input.length() >= 8) {// 8자리 이상

				for (int i = 0; i < input.length(); i++) {

					if ((input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') // 영어, 숫자, 특수문자(!@#$%^&*)
							|| (input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
							|| (input.charAt(i) >= '0' && input.charAt(i) <= '9') || input.charAt(i) == '!'
							|| input.charAt(i) == '@' || input.charAt(i) == '#' || input.charAt(i) == '$'
							|| input.charAt(i) == '%' || input.charAt(i) == '^' || input.charAt(i) == '&'
							|| input.charAt(i) == '*') {

					} else {
						editPasswordFail();
						break;
					}
				}
			} else {
				editPasswordFail();
			}

			dir.delete(); //파일 삭제

			// 파일 다시 쓰고 저장
			try {
				BufferedWriter writer = new BufferedWriter(
						new FileWriter("C:\\DDGCinema-master\\DDGCinema-master\\[02] 데이터 파일\\고객정보.txt", true));
				
				for (String text : list) {

					String[] m = new String[10];
					m = text.split("■");
					String info = "";
					
					if (m[3].equals("한보라")) {

						if (!(input.equals(m[2]))) {
							writer.write(text.replaceFirst(m[2], input));
						} 
						else {}
					}else {writer.write(text); }
				}
				
				writer.close();
				editPasswordSuccess(); // 비밀번호 입력 성공 출력
			} catch (IOException e) {}
		}

		// 비밀번호 변경 성공시
		private void editPasswordSuccess() {

				Scanner sc = new Scanner(System.in);

				System.out.println("비밀번호 변경에 성공하였습니다. 번호를 선택하여 주세요.");
				System.out.println("==============================");
				System.out.println("1. 뒤로가기");
				System.out.println("2. 처음으로 돌아가기");
				System.out.println("==============================");
				System.out.print("메뉴 선택 : ");

				int num = sc.nextInt();

				switch (num) {
				case 1:
					printMyinfo();
				case 2: // 처음으로가기
					MemberStart.First();

				}// switch

			} // for


		// 비밀번호 변경 실패시
		private void editPasswordFail() {

				Scanner sc = new Scanner(System.in);

				System.out.println("비밀번호 변경에 실패하였습니다. 번호를 선택하여 주세요.");
				System.out.println("==============================");
				System.out.println("1. 뒤로가기");
				System.out.println("2. 처음으로 돌아가기");
				System.out.println("==============================");
				System.out.print("메뉴 선택 : ");

				int num = sc.nextInt();

				switch (num) {
				case 1: // 뒤로가기
					editPassword();
				case 2: // 처음으로가기
					MemberStart.First();

				}

			}

		}
