package Movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import customer.Member;
import customer.MemberArray;

class menuItem {
   String name = "" ; 
   String price = "" ;  
   String many = "" ; 
}

public class Snack12 {
	Member member;
	List<Member> memberArray;

	public void snack(Member member1) throws IOException {
		try {
			this.member = member1;

			Scanner sc = new Scanner(System.in);

			List<menuItem> menuItemList = new ArrayList<menuItem>();

			File file = new File("data/file.txt");
			try (Reader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader);) {
				String data;
				int i = 1;
				while ((data = br.readLine()) != null) {
					System.out.print( i++ +" "+ data + "\n");
					String[] abc = data.split(","); // ,(콤마)로 구분
					String itemName = abc[0];
					String itemCost = abc[1];
					String itemCount = abc[2];
					menuItem newItem = new menuItem();
					newItem.name = itemName;
					newItem.price = itemCost;
					newItem.many = itemCount;
					menuItemList.add(newItem);

				}
				System.out.println();
			} catch (IOException e) {System.out.println("입출력 오류입니다.");}

			System.out.println("메뉴 번호를 선택해주세요>> ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println("수량을 선택해주세요>> ");
			int selectMany = Integer.parseInt(sc.nextLine());

			// 선택한 메뉴이름
			String selecMenu = menuItemList.get(num - 1).name;

			// 선택한 메뉴 총 가격
			int selecTotalPrice = (Integer.parseInt(menuItemList.get(num - 1).price)) * selectMany;

			// 재고
			String leftCount = Integer.toString((Integer.parseInt(menuItemList.get(num - 1).many)) - selectMany);

			System.out.println(member.getmName() +"은 " 
								+ selecMenu + selectMany + 
								"개 를 선택하셨습니다. 지불하실 금액은 " + selecTotalPrice + "원 입니다.");
			
		
			
		
			
			member.plusPoint((int)(selecTotalPrice*0.01));
			
			System.out.println("포인트 "+(int)(selecTotalPrice*0.01)+"적립되었습니다. "
					  +"고객님에 총 포인트는 "+member.getmPoint()+"입니다.");
			
			System.out.println("주문 완료 되었습니다. 매점에서 픽업해주세요.");
			
			MemberArray memberList = new MemberArray();
			
			memberList.edit(Integer.parseInt(this.member.getmNum()) - 1, member);

		} catch (NumberFormatException e) {
			System.out.println("입력을 잘못하셨습니다.");
		}
	}
}


