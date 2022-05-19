package Movie;

public class Movie {
	public String movieName; //영화제목
	public int visitorNumber; //총 관람객 수
	public String actors; // 배우들 모임
	public String plot; //줄거리
	public int screenNumber; //상영관 숫자
	public long sales; //매출
	
	 //영화 리스트 호출시 생성자
	Movie(){};
	
	
	//영화 정보 입력할 때 생성자
	Movie(String movieName,int screenNumber){
		this.movieName = movieName;
		this.screenNumber = screenNumber;		
		this.visitorNumber = 0;
		this.sales = 0;
	}
	
	
	public void totalVisitorNumber(int number) {
		this.visitorNumber += number;
	}
	
	public void totalSales(int number) {
		this.sales += number;
	}
	
	public void setActor(String actors) {
		this.actors = actors;
	}
	
	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	public void movieInfo() {
		System.out.println("영화 제목 : " + movieName + "\n"+ 
						   "     관람객 수: " + visitorNumber +"\n"+
						   "     영화 배우: " + actors + "\n"+
						   "     줄거리 : " + plot +"\n"+
						   "     상영관 : " + screenNumber);
	}
	

}
