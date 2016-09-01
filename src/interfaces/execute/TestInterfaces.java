package interfaces.execute;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import net.HtmlResources;
import file.WriteFile;
import file.TextData;
import file.XlsData;
import interfaces.constant.Url;
import interfaces.operation.Login;

public class TestInterfaces extends TestCase {
	private static TextData textDate = new TextData(0, 0, 0, 0, 0, 999999);
	
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
			List<String> resUrl = HtmlResources.getHtmlResUrl(Url.URL, Url.USER_LOGIN_PAGE, "");
			List<String> resUrl2 = HtmlResources.getHtmlResUrl(Url.URL, Url.USER_INFO_PAGE, "");
			XlsData xlsData = new XlsData();
			xlsData.setId(1);
			xlsData = new Login().open(resUrl, xlsData);
			writeFile.WriteXls(filePath, xlsData);
			addTextData(xlsData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (filePath != null) {
				try {
					writeFile.WriteTxt(filePath, textDate);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	private static void addTextData(file.XlsData xlsData){
		textDate.setTotal(textDate.getTotal()+1);
		if (xlsData.isResult()) {
			textDate.setSuccess(textDate.getSuccess()+1);
		}else {
			textDate.setFail(textDate.getFail()+1);
		}
		if (xlsData.getExecutionTime()>textDate.getMaxTime()) {
			textDate.setMaxTime(xlsData.getExecutionTime());
		}else if (xlsData.getExecutionTime()<textDate.getMinTime()) {
			textDate.setMinTime(xlsData.getExecutionTime());
		}
		textDate.setTotalExecutionTime(textDate.getTotalExecutionTime()+xlsData.getExecutionTime());
	}
}
