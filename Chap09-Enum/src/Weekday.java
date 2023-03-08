/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * Weekday 열거형
 */
public enum Weekday{
	SUN, MON, TUE, WED, THU, FRI, 
	SAT{
		@Override public Weekday nextDay() {
			return SUN;
		}
	};
	public static String[] koName = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
	@Override
	public String toString(){
		return koName[this.ordinal()];
	}
	public Weekday nextDay() {
		return Weekday.values()[this.ordinal()+1];
	}
	public Weekday prevDay() {
		return Weekday.values()[(this.ordinal()+6)%7];
	}
	public Weekday nextDays(int n){
		int w = (ordinal()+n)%7;
		return Weekday.values()[w];
	}
	public Weekday prevDays(int n){
		n = n%7;
		n = 7-(n%7);
		int w = (ordinal()+n)%7;
		return Weekday.values()[w];
	}
	public static Weekday valueOf(int ordinal){
		Weekday[] weekdays = Weekday.values();
		assert(ordinal>=0&&ordinal<weekdays.length);
		return weekdays[ordinal];
	}
}

/*
public enum Weekday {
	SUN{
		@Override
		public String toString(){ return "일요일"; } 
	}, 
	MON{
		@Override
		public String toString(){ return "일요일"; } 
	}, 
	TUE{
		@Override
		public String toString(){ return "화요일"; } 
	}, 
	WED{
		@Override
		public String toString(){ return "수요일"; } 
	}, 
	THU{
		@Override
		public String toString(){ return "목요일"; } 
	}, 
	FRI{
		@Override
		public String toString(){ return "금요일"; } 
	},
	SAT{
		@Override
		public String toString(){ return "토요일"; } 
	};
	public Weekday nextDays(int n){
		int w = (ordinal()+n)%7;
		return Weekday.values()[w];
	}
	public Weekday prevDays(int n){
		n = n%7;
		n = 7-(n%7);
		int w = (ordinal()+n)%7;
		return Weekday.values()[w];
	}
	public static Weekday valueOf(int ordinal){
		Weekday[] weekdays = Weekday.values();
		assert(ordinal>=0&&ordinal<weekdays.length);
		return weekdays[ordinal];
	}
}
*/
/*
public enum Weekday {
	SUN("일요일"), MON("월요일"), TUE("화요일"), WED("수요일"), THU("목요일"), FRI("금요일"), SAT("토요일");
	private String koName;
	private Weekday(String koName){ this.koName = koName; }
	@Override
	public String toString(){
		return koName;
	}
	public Weekday nextDays(int n){
		int w = (ordinal()+n)%7;
		return Weekday.values()[w];
	}
	public Weekday prevDays(int n){
		n = n%7;
		n = 7-(n%7);
		int w = (ordinal()+n)%7;
		return Weekday.values()[w];
	}
	public static Weekday valueOf(int ordinal){
		Weekday[] weekdays = Weekday.values();
		assert(ordinal>=0&&ordinal<weekdays.length);
		return weekdays[ordinal];
	}
}
*/