package tools.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getAplicationMonth(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date d = sdf.parse(date);
		sdf.applyPattern("MMMM");
		String output = sdf.format(d);
		return output;
	}
	public static String getAplicationDay(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date d = sdf.parse(date);
		sdf.applyPattern("dd");
		String output = sdf.format(d);
		return output;
	}

}
