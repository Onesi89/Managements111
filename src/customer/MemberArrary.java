package customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import Movie.Movie;
import interfaceList.HumanInfoEditable;

public class MemberArrary implements HumanInfoEditable{
	
	public List<Member> memverArray;
	
	
	@Override
	public void listCall() { // 고객 리스트 불러오는 메서드, member를 memberArray 객체에 넣는다.
		File file = new File("data/고객정보.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = null;

				int i;
				List<Member> list = new ArrayList<>();
				while ((str = br.readLine()) != null) {
					String[] m = str.split("■");// 한 줄이 m[0], m[1], m[2]...m[9]로 나누어짐
					Member member = new Member(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9]);
					list.add(member);

					/*
					 * 나중에 검색 할 때 사용, 로그인 할 때 사용
					 * if (m[1].equals("xmpcg866")) {
						System.out.println("이름 :" + Member.mName);
						System.out.println("생년월일 :" + Member.mBirth);
						System.out.println("주소 :" + Member.mAddress);
						System.out.println("연락처 :" + Member.mPhone);
						System.out.println("이메일 :" + Member.mEmail);
						System.out.println("등급 :" + Member.mGrade);
					}*/
					br.close();}
				
			} catch (NullPointerException e) {
				System.out.println(e);
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		} 

	
	@Override
	public void addToList() throws InputMismatchException, IOException, NumberFormatException {

		
	}
	
	@Override
	public void delFromList() throws InputMismatchException, IOException, NumberFormatException {

		
	}
	
	@Override
	public void listWrite(boolean trueOrFalse) throws InputMismatchException, IOException, NumberFormatException {

		
	}

}
