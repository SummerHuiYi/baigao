package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	private static Logger log=LogManager.getLogger(Log.class.getName());
	
	public static void startTestCase(String sTestCaseName) {
		log.info("*******************************************************************************");
		log.info("---"+sTestCaseName+"测试用例执行开始"+"---");
	}
	public static void endTestCase(String eTestCaseName) {	
		log.info("---"+eTestCaseName+"测试用例执行结束"+"---");
		log.info("******************************************************************************");
	}
	public static void info(String message) {
		log.info(message);
	}
	public static void warn(String message){
		log.warn(message);      
    }
    public static void error(String message){
    	log.error(message);     
    }
    public static void fatal(String message){
    	log.fatal(message);     
    }
    public static void debug(String message){
    	log.debug(message);     
    }
}
