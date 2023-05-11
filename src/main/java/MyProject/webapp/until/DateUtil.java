package MyProject.webapp.until;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date formatStringToDate(String date, String type) throws ParseException {
        DateFormat df = new SimpleDateFormat(type);
        Date dateFormat = df.parse(date);
        return dateFormat;
    }

    public static String dateToString(Date date, String type) {
        DateFormat df = new SimpleDateFormat(type);
        String todayAsString = df.format(date);
        return todayAsString;
    }
}
