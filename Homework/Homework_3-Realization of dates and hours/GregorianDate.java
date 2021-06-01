import java.util.Scanner;

public class GregorianDate extends AllDate{
	private static String [] greMonth = {"Jan." ,"Feb.", "Mar.", "Apr." ,"May.", "Jun.", "Jul.", "Aug.", "Sep." ,"Oct.", "Nov." ,"Dec."};
	
	
	public GregorianDate(int day, int month , int year) {
		super(day,month,year);
	}
	public GregorianDate(GregorianDate date) {
		super(date);
	}
	public GregorianDate(String date) throws InputDateException {
		super(date);
	}
	@Override
	public boolean equals(IDate t) {
		if(t == null)
			return false;
		if(this.numberOfDaysFromFirstDayGregorian()== t.numberOfDaysFromFirstDayGregorian())
			return true;
		return false;
	}
	@Override
	public boolean before(IDate t) {
		if(t == null)
			return false;
		if(this.numberOfDaysFromFirstDayGregorian()< t.numberOfDaysFromFirstDayGregorian())
			return true;
		return false;
	}
	@Override
	public boolean after(IDate t) {
		if(t == null)
			return false;
		if(this.numberOfDaysFromFirstDayGregorian()> t.numberOfDaysFromFirstDayGregorian())
			return true;
		return false;
	}
	@Override
	public int numberOfDaysFromFirstDayGregorian() {
		return DateUtils.absoluteFromGregorianDate(this);
	}
	@Override
	public DateUtils.DateType getDateCalendar() {
		return DateUtils.DateType.GREGORIAN ;
	}
	
	@Override
	public String toString() {
		
		return String.format("Gregorian date %02d %s %02d",this.getDay(),greMonth[this.getMonth()-1],this.getYear()); 
	}
	
	
}
