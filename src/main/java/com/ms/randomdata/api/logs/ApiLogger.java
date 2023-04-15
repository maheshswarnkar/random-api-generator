package com.ms.randomdata.api.logs;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ms.randomdata.api.utils.Constants;
import com.ms.randomdata.api.utils.UniqeNumberFromDateTime;

/*
 * Logger format : - Time || UID || WorkFlowName || StageName || Message
 */

public class ApiLogger {

	public static void printLoggerWithUUID(String uid, String workFlowName, String stageName, String message) {
		Logger logger = LogManager.getLogger(ApiLogger.class);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Constants.LOG_FILE_LINE_DELIMITER).append(LocalDateTime.now().toString())
				.append(Constants.LOG_FILE_LINE_DELIMITER).append(uid).append(Constants.LOG_FILE_LINE_DELIMITER)
				.append(workFlowName).append(Constants.LOG_FILE_LINE_DELIMITER).append(stageName)
				.append(Constants.LOG_FILE_LINE_DELIMITER).append(message);

//		System.out.println(stringBuilder.toString());

		logger.info(stringBuilder.toString());
		logger = null;
	}

	public static void printLoggerAndGenerateUUID(String workFlowName, String stageName, String message) {

		Logger logger = LogManager.getLogger(ApiLogger.class);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Constants.LOG_FILE_LINE_DELIMITER).append(LocalDateTime.now().toString())
				.append(Constants.LOG_FILE_LINE_DELIMITER)
				.append(UniqeNumberFromDateTime.generateUniqueNumberFromTime())
				.append(Constants.LOG_FILE_LINE_DELIMITER).append(workFlowName)
				.append(Constants.LOG_FILE_LINE_DELIMITER).append(stageName).append(Constants.LOG_FILE_LINE_DELIMITER)
				.append(message);

//		System.out.println(stringBuilder.toString());

		logger.info(stringBuilder.toString());
		logger = null;
	}

	public static void main(String[] args) {
		ApiLogger apiLogger = new ApiLogger();
		for (int i = 1; i < 1000; i++) {
			printLoggerWithUUID("20230413174811298674600283", "RandomAPI", "CreateMain", "Hello Mahesh with UUID " + i);
			printLoggerAndGenerateUUID("RandomAPI", "CreateMain", "Hello Mahesh and genereate UUID " + i);
		}
	}

}
