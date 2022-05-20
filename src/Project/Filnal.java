package Project;

import java.util.Scanner;


public class Filnal {

	private static Scanner scanner;

	
	public static void fi() {

		//메뉴창
		Scanner sc =new Scanner(System.in);
		
		System.out.println("=========================");
		System.out.println("게임을시작하겠습니다.");
		System.out.println("==========================");
		System.out.println( "1.가위바위보게임");
		System.out.println("2.홀짝게임");
		int c = sc.nextInt();
		
		
		switch (c) {
		
	case 1:
			//int num = sc.nextInt();
			Bogame2 bogame2 = new Bogame2();
			bogame2.showMenu();
			//bogame2.convertText(num);
			bogame2.game();
			break;
			 
			
		case 2:
			BlockGame block = new BlockGame();
			block.showinfo();
			break;
		}
	}
	
	public static void main(String[] args) {

	}
}
					
				
			
			
	
		
			



			
