package egov.lib.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class RequestUtil {

	private static Log logger = LogFactory.getLog(RequestUtil.class);
	
	//ip주소얻기
	public static String getClientIP(HttpServletRequest request) {
	
	     String ip = request.getHeader("X-FORWARDED-FOR"); 
	     if (ip == null || ip.length() == 0) {
	         ip = request.getHeader("Proxy-Client-IP");
	     }
	     if (ip == null || ip.length() == 0) {
	         ip = request.getHeader("WL-Proxy-Client-IP");
	     }
	     if (ip == null || ip.length() == 0) {
	         ip = request.getRemoteAddr() ;
	     }
	     
	     if(ip.length()>16)
	     {
			 logger.error("INFO======================================================================");
			 logger.error("IP16길이 초과 변환전:"+ip+", 변환후:"+ip.substring(0,16));
			 logger.error("INFO======================================================================");
	    	 ip=ip.substring(0,16);
	     }
	     
	     return ip;
	 }
}
