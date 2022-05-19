package Movie;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import SystemManagements.SystemStart;

public class MovieHome {
	public void movieHomeStart() {
		while(true) {
			try {
			for(int i = 0; i<1000000000;i++);
			System.out.println("--------------------");
			System.out.println("  영화관리.");
			System.out.println("--------------------");
			System.out.println("1. 현재 상영작 정보");
			System.out.println("2. 영화 추가");
			System.out.println("3. 영화 삭제");
			System.out.println("4. 뒤로가기");
			System.out.println("번호를 선택해주세요.");
			
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			MovieList movie = new MovieList();
			
			switch(number) {
			case 1: {
				System.out.println("--------------------");
				System.out.println("  영화 정보    ");
				movie.movieInfo();
				break;
				
			}
			case 2:{
				System.out.println("--------------------");
				System.out.println("  영화 추가    ");
				movie.addToList();
				break;
			}
			case 3:{		
				System.out.println("--------------------");
				System.out.println("  영화 삭제    ");
				movie.delFromList();
				break;
			}
			case 4:{		
				System.out.println("--------------------");
				System.out.println("  관리자 모드로 돌아갑니다.");
				SystemStart startEXE = SystemStart.getInstance();
				startEXE.systemStart();
				
			}
			}
			}catch(FileNotFoundException e) {
				System.out.println("파일을 찾을 수 없습니다. 관리자 모드로 돌아갑니다.");
			}
			catch(InputMismatchException e) {
				System.out.println("파일을 찾을 수 없습니다. 관리자 모드로 돌아갑니다.");
			}                                      
			catch(IOException e) {                 
				System.out.println("파일을 찾을 수 없습니다. 관리자 모드로 돌아갑니다.");
			}

		}

	}

}
