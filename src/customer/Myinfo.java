package customer;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Myinfo {
	Member member;
	// 내정보관리 화면출력

	public void printMyinfo(Member member1) {
		
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

		// case 2: // 주소 변경
		// editAddress();
		// break;
		//
		// case 3: // 휴대폰 번호 변경
		// editPhoneNumber();
		// break;
		//
		// case 4: // 이메일 변경
		// editEmail();
		// break;
		//
		case 5: // 뒤로가기
			// printmypage(member);
			break;

		case 6: // 처음으로 돌아가기
			MemberStart.First(member);
			break;

		}}
		catch(IOException e){};

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
	System.out.println("2. 처음으로가기");
	System.out.println("==============================");
	System.out.print("입력(변경할 비밀번호 or 숫자 입력) : ");

	// 변경할 데이터 입력 또는 메뉴 선택 
	
	String input = sc.nextLine();

	if(input.equals("1")){// 뒤로가기

//		MemberStart.Member(member);

	}else if(input.equals("2")){// 처음으로가기

		MemberStart.First(member);

	}else{passwordEdit(input); // 변경하는 메소드

	}

	}

	// 비밀번호 변경 
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
					MemberArray memberArray = new MemberArray();
					this.member.getmNum();
					memberArray.edit(Integer.parseInt(this.member.getmNum())-1, member);
					
					break;

				}
			}
		} else {
			System.out.println("!--유효하지 않은 비밀번호입니다. 확인 부탁드립니다.--!");

			// editPasswordFail();
		}

		
		}
		
		
		

//		try{
//			BufferedReader br = new BufferedReader(new FileReader(file));
//			String str = null;
//
//			try{ 
//				int i; List<Member> list = new ArrayList<>(); 
//				while ((str = br.readLine()) != null) { 
//					String[] m = str.split("■");// 한 줄이 m[0], m[1], m[2]...m[9]로 나누어짐 
//					Member member = new Member(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9]);
//
//
//					if (!(input.equals(m[2]))) { 
//						str.replaceFirst("jkld73!!", "dktLwje2"); 
//						}
//					list.add(member);
//
//					MemberArray a = new MemberArray(); 
//					a.listWrite(false); }
//
//				br.close(); 
//				}catch(NullPointerException e)
//			{
//			}catch(FileNotFoundException e)
//			{
//			}catch(IOException e)
//			{
//			}catch(Exception e)
//		
//		}

	}

