package web.performance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.HttpRequest;
import file.RequestLogData;
import interfaces.constant.RequestHeader;

public class Login {
	public RequestLogData open(List<String> resUrl, RequestLogData xlsData) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		xlsData.setOperation(resUrl.get(0));
		try {
			String content;
			Date startTime = new Date();		
			for (String url : resUrl) {
				HttpRequest.sendGet(url, "", RequestHeader.head);
			}
			this.login();
			Date endTime = new Date();
			xlsData.setStartTime(df.format(startTime));
			xlsData.setEndTime(df.format(endTime));
			xlsData.setExecutionTime((float)(endTime.getTime()-startTime.getTime())/1000);
			xlsData.setResult(true);
		} catch (Exception e) {
			xlsData.setResult(false);
			xlsData.setErrorMessage(e.getMessage());
			e.printStackTrace();
		} finally {
			return xlsData;
		}
	}
	
	private void login(){
		
	}
}
