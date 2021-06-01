import java.util.Scanner;

public class JewishDate extends AllDate{
	private static final String [] jewMonth = {"Nisan", "Iyar", "Sivan", "Tmuz", "Av", "Elul", "Tishrei", "Heshvan", "Kislev", "Tevet", "Shvat", "Adar","Adar A","Adar B"};
	
	public JewishDate(int day,int month,int year) {
		super(day,month,year);
	}
	
	public JewishDate(JewishDate date) {
		super(date);
	}
	
	public JewishDate(String date) throws InputDateException {
		super(date);
	}
	@Override
	public boolean equals(IDate t) {
		if (t == null)
			return false;
		if(this.numberOfDaysFromFirstDayGregorian()== t.numberOfDaysFromFirstDayGregorian())
			return true;
		return false;
	}

	@Override
	public boolean before(IDate t) {
		if (t == null)
			return false;
		if(this.numberOfDaysFromFirstDayGregorian()< t.numberOfDaysFromFirstDayGregorian())
			return true;
		return false;
	} 

	@Override
	public boolean after(IDate t) {
		if (t == null)
			return false;
		if(this.numberOfDaysFromFirstDayGregorian()> t.numberOfDaysFromFirstDayGregorian())
			return true;
		return false;
	}

	@Override
	public int numberOfDaysFromFirstDayGregorian() {
		return DateUtils.absoluteFromJewishDate(this);
	}

	@Override
	public DateUtils.DateType getDateCalendar() {
		return DateUtils.DateType.JEWISH;
	}
	
	@Override
	public String toString() {	
		if(DateUtils.hebrewLeapYear(this.getYear()))
		{
			if(this.getMonth() == 12)
				return String.format("Jewish date %02d %s %02d",this.getDay(),jewMonth[this.getMonth()],this.getYear()); 
			else if(this.getMonth() == 13)
				return String.format("Jewish date %02d %s %02d",this.getDay(),jewMonth[this.getMonth()],this.getYear()); 
		}

		return String.format("Jewish date %02d %s %02d",this.getDay(),jewMonth[this.getMonth()-1],this.getYear()); 
	
	}
}