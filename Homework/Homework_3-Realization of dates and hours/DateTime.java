

public class DateTime {

	private IDate date;
	private Time time;

	public DateTime(short day, short month, short year, DateUtils.DateType cal, short hour, short min, short sec) {
		if (DateUtils.DateType.GREGORIAN == cal) {
			date = new GregorianDate(day,month,year);
			time = new Time(hour,min,sec);
		}
		else if (DateUtils.DateType.JEWISH == cal) {
			date = new JewishDate(day,month,year);
			time = new Time(hour,min,sec);
		}
		
	}

	public DateTime(IDate date, Time time) {
		if (DateUtils.DateType.GREGORIAN == date.getDateCalendar()) {
			this.date = new GregorianDate(date.getDay(),date.getMonth(),date.getYear());
			this.time = new Time(time.getHour(),time.getMinute(),time.getSecond());
		}
		else if (DateUtils.DateType.JEWISH == date.getDateCalendar()) {
			this.date = new JewishDate(date.getDay(),date.getMonth(),date.getYear());
			this.time = new Time(time.getHour(),time.getMinute(),time.getSecond());
		}
	}

	public void setDay(short day) {
		this.date.setDay(day);
	}

	public void setMonth(short month) {
		this.date.setMonth(month);

	}

	public void setYear(short year) {
		this.date.setYear(year);
	}

	public short getDay() {
		return this.date.getDay();
	}

	public short getMonth() {
		return this.date.getMonth();
	}

	public short getYear() {
		return this.date.getYear();
	}

	public void setHour(short hour) {
		this.time.setHour(hour);
	}

	public void setMinute(short min) {
		this.time.setMinute(min);
	}

	public void setSecond(short sec) {
		this.time.setSecond(sec);
	}

	public short getHour() {
		return this.time.getHour();
	}

	public short getMinute() {
		return this.time.getMinute();
	}

	public short getSecond() {
		return this.time.getSecond();
	}

	public DateUtils.DateType getDateCalendar() {
		return this.date.getDateCalendar();
	}

	public void setDate(IDate date) {
		if(date.getDateCalendar() == DateUtils.DateType.GREGORIAN)
			this.date = new GregorianDate(date.getDay(),date.getMonth(),date.getYear());
		else
			this.date =new JewishDate(date.getDay(),date.getMonth(),date.getYear());
	}

	public void setTime(Time time) {
		this.setHour(time.getHour());
		this.setMinute(time.getMinute());
		this.setSecond(time.getSecond());
	}

	public IDate getDate() {
		if(this.date.getDateCalendar() == DateUtils.DateType.GREGORIAN)
			return new GregorianDate(this.getDay(),this.getMonth(),this.getYear());
		else
			return new JewishDate(this.getDay(),this.getMonth(),this.getYear());
	}

	public Time getTime() {
		return new Time(this.getHour(),this.getMinute(),this.getSecond());
	}

	public boolean equals(DateTime dateTimeOther) {
		if(this.date.equals(dateTimeOther.date)) {
			if(this.time.equals(dateTimeOther.time))
			{
				return true;
			}
		}	
		return false;
	}

	public boolean before(DateTime dateTimeOther) {
		if(this.date.before(dateTimeOther.date)) {
			return true;
		}
		else if(this.date.equals(dateTimeOther.date))
			if(this.time.before(dateTimeOther.time))
				return true;
		return false;	
	}

	public boolean after(DateTime dateTimeOther) {
		if(this.date.after(dateTimeOther.date)) {
			return true;
		}
		else if(this.date.equals(dateTimeOther.date))
			if(this.time.after(dateTimeOther.time))
				return true;
		return false;	
	}

	@Override
	public String toString() {
		return this.date.toString()+", "+this.time.toString();
	} 

}