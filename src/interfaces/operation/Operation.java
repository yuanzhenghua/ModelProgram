package interfaces.operation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import net.CounterThread;
import net.HttpRequest;
import file.RequestLogData;

public class Operation {
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private RequestLogData detailed = new RequestLogData();
	private Date startTime;
	private Date endTime;
	
	public void postUrl(String url, Map<String, String> param,  Map<String, String> pic, Map<String, String> head, CounterThread counterThread) throws Exception {
		this.startTime = new Date();
		Map<String, String> requestLogData = HttpRequest.sendPost("multipart/form-data", url, param, pic, head);
		//System.out.println(requestLogData);
		this.endTime = new Date();
		this.addRequestLogData(url, requestLogData);
		counterThread.requestLogData.add(detailed);
	}
	
	private void addRequestLogData(String url, Map<String, String> requestLogData){
//		System.out.println("id="+Long.parseLong(requestLogData.get("id")));
//		System.out.println("url="+url);
//		System.out.println("result="+(Integer.parseInt(requestLogData.get("code"))==200?true:false));
//		System.out.println("code="+Integer.parseInt(requestLogData.get("code")));
//		System.out.println("startTime"+df.format(this.startTime));
//		System.out.println("startTime"+df.format(this.startTime));
//		System.out.println("endTime="+df.format(this.endTime));
//		System.out.println("endTime="+df.format(this.endTime));
//		System.out.println("eee="+(this.endTime.getTime()-this.startTime.getTime())/10000);
//		System.out.println("req="+requestLogData.get("req"));
//		System.out.println("resp="+requestLogData.get("resp"));
//		System.out.println("errorMessage="+requestLogData.get("errorMessage"));
		
		this.detailed.setId(Long.parseLong(requestLogData.get("id")));
		this.detailed.setOperation(url);
		this.detailed.setResult(Integer.parseInt(requestLogData.get("code"))==200?true:false);
		this.detailed.setResultCode(Integer.parseInt(requestLogData.get("code")));
		this.detailed.setStartTime(df.format(this.startTime));
		this.detailed.setEndTime(df.format(this.endTime));
		this.detailed.setExecutionTime((this.endTime.getTime()-this.startTime.getTime())/10000);	
		this.detailed.setReqData(requestLogData.get("req"));		
		this.detailed.setRespData(requestLogData.get("resp"));		
		this.detailed.setErrorMessage(requestLogData.get("errorMessage"));
	}
}
