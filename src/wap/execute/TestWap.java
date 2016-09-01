package wap.execute;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.TestCase;

public class TestWap extends TestCase {
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","SKGAINLRFEUGLNS4");//XX可以是手机的型号
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platformVersion", "5.0");
        capabilities.setCapability("platformName", "Android");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}
	
	
	@After
	public void tearDown() throws Exception {		
		if(driver != null){
			driver.close();
			driver.quit();
		}
	}
	
	//页面基本显示测试
	@Test
	public void testHomePage() throws Exception {
//		driver.get(Url.HOME_PAGE);
//		new Thread().sleep(1000);
//		new HomePage().checkAll(driver);
	}
	
}
