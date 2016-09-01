package web.execute;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import junit.framework.TestCase;
import web.constant.Url;
public class TestWeb extends TestCase {
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		//chrome浏览器
//		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
//		driver = new ChromeDriver();
		//IE浏览器
//		System.setProperty("webdriver.ie.driver", "C:/Program Files (x86)/Internet Explorer/IEDriverServer.64.exe");
//		driver = new InternetExplorerDriver();
		//firefox浏览器  没有找到webdriver
//		System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	
	@After
	public void tearDown() throws Exception {		
		if(driver != null){
			driver.close();
			driver.quit();
		}
	}
	
	/**
	 * 需要测试页面的逻辑实现
	 * @throws Exception
	 */
	@Test
	public void testWeb1() throws Exception{
//		driver.get(Url.HOME_PAGE);
//		new HomePage().checkAll(driver);
	}

}
