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
	static File path1 = new File("data");
	static File path = new File("data/adminInfo.txt");

	private class AdminInfo { //이너 클래스
		Scanner sc;
		String adminID; // 어드민 아이디
		String adminPW; // 어드민 패스워드
		String adminName; // 어드민 네임
		String adminPhone; // 어드민 폰넘버
		String adminDuty; // 어드민 직급
		List<AdminLogin.AdminInfo> list = new ArrayList<AdminLogin.AdminInfo>();

		AdminInfo(String adminID, String adminPW, String adminName, String adminPhone, String adminDuty) {
			this.adminID = adminID;
			this.adminPW = adminPW; 
			this.adminName = adminName;
			this.adminPhone = adminPhone;
			this.adminDuty = adminDuty;
		}
		
		AdminInfo(){}
		void adminList() {
			System.out.println("------------------------------------");
			System.out.println("  관리자창입니다.");
			System.out.println("------------------------------------");
			listCall();
			}
		
		void listCall() { //직원 목록 부르기
			try (Reader r = new FileReader(path); BufferedReader br = new BufferedReader(r);) {
				for(long i = 0 ; i < 1000000000 ; i++) {} //시간 지연
				System.out.print("순번    이름\t     핸드폰번호          직무     입사일\n");
				
				String line = null; // line 초기화
				
				int i = 0; // i 초기화
				while ((line = br.readLine()) != null) {
					System.out.println((i + 1) + "   " + line);
					i++;
					String[] abc = line.split(" ");
					AdminLogin.AdminInfo test = new AdminInfo(abc[0], abc[1], abc[2], abc[3], abc[4]);
					list.add(test);
					}
				}catch(IOException e) {System.out.println("오류랄까");}}
		
			
		void addAdmin() throws InputMismatchException, IOException, NumberFormatException {
			sc = new Scanner(System.in);
			AdminInfo a = new AdminInfo();
			List<AdminLogin.AdminInfo> list1 = new ArrayList<AdminLogin.AdminInfo>();
			
			
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
			if(sc.next().equals("n")) {adminLogin();}
			
			list1.add(a);
			
			listCall();
			
			for(int i= 0; i<list.size() ; i++) {
				if(list.get(i).adminID.equals(a.adminID)) {
					System.out.println("아이디가 중복되었습니다. 확인부탁드립니다.");
					adminLogin();
					break;
				}
			}
			list.addAll(list1);
			
			
			System.out.println();
			Writer os = new FileWriter(path,true); 
			BufferedWriter bos = new BufferedWriter(os);
			for (AdminInfo e : list) {
				bos.write(e.adminID + " " );
				bos.write(e.adminPW + " ");
				bos.write(e.adminName + " ");
				bos.write(e.adminPhone + " ");
				bos.write(e.adminDuty + " ");
				bos.newLine();	
			}
			bos.close();};	
			
		void delAdmin() throws InputMismatchException, IOException, NumberFormatException {
				editWrite();
		};
		void editWrite() throws InputMismatchException, IOException, NumberFormatException {
		sc = new Scanner(System.in);
		list = new ArrayList<AdminLogin.AdminInfo>();
		Writer os = new FileWriter(path); 
		BufferedWriter bos = new BufferedWriter(os);
		for (AdminInfo e : list) {
			bos.write(e.adminID + " " );
			bos.write(e.adminPW + " ");
			bos.write(e.adminName + " ");
			bos.write(e.adminDuty + " ");
			bos.newLine();	
		}
		bos.close();};
	}

	public static boolean adminLogin() throws IOException {
		AdminLogin adminLogin = new AdminLogin();
		Scanner sc = new Scanner(System.in);
		// 아래의 경로가 없으면 생성해라.

		if (!(path1.exists())) {
			path1.mkdir();
		}
		if (!(path.exists())) {
			path.createNewFile();
		}
		System.out.println("1. 기존 아이디 로그인  2. 관리자 추가");
		int number = sc.nextInt();
		if(number == 2) {
			AdminLogin.AdminInfo adminInfo = adminLogin.new AdminInfo();
			adminInfo.addAdmin();
			adminLogin();
		}
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
				} else {
					System.out.println("아이디 비밀번호가 잘못 되었습니다. 처음부터 다시 시도해주세요");

				}
			}
		} catch (IOException e) {
			e.printStackTrace();;
		}
		return false;
	}
}