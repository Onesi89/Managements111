package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import interfaceList.HumanInfoEditable;

public class MemberArray implements HumanInfoEditable{
	public File file = new File("data/test.txt");
	public List<Member> memberArray;
	public Scanner sc;

	public Member check(String mId, String mPw) {
		listCall();

		for (int i = 0; i < memberArray.size();i++) {
			if (memberArray.get(i).getmId().equals(mId)) {
				if (memberArray.get(i).getmPwd().equals(mPw)) {
					System.out.println("로그인에 성공하였습니다.");
					System.out.println("-------------------------");
					return memberArray.get(i);
				}
				/*
				 * System.out.println("이름 :" + Member.mName); System.out.println("생년월일 :" +
				 * Member.mBirth); System.out.println("주소 :" + Member.mAddress);
				 * System.out.println("연락처 :" + Member.mPhone); System.out.println("이메일 :" +
				 * Member.mEmail); System.out.println("등급 :" + Member.mGrade);
				 */
			}
		}
		System.out.println("로그인에 실패하였습니다.");
		return null;

	}

	@Override
	public void listCall() { // 고객 리스트 불러오는 메서드, member를 memberArray 객체에 넣는다.
		File file = new File("data/test.txt"); // 나중에 data/고객정보.txt 바뀔예정
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = null;

			memberArray = new ArrayList<Member>();
			while ((str = br.readLine()) != null) {
				String[] m = str.split("■");// 한 줄이 m[0], m[1], m[2]...m[9]로 나누어짐
				Member member = new Member(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9]);
				memberArray.add(member);

				/*
				 * 나중에 검색 할 때 사용, 로그인 할 때 사용 if (m[1].equals("xmpcg866")) {
				 * System.out.println("이름 :" + Member.mName); System.out.println("생년월일 :" +
				 * Member.mBirth); System.out.println("주소 :" + Member.mAddress);
				 * System.out.println("연락처 :" + Member.mPhone); System.out.println("이메일 :" +
				 * Member.mEmail); System.out.println("등급 :" + Member.mGrade); }
				 */
			}
			br.close();

		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void addToList() throws InputMismatchException, IOException, NumberFormatException {

		listCall(); // 기존 리스트 불러오기 출력 x

		out: while (true) {

			sc = new Scanner(System.in);

			System.out.println("회원 가입 페이지입니다.");
			System.out.println("-------------------------"); // 구분선

			System.out.println("-------------------------"); // 구분선

			String mNum = String.valueOf(memberArray.size());
			System.out.println("아이디를 입력하세요.");
			String mId = sc.nextLine();
			;
			System.out.println("패스워드를 입력하세요. 8자리이상(특수문자 사용 가능)");
			String mPwd = sc.nextLine();
			;
			System.out.println("이름을 입력하세요.");
			String mName = sc.nextLine();
			;
			System.out.println("생년월일을 입력하세요.(ex 990101)");
			String mBirth = sc.nextLine();
			;
			System.out.println("주소를 입력하세요.");
			String mAddress = sc.nextLine();
			;
			System.out.println("핸드폰 번호를 입력하세요.");
			String mPhone = sc.nextLine();
			;
			System.out.println("이메일 주소를 입력하세요");
			String mEmail = sc.nextLine();
			;
			String mGrade = "병아리";
			String mPoint = "0";

			System.out.println("저장하시겠습니까(y/n)");

			Member member1 = new Member(mNum, mId, mPwd, mName, mBirth, mAddress, mPhone, mEmail, mGrade, mPoint);

			boolean trueOrFalse = true; // while 탈출 할 것인말것인지 확인

			if (!(sc.next().equals("y"))) {
				System.out.println("취소 및 잘못입력하였습니다. 처음으로 돌아갑니다.");
				trueOrFalse = false;
			}

			for (int i = 0; i < memberArray.size(); i++) { // 아이디 중복
				if (memberArray.get(i).equals(member1)) {
					System.out.println("아이디가 중복되었습니다. 아이디를 확인해주세요.");
					trueOrFalse = false;
					break;
				}
			}
			// 비밀번호 유효성 검사
			// 8자리 이상
			if (mPwd.length() >= 8) {
				for (int i = 0; i < mPwd.length(); i++) {
					// 영어, 숫자, 특수문자(!@#$%^&*)
					if ((mPwd.charAt(i) >= 'A' && mPwd.charAt(i) <= 'Z')
							|| (mPwd.charAt(i) >= 'a' && mPwd.charAt(i) <= 'z')
							|| (mPwd.charAt(i) >= '0' && mPwd.charAt(i) <= '9') || mPwd.charAt(i) == '!'
							|| mPwd.charAt(i) == '@' || mPwd.charAt(i) == '#' || mPwd.charAt(i) == '$'
							|| mPwd.charAt(i) == '%' || mPwd.charAt(i) == '^' || mPwd.charAt(i) == '&'
							|| mPwd.charAt(i) == '*') {

						// if문 빠져나가기 위함
						i = 10000000;
						break;

					}
				}
			} else {
				System.out.println("유효하지 않은 비밀번호입니다. 확인 부탁드립니다.");
				trueOrFalse = false;

				// editPasswordFail();
			}

			if (trueOrFalse) {
				memberArray.add(member1);
				listWrite(false);
				break out;
			}
			;

		}
		System.out.println("저장하였습니다. 다시 로그인 해주세요");
	}
	

	@Override
	public void delFromList() throws InputMismatchException, IOException, NumberFormatException {
	}
	
	@Override
	public void listWrite(boolean trueOrFalse) throws InputMismatchException, IOException, NumberFormatException {
		sc = new Scanner(System.in);
		Writer os = new FileWriter(file, trueOrFalse);
		BufferedWriter bos = new BufferedWriter(os);
		int i = 1;
		for (Member e : memberArray) {
			bos.write(i++ + "■");
			bos.write(e.getmId() + "■");
			bos.write(e.getmPwd()+ "■");
			bos.write(e.getmName() + "■");
			bos.write(e.getmBirth()+ "■");
			bos.write(e.getmAddress() + "■");
			bos.write(e.getmPhone() + "■");
			bos.write(e.getmEmail() + "■");
			bos.write(e.getmGrade() + "■");
			bos.write(e.getmPoint());
			bos.newLine();
		}
		bos.close();
	}


}

