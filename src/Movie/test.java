package Movie;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

public class test {
	public static void main(String[] args) {
		
		// 영화 객체 생성
		MovieList a = new MovieList();
		try {
			a.movieListCall(); //영화 리스트 불러오기
			a.movieInfo(); // 영화리스트에 모든 원소 출력
			a.addToList(); // 영화  1개 추가
			a.movieInfo(); // 영화리스트에 모든 원소 출력
			a.delFromList(); //영화 1개 삭제
			a.movieInfo(); // 영화리스트에 모든 원소 출력
					
		} catch (FileNotFoundException e) {
			System.out.println("잘못 입력 오류");
		} catch (IOException e) {
			System.out.println("입출력 오류");
		} catch (InputMismatchException e) {
			System.out.println("파일 없음 오류");
		}

	}

}
