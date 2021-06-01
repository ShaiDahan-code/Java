import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;


public class DatesHandler {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file_name = args[0];
		int length = Integer.parseInt(args[1]);

		DateTime[] arr = new DateTime[length];
		List<DateTime> list = new ArrayList<DateTime>();
		SortedSet<DateTime> set = new TreeSet<DateTime>(new DateTimeComparator());
		SortedSet<DateTime> setGregorian = new TreeSet<DateTime>(new DateTimeComparator());
		SortedSet<DateTime> setJewish = new TreeSet<DateTime>(new DateTimeComparator());
		Map<DateUtils.DateType, Set<DateTime>> map = new HashMap<DateUtils.DateType, Set<DateTime>>();
		File f = new File(args[0]);
		
		try {
			Scanner s = new Scanner(f);
			int index = 0 ;
			while(s.hasNextLine()) {
				try {
				DateTime date_and_time;
				IDate date = null ;
				Time t;
				String string_line = s.nextLine();
				Scanner line = new Scanner(string_line).useDelimiter("#");
				String p = line.next();
				
				if((!"j".contains(p) && (!"g".contains(p))) || (string_line.length() >22))
					throw new WrongGorJException("Input Line Error");
				
				if((p.contains("j")&&line.hasNext())) 
						date = new JewishDate(line.next());
				if(p.contains("g")&&line.hasNext())
						date = new GregorianDate(line.next());
				
				if(date!=null && date.getDay() != 0) {
						if(line.hasNext())
							if((p = line.next()).length() !=8)
							{
								t = new Time(p);
							}
							else 
								t = new Time(p);
						else
							t = new Time("00:00:00");
						
						date_and_time = new DateTime(date,t);
						arr[index++] = date_and_time;
						list.add(date_and_time);
						set.add(date_and_time);
						if(date.getDateCalendar() == DateUtils.DateType.GREGORIAN)
							setGregorian.add(date_and_time);
						else
							setJewish.add(date_and_time);
				}
			}
			catch (WrongGorJException e) {
				System.err.println(e.getMessage());
			}
			catch(InputDateException e) {
				System.err.println(e.getMessage());
			}
			catch(InputTimeException e) {
				System.err.println(e.getMessage());
			}
		}
			map.put(DateUtils.DateType.GREGORIAN, setGregorian);
			map.put(DateUtils.DateType.JEWISH, setJewish);
			Collections.reverse(list);
			createAllFiles(arr,list,set,map);
		}
		catch(FileNotFoundException e) {
			System.err.println(e.getMessage());
		} 
	
	}
	private static void createAllFiles(DateTime[] arr,List<DateTime> list,SortedSet<DateTime> set,Map<DateUtils.DateType, Set<DateTime>> map) throws IOException {
		Writer wrArr = new FileWriter("datesOutArr2.txt");
		Writer wrList = new FileWriter("datesOutList2.txt");
		Writer wrArrSort = new FileWriter("datesSortOutArr2.txt");
		Writer wrListSort = new FileWriter("datesSortOutList2.txt");
		Writer wrSet = new FileWriter("datesSortOutSet2.txt");
		Writer wrMap = new FileWriter("datesSortOutMap2.txt");
		
		for (DateTime date : arr) {
			if (date==null) break;
			wrArr.write(date.toString());
			wrArr.write("\n");
		}

		for (DateTime date : list) {
			wrList.write(date.toString());
			wrList.write("\n");
		}

		Arrays.sort(arr,new DateTimeComparator());
		for (DateTime date : arr) {
			if (date==null) break;
			wrArrSort.write(date.toString());
			wrArrSort.write("\n");
		}

		Collections.sort(list,new DateTimeComparator());
		for (DateTime date : list) {
			wrListSort.write(date.toString());
			wrListSort.write("\n");
		}

		for (DateTime date : set) {
			wrSet.write(date.toString());
			wrSet.write("\n");
		}

		for (Set<DateTime> setDatesType : map.values()) {
			for (DateTime date : setDatesType) {
				wrMap.write(date.toString());
				wrMap.write("\n");
			}
		}
		wrMap.flush();
		wrSet.flush();
		wrListSort.flush();
		wrArrSort.flush();
		wrList.flush();
		wrArr.flush();
		wrMap.close();
		wrSet.close();
		wrListSort.close();
		wrArrSort.close();
		wrList.close();
		wrArr.close();
	}

}
