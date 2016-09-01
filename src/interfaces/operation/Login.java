package interfaces.operation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.HttpRequest;
import file.XlsData;

public class Login {
	public XlsData open(List<String> resUrl, XlsData xlsData) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		xlsData.setOperation(resUrl.get(0));
		try {
			String content;
			Date startTime = new Date();		
			for (String url : resUrl) {
				HttpRequest.getHtml(url, "");
			}
			this.login();
			Date endTime = new Date();
			xlsData.setStartTime(df.format(startTime));
			xlsData.setEndTime(df.format(endTime));
			xlsData.setExecutionTime((float)(endTime.getTime()-startTime.getTime())/1000);
			xlsData.setResult(true);
		} catch (Exception e) {
			xlsData.setResult(false);
			xlsData.setExplain(e.getMessage());
			e.printStackTrace();
		} finally {
			return xlsData;
		}
	}
	
	private void login(){
		
	}
}
