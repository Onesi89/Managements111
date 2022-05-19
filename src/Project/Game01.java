package Project;
import java.util.*;
import java.util.Scanner;
public class Game01 {
	//가위바위보게임
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);

	      System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");

	      System.out.println(" 가위  바위  보  게임 ");


	      System.out.println(" 1.가위 ");
	      System.out.println(" 2.바위 ");
	      System.out.println(" 3.보 ");
	      System.out.println(" 4.나가기 ");
	      System.out.println(" 숫자을 입력하시오.");

	      System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");   

	      int com = 0;
	      
	      Random r = new Random();
	      int user = sc.nextInt();
	      com = r. nextInt(4)+1;

	      if(user == 1) {
	         if(com == 2) {

	            System.out.println(" ■ 승리 ■ ");
	         }
	         else if(com == 3) {
	            System.out.println(" ■ 패배 ■ ");
	         }
	         else {
	            System.out.println(" ■ 무승부 ■ ");
	         }
	      }
	      else if(user == 2) {
	         if(com == 2) {
	            System.out.println(" ■ 무승부 ■ ");
	         }
	         else if(com == 3) {
	            System.out.println(" ■ 승리 ■ ");
	          
	         }
	         else {
	            System.out.println(" ■ 패배 ■ ");
	         }
	      }
	      else if(user == 3) {
	         if(com == 2) {
	            System.out.println(" ■ 패배 ■ ");
	         }
	         else if(com == 3) {
	            System.out.println(" ■ 무승부 ■ ");
	         }
	         else {
	            System.out.println(" ■ 승리 ■ ");
	      
	         }
	      }
	      else {
	         System.out.println(" 다시 입력 해주세요!!");
	      }


	      sc.close();

	   }

	public void printGame03(String helloworld) {
		// TODO Auto-generated method stub
		
	}
	}

