import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;

public class main {

	public static void main(String[] args) throws InputTimeException {
		IDate gd1;
		IDate jd1;
		Time t1;
		Time t2;
		
		DateTime dt1;
		DateTime dt2;
			gd1 = new GregorianDate(01, 10, 2020);
			jd1 = new JewishDate(02, 11, 2021);
			t1 = new Time("10:00:00");
			t2 = new Time("02:10:30");
		
			dt1 = new DateTime(gd1, t1);
			dt2 = new DateTime(jd1, t2);
			dt1.setDate(jd1);
			dt1.setTime(t2);
			DateTime dt3=new DateTime(dt1.getDate(), dt1.getTime()); //equals to dt1.
			DateTime dt4=new DateTime(dt1.getDate(), new Time("9:00:00"));	//equals to dt1 gregorian date, but before in time.
			DateTime dt5=new DateTime(new GregorianDate(01, 9, 2020), dt1.getTime());// equals in time to dt1, but date before dt1
//			assertTrue(dt4.before(dt1));
//			assertTrue(dt5.before(dt1));
//			assertTrue(dt1.after(dt4));
//			assertTrue(dt1.after(dt5));
		System.out.println(dt5.getDate().numberOfDaysFromFirstDayGregorian() + "\n"+ dt1.getDate().numberOfDaysFromFirstDayGregorian());
	}

}
