import java.util.Comparator;

public class DateTimeComparator implements Comparator<DateTime> {
	
	@Override
	public int compare(DateTime d1, DateTime d2) {
		if (d1 == null || d2 == null)
			return 0;
		if(d1.before(d2))
			return -1;
		else if (d1.after(d2))
			return 1;
		else 
			return 0;
	}

}
