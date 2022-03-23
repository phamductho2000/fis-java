package fis.training.DemoLog4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogToFile {

//	private static final Log log = LogFactory.getLog(LogToFile.class);
	private static final Logger log = LogManager.getLogger(LogToFile.class);

	public static void main(String[] args) {
		log.debug("Example debug message ..");
		log.info("Example info message ..");
		log.warn("Example warn message ..");
		log.error("Example error message ..");
		log.fatal("Example fatal message ..");

//		try {
//			raiseException();
//		} catch (Exception e) {
//			log.fatal("<Some Object>", e);
//		}
	}

	private static void raiseException() throws Exception {
		throw new Exception("Test Exception");
	}

}
