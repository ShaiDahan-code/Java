import java.util.Scanner;

public abstract class AllDate implements IDate {

	private short day;
	private short month;
	private short year;

	
	public AllDate(int day, int month , int year) {
			setDay((short)day);
			setMonth((short)month);
			setYear((short)year);
	}
	public AllDate(AllDate date) {
		setDay(date.getDay());
		setMonth(date.getMonth());
		setYear(date.getYear());
	}
	public AllDate(String date) throws InputDateException {
		Scanner paramsScan = new Scanner(date);
		try {
			paramsScan.useDelimiter("/");
			setDay(paramsScan.nextShort());
			setMonth(paramsScan.nextShort());
			setYear(paramsScan.nextShort());
		} catch (Exception e) {
			throw new InputDateException("Exception in scanning the date string");
		} finally {
			paramsScan.close();
		}
	}
	@Override
	public void setDay(short day) {
		if(day<1 || day>31)
			throw new IllegalArgumentException("Day argument " + day + " is illegal.");
		this.day = day;	
	}
	@Override
	public void setMonth(short month) {
		if(month<1 || month>13)
			throw new IllegalArgumentException("Month argument " + month + " is illegal.");
		this.month = month;
	}
	@Override
	public void setYear(short year) {
		if(year<0)
			throw new IllegalArgumentException("Year argument " + year + " is illegal.");
		this.year = year;
		
	}
	@Override
	public short getDay() {
		return this.day;
	}
	@Override
	public short getMonth() {
		return this.month;
	}
	@Override
	public short getYear() {
		return this.year;
	}
}
