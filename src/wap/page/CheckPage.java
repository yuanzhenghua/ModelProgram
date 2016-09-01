package wap.page;

import org.openqa.selenium.WebDriver;

public abstract class CheckPage {
	
	
	/**
	 * 需要测试所有内容
	 * @param driver
	 * @throws Exception 
	 */
	public void checkAll(WebDriver driver) throws Exception {
		new Slidebar().checkCSS(driver);
		new Footer().checkCSS(driver);
		this.checkCSS(driver);
	}	

	/**
	 * 检测页面中所有静态信息，包括图片、地址、文字、提示等内容
	 * @param driver
	 * @throws Exception 
	 */
	public abstract void checkCSS(WebDriver driver) throws Exception;

	
}
