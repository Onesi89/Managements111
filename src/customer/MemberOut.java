package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import login.Login;

public class MemberOut {
	
		//필드 맴버변수, 읽을 파일 경로
		static File path1 = new File("data");
		static File path = new File("data/test.txt");
		public String[] args;
		public Member member;
		
		//이너 클래스
		public class MemInfo {
			Scanner sc;
			private String mNum = "0";
			private String mId;
			private String mPwd;
			private String mName;
			private String mBirth;
			private String mAddress;
			private String mPhone;
			private String mEmail;
			private String mGrade;
			private String mPoint = "0";
			List<MemInfo> list = new ArrayList<MemInfo>();


			//맴버 정보 생성자
			MemInfo(String mNum, String mId, String mPwd, String mName, String mBirth, String mAddress, String mPhone,
					String mEmail, String mGrade, String mPoint) {
				this.mNum = mNum;
				this.mId = mId ;
				this.mPwd = mPwd ;
				this.mName = mName ;
				this.mBirth = mBirth ;
				this.mAddress = mAddress ;
				this.mPhone = mPhone ;
				this.mEmail = mEmail ;
				this.mGrade = mGrade ;
				this.mPoint = mPoint ;

			}

			//맴버 생성자
			MemInfo(){}
			

			//직원 목록 부르기
			public void callList() {
				try (Reader r = new FileReader(path); BufferedReader br = new BufferedReader(r);) {
//					System.out.print("순번     ID	PW	이름	생년월일	주소      핸드폰번호	이메일	등급		포인트\n");
					String line = null; // line 초기화
					list.clear(); 
					int i = 1; // i 초기화
					while ((line = br.readLine()) != null) {
//						System.out.println((i++) + "   " + line); //출력
						String[] m = line.split("■");
						MemInfo test = new MemInfo(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9]);
					
						list.add(test);
					}
					
					}catch(IOException e) {
						System.out.println("오류");
						}
				}
			
			
			
			// 회원삭제
			public void delMemlist(Member member)  throws InputMismatchException, NumberFormatException, IOException {
				
				callList(); // 기존 리스트 부르기
				
				sc = new Scanner(System.in); //입력받을 스캐너 실행
				System.out.println("사용중인 비밀번호를 입력해주세요.");
				String pwnumber = sc.nextLine(); //리스트 인덱스 번호 입력 받기
				
				if((member.getmPwd().equals(pwnumber))) {
					list.remove(Integer.parseInt(member.getmNum())-1);
					listWrite(false); //txt 파일에 덮어 쓰기
					System.out.println("탈퇴가 완료되었습니다. 처음으로 돌아갑니다.");
					Login.main(args);
					
				}else {
					System.out.println("잘못 입력하였습니다. 처음으로 돌아갑니다.");
					Login.main(args);
				}
		};
		
			//파일에 덮어쓰기
			public void listWrite(boolean trueOrFalse) throws IOException{
				sc = new Scanner(System.in);
				Writer os = new FileWriter(path,trueOrFalse);
				BufferedWriter bos = new BufferedWriter(os);
				int i = 1 ;
				for (MemInfo e : list) {
					bos.write(i++ + "■");
					bos.write(e.mId + "■");
					bos.write(e.mPwd + "■");
					bos.write(e.mName + "■");
					bos.write(e.mBirth + "■");
					bos.write(e.mAddress + "■");
					bos.write(e.mPhone + "■");
					bos.write(e.mEmail + "■");
					bos.write(e.mGrade + "■");
					bos.write(e.mPoint);
					bos.newLine();
				}
				bos.close();
			}
			
			@Override
			public boolean equals(Object obj) {
				if (obj instanceof MemInfo) {
					if (this.mPwd == ((MemInfo) obj).mPwd)
						return true;
				}
				return false;
			}
		}


		
			// TODO Auto-generated method stub
			
		}
