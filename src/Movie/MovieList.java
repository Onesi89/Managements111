package Movie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MovieList {

	
	/*해당 객체를 만들고, 출력할 때는 무조건 try - catch 로 예외처리 해줘야함.
	 * FileNotFoundException, InputMismatchException, IOException
	 * */
	
	public List<Movie> movieArray;
	

	// 파일 덮어쓰기전에 실행하세요. txt파일에서 내용을 arraylist에 담기
	public void movieListCall() {
		File file = new File("data/movieArray.txt");
		movieArray = new ArrayList<Movie>();

		String line = null;

		try (Reader r = new FileReader(file); BufferedReader br = new BufferedReader(r)) {
			
			while ((line = br.readLine()) != null) {
				String[] array = line.split("■"); // ■ 삭제
				Movie movie = new Movie(); // 영화 객체 얻기

				movie.movieName = array[0];
				movie.visitorNumber = Integer.parseInt(array[1]);
				movie.actors = array[2];
				movie.plot = array[3];
				movie.screenNumber = Integer.parseInt(array[4]);
				movie.sales = Integer.parseInt(array[5]);

				movieArray.add(movie); // array에 1개 추가
			}

		} catch (IOException e) {
			System.out.println(e);
		} catch (InputMismatchException e) {
			System.out.println(e);
		}
	}
	
	// 파일 덮어쓰기 실행하세요. arraylist 에서 txt 파일 담기.
	public void movieWrite() {
		File file = new File("data/movieArray.txt");

		try (Writer w = new FileWriter(file); BufferedWriter bw = new BufferedWriter(w)) {

			for (int i = 0; i < movieArray.size(); i++) {
				bw.write(movieArray.get(i).movieName);
				bw.write("■");
				bw.write(String.valueOf(movieArray.get(i).visitorNumber));
				bw.write("■");
				bw.write(movieArray.get(i).actors);
				bw.write("■");
				bw.write(movieArray.get(i).plot);
				bw.write("■");
				bw.write(String.valueOf(movieArray.get(i).screenNumber));
				bw.write("■");
				bw.write(String.valueOf((int) movieArray.get(i).sales)); // write long 안됨..
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (InputMismatchException e) {
			System.out.println(e);
		}

	}
		
   //영화 정보 출력
	public void movieInfo() throws InputMismatchException, IOException{ // movieArray.get(i).movieInfo() 출력임
		movieListCall();
		System.out.println("--------------------");
		for (int i = 0; i < movieArray.size(); i++) {
			System.out.print(i+1+". ");
			movieArray.get(i).movieInfo();
			System.out.println("--------------------");
		}
	}
		
	//영화 추가, movieArray.get(i).movieInfo() 출력임
	public void addToList() throws InputMismatchException, IOException{
		movieListCall();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("영화 제목을 입력해주세요.");
		String movieName = sc.nextLine();
		
		System.out.println("상영관을 선택해주세요(숫자)");
		int screenNumber = Integer.parseInt(sc.nextLine());

		Movie movie = new Movie(movieName, screenNumber);
		
		System.out.println("영화 배우들을 입력해주세요. 다 입력하셨으면 엔터를 눌러주세요.");
		String actors = sc.nextLine();
		movie.setActor(actors);
		
		System.out.println("간단한 줄거리를 입력해주세요. 다 입력하셨으면 엔터를 눌러주세요.");
		String plot = sc.nextLine();
		movie.setPlot(plot);
		
	
		movieArray.add(movie);
		
		movieWrite();
		
		System.out.println("추가 되었습니다. 영화 관리 화면으로 돌아갑니다.");
	}
		
	// 영화 삭제
	public void delFromList() { // movieArray.get(i).movieInfo() 출력임
		movieListCall();
		for(int i = 0; i< movieArray.size(); i++) {
			System.out.println((i+1) + " ."+ movieArray.get(i).movieName);
		}
		Scanner sc = new Scanner(System.in);

		System.out.println("삭제할 영화의 번호를 선택해주세요.");
		int number = Integer.parseInt(sc.nextLine()) - 1;

		System.out.println("정말 삭제하시겠습니까(y/n)");
		String select = sc.nextLine();

		if (select.equals("y")) {
			movieArray.remove(number);
			System.out.println("삭제 되었습니다. 영화 관리 화면으로 돌아갑니다.");
			movieWrite();
		} else {
			System.out.println("잘못 입력하였습니다. 영화 관리 화면으로 돌아갑니다.");
		}

	}
}
