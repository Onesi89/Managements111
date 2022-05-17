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
	
	CustomerManagements() throws IOException {
		File path1 = new File("data"); 
		path = new File("data/test.txt"); //test
		if(!(path1.exists())) {path1.mkdir();} //현재 폴더에 data 폴더생성
		if(!(path.exists())) {path.createNewFile();} //data 폴더에 employee.txt 생성
		sc = new Scanner(System.in);
	}
	
	void  customerList() {
		while (true) {
		
		try(Reader r = new FileReader(path);
			BufferedReader br = new BufferedReader(r);){
			for(long i = 0 ; i < 1000000000 ; i++) {} //시간 지연
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
			System.out.println("------------------------------------"); 
			System.out.println("1. 아이디");
			System.out.println("2. 성함");
			System.out.println("3. 전화번호");
			System.out.println("4. 등급");
			System.out.println("5. 뒤로가기");
			System.out.println("------------------------------------"); 
			System.out.print("선택: ");
			
//			for(int i = 0; i<10; i++) { //전체리스트 확인
//				print(i);
//			} 
			
			switch(sc.nextInt()) {
			case 1:
			{searchID(); break;}
			case 2:
			{searchName(); break;}
			case 3:
			{searchPhone(); break;}
			case 4:
			{searchGrade(); break;}
			case 5:
			{SystemStart startEXE = SystemStart.getInstance();
			startEXE.systemStart();}
			}
		}catch(InputMismatchException e) {System.out.println("72번 오류 고객관리로 돌아갑니다.");}
		catch(IOException e) {System.out.println("73번 오류 고객관리로 돌아갑니다.");}
		}	
	}
	// 요부분 수정하고 싶다.
	void searchID() {
		System.out.println("------------------------------------");
		System.out.println("검색할 ID를 입력해주세요.");
		sc = new Scanner(System.in);
		String a = sc.next();
		int count = 0;
		out: for (int i = 0; i < cList.size(); i++) {
			if (a.equals(cList.get(i).mId)) {
				System.out.println(
						"순번 아이디        비밀번호          이름      생년월일               주소                  전화번호               이메일주소                   등급       포인트");
				count++;
				print(i);
				break out;
			}
		}
		if (count != 0)
			printEdit();
		else {
			System.out.println("\n잘못 입력하였습니다. 고객관리로 이동합니다.");
			customerList();
		}
	}

	void searchName() {
		System.out.println("------------------------------------");
		System.out.println("검색할 이름을 입력해주세요.");
		System.out.println("------------------------------------");
		sc = new Scanner(System.in);
		String a = sc.next();
		int count = 0;

		System.out.println(
				"순번 아이디        비밀번호          이름      생년월일               주소                  전화번호               이메일주소                   등급       포인트");

		for (int i = 0; i < cList.size(); i++) {
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
		customerList();
	}

	void searchPhone() {
		System.out.println("------------------------------------");
		System.out.println("검색할 핸드폰번호를 입력해주세요.");
		System.out.println("------------------------------------");
		sc = new Scanner(System.in);
		String a = sc.next();
		int count = 0;

		System.out.println(
				"순번 아이디        비밀번호          이름      생년월일               주소                  전화번호               이메일주소                   등급       포인트");

		for (int i = 0; i < cList.size(); i++) {
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
		customerList();
	}

	void searchGrade() {
		System.out.println("------------------------------------");
		System.out.println("검색할 등급을 입력해주세요.");
		System.out.println("------------------------------------");
		
		sc = new Scanner(System.in);
		String a = sc.next();
		int count = 0;

		System.out.println(
				"순번 아이디        비밀번호          이름      생년월일               주소                  전화번호               이메일주소                   등급       포인트");

		for (int i = 0; i < cList.size(); i++) {
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
		customerList();
	}

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
	void printEdit() {
		System.out.println("------------------------------------");
		System.out.println("수정할 회원 번호를 선택해주세요. 뒤로가려면 숫자 0을 입력해주세요.");
		System.out.print("선택 : ");
		sc = new Scanner(System.in);
		int number = sc.nextInt();
		try {
		if(number == 0) {System.out.println("처음으로 돌아갑니다.");
			customerList();}
		else if(cList.get(number-1)==null) {
			System.out.println("처음으로 돌아갑니다.");
			customerList();
		}}catch(IndexOutOfBoundsException e) {System.out.println("인덱스 오류");}

		System.out.println("아래의 번호 중 하나를 선택해주세요.");
		System.out.println("1. 회원 수정");
		System.out.println("2. 회원 삭제");
		System.out.println("3. 뒤로 가기");
		System.out.print("선택 :");
		number--;
		
		
		switch(sc.nextInt()) {
		case 1:{new CustomerEdit().edit(); break;}
		case 2:{new CustomerEdit().delete(number); 
				new CustomerEdit().delWrite(cList);
				break;}
		case 3:{printEdit();}
	}
	}
	
	private class CustomerEdit{
		private List<CustomerManagements> delete(int number){
			sc = new Scanner(System.in);
			System.out.println("!!!!!! cList 사이즈 :" + cList.size());
			System.out.println("정말 삭제하시겠습니까?(y/n)");
			if(sc.next().equals("y")) {
				cList.remove(number);
				return cList;
				
			}else return cList;
		};
		
		private void delWrite(List<CustomerManagements> list) {

			try (Writer os = new FileWriter(path); // 덮어쓰기
					BufferedWriter bos = new BufferedWriter(os);) {
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
				}

			} catch (IOException e) {System.out.println("278번줄 오류");
			}

		}
		
		private void edit() {};
		
		
	}
}

 
