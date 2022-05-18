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

public class EmployeeManagements implements interfaceList.HumanInfoEditable{
	private String name;
	private String phoneNumber;
	private String duty;
	private String joinDate;
	private List<EmployeeManagements> emList;
	public File path;
	public Scanner sc;
	

	EmployeeManagements() throws IOException{
		File path1 = new File("data"); 
		path = new File("data/employee.txt");
		if(!(path1.exists())) {path1.mkdir();} //현재 폴더에 data 폴더생성
		if(!(path.exists())) {path.createNewFile();} //data 폴더에 employee.txt 생성
		sc = new Scanner(System.in);
	}
	
	EmployeeManagements(String name, String phoneNumber, String duty, String joinDate){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.duty = duty;
		this.joinDate = joinDate;
		path = new File("data/employee.txt");
		sc = new Scanner(System.in);
	}
	@Override
	public void listCall() {
		while (true) {
			try (Reader r = new FileReader(path); BufferedReader br = new BufferedReader(r);) {
				for(long i = 0 ; i < 1000000000 ; i++) {} //시간 지연
				System.out.println("------------------------------------");
				System.out.println("   직원 관리 창입니다.");
				System.out.println("------------------------------------");
				System.out.print("순번    이름\t     핸드폰번호          직무     입사일\n");
				emList = new ArrayList<EmployeeManagements>();

				String line = null; // line 초기화
				
				int i = 0; // i 초기화
				while ((line = br.readLine()) != null) {
					System.out.println((i + 1) + "   " + line);
					i++;
					String[] abc = line.split(" ");
					EmployeeManagements test = new EmployeeManagements();
					test.name = abc[0];
					test.phoneNumber = abc[1];
					test.duty = abc[2];
					test.joinDate = abc[3];
					emList.add(test);}
					
					System.out.println("------------------------------------");
					System.out.println("1. 직원 추가");
					System.out.println("2. 직원 삭제");
					System.out.println("3. 직원 수정");
					System.out.println("4. 뒤로 가기");
					System.out.println("------------------------------------");
					System.out.print(("선택 : "));
					
					sc = new Scanner(System.in);

					switch (sc.nextInt()) {
					case 1: {
						System.out.println("------------------------------------");
						this.addToList();
						listCall();
						break;
					}
					case 2: {
						System.out.println("------------------------------------");
						this.delFromList();
						listCall();;
						break;

					}
					case 3: {
						System.out.println("------------------------------------");
						this.employeeEdit();
						listCall();
						break;
					}

					case 4: {
						System.out.println("------------------------------------");
						SystemStart startEXE = SystemStart.getInstance();
						startEXE.systemStart();
						break;
					}
					default: {
						System.out.println("번호를 다시 선택해주세요.97");
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("! 108 번호를 다시 입력해주세요 , 처음으로 갑니다.");
			} catch (IOException e) {
				System.out.println("!110 입출력 파일에 오류가 있습니다. 확인 해주세요.");
			}
		}
	}
	
	@Override
	public void addToList() { //추가
		emList = new ArrayList<EmployeeManagements>();
		
		System.out.println("이름을 입력하세요.");
		this.name = sc.next();;
		System.out.println("전화번호를 입력하세요.");
		this.phoneNumber = sc.next();
		System.out.println("직무를 입력하세요.");
		this.duty = sc.next();
		System.out.println("입사일 입력하세요.");
		this.joinDate = sc.next();
		System.out.println("저장 하시겠습니까?(y/n)");
		
		emList.add(this);
		
		out:
		for (;;) {
			try (Writer os = new FileWriter(path, true); // 이어쓰기
					BufferedWriter bos = new BufferedWriter(os);) {
				String a = sc.next();
				if (a.equals("y")) {
					System.out.println("저장 되었습니다.");
					for (EmployeeManagements e : emList) {
						bos.write(e.name + " ");
						bos.write(e.phoneNumber + " ");
						bos.write(e.duty + " ");
						bos.write(e.joinDate);
						bos.newLine();
					}
					break out;
				} else if (a.equals("n")) {
					System.out.println("! 146 잘못 입력하였습니다. 처음으로 돌아갑니다.");
					listCall();
				} else {
					System.out.println("다시 입력해주세요(y/n)");
				}

			} catch (IOException e) {
				System.out.println("! 153 처음으로 돌아갑니다.");
			} catch (InputMismatchException e) {
				System.out.println("! 155 처음으로 돌아갑니다.");
			}

		}
	}
	@Override
	public void delFromList() throws InputMismatchException, IOException, NumberFormatException { // 삭제
		System.out.println("삭제할 번호를 선택하세요");
		int number = sc.nextInt() - 1;
		System.out.println("정말 삭제하시겠습니까?(y/n) 복구가 불가능합니다.");
		String a = sc.next();
		if (a.equals("y")) {
			emList.remove(number);
			listWrite(false);
		} else {
			System.out.println("!178 취소되었습니다. 처음으로 돌아갑니다.");
		}

	}

	public void employeeEdit() throws InputMismatchException, IOException, NumberFormatException { // 수정
		System.out.println("수정할 번호를 선택하세요");

		int number = (sc.nextInt() - 1);
		if (number < emList.size() && number > -1) {
			sc = new Scanner(System.in);
			System.out.println("이름을 입력하세요.");
			String name = sc.next();
			System.out.println("전화번호를 입력하세요.");
			String phoneNumber = sc.next();
			System.out.println("직무를 입력하세요.");
			String duty = sc.next();
			System.out.println("입사일 입력하세요.");
			String joinDate = sc.next();
			System.out.println("저장 하시겠습니까?(y/n)");
			EmployeeManagements b = new EmployeeManagements(name, phoneNumber, duty, joinDate);

			if (sc.next().equals("y")) {
				emList.set(number, b);
				listWrite(false);
			} else {
				System.out.println("------------------------------------");
				System.out.println("! 213 취소 되었습니다. 직원리스트로 돌아갑니다.");
			}
		} else {
			System.out.println("------------------------------------");
			System.out.println("! 217 취소 되었습니다. 직원 리스트로 돌아갑니다.");
		}
	}
	// 코드 줄임용
	@Override
	public void listWrite(boolean tureOrFalse) throws InputMismatchException, IOException, NumberFormatException {
		Writer os = new FileWriter(path,tureOrFalse); 
		BufferedWriter bos = new BufferedWriter(os);
		for (EmployeeManagements e : emList) {
			bos.write(e.name + " ");
			bos.write(e.phoneNumber + " ");
			bos.write(e.duty + " ");
			bos.write(e.joinDate);
			bos.newLine();	
		}
		bos.close();
	}
}	