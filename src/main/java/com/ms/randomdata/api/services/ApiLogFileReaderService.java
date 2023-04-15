package com.ms.randomdata.api.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.randomdata.api.logs.ApiLogger;
import com.ms.randomdata.api.models.ApiLogs;
import com.ms.randomdata.api.repository.ApiLogsRepository;
import com.ms.randomdata.api.services.ApiLogFileReaderService;
import com.ms.randomdata.api.utils.Constants;

@Service
public class ApiLogFileReaderService {

	@Autowired
	ApiLogsRepository apiLogsRepository;

	public void readLogFile() {

		String fileName = "random-api.log";

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {

			String line;
			while ((line = reader.readLine()) != null) {
				processLine(line);
			}

		} catch (IOException e) {
			ApiLogger.printLoggerWithUUID("", "RandomApiLog", "ApiLogFileReaderService",
					"ExceptionOccurred" + e.getMessage());
		}
		System.out.println("logs are saved in DB..");
	}

	private void processLine(String line) {
		String[] strArray = line.split(Constants.LOG_FILE_LINE_DELIMITER);
		if (strArray.length >= 6) {
			processLineData(strArray[0], strArray[1], strArray[2], strArray[3], strArray[4], strArray[5]);
		} else {
//			ApiLogger.printLoggerWithUUID("", "RandomApiLog", "ApiLogFileReaderService",
//					"Line cannot be proceessed becasue some issue in line breakup -- " + line);
			System.out.println("Line cannot be proceessed becasue some issue in line breakup -- " + line);

		}

	}

	private void processLineData(String loggerInfo, String loggingTime, String uid, String workFlowName,
			String stageName, String message) {
		ApiLogs apiLogs = new ApiLogs();
		apiLogs.setLoggerInfo(loggerInfo);
		apiLogs.setLogGenerationTime(loggingTime);
		apiLogs.setWorkFlowName(workFlowName);
		apiLogs.setStageName(stageName);
		apiLogs.setUid(uid);
		apiLogs.setMessage(message);

		try {
			apiLogsRepository.save(apiLogs);
		} catch (Exception e) {
			System.out.println("Can not insert this log into db " + apiLogs);
		}

	}
	
	public List<ApiLogs> getLogs() {
		List<ApiLogs> apiLogs = apiLogsRepository.findAll();
		return apiLogs;
	}
	

	public static void main(String[] args) {
		ApiLogFileReaderService apiLogFileReaderService = new ApiLogFileReaderService();
		apiLogFileReaderService.readLogFile();
	}

	

}
