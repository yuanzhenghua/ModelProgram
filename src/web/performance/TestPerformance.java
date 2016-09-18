package web.performance;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import net.HtmlResources;
import net.HttpRequest;
import file.WriteFile;
import file.TotalData;
import file.RequestLogData;
import interfaces.constant.RequestHeader;
import interfaces.constant.Url;

public class TestPerformance extends TestCase {
	private static TotalData totalData = new TotalData(0, 0, 0, 0, 0, 999999);
	
	@Before
	public void setUp() throws Exception {

	}
	
	
	@After
	public void tearDown() throws Exception {		
	
	}
	
	/**
	 * 测试操作逻辑实现
	 * @throws Exception
	 */	
	@Test
	public void test1() throws Exception {		
		WriteFile writeFile = new WriteFile();
		String filePath = null;
		try {
			filePath = writeFile.CreateFolder(System.getProperty("user.dir")+"\\result");
			List<String> resUrl = HtmlResources.getHtmlResUrl(Url.URL, Url.Login, "", RequestHeader.head);
			List<String> resUrl2 = HtmlResources.getHtmlResUrl(Url.URL, Url.Login, "", RequestHeader.head);
			RequestLogData requestLogData = new RequestLogData();
			requestLogData = new Login().open(resUrl, requestLogData);
			writeFile.WriteXls(filePath, requestLogData);
			totalData = writeFile.updataTotalData(totalData, requestLogData);
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
