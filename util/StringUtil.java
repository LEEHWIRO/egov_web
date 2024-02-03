package aaa.lib.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtil {
	
	private static Log logger = LogFactory.getLog(StringUtil.class);

    private StringUtil() {
    }
    
    
    public static String stringToUnit(String str)
    {
    	String unit ="";
    	int intstr =Integer.parseInt(str);
    	int viewstr = 0;

 
    	if(intstr> 10000)
    	{
    		viewstr = intstr/10000;
    		unit = viewstr +"만";	
    	}
    	else if(intstr> 1000)
    	{
    		viewstr = intstr/1000;
    		unit = viewstr +"천";	
    	}
    	else
    	{
    		unit = ""+intstr;
    	}
    	
    	return unit;
    }

}
