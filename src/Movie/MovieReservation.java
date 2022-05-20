package Movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class MovieReservation {
   public String movieName; //영화제목
   public int visitorNumber; //총 관람객 수
   public String actors; // 배우들 모임
   public String plot; //줄거리
   public int screenNumber; //상영관 숫자
   public long sales; //매출
//   Movie movie = new Movie(){};
   public List<Movie> movieArray;
   
   public static void main(String[] args) throws InputMismatchException, IOException {
	   MovieReservation ww = new MovieReservation();
	   ww.reservation();
	    
   } 
   
   
   public void reservation() throws InputMismatchException, IOException {  Scanner sc = new Scanner(System.in);
   
   //영화리스트 클래스에서 영화 정보 불러오기
   
   MovieList movie = new MovieList();
   movie.movieListCall();
   movie.movieInfo();
   
   this.movieArray = movie.movieArray;
		   
   
   
   System.out.println(movieArray.get(0).actors);
   
   System.out.println("---------------------");  //구분선
   
   System.out.println("영화를 선택해주세요>>");
   int num = Integer.parseInt(sc.nextLine());
   
//   선택한 영화 = movieArray.get(num).movieName;
   System.out.println("어른 인원을 입력해주세요>> ");
   String adultCnt = sc.nextLine();
   System.out.println("어린이 인원을 입력해주세요>>");
   String childCnt = sc.nextLine();
   int totTotalCnt = Integer.parseInt(adultCnt) + Integer.parseInt(childCnt);
   
   
//최종 결정사항 map에 넣기 infomap
   Boolean continueFlag = true;
   while(continueFlag) {
      System.out.println("서비스를 선택해 주세요.");
      System.out.println("1.좌석확인 2.좌석예매 3.예매취소 4.예매전체취소 5.프로그램 종료");
      
      List<Map<String, Object>> seatList = new ArrayList<Map<String, Object>>();
      for(int i = 1; i <= 6; i++) {
         for(int j = 1; j <= 6; j++) {
            Map<String, Object> seatMap = new HashMap<String, Object>();
            int iRow = i+64;
            int jRow = j;
            char chrIRow = (char)(iRow);
            
            //상영관 좌석 행
            seatMap.put("row", String.valueOf(chrIRow));
            //상영관 좌석 열
            seatMap.put("col", String.valueOf(jRow));
            //점유 여부
            seatMap.put("emptyYn", "Y");
            seatList.add(seatMap);
         }
      }
      
      
      String str = sc.nextLine();
      switch (str) {
      case "1":
         seatCheck(seatList);
//         break;
      case "2":
         seatReservation(seatList,totTotalCnt);
         break;
      case "3":
         reservationCancel(seatList);
         break;
      case "4":
         myReservationAllCancel(seatList);
         break;
      case "5":
         continueFlag = false;
         System.out.println("프로그램이 종료되었습니다.");
         break;
      default:
         System.out.println("올바른 메뉴를 선택하세요.");
      }
   }}
   
   
     
   
   //메소드2
   private static void seatCheck(List<Map<String, Object>> dataList) {
      //1. 좌석확인
      String prevRow = "A";
      String rowStr = "";
      String colStr = "";
      for(int i = 0;i<dataList.size();i++) {
         //resultMap.get("");
         String currentRow = dataList.get(i).get("row").toString(); 
         String emptyStr = dataList.get(i).get("emptyYn").toString();

         if(prevRow.equals(currentRow)) {
            rowStr = currentRow;
            colStr += "["+currentRow+""+dataList.get(i).get("col").toString() + ":";
            if("Y".equals(emptyStr)) {
               colStr += "O] ";
            }else {
               colStr += "X] ";
            }
         }else {
            System.out.println(colStr);
            prevRow = currentRow;
            colStr = "";
            colStr += "["+currentRow+""+dataList.get(i).get("col").toString() + ":";
            if("Y".equals(emptyStr)) {
               colStr += "O] ";
            }else {
               colStr += "X] ";
            }
         }
      }
      System.out.println(colStr);
   }
   private static void seatReservation(List<Map<String, Object>> seatList,int memberCnt) {
      // 2. 좌석예매 System.out.println("\n\n예매할 좌석을 선택해 주세요."); //1. 좌석확인
      seatCheck(seatList);
      
      Scanner sc = new Scanner(System.in);
      String line = "";
      String num = "";
      String rtnMsg = "";
      for(int j = 0; j < memberCnt; j++) {
         System.out.println("예매할 좌석 번호를 선택하세요::: ");
         String seatLineNum = sc.nextLine();
         System.out.println("seatLineNum::: " + seatLineNum);
         //line = seatLineNum.substring(0, 1);
         line = String.valueOf(seatLineNum.charAt(0));
         num = String.valueOf(seatLineNum.charAt(1));
         
         int i = 0;
         for (Map<String, Object> map : seatList) {
            String seatLine = map.get("row").toString();
            String seatNum = map.get("col").toString();
            
            if (line.equals(seatLine)) {
               if (num.equals(seatNum)) {
                  String seatCheck = map.get("emptyYn").toString();
                  if("N".equals(seatCheck)) {
                     System.out.println("이미 예매된 좌석입니다. ");
                     return;
                  }
                  seatList.get(i).put("emptyYn", "N");
                  //rtnMsg += seatLine + "라인 " + seatNum +"번 좌석 예매를 완료하였습니다.";
                  rtnMsg = seatLine + "라인 " + seatNum +"번 좌석 예매를 완료하였습니다. ";
                  System.out.println(rtnMsg);
               }
            }
            i++;
         }
      }
      //System.out.println("seatList::: " + seatList);
   }

   private static void reservationCancel(List<Map<String, Object>> seatList) {
      //3.예매취소
      seatCheck(seatList);
      System.out.printf("취소할 좌석 라인을 선택하세요::: ");
      Scanner sc = new Scanner(System.in);
      String line = sc.nextLine();
      System.out.printf("취소할 좌석 번호를 선택하세요::: ");
      String num = sc.nextLine();

      int i = 0;
      for (Map<String, Object> map : seatList) {
         String seatLine = map.get("row").toString();
         String seatNum = map.get("col").toString();
         
         if (line.equals(seatLine)) {
            if (num.equals(seatNum)) {
               String seatCheck = map.get("emptyYn").toString();
               if("Y".equals(seatCheck)) {
                  System.out.println("이미 취소된 좌석입니다. ");
                  return;
               }
               seatList.get(i).put("emptyYn", "Y");
               String rtnMsg = seatLine + "라인 " + seatNum +"번 좌석 예매취소를 완료하였습니다. ";
               System.out.println(rtnMsg);
            }
         }
         i++;
      }
   }
   
   private static void myReservationAllCancel(List<Map<String, Object>> seatList) {
      //4.예매전체취소 
      int i = 0;
      for (Map<String, Object> map : seatList) {
         seatList.get(i).put("emptyYn", "N");
         i++;
      }
      System.out.println("예매를 전체 취소하였습니다. ");
   }

//   //movie list에 있는 메소드 똑같이 배낌
//   private static void movieListCall() { 
//      
//
//      File file = new File("C:/temp/movieArray.txt");
//      movieArray = new ArrayList<Movie>();
//
//      String line = null;
//
//      try (Reader r = new FileReader(file); BufferedReader br = new BufferedReader(r)) {
//         
//         while ((line = br.readLine()) != null) {
//            String[] array = line.split("■"); // ■ 삭제
//            Movie movie = new Movie(); // 영화 객체 얻기
//
//            movie.movieName = array[0];
//            movie.visitorNumber = Integer.parseInt(array[1]);
//            movie.actors = array[2];
//            movie.plot = array[3];
//            movie.screenNumber = Integer.parseInt(array[4]);
//            movie.sales = Integer.parseInt(array[5]);
//
//            movieArray.add(movie); // array에 1개 추가
//         }
//
//      } catch (IOException e) {
//         System.out.println(e);
//      } catch (InputMismatchException e) {
//         System.out.println(e);
//      } 
//         
//   }


/*   private static void movieselect(String num) {
      
      MovieList a = new MovieList();
      try {
         a.movieInfo(); // 영화리스트에 모든 원소 출력
                  
      } catch (FileNotFoundException e) {
         System.out.println("잘못 입력 오류");
      } catch (IOException e) {
         System.out.println("입출력 오류");
      } catch (InputMismatchException e) {
         System.out.println("파일 없음 오류");
      }
      
      
      
   }



   private static void movieList() {
      MovieList a = new MovieList();
      try {
         a.movieInfo(); // 영화리스트에 모든 원소 출력
      } catch (FileNotFoundException e) {
         System.out.println("잘못 입력 오류");
      } catch (IOException e) {
         System.out.println("입출력 오류");
      } catch (InputMismatchException e) {
         System.out.println("파일 없음 오류");
      }
      
   }


*/
}