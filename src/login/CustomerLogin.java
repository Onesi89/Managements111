package login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerLogin {
	static File path1 = new File("data");
	static File path = new File("data/adminInfo.txt");
	
	public static boolean customerLogin(){
	System.out.println("-------------------------"); // 구분선
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		AdminLogin adminLogin = new AdminLogin();
		Scanner sc = new Scanner(System.in);
		// 아래의 경로가 없으면 생성해라.

		if (!(path1.exists())) {
			path1.mkdir();
		}
		if (!(path.exists())) {
			path.createNewFile();
		}
		System.out.println("1. 로그인  2. 회원 가입 3. 뒤로 가기" );
		int number = sc.nextInt();
		
		AdminLogin.AdminInfo adminInfo = adminLogin.new AdminInfo();
		
		switch(number) {
		case 2:{
			adminInfo.addToList();
			adminLogin();
			break;
		}case 3:{
			Login loginStart = Login.getInstance();
			loginStart.systemStart();
			break;
		}case 1:{
			break;
			
		}default :{
			System.out.println("번호를 잘못 입력하셨습니다. 처음으로 돌아갑니다.");
			adminLogin();
		}
		}

		System.out.println("ID를 입력해주세요.");
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
		
