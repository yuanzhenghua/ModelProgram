package wap.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.TestCase;
import web.ColorTool;
import web.NumberTool;
import web.UnitConversionTool;
import wap.constant.Url;

public class Footer {
	public void checkCSS(WebDriver driver) {
		float devicePixelRatio = Float.parseFloat(String.valueOf(((JavascriptExecutor) driver).executeScript("return window.devicePixelRatio")));
		float sWidth = Float.parseFloat(String.valueOf(((JavascriptExecutor) driver).executeScript("return screen.width")));
		
		WebElement footer_blank = driver.findElement(By.className("footer_blank"));
		TestCase.assertEquals(footer_blank.getCssValue("width"), driver.findElement(By.className("body_wrap")).getSize().getWidth()+"px");
		TestCase.assertEquals(footer_blank.getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "1.24rem"));
		
		WebElement footer_nav_wrap = driver.findElement(By.className("footer_nav_wrap"));
		TestCase.assertEquals(footer_nav_wrap.getCssValue("position"), "fixed");
		TestCase.assertEquals(footer_nav_wrap.getCssValue("bottom"), "0px");
		TestCase.assertEquals(footer_nav_wrap.getCssValue("width"), driver.findElement(By.className("body_wrap")).getSize().getWidth()+"px");
		TestCase.assertEquals(footer_nav_wrap.getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "1.24rem"));
		TestCase.assertEquals(footer_nav_wrap.getCssValue("background-color"), ColorTool.ToRgba("#e81518", ""));
		TestCase.assertEquals(footer_nav_wrap.getCssValue("z-index"), "10");
		
		WebElement block_wrap = footer_nav_wrap.findElement(By.className("block_wrap"));
		TestCase.assertEquals(block_wrap.getCssValue("position"), "relative");
		TestCase.assertEquals(block_wrap.getCssValue("left"), NumberTool.Division(footer_nav_wrap.getSize().getWidth(), 2)+"px");
		TestCase.assertEquals(block_wrap.getCssValue("width"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "7.733333rem"));
		TestCase.assertTrue(UnitConversionTool.comparePx(block_wrap.getCssValue("height"), footer_nav_wrap.getSize().getHeight()+"px"));
		TestCase.assertEquals(block_wrap.getCssValue("margin-left"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "-3.866667rem"));
		
		WebElement footer_nav_btn_wrap = block_wrap.findElement(By.className("footer_nav_btn_wrap"));
		TestCase.assertEquals(footer_nav_btn_wrap.getCssValue("margin"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.28rem")+" 0px 0px "+UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.28rem"));
		TestCase.assertTrue(UnitConversionTool.comparePx(footer_nav_btn_wrap.getCssValue("width"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.66rem")));;
		TestCase.assertTrue(UnitConversionTool.comparePx(footer_nav_btn_wrap.getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "1.053333rem")));
		
		WebElement footer_nav_btn = footer_nav_btn_wrap.findElement(By.className("footer_nav_btn"));
		TestCase.assertTrue(UnitConversionTool.comparePx(footer_nav_btn.getCssValue("width"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.66rem")));
		TestCase.assertEquals(footer_nav_btn.getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.546667rem"));
		TestCase.assertEquals(footer_nav_btn.getCssValue("background-image"), "url(\""+Url.URL+"/imgs/home/nav_btn.png\")");
		TestCase.assertEquals(footer_nav_btn.getCssValue("background-size"), "contain");
		TestCase.assertTrue(UnitConversionTool.comparePx(footer_nav_btn.getCssValue("margin-bottom"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.06rem")));
		
		WebElement footer_nav_desc = footer_nav_btn_wrap.findElement(By.className("footer_nav_desc"));
		TestCase.assertEquals(footer_nav_desc.getCssValue("font-size"), "18px");
		TestCase.assertEquals(footer_nav_desc.getCssValue("text-align"), "center");
		TestCase.assertEquals(footer_nav_desc.getText(), "导航");
		
		WebElement call_db_f1 = block_wrap.findElement(By.cssSelector(".call.db.fl"));
		TestCase.assertEquals(call_db_f1.getCssValue("width"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "5.84rem"));
		TestCase.assertEquals(call_db_f1.getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "1.066667rem"));
		TestCase.assertEquals(call_db_f1.getCssValue("margin-left"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.6rem"));
		TestCase.assertEquals(call_db_f1.getCssValue("display"), "block");
		TestCase.assertEquals(call_db_f1.getCssValue("float"), "left");
		TestCase.assertEquals(call_db_f1.getAttribute("href"), "tel:18700000000");
		
		WebElement consult = call_db_f1.findElement(By.className("consult"));
		TestCase.assertEquals(consult.getCssValue("margin-top"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.133333rem"));
		TestCase.assertEquals(consult.getCssValue("width"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "5.84rem"));
		TestCase.assertEquals(consult.getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "1.066667rem"));
		TestCase.assertEquals(consult.getCssValue("background-color"), ColorTool.ToRgba("#ffffff", ""));
		TestCase.assertEquals(consult.getCssValue("border-radius"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.12rem"));
		TestCase.assertEquals(consult.getCssValue("color"), ColorTool.ToRgba("#e81518", ""));
		TestCase.assertEquals(consult.getCssValue("font-size"), "30px");
		TestCase.assertEquals(consult.getAttribute("value"), "免费咨询");
	}
}
