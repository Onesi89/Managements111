package login;

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

public class AdminLogin {
	//필드 맴버변수, 읽을 파일 경로
	static File path1 = new File("data");
	static File path = new File("data/adminInfo.txt");
	
	// ---------------------이너 클래스 시작
	private class AdminInfo implements interfaceList.HumanInfoEditable {
		Scanner sc;
		String adminID; // 어드민 아이디
		String adminPW; // 어드민 패스워드
		String adminName; // 어드민 네임
		String adminPhone; // 어드민 폰넘버
		String adminDuty; // 어드민 직급
		List<AdminInfo> list = new ArrayList<AdminInfo>();
		
		
		//맴버 기본 정보 생성자
		AdminInfo(String adminID, String adminPW, String adminName, String adminPhone, String adminDuty) {
			this.adminID = adminID;
			this.adminPW = adminPW; 
			this.adminName = adminName;
			this.adminPhone = adminPhone;
			this.adminDuty = adminDuty;
		}
		
		//맴버 생성자
		AdminInfo(){}
		

		//직원 목록 부르기
		@Override
		public void listCall(){ 
			try (Reader r = new FileReader(path); BufferedReader br = new BufferedReader(r);) {
//				for(long i = 0 ; i < 1000000000 ; i++) {} //시간 지연
				System.out.print("순번     이름\t      핸드폰번호           직무      입사일\n");
				
				String line = null; // line 초기화
				list.clear(); // 혹시모를 꼬임 방지 리스트 초기화
				int i = 1; // i 초기화
				
				while ((line = br.readLine()) != null) {
					System.out.println((i++) + "   " + line); //출력
					String[] abc = line.split(" ");
					AdminInfo test = new AdminInfo(abc[0], abc[1], abc[2], abc[3], abc[4]);
				
					list.add(test);
					}
				
				}catch(IOException e) {System.out.println("오류랄까");}}
		
		
		
		// 관리자 추가	
		@Override
		public void addToList() throws InputMismatchException, NumberFormatException, IOException {
			sc = new Scanner(System.in);
			AdminInfo a = new AdminInfo();
			System.out.println("기존 리스트입니다.");
			
			System.out.println("-------------------------"); // 구분선
			
			listCall(); //기존 리스트 불러오기
			
			System.out.println("-------------------------"); // 구분선
		
			//신규 확인
			System.out.println("아이디를 입력해주세요.");
			a.adminID = sc.next();
			
			System.out.println("패스워드를 입력해주세요.");
			a.adminPW = sc.next();
			
			System.out.println("이름을 입력해주세요.");
			a.adminName = sc.next();
			
			System.out.println("핸드폰 번호를 입력해주세요.");
			a.adminPhone = sc.next();
			
			System.out.println("직급을 입력해주세요");
			a.adminDuty = sc.next();
			
			System.out.println("저장하시겠습니까(y/n)");
			
			if (!(sc.next().equals("y"))) {
				System.out.println("취소 및 잘못입력하였습니다. 처음으로 돌아갑니다.");
			}
			
			int j = 0;
			
			for (int i = 0; i < list.size(); i++) { // 아이디 중복 
				if (list.get(i).adminID.equals(a.adminID)) {
					System.out.println("아이디가 중복되었습니다. 아이디를 확인해주세요.");
					j++;
					break;
				}
			}

			if(j == 0) {
				list.add(a); // 기존 리스트에 추가
				listWrite(false); // txt 파일에 덮어쓰기
			};

			
		};
		
		//관리자  삭제
		@Override
		public void delFromList () throws InputMismatchException, NumberFormatException, IOException {
			
			listCall(); // 기존 리스트 부르기
			
			sc = new Scanner(System.in); //입력받을 스캐너 실행
			System.out.println("삭제하실 번호를 선택해주세요.");
			
			int number = sc.nextInt() - 1; //리스트 인덱스 번호 입력 받기
			
			if((number > -1) && number < list.size()) {
				list.remove(number);
				listWrite(false); //txt 파일에 덮어 쓰기
				System.out.println("삭제되었습니다. 처음으로 돌아갑니다.");
				adminLogin();
			}else {
				System.out.println("잘못 입력하였습니다. 처음으로 돌아갑니다.");
				adminLogin();
			}
		};
		
		//파일에 덮어쓰기
		@Override
		public void listWrite(boolean trueOrFalse) throws InputMismatchException, NumberFormatException, IOException {
			sc = new Scanner(System.in);
			Writer os = new FileWriter(path,trueOrFalse);
			BufferedWriter bos = new BufferedWriter(os);
		
			for (AdminInfo e : list) {
				bos.write(e.adminID + " ");
				bos.write(e.adminPW + " ");
				bos.write(e.adminName + " ");
				bos.write(e.adminPhone + " ");
				bos.write(e.adminDuty);
				bos.newLine();
			}
			bos.close();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof AdminInfo) {
				if (this.adminID == ((AdminInfo) obj).adminID)
					return true;
			}
			return false;
		}
}
	// ---------------------이너 클래스 끝
	
	// 관리자 기본 화면
	public static boolean adminLogin() throws IOException {
		AdminLogin adminLogin = new AdminLogin();
		AdminLogin.AdminInfo adminInfo = adminLogin.new AdminInfo();
		
	
		// 아래의 경로가 없으면 생성해라.
		if (!(path1.exists())) {
			path1.mkdir();
		}
		if (!(path.exists())) {
			path.createNewFile();
		}
		
		//while문 시작
		out:
		while(true) {
		System.out.println("-------------------------"); // 구분선
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			System.out.println("오류가 발생하였습니다.");
		}
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("    [관리자 로그인 페이지]" );
		System.out.println("1.기존 아이디 로그인 \n2.관리자 추가\n3.관리자 삭제 \n4.뒤로가기" );
		System.out.println("-------------------------"); // 구분선
		System.out.println("선택 ");
		int number = sc.nextInt();
		System.out.println("-------------------------"); // 구분선

		
		
		
		switch(number) {
		case 2:{
			adminInfo.addToList();
			break;
			
		}case 3:{
			adminInfo.delFromList();
			break;
			
		}case 4:{
			Login loginStart = Login.getInstance();
			loginStart.systemStart();
			break;
		}case 1:{
			break out;
			
		}default :{
			System.out.println("번호를 잘못 입력하셨습니다. 처음으로 돌아갑니다.");
		}
		}
		}
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("관리자 ID를 입력해주세요.");
		String adminID = sc.next();
		
		System.out.println("비밀번호를 입력해주세요.");
		String adminPW = sc.next();
		

		try (Reader r = new FileReader(path); BufferedReader br = new BufferedReader(r);) {
			String line = null;
			List<AdminLogin.AdminInfo> list = new ArrayList<AdminLogin.AdminInfo>();
			while ((line = br.readLine()) != null) {
				String[] s = line.split(" ");

				AdminLogin a = new AdminLogin();
				AdminLogin.AdminInfo admin = a.new AdminInfo(s[0], s[1], s[2], s[3], s[4]);
				list.add(admin);
			}
			
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).adminID.equals(adminID) && list.get(i).adminPW.equals(adminPW)) {
					return true;					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();;
		}
		
		System.out.println("아이디 비밀번호가 잘못 되었습니다. 처음부터 다시 시도해주세요");
		return false;
	}
	}
