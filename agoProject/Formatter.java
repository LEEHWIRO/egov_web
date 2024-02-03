package egov.lib.util;

import java.sql.Date;
import java.util.Calendar;

public class Formatter {

	public static String currentTime()
	{
	    Calendar cal = Calendar.getInstance( );

	    String now = String.format("%04d-%02d-%02d %02d:%02d:%02d",
	                                 cal.get(Calendar.YEAR),
	                                 (cal.get(Calendar.MONTH) + 1),
	                                 cal.get(Calendar.DAY_OF_MONTH),

	                                 cal.get(Calendar.HOUR_OF_DAY),
	                                 cal.get(Calendar.MINUTE),
	                                 cal.get(Calendar.SECOND)
	                             );
	    
	    return now;
	}

	public static String today()
	{
	    Calendar cal = Calendar.getInstance( );

	    String now = String.format("%04d-%02d-%02d",
	                                 cal.get(Calendar.YEAR),
	                                 (cal.get(Calendar.MONTH) + 1),
	                                 cal.get(Calendar.DAY_OF_MONTH)
	                             );
	    
	    return now;
	}
	
	public static Date convertToDate(String year,String month,String day)
	{
        String date = year+"-"+month+"-"+day;
        Date rtnDate = Date.valueOf(date);
        return rtnDate;
	}

}
