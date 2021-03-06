package interfaces.execute;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import file.WriteFile;
import file.TotalData;
import interfaces.constant.RequestHeader;
import interfaces.constant.Url;
import interfaces.operation.Operation;
import net.CounterThread;

public class TestInterfaces{
	private static TotalData totalData = new TotalData(0, 0, 0, 0, 0, 999999);
	private static CounterThread counterThread = new CounterThread(); //计数器线程，用于每秒保存数据用
	private Map<String, String> params = null;
	private Map<String, String> pics = null;
	
	/**
	 * 测试入口，调用对应的实现方法，实现方法在operation下
	 * @throws Exception
	 */
	public void test1() throws Exception {		
		WriteFile writeFile = new WriteFile();
		String filePath = null;
		counterThread.isRun = true;
		counterThread.start();
		params = new HashMap<>();
		params.put("username", "13486119817");
		params.put("password", "1234567");
		try {
			filePath = writeFile.CreateFolder(System.getProperty("user.dir")+"\\result");
			counterThread.setPath(filePath);
			new Operation().postUrl(Url.Login, this.params, this.pics, RequestHeader.head, counterThread);
			//requestLogData = new Login().open(resUrl, requestLogData);
//			writeFile.WriteXls(filePath, requestLogData);
//			totalData = writeFile.updataTotalData(totalData, requestLogData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (filePath != null) {
				try {
					writeFile.WriteTxt(filePath, totalData);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			counterThread.isRun = false;
		}
	}
	
//	private static void addTextData(file.RequestLogData xlsData){
//		textDate.setTotal(textDate.getTotal()+1);
//		if (xlsData.isResult()) {
//			textDate.setSuccess(textDate.getSuccess()+1);
//		}else {
//			textDate.setFail(textDate.getFail()+1);
//		}
//		if (xlsData.getExecutionTime()>textDate.getMaxTime()) {
//			textDate.setMaxTime(xlsData.getExecutionTime());
//		}else if (xlsData.getExecutionTime()<textDate.getMinTime()) {
//			textDate.setMinTime(xlsData.getExecutionTime());
//		}
//		textDate.setTotalExecutionTime(textDate.getTotalExecutionTime()+xlsData.getExecutionTime());
//	}
}
