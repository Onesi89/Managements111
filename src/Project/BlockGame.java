package Project;

import java.util.Scanner;

public class BlockGame{
	public void showinfo(){
		//메뉴창
		//안보고 혼자 홀짝을 만들어본다는 생각으로 해봄!
		//추가로 1 2 3 외에 다른걸 적을경우엔 다시 적으라는 신호를 줌!
		Scanner sc=new Scanner(System.in);
		String[] msg={"","홀","짝"};
		int nawin = 0;
		int comwin = 0;

		for(;;){
			System.out.println("홀짝 게임을 실행합니다! 3번키 누를시 종료 입력하세요");
			
			int comnum= (int)(Math.random()*10)+1;//둘중하나의 범위를 정하고 0부터 시작하기때문에 +1설정
			
			int i=Integer.parseInt(sc.nextLine());
			if (i==1){
				if(i==comnum){
					System.out.println("컴 : "+comnum);
					System.out.println("나 : "+i);
					System.out.println("승리!");
					nawin+=1;
				}
				else{
					System.out.println("컴 : "+comnum);
					System.out.println("나 : "+i);
					System.out.println("패배!");
					comwin+=1;
				}
			}

			else if(i==2) {

				if(i==comnum){
					System.out.println("컴퓨터 : "+comnum);
					System.out.println("사용자 : "+i);
					System.out.println("승리!");
					nawin+=1;
				}
				else{
					System.out.println("컴퓨터: "+comnum);
					System.out.println("사용자 : "+i);
					System.out.println("패배!");
					comwin+=1;
				}
			}else if(i==3){
				System.out.println("사용자"+nawin+"승");
				break;
			}
			else {System.out.println("다시입력하세요");}
		}


	}
}


