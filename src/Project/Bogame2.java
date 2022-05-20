package Project;

	import java.io.IOException;
	import java.util.Scanner;
	public class Bogame2 {
	public static void showMenu(){
	
	//메뉴창
			Scanner sc =new Scanner(System.in);
	      
	        System.out.println("=========================");
	        System.out.println(" 1.가위 2.바위 3.보 9.게임종료");
	        System.out.println("메뉴 숫자를 입력하세요");
	       
	      
	      
	       }//end showMenu()
	   
	    public static String convertText(int num){
	        String r = "";
	        if(num==1) r="가위";
	        else if(num==2) r="바위";
	        else if(num==3) r="보";
	        else r="!!";   
	        return r;  
	    }
	   
	    public static void game()  {
	       
	        String str="";//빈문자열, Null String
	        Scanner scn = new Scanner(System.in);      
	        while(true){               
	           
	           // showMenu();//메뉴 출력메소드 호출
	           
	            //int mNum = System.in.read()-48;
	            int mNum = scn.nextInt();
	            int cNum = (int)(Math.random()*3)+1; //1~3난수 발생
	            if (mNum==9) break; //게임 종료
	           
	            System.out.println("사용자->"+mNum +":"+convertText(mNum));
	            System.out.println("컴퓨터->"+cNum +":"+ (cNum==1?"가위":cNum==2?"바위":"보"));
	           
	            //1. 비길경우 mNum==cNum
	            //2. 내가 이길경우
	            //3. 컴퓨터가 이길경우         
	            if(mNum==cNum){            
	                System.out.println("무승부");           
	            }else if( ((mNum==1)&&(cNum==3)) || ((mNum==2)&&(cNum==1)) || ((mNum==3)&&(cNum==2)) ) {
	                System.out.println("승리!");
	               
	            }else System.out.println("패배!");
	                   
	        }//while
	       
	        System.out.println("The End");     
	       
	    }

		
	}	

