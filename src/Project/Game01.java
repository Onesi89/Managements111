package Project;
import java.util.*;
import java.util.Scanner;
public class Game01 {
	//��������������
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);

	      System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");

	      System.out.println(" ����  ����  ��  ���� ");


	      System.out.println(" 1.���� ");
	      System.out.println(" 2.���� ");
	      System.out.println(" 3.�� ");
	      System.out.println(" 4.������ ");
	      System.out.println(" ������ �Է��Ͻÿ�.");

	      System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");   

	      int com = 0;
	      
	      Random r = new Random();
	      int user = sc.nextInt();
	      com = r. nextInt(4)+1;

	      if(user == 1) {
	         if(com == 2) {

	            System.out.println(" �� �¸� �� ");
	         }
	         else if(com == 3) {
	            System.out.println(" �� �й� �� ");
	         }
	         else {
	            System.out.println(" �� ���º� �� ");
	         }
	      }
	      else if(user == 2) {
	         if(com == 2) {
	            System.out.println(" �� ���º� �� ");
	         }
	         else if(com == 3) {
	            System.out.println(" �� �¸� �� ");
	          
	         }
	         else {
	            System.out.println(" �� �й� �� ");
	         }
	      }
	      else if(user == 3) {
	         if(com == 2) {
	            System.out.println(" �� �й� �� ");
	         }
	         else if(com == 3) {
	            System.out.println(" �� ���º� �� ");
	         }
	         else {
	            System.out.println(" �� �¸� �� ");
	      
	         }
	      }
	      else {
	         System.out.println(" �ٽ� �Է� ���ּ���!!");
	      }


	      sc.close();

	   }

	public void printGame03(String helloworld) {
		// TODO Auto-generated method stub
		
	}
	}

