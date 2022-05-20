package SystemManagements;

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
	public String str = "------------------------------------\n순번 아이디               비밀번호             이름      생년월일                     주소                  전화번호               이메일주소                             등급       포인트";
	
	//생성자
	CustomerManagements() throws IOException {
		File path1 = new File("data"); 
		path = new File("data/test.txt"); //test
		sc = new Scanner(System.in);
		
		if(!(path1.exists())) {path1.mkdir();} //현재 폴더에 data 폴더생성
		if(!(path.exists())) {path.createNewFile();} //data 폴더에 employee.txt 생성	
	}
	
	//고객관리 메인화면
	void customerList() { 
		//반복문 시작
		out:
		while (true) {
		
		try(Reader r = new FileReader(path);
			BufferedReader br = new BufferedReader(r);)
		{	//시간 지연
			for(long i = 0 ; i < 1000000000 ; i++) {} 
			
			sc = new Scanner(System.in);
			
			System.out.println("------------------------------------");
			System.out.println("   고객 관리 창입니다.");
			System.out.println("------------------------------------");     
			
			//CustomerManagements 필드이 cList 초기화
			cList = new ArrayList<CustomerManagements>();
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				//구분자 제거 [1,2,3,4,5,6...]
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
			System.out.println("------------------------------------"); 
			System.out.println("1. 아이디");
			System.out.println("2. 성함");
			System.out.println("3. 전화번호");
			System.out.println("4. 등급");
			System.out.println("5. 뒤로가기");
			System.out.println("------------------------------------"); 
			System.out.print("선택: ");
		
			//고객 아이디, 이름, 전화번호, 등급으로 검색
			switch(sc.nextInt()) { 
			
			case 1:
			{searchID(); break;}
			case 2:
			{searchName(); break;}
			case 3:
			{searchPhone(); break;}
			case 4:
			{searchGrade(); break;}
			//관리자 모드로 이동
			case 5:
			{break out;
			}
			}
			
		}catch(InputMismatchException e) {System.out.println("입력을 잘못 하셨습니다. 고객관리로 돌아갑니다.");}
		catch(IOException e) {System.out.println("입출력 파일 오류입니다. 고객관리로 돌아갑니다.");}
		}
		//관리자 시스템으로 돌아가기
		SystemStart startEXE = SystemStart.getInstance();
		startEXE.systemStart();
	}

	//고객 ID 검색
	void searchID() {
		System.out.println("------------------------------------");
		System.out.println("검색할 ID를 입력해주세요.");
		
		sc = new Scanner(System.in);
		String a = sc.next();
		
		// count가 0이면 일치하는 값 없음. 1이면 일치하는 값 있음.
		int count = 0;
		out: for (int i = 0; i < cList.size(); i++) {
			if(i==0) {System.out.println(str);}
			if (a.equals(cList.get(i).mId)) {
			count++;
			print(i);
			break out;
			}
		}
		
		if (count != 0)
			printEdit();
		else {
			System.out.println("\n잘못 입력하였습니다. 고객관리로 이동합니다.");
//			customerList();
		}
	}

	
	//고객 이름 검색
	void searchName() { //이름 검색
		System.out.println("------------------------------------");
		System.out.println("검색할 이름을 입력해주세요.");
		
		sc = new Scanner(System.in);
		String a = sc.next();
		
		// count가 0이면 일치하는 값 없음. 1이면 일치하는 값 있음.
		int count = 0;
		
		for (int i = 0; i < cList.size(); i++) {
			if(i==0) {System.out.println(str);}
			if (a.equals(cList.get(i).mName)) {  
			count++;
			print(i);
			}
		}
		if (count != 0)
			printEdit();
		else {
			System.out.println("\n잘못 입력하였습니다. 고객관리로 이동합니다.");
		}
//		customerList();
	}
	
	//핸드폰번호 검색
	void searchPhone() { 
		System.out.println("------------------------------------");
		System.out.println("검색할 핸드폰번호를 입력해주세요.");

		sc = new Scanner(System.in);
		String a = sc.next();
		
		// count가 0이면 일치하는 값 없음. 1이면 일치하는 값 있음.
		int count = 0;

		for (int i = 0; i < cList.size(); i++) {
			if(i==0) {System.out.println(str);}
			if (a.equals(cList.get(i).mPhone)) { 
			count++;
			print(i);
			}
		}
		
		if (count != 0)
			printEdit();
		else {
			System.out.println("\n잘못 입력하였습니다. 고객관리로 이동합니다.");
		}
//		customerList();
	}
	
	//등급 검색
	void searchGrade() { 
		System.out.println("------------------------------------");
		System.out.println("검색할 등급을 입력해주세요.");

		
		sc = new Scanner(System.in);
		String a = sc.next();
		
		// count가 0이면 일치하는 값 없음. 1이면 일치하는 값 있음.
		int count = 0;
		for (int i = 0; i < cList.size(); i++) {
			if(i==0) {System.out.println(str);}
			if (a.equals(cList.get(i).mGrade)) {  
			count++;
			print(i);
			}
		}
		if (count != 0)
			printEdit();
		else {
			System.out.println("\n잘못 입력하였습니다. 고객관리로 이동합니다.");
		}
//		customerList();
	}

	// 원소 출력 메서드
	void print(int i) { 
		System.out.print((i+1)+"  ");
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
	
	//수정 화면 메서드
	void printEdit() { 
		System.out.println("------------------------------------");
		System.out.println("수정할 회원 번호를 선택해주세요. 뒤로가려면 숫자 0을 입력해주세요.");
		System.out.print("선택 : ");
		
		sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		//잘못된 값을 입력받았을 때 빠져나올 수 있는 값
		boolean test = true;
		
		try {

			
			if(number == 0) {
				test = false;}
			
			else if(cList.get(number-1)==null) {
				test  =false;
			}
			
		}catch(IndexOutOfBoundsException e) {System.out.println("인덱스 오류");}

		//입력받은 값과 인덱스 값의 차이 보정
		number--;
		
		if (test) {
			
			System.out.println("아래의 번호 중 하나를 선택해주세요.");
			System.out.println("1. 회원 수정");
			System.out.println("2. 회원 삭제");
			System.out.println("3. 뒤로 가기");
			System.out.print("선택 :");
			
			switch (sc.nextInt()) { // 수정 선택문
				case 1: {
					new CustomerEdit().edit(number);
					new CustomerEdit().customerWrite(cList);
					break;
				}
	
				case 2: {
					new CustomerEdit().delete(number);
					new CustomerEdit().customerWrite(cList);
					break;
				}
	
				case 3: {
					printEdit();
				}
			}
		}else {
			System.out.println("\n잘못입력하셨습니다. 고객관리로 돌아갑니다.\n");}
}
	
	//회원 수정 이너클래스
	private class CustomerEdit{ 
		
		//회원 삭제 
		private List<CustomerManagements> delete(int number){ 
			sc = new Scanner(System.in);

			System.out.println("정말 삭제하시겠습니까?(y/n)");
			
			if(sc.next().equals("y")) {
				cList.remove(number);
				return cList;
				
			}else return cList;
		};
		
		// 회원정보 txt파일로 저장
		private void customerWrite(List<CustomerManagements> list) { // 덮어쓰기
			try (Writer os = new FileWriter(path);
				 BufferedWriter bos = new BufferedWriter(os);)
				{
				int count = 1;
				for (CustomerManagements e : cList) {
					bos.write(String.valueOf(count++));
					bos.write("■");
					bos.write(e.mId);
					bos.write("■");
					bos.write(e.mPwd);
					bos.write("■");
					bos.write(e.mName);
					bos.write("■");
					bos.write(e.mBirth);
					bos.write("■");
					bos.write(e.mAdress);
					bos.write("■");
					bos.write(e.mPhone);
					bos.write("■");
					bos.write(e.mEmail);
					bos.write("■");
					bos.write(e.mGrade);
					bos.write("■");
					bos.write(e.mPoint);
					bos.newLine();
					bos.flush();
				}
				} catch (IOException e) {System.out.println("입출력 오류입니다.");
			}

		}
		
		// 회원 수정
		private void edit(int number) { 
			
			sc = new Scanner(System.in);
			
			System.out.println("------------------------------------");
			System.out.println("수정할 항목을 선택해주세요.");
			System.out.println("1. 정보");
			System.out.println("2. 비밀번호 변경");
			System.out.print("선택 : ");

			switch (sc.nextInt()) {
			case 1: {
				editSelect(number,1);
				System.out.println("------------------------------------");
				break;
			}
			case 2: {
				editSelect(number,2);
				System.out.println("------------------------------------");
				break;
			}
			case 3: {
				System.out.println("뒤로 가기");
				System.out.println("------------------------------------");
				printEdit();
				break;
			}

			default : {
				System.out.println("고객관리로 돌아갑니다.");
				System.out.println("------------------------------------");
//				customerList();
				break;
			}
			}

		} 	

		private List<CustomerManagements> editSelect(int number, int caseNumber) {
			
			switch (caseNumber) {
			
			case 1: {
				sc = new Scanner(System.in);
				
				System.out.println("이름을 입력해주세요."); // cList 인덱스 2
				cList.get(number).mName = sc.nextLine();
				
				System.out.println("생일을 입력해주세요.(ex : 990101)"); // cList 인덱스 3
				cList.get(number).mBirth = sc.nextLine();
				
				System.out.println("주소를 입력해주세요."); // cLlit 인덱스 4
				cList.get(number).mAdress = sc.nextLine();
				
				System.out.println("핸드폰 번호를 입력해주세요.(ex : 010-xxxx-xxxx)"); // cList 인덱스 5
				cList.get(number).mPhone = sc.nextLine();
				
				System.out.println("이메일 주소를 입력해주세요."); // cList 인덱스 6;
				cList.get(number).mEmail = sc.nextLine();
			}
			case 2: {
				sc = new Scanner(System.in);
				System.out.println("비밀번호를 입력해주세요");
				cList.get(number).mPwd = sc.nextLine();
				System.out.println("고객관리로 들어갑니다.");
			}
			}
			return cList;
		}
	}
}
