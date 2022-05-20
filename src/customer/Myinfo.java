package customer;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Myinfo {
	Member member;
	static int i = 0;

	// 내정보관리 화면출력

	public void printMyinfo(Member member1) {
		out: while (true) {

			member = member1;// 이름■생년월일■주소■연락처■이메일

			System.out.println(member.getmName());

			Scanner sc = new Scanner(System.in);

			System.out.println("내정보 관리에 들어왔습니다. 번호를 선택하여 주세요.");
			System.out.println("==============================");

			mMember(); // 회원정보 호출

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
			try {
				switch (num) {
				case 1: // 비밀번호 변경
					editPassword();
					break;

				case 2: // 주소 변경
					editAddress();
					break;

				case 3: // 휴대폰 번호 변경
					editPhoneNumber();
					break;

				case 4: // 이메일 변경
					editEmail();
					break;

				case 5: // 뒤로가기
					break out;

				case 6: // 처음으로 돌아가기
					i = 1;
					break out;

				}
			} catch (IOException e) {
			} catch (NumberFormatException e) {
			}
			;
		}
		if (i == 1) {
		}

	}
	

	// 이름■생년월일■주소■연락처■이메일 
	private void mMember() {
						System.out.println("이름 :" + member.getmName());
						System.out.println("생년월일 :" + member.getmBirth()); 
						System.out.println("주소 :" +member.getmAddress());
						System.out.println("연락처 :" + member.getmPhone());
						System.out.println("이메일 :" + member.getmEmail()); 
						System.out.println("등급 :" + member.getmGrade()); 
						}
	
	 // 비밀번호 //


//	 비밀번호 변경메뉴 

	private void editPassword() throws InputMismatchException, NumberFormatException, IOException { 
		Scanner sc = new Scanner(System.in);

	System.out.println("비밀번호 변경에 들어왔습니다. 변경할 비밀번호를 입력하세요.");
	System.out.println("비밀번호는 8자리 이상 특수문자(!@#$%^&*), 영어 대문자, 소문자만 사용가능합니다.");
	System.out.println("==============================");
	System.out.println("1. 뒤로가기");
//	System.out.println("2. 처음으로가기");
//	System.out.println("==============================");
	System.out.print("입력(변경할 비밀번호 or 숫자 입력) : ");

	// 변경할 데이터 입력 또는 메뉴 선택 
	
	String input = sc.nextLine();

	if(input.equals("1")){// 뒤로가기

//		MemberStart.Member(member);

//	}else if(input.equals("2")){// 처음으로가기
//
//		MemberStart.First(member);

	}
	else{passwordEdit(input); // 변경하는 메소드

	}

	}

	// 비밀번호 변경  String inpu - 변경할 비밀번호
	private void passwordEdit(String input) throws InputMismatchException, NumberFormatException, IOException { 
		
//		System.out.println("변경할 비밀번호");

		String mPwd = input;
		
		if (mPwd.length() >= 8) {
			for (int i = 0; i < mPwd.length(); i++) {
				// 영어, 숫자, 특수문자(!@#$%^&*)
				if ((mPwd.charAt(i) >= 'A' && mPwd.charAt(i) <= 'Z') || (mPwd.charAt(i) >= 'a' && mPwd.charAt(i) <= 'z')
						|| (mPwd.charAt(i) >= '0' && mPwd.charAt(i) <= '9') || mPwd.charAt(i) == '!'
						|| mPwd.charAt(i) == '@' || mPwd.charAt(i) == '#' || mPwd.charAt(i) == '$'
						|| mPwd.charAt(i) == '%' || mPwd.charAt(i) == '^' || mPwd.charAt(i) == '&'
						|| mPwd.charAt(i) == '*') {

					
					// if문 빠져나가기 위함
					i = 10000000;
					
					this.member.setmPwd(mPwd);
					
					
					this.member.getmNum();
					
					MemberArray memberArray = new MemberArray();
					
					
					memberArray.edit(Integer.parseInt(this.member.getmNum())-1, member);
					
					break;

				}
			}
		} else {
			System.out.println("!--유효하지 않은 비밀번호입니다. 확인 부탁드립니다.--!");

			// editPasswordFail();
		}

		
		}
	
	private void editPasswordSuccess() throws InputMismatchException, NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("비밀번호가 성공적으로 변경되었습니다.");
		System.out.println("==============================");
//		System.out.println("원하시는 메뉴를 선택하세요.");
//		System.out.println("==============================");
//		System.out.println("1. 뒤로가기");
//		System.out.println("2. 처음으로 돌아가기");
//		System.out.println("==============================");
//		System.out.print("메뉴 선택 : ");
//		
//		int num = sc.nextInt();
//
//		switch (num) {
//		case 1: // 뒤로가기
//			printMyinfo(member);
//		case 2: // 처음으로가기
//			MemberStart.First(member);
//		}
	}

	// ==================================================================================================================================
	// 2. 주소 변경

	private void editAddress() throws InputMismatchException, NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("주소 변경에 들어왔습니다. 변경할 주소를 입력하세요.");
		System.out.println("읍/면/동 까지 입력해주세요");
		System.out.println("==============================");
		System.out.println("1. 뒤로가기");
//		System.out.println("2. 처음으로가기");
		System.out.println("==============================");
		System.out.print("입력(변경할 주소 or 숫자 입력) : ");

		// 변경할 데이터 입력 또는 메뉴 선택

		String input = sc.nextLine();

		if (input.equals("1")) {// 뒤로가기
//			printMyinfo(member);

		} 
//		else if (input.equals("2")) {// 처음으로가기
//
//			MemberStart.First(member);
//
//		} 
		else {
			addressEdit(input); // 변경하는 메소드
		}
	}

	private void addressEdit(String input) throws InputMismatchException, NumberFormatException, IOException {
		// 유효성 검사
		String mAddress = input;

		if (mAddress.contains("시") || mAddress.contains("군") || mAddress.contains("구") || mAddress.contains("동")
				|| mAddress.contains("읍") || mAddress.contains("면")) {


			this.member.setmAddress(mAddress);
			MemberArray memberArray = new MemberArray();
			this.member.getmNum();
			memberArray.edit(Integer.parseInt(this.member.getmNum()) - 1, member);
			
			editAddressSuccess(); 
			
		} else {
			System.out.println("!--주소를 찾을 수 없습니다. 다시 확인해주세요.--!");

		}
	}
	private void editAddressSuccess() throws InputMismatchException, NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("주소가 성공적으로 변경되었습니다.");
		System.out.println("==============================");
//		System.out.println("원하시는 메뉴를 선택하세요.");
//		System.out.println("==============================");
//		System.out.println("1. 뒤로가기");
//		System.out.println("2. 처음으로 돌아가기");
//		System.out.println("==============================");
//		System.out.print("메뉴 선택 : ");
//		
//		int num = sc.nextInt();
//
//		switch (num) {
//		case 1: // 뒤로가기
//			printMyinfo(member);
//		case 2: // 처음으로가기
//			MemberStart.First(member);
//		}
	}

	// ============================================================================================================================
	// 3. 연락처 변경

	private void editPhoneNumber() throws InputMismatchException, NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("전화번호 변경에 들어왔습니다. 변경할 연락처를 입력하세요.");
		System.out.println("번호 입력시 '-'를 포함하여 입력해주세요. ex)000-0000-0000");
		System.out.println("==============================");
		System.out.println("1. 뒤로가기");
//		System.out.println("2. 처음으로가기");
		System.out.println("==============================");
		System.out.print("입력(변경할 연락처 or 숫자 입력) : ");
//
//		// 변경할 데이터 입력 또는 메뉴 선택
//
		String input = sc.nextLine();

		if (input.equals("1")) {// 뒤로가기
//			printMyinfo(member);

//		} else if (input.equals("2")) {// 처음으로가기
//			MemberStart.First(member);
//
		} else {
			phoneEdit(input); // 변경하는 메소드
		}
	}

	private void phoneEdit(String input) throws InputMismatchException, NumberFormatException, IOException {
		// 유효성 검사
		String mPhone = input;

		if (mPhone.contains("010")) {
			String[] number = mPhone.split("-");
			if (Integer.parseInt(number[1]) % 1000 > 0 && Integer.parseInt(number[2]) % 1000 > 0) {

				this.member.setmPhone(mPhone);
				MemberArray memberArray = new MemberArray();
				this.member.getmNum();
				memberArray.edit(Integer.parseInt(this.member.getmNum()) - 1, member);
				
				editPhoneSuccess(); 
				
			}
		} else {
			System.out.println("!--유효하지 않은 번호입니다. 다시 입력해주세요.--!");

		}
	}
	private void editPhoneSuccess() throws InputMismatchException, NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("전화번호가 성공적으로 변경되었습니다.");
		System.out.println("==============================");
//		System.out.println("원하시는 메뉴를 선택하세요.");
//		System.out.println("==============================");
//		System.out.println("1. 뒤로가기");
//		System.out.println("2. 처음으로 돌아가기");
//		System.out.println("==============================");
//		System.out.print("메뉴 선택 : ");
//		
//		int num = sc.nextInt();
//
//		switch (num) {
//		case 1: // 뒤로가기
//			printMyinfo(member);
//		case 2: // 처음으로가기
//			MemberStart.First(member);
//		}
	}

	// ====================================================================================================
	// 4. 이메일 변경

	private void editEmail() throws InputMismatchException, NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		System.out.println("이메일 변경에 들어왔습니다. 변경할 비밀번호를 입력하세요.");
		System.out.println("'@' ,'com' 포함해서 입력해주세요. 123@naver.com");
		System.out.println("==============================");
		System.out.println("1. 뒤로가기");
//		System.out.println("2. 처음으로가기");
		System.out.println("==============================");
		System.out.print("입력(변경할 이메일주소 or 숫자 입력) : ");

		// 변경할 데이터 입력 또는 메뉴 선택

		String input = sc.nextLine();

		if (input.equals("1")) {// 뒤로가기
//			printMyinfo(member);

		}
//		else if (input.equals("2")) {// 처음으로가기
//
//			MemberStart.First(member);
//
//		} else {
			emailEdit(input); // 변경하는 메소드
		}
//	}

	private void emailEdit(String input) throws InputMismatchException, NumberFormatException, IOException {
		// 유효성 검사
		String mEmail = input;

		if (mEmail.contains("@") && (mEmail.contains(".com") || mEmail.contains(".co.kr") || mEmail.contains(".net"))) {

			this.member.setmEmail(mEmail);
			MemberArray memberArray = new MemberArray();
			this.member.getmNum();
			memberArray.edit(Integer.parseInt(this.member.getmNum()) - 1, member);
			
			editEmaileSuccess();

		} else {
			System.out.println("!--유효하지 않은 이메일 주소입니다. 다시 확인해주세요.--!");

		}
	}

	private void editEmaileSuccess() throws InputMismatchException, NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이메일 주소가 성공적으로 변경되었습니다.");
		System.out.println("==============================");
//		System.out.println("원하시는 메뉴를 선택하세요.");
//		System.out.println("==============================");
//		System.out.println("1. 뒤로가기");
//		System.out.println("2. 처음으로 돌아가기");
//		System.out.println("==============================");
//		System.out.print("메뉴 선택 : ");
//		
//		int num = sc.nextInt();
//
//		switch (num) {
//		case 1: // 뒤로가기
//			printMyinfo(member);
//		case 2: // 처음으로가기
//			MemberStart.First(member);
//		}
		
	}

}

	

