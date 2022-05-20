package Movie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import customer.Member;
import customer.MemberArray;



	public class MovieReservation {
		
		static Map<String,Object> seatMap;
		public static String selecRow;
		public static String selecCol;
		public static List<String> infoList;
		public List<Movie> movieArray;
		public int num;
		public Member member;
		
		//
		List<Member> memberArray;
   
   
//  public static void main(String[] args) throws InputMismatchException, IOException {
//	   MovieReservation ww = new MovieReservation();
//	   ww.asd();
//	   System.out.println(infoList);
//   }
//  
  
  
  
   //reservation Start
   public void reservation(Member member1) throws InputMismatchException, IOException { 
			try {

				this.member = member1;

				showMovieList();// 1. 영화리스트 클래스에서 영화 정보 불러오기

				Scanner sc = new Scanner(System.in);
				System.out.println("---------------------"); // 구분선

				System.out.println("영화를 선택해주세요>>");
				int num = Integer.parseInt(sc.nextLine());
				this.num = num;

				System.out.println("선택한 영화 : " + movieArray.get(num - 1).movieName);
				System.out.println();

				List<String> selcetSeat1 = new ArrayList<>();
				seat(); // 2. 좌석 출력 및 선택 메소드

				System.out.println();
				System.out.println("선택하신 좌석은 [" + selecRow + selecCol + "] 입니다");
				System.out.println("영화 관람 비용은  10000원 입니다.\n");

				// 로그인 한 아이디로 -> 포인트 출력

				System.out.println("\n" + member.getmName() + "님의 보유 포인트는 " + member.getmPoint() + "입니다.");
				
				int usePoint = 0;
				
				outout:
				for(;;) {
				System.out.println("포인트를 사용하시겠습니까? (y/n)");
	
				String sel = sc.next();
				
				// memberArray = memberList.memberArray;
				MemberArray memberList = new MemberArray();
				
				
				if(sel.equals("y")) {
				System.out.print("사용하실 포인트를 입력해주세요>>  ");

				usePoint = sc.nextInt(); // 포인트 사용
				
					if(usePoint <= Integer.parseInt(member.getmPoint())){		
						
						// 맴버 포인트 사용
						member.minusPoint(usePoint);
						
						memberList.edit(Integer.parseInt(this.member.getmNum()) - 1, member);

						System.out.println("\n오늘 결제하실 총 금액은 " + (10000 - usePoint) + "입니다.");
						System.out.println("남은 포인트는 "+member.getmPoint()+"입니다.");
						
						break outout;
						
					} else {System.out.println("보유하신 포인트가 더 적습니다. 확인부탁드립니다.\n");}
		
				
				}else {
					member.plusPoint(100);
					
					System.out.println("\n오늘 결제하실 총 금액은 " + (10000) + "입니다.");
					System.out.println("포인트 적립 100원이 되었습니다. 고객님의 포인트는" + member.getmPoint() + "입니다.");
					memberList.edit(Integer.parseInt(this.member.getmNum()) - 1, member);
					break outout;
					
					}
				}
				
				// 입력 정보 리스트
				List<String> infoList = new ArrayList<>();
				infoList.add(movieArray.get(num - 1).movieName); // 0 :영화이름
				infoList.add(selecRow + selecCol); // 1 : 선택좌석
				infoList.add(Integer.toString(usePoint)); // 사용 포인트
				MovieReservation.infoList = infoList;
				
				System.out.println("예약에 성공하였습니다. 마이페이지로 이동합니다.");
				
				
				
			} catch(NumberFormatException e) {
				System.out.println("입력을 잘못 하였습니다. 처음부터 다시 해주세요.");
			}
				catch (InputMismatchException e) {
				System.out.println("입력을 잘못 하였습니다. 처음부터 다시 해주세요.");
			} catch (IOException e) {
				System.out.println("처음부터 다시 해주세요.");
			}
		}
	
	// asd() End
   
   
   
   //1. 영화리스트 클래스에서 영화 정보 불러오기 Start
   public void showMovieList() throws InputMismatchException, IOException {
	   MovieList movie = new MovieList();
		movie.movieListCall();
		movie.movieInfo();

		this.movieArray = movie.movieArray;
}
 //1. 영화리스트 클래스에서 영화 정보 불러오기 End




 //2. 좌석 출력 및 선택 메소드 Start
public void seat() {  
	   //좌석 생성
	   List<String> row1 = Arrays.asList("1","2","3","4","5");
	   List<String> row2 = Arrays.asList("1","2","3","4","5");
	   List<String> row3 = Arrays.asList("1","2","3","4","5");
	   Map<String,List> seatMap = new HashMap<>();
	   seatMap.put("A",row1);
	   seatMap.put("B",row2);
	   seatMap.put("C",row3);
	   System.out.println("A : " +seatMap.get("A")); 
	   System.out.println("B : " +seatMap.get("B"));
	   System.out.println("C : " +seatMap.get("C"));
 
	   
	   //좌석 입력 받기
	   Scanner sc1 = new Scanner(System.in);
	   System.out.println("------좌석을 선택해 주세요.------");
	   System.out.println("문자  선택하기>>"); //a
	   String selecRow = sc1.nextLine().toUpperCase();
	   System.out.println("앉고싶은 좌석의 숫자 선택하기>>"); //3
	   String selecCol = sc1.nextLine();
	   
	   this.selecRow = selecRow;
	   this.selecCol = selecCol;
	   
	   List<String> reservRowList = seatMap.get(selecRow);
	   reservRowList.set(Integer.parseInt(selecCol)-1, "X");
	   seatMap.put(selecRow,reservRowList);
	   System.out.println("A : " +seatMap.get("A")); 
	   System.out.println("B : " +seatMap.get("B"));
	   System.out.println("C : " +seatMap.get("C"));
	  
   }
   
//2. 좌석 출력 및 선택 메소드 End
   
   
	}
   