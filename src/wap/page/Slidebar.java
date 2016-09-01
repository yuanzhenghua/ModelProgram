package wap.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.TestCase;
import web.ColorTool;
import web.NumberTool;
import web.UnitConversionTool;
import wap.constant.Url;

public class Slidebar {
	
	public void checkCSS(WebDriver driver) throws Exception {
		float devicePixelRatio = Float.parseFloat(String.valueOf(((JavascriptExecutor) driver).executeScript("return window.devicePixelRatio")));
		float sWidth = Float.parseFloat(String.valueOf(((JavascriptExecutor) driver).executeScript("return screen.width")));	
		
		WebElement slidebar_wrap = driver.findElement(By.className("slidebar_wrap"));
		TestCase.assertEquals(slidebar_wrap.getCssValue("width"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "5rem"));
		TestCase.assertEquals(slidebar_wrap.getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "17.786667rem"));
		TestCase.assertEquals(slidebar_wrap.getCssValue("background-color"), ColorTool.ToRgba("#2f2f31", ""));
		TestCase.assertEquals(slidebar_wrap.getCssValue("z-index"), "10");
		TestCase.assertEquals(slidebar_wrap.getCssValue("color"), ColorTool.ToRgba("#ffffff", ""));
		TestCase.assertEquals(slidebar_wrap.getCssValue("position"), "fixed");
		TestCase.assertEquals(slidebar_wrap.getCssValue("left"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "-5rem"));
		TestCase.assertEquals(slidebar_wrap.getCssValue("top"), "0px");
		
		WebElement logo_wrap = slidebar_wrap.findElement(By.className("logo_wrap"));
		TestCase.assertEquals(logo_wrap.getCssValue("width"), slidebar_wrap.getCssValue("width"));
		TestCase.assertEquals(logo_wrap.getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "2.28rem"));
		
		WebElement logo = logo_wrap.findElement(By.className("logo"));
		TestCase.assertEquals(logo.getCssValue("position"), "relative");
//		TestCase.assertEquals(logo.getCssValue("left"), NumberTool.Division(logo.getCssValue("height"), 2));
//		TestCase.assertEquals(logo.getCssValue("top"), NumberTool.Division(logo.getSize().getHeight(), 2));
		TestCase.assertEquals(logo.getCssValue("margin-left"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "-1.133333rem"));
		TestCase.assertEquals(logo.getCssValue("margin-top"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "-0.333333rem"));
		TestCase.assertEquals(logo.getCssValue("width"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "2.266667rem"));
		TestCase.assertEquals(logo.getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.666667rem"));
		TestCase.assertEquals(logo.getCssValue("background-color"), "rgba(255, 192, 203, 1)");
		
		WebElement nav_ul = slidebar_wrap.findElement(By.className("nav_ul"));
		TestCase.assertEquals(nav_ul.getCssValue("width"), slidebar_wrap.getCssValue("width"));
		TestCase.assertEquals(nav_ul.getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "8.0rem"));
		
		List<WebElement> hover_bar_fl = nav_ul.findElements(By.cssSelector(".hover_bar.fl"));
		TestCase.assertEquals(hover_bar_fl.size(), 5);
		TestCase.assertEquals(hover_bar_fl.get(0).getCssValue("margin-right"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.533333rem"));
		TestCase.assertEquals(hover_bar_fl.get(0).getCssValue("width"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.106667rem"));
		//TestCase.assertEquals(hover_bar_fl.get(0).getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "1.333333rem"));
		TestCase.assertTrue(UnitConversionTool.compareRem(hover_bar_fl.get(0).getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "1.333333rem")));
		TestCase.assertEquals(hover_bar_fl.get(0).getCssValue("background-color"), "rgba(255, 0, 0, 1)");
		//TestCase.assertEquals(hover_bar_fl.get(0).getCssValue("visibility"), "hidden");
		TestCase.assertEquals(hover_bar_fl.get(0).getCssValue("float"), "left");
		
		List<WebElement> nav_li = nav_ul.findElements(By.className("nav_li"));
		TestCase.assertEquals(nav_li.size(), 5);
		for (int i = 0; i < nav_li.size(); i++) {
			TestCase.assertEquals(nav_li.get(i).getCssValue("width"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "5rem"));
			TestCase.assertTrue(UnitConversionTool.compareRem(nav_li.get(i).getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "1.333333rem")));
			WebElement nav_span;
			if (nav_li.get(i).findElement(By.tagName("span")).getAttribute("class").equals("nav_span nav_span1")) {
				nav_span = nav_li.get(i).findElement(By.cssSelector(".nav_span.nav_span1"));
				TestCase.assertEquals(nav_span.getCssValue("background-image"), "url(\""+Url.URL+"/imgs/slidebar/slidebar1.jpg\")");
				TestCase.assertEquals(nav_span.getAttribute("innerHTML"), "首页");
			} else if (nav_li.get(i).findElement(By.tagName("span")).getAttribute("class").equals("nav_span nav_span2")) {
				nav_span = nav_li.get(i).findElement(By.cssSelector(".nav_span.nav_span2"));
				TestCase.assertEquals(nav_span.getCssValue("background-image"), "url(\""+Url.URL+"/imgs/slidebar/slidebar2.jpg\")");
				TestCase.assertEquals(nav_span.getAttribute("innerHTML"), "集团介绍");
			} else if (nav_li.get(i).findElement(By.tagName("span")).getAttribute("class").equals("nav_span nav_span3")) {
				nav_span = nav_li.get(i).findElement(By.cssSelector(".nav_span.nav_span3"));
				TestCase.assertEquals(nav_span.getCssValue("background-image"), "url(\""+Url.URL+"/imgs/slidebar/slidebar3.jpg\")");
				TestCase.assertEquals(nav_span.getAttribute("innerHTML"), "客户案例");
			} else if (nav_li.get(i).findElement(By.tagName("span")).getAttribute("class").equals("nav_span nav_span4")) {
				nav_span = nav_li.get(i).findElement(By.cssSelector(".nav_span.nav_span4"));
				TestCase.assertEquals(nav_span.getCssValue("background-image"), "url(\""+Url.URL+"/imgs/slidebar/slidebar4.jpg\")");
				TestCase.assertEquals(nav_span.getAttribute("innerHTML"), "商务合作");
			} else if (nav_li.get(i).findElement(By.tagName("span")).getAttribute("class").equals("nav_span nav_span5")) {
				nav_span = nav_li.get(i).findElement(By.cssSelector(".nav_span.nav_span5"));
				TestCase.assertEquals(nav_span.getCssValue("background-image"), "url(\""+Url.URL+"/imgs/slidebar/slidebar5.jpg\")");
				TestCase.assertEquals(nav_span.getAttribute("innerHTML"), "最新动态");
			} else {
				throw new Exception("属性未定义："+nav_li.get(i).findElement(By.tagName("span")).getAttribute("class"));
			}
			TestCase.assertEquals(nav_span.getCssValue("width"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "4.266667rem"));
			TestCase.assertEquals(nav_span.getCssValue("text-indent"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "0.933333rem"));
			TestCase.assertEquals(nav_span.getCssValue("display"), "inline-block");
			TestCase.assertTrue(UnitConversionTool.compareRem(nav_span.getCssValue("height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "1.333333rem")));;
			TestCase.assertEquals(nav_span.getCssValue("line-height"), UnitConversionTool.rem2px(devicePixelRatio, sWidth, "1.333333rem"));
		}
	}
}
