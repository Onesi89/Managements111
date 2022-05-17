package SystemManagements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerManagements {
	private String mId; // 아이디 
	private String mPwd; // 비밀번호
	private String mName; //이름
	private String mBirth; //생년월일
	private String mAdress; //주소
	private String mPhone; //전화번호
	private String mEmail; //이메일
	private String mGrade; //회원등급
	private String mPoint; //포인트
	private List<CustomerManagements> cList; // 고객정보 객체 리스트 저장 -> 문제가 있을런지 확인
	private File path; // 파일 경로
	public Scanner sc;
	
	CustomerManagements() throws IOException {
		File path1 = new File("data"); 
		path = new File("data/test.txt"); //test
		if(!(path1.exists())) {path1.mkdir();} //현재 폴더에 data 폴더생성
		if(!(path.exists())) {path.createNewFile();} //data 폴더에 employee.txt 생성
		sc = new Scanner(System.in);
	}
	
	void  customerList() {
//		for(long i = 0 ; i < 1000000000 ; i++) {} //시간 지연
		try(Reader r = new FileReader(path);
			BufferedReader br = new BufferedReader(r);){
			sc = new Scanner(System.in);
			System.out.println("------------------------------------");
			System.out.println("   고객 관리 창입니다.");
			System.out.println("------------------------------------");      
			cList = new ArrayList<CustomerManagements>();
			String line = null;
			
			while((line = br.readLine()) != null) {
				String[] abc = line.split("■");
				CustomerManagements test = new CustomerManagements();
				
				test.mId = abc[1];
				test.mPwd = abc[2];
				test.mName = abc[3];
				test.mBirth = abc[4];
				test.mAdress = abc[5];
				test.mPhone = abc[6];
				test.mEmail = abc[7];
				test.mGrade = abc[8];
				test.mPoint = abc[9];
				cList.add(test);	
			}
			System.out.println("검색할 항목을 선택해주세요.");
			System.out.println("1. 아이디");
			System.out.println("2. 성함");
			System.out.println("3. 전화번호");
			System.out.println("4. 등급");
			
		/*	for(int i = 0; i<10; i++) { 전체리스트 확인
				print(i);
				System.out.println();
			} */
			
			switch(sc.nextInt()) {
			case 1:
			{searchID();}
			case 2:
			{searchName();}
			case 3:
			{searchPhone();}
			case 4:
			{searchGrade();}	
			
			}
			
		}catch(InputMismatchException e) {System.out.println("72번 오류");}
		catch(IOException e) {System.out.println("73번 오류");}
		
	}
	// 요부분 수정하고 싶다.
	void searchID() {
		System.out.println("입력해주세요.");
		sc = new Scanner(System.in);
		String a = sc.next();
		System.out.println("순번 아이디        비밀번호          이름      생년월일               주소                  전화번호               이메일주소                   등급       포인트");
		for(int i = 0 ; i<cList.size();i++) {
			if(a.equals(cList.get(i).mId)) {			
				print(i);	}

			else {System.out.println("잘못 입력하셨습니다. 처음으로 돌아갑니ㅏ.");}                             
			}                                 
		}                                     

	void searchName() {
		System.out.println("입력해주세요.");
		sc = new Scanner(System.in);
		String a = sc.next();
		System.out.println("순번 아이디        비밀번호          이름      생년월일               주소                  전화번호               이메일주소                   등급       포인트");
		for(int i = 0 ; i<cList.size();i++) {
			if(a.equals(cList.get(i).mName)) {			
				print(i);	}

			else {}                             
			}                                 
		}     
	
	void searchPhone() {
		System.out.println("입력해주세요.");
		sc = new Scanner(System.in);
		String a = sc.next();
		System.out.println("순번 아이디        비밀번호          이름      생년월일               주소                  전화번호               이메일주소                   등급       포인트");
		for(int i = 0 ; i<cList.size();i++) {
			if(a.equals(cList.get(i).mPhone)) {			
				print(i);	}

			else {	}                             
			}                                 
		} 
	void searchGrade() {
		System.out.println("입력해주세요.");
		sc = new Scanner(System.in);
		String a = sc.next();
		System.out.println("순번 아이디        비밀번호          이름      생년월일               주소                  전화번호               이메일주소                   등급       포인트");
		for(int i = 0 ; i<cList.size();i++) {
			if(a.equals(cList.get(i).mGrade)) {			
				print(i);}                            
			}                                 
		} 

	void print(int i) {
		System.out.print((i+"  "));
		System.out.print(cList.get(i).mId+"   ");
		System.out.print(cList.get(i).mPwd+"    ");
		System.out.print(cList.get(i).mName+"    " );
		System.out.print(cList.get(i).mBirth+"   ");
		System.out.print(cList.get(i).mAdress+"   ");
		System.out.print(cList.get(i).mPhone+"    ");
		System.out.print(cList.get(i).mEmail+"    ");
		System.out.print(cList.get(i).mGrade+"    ");
		System.out.print(cList.get(i).mPoint+"   ");
		System.out.println();
	}
}

 
