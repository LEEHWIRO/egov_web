package aaa.lib.util;

import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConverterUtil {
	
	private static Log logger = LogFactory.getLog(ConverterUtil.class);

    private ConverterUtil() {
    }
    
    public static String getServerPath2()
    {
    	String serverPath = "https://domain.com";
    	return serverPath;
    }
    
    public static String getServerPath(HttpServletRequest request)
    {
    	String serverPath ="https://domain.com";
    	return serverPath;
    }

    
    public static Class<?> loadClass(String className) throws ClassNotFoundException, Exception {

        Class<?> clazz = null;
        try {
            clazz =
                Thread.currentThread().getContextClassLoader().loadClass(
                    className);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        } catch (Exception e) {
            throw new Exception(e);
        }

        if (clazz == null) {
            clazz = Class.forName(className);
        }

        return clazz;

    }

    public static Object instantiate(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        Class<?> clazz;

        try {
            clazz = loadClass(className);
            return clazz.newInstance();
        } catch (ClassNotFoundException e) {
            if (logger.isErrorEnabled())
                logger.error(className + " : Class is can not instantialized.");
            throw new ClassNotFoundException();
        } catch (InstantiationException e) {
            if (logger.isErrorEnabled())
                logger.error(className + " : Class is can not instantialized.");
            throw new InstantiationException();
        } catch (IllegalAccessException e) {
            if (logger.isErrorEnabled())
                logger.error(className + " : Class is not accessed.");
            throw new IllegalAccessException();
        } catch (Exception e) {
            if (logger.isErrorEnabled())
                logger.error(className + " : Class is not accessed.");
            throw new Exception(e);
        }
    }

    public static Object instantiate(String className, String[] types, Object[] values) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        Class<?> clazz;
        Class<?>[] classParams = new Class[values.length];
        Object[] objectParams = new Object[values.length];

        try {
            clazz = loadClass(className);

            for (int i = 0; i < values.length; i++) {
                classParams[i] = loadClass(types[i]);
                objectParams[i] = values[i];
            }

            Constructor<?> constructor = clazz.getConstructor(classParams);
            return constructor.newInstance(values);

        } catch (ClassNotFoundException e) {
            if (logger.isErrorEnabled())
                logger.error(className + " : Class is can not instantialized.");
            throw new ClassNotFoundException();
        } catch (InstantiationException e) {
            if (logger.isErrorEnabled())
                logger.error(className + " : Class is can not instantialized.");
            throw new InstantiationException();
        } catch (IllegalAccessException e) {
            if (logger.isErrorEnabled())
                logger.error(className + " : Class is not accessed.");
            throw new IllegalAccessException();
        } catch (Exception e) {
            if (logger.isErrorEnabled())
                logger.error(className + " : Class is not accessed.");
            throw new Exception(e);
        }
    }
    
    public static HashMap<String, Object> getParameterHashMap(HttpServletRequest request) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		Enumeration<?> paramNames = request.getParameterNames(); 
		while(paramNames.hasMoreElements()) { 
			String name = paramNames.nextElement().toString(); 
			String[] value = request.getParameterValues(name); 
			if(value.length == 1 ){
				param.put(name, value[0]);
			} else {
				param.put(name, value);
			}
			
			if(name.indexOf("SCH") == -1 && name.indexOf("FRM") == -1 && name.indexOf("SEL_") == -1 ) {
			    String val = "";
	            for(int i=0;i<value.length;i++){
	                val += value[i]+"^";
	            }
	            param.put("ARR_"+name , val);
			}
			
		} 
		return param;
	}
    
    public static HashMap<String, Object> getParameterHashMap(HttpServletRequest request, boolean isEstimate) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		Enumeration<?> paramNames = request.getParameterNames(); 
		
		while(paramNames.hasMoreElements()) { 
			String name = paramNames.nextElement().toString(); 
			String[] value = request.getParameterValues(name); 
			if(value.length == 1 ){
				logger.debug(name + " : " + value[0]);
				param.put(name, value[0]);
			} else {
				param.put(name, value);
				logger.debug(name + " : " + "ARRAY["+value.length +"]");
			}
			
			if(name.indexOf("SCH") == -1 && name.indexOf("FRM") == -1 && name.indexOf("SEL_") == -1 ) {
			    String val = "";
	            for(int i=0;i<value.length;i++){
	            	if(value[i].equals("")){
	            		val += "0^";
	            	}else{
	            		val += value[i]+"^";
	            	}
	            }
	            param.put("ARR_"+name , val);
	            logger.debug("ARR_"+name + " : " + val);
			}
			
		} 
		
		param.put("result"     , null);
		param.put("returnCode" , null);
		param.put("returnMsg"  , null);
        
		return param;
	}

    public static String getParameterString(HttpServletRequest request) {
        StringBuffer sbf = new StringBuffer();
        Enumeration<?> paramNames = request.getParameterNames(); 
        
        while(paramNames.hasMoreElements()) { 
            String name = paramNames.nextElement().toString(); 
            String[] value = request.getParameterValues(name); 
            
            if(value.length == 1 ){
                sbf.append(name + "=\"" + value[0] +"\" ," );
            } else {

                sbf.append(name+"=\"{");
                for(int i=0;i<value.length;i++){
                    sbf.append(value[i]);
                    if(i< value.length-1) {
                        sbf.append(",");
                    }
                    if( sbf.length() > 2000) {
                        break;
                    }
                }
                sbf.append("}\" ,");
            }
            
            if( sbf.length() > 2000) {
                break;
            }
        } 
        
        logger.debug("sbf.toString()=" + sbf.toString());
        return sbf.toString();
    }
}
