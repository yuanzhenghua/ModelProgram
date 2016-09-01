package web.page;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Test;
import junit.framework.TestCase;
import net.HtmlResources;
import net.HttpRequest;
import web.ColorTool;
import web.constant.Url;

public abstract class CheckPage {
	/**
	 * 需要测试所有内容
	 * @param driver
	 * @throws Exception 
	 */
	public void checkAll(WebDriver driver) throws Exception {
		checkPublicHeadModule(driver);
		checkPublicTailModule(driver);
		checkFloatingWindow(driver);
		checkStaticInformation(driver);
		checkResourceLink(driver);
	}
	
	public void checkPublicHeadModule(WebDriver driver) throws Exception {
		//检测头部模块
		TestCase.assertEquals(driver.findElement(By.className("head_wrap")).getCssValue("margin"), "0px");
		TestCase.assertEquals(driver.findElement(By.className("head_wrap")).getCssValue("width"), "1423px");
		TestCase.assertEquals(driver.findElement(By.className("head_wrap")).getCssValue("height"), "100px");
		
		TestCase.assertEquals(driver.findElement(By.className("jeaf_logo")).getCssValue("float"), "left");
		TestCase.assertEquals(driver.findElement(By.className("jeaf_logo")).getCssValue("margin-top"), "29px");
		TestCase.assertEquals(driver.findElement(By.className("jeaf_logo")).getCssValue("display"), "block");
		TestCase.assertEquals(driver.findElement(By.className("jeaf_logo")).getCssValue("width"), "73px");
		TestCase.assertEquals(driver.findElement(By.className("jeaf_logo")).getCssValue("height"), "38px");
		TestCase.assertEquals(driver.findElement(By.className("jeaf_logo")).getCssValue("border-right"), "2px solid "+ColorTool.ToRgb("#e7aaac"));
		TestCase.assertEquals(driver.findElement(By.className("jeaf_logo")).getAttribute("src"), Url.URL+"/imgs/home/home_logo1.jpg");
		
		TestCase.assertEquals(driver.findElement(By.className("sub_logo_link")).getCssValue("float"), "left");
		TestCase.assertEquals(driver.findElement(By.className("sub_logo_link")).getCssValue("display"), "block");
		TestCase.assertEquals(driver.findElement(By.className("sub_logo_link")).getCssValue("margin-left"), "17px");
		TestCase.assertEquals(driver.findElement(By.className("sub_logo_link")).getCssValue("margin-top"), "25px");
		TestCase.assertEquals(driver.findElement(By.className("sub_logo_link")).getCssValue("width"), "170px");
		TestCase.assertEquals(driver.findElement(By.className("sub_logo_link")).getCssValue("height"), "50px");
		TestCase.assertEquals(driver.findElement(By.className("sub_logo_link")).getCssValue("background-color"), "rgba(204, 204, 204, 1)");
		TestCase.assertEquals(driver.findElement(By.className("sub_logo_link")).getAttribute("href"), Url.HOME_PAGE);
		
		TestCase.assertEquals(driver.findElement(By.className("sub_logo")).getCssValue("display"), "block");
		TestCase.assertEquals(driver.findElement(By.className("sub_logo")).getCssValue("width"), "170px");
		TestCase.assertEquals(driver.findElement(By.className("sub_logo")).getCssValue("height"), "50px");
		TestCase.assertEquals(driver.findElement(By.className("sub_logo")).getAttribute("src"), Url.URL+"/imgs/home/home_logo2.jpg");
		
		TestCase.assertEquals(driver.findElement(By.className("head_nav_wrap")).getCssValue("float"), "left");
		TestCase.assertEquals(driver.findElement(By.className("head_nav_wrap")).getCssValue("margin-left"), "450px");
		TestCase.assertEquals(driver.findElement(By.className("head_nav_wrap")).getCssValue("margin-top"), "35px");
		TestCase.assertEquals(driver.findElement(By.className("head_nav_wrap")).getCssValue("width"), "480px");
		TestCase.assertEquals(driver.findElement(By.className("head_nav_wrap")).getCssValue("height"), "32px");
		for (WebElement a : driver.findElement(By.className("head_nav_wrap")).findElements(By.tagName("a"))) {
			if (a.getAttribute("class").equals("index") || a.getAttribute("class").equals("index nav_hover")) {
				TestCase.assertEquals(a.getAttribute("href"), Url.HOME_PAGE);
				TestCase.assertEquals(a.getText(), "产品");
			} else if (a.getAttribute("class").equals("introduction") || a.getAttribute("class").equals("introduction nav_hover")) {
				TestCase.assertEquals(a.getAttribute("href"), Url.VIEWS_INTRODUCTION);
				TestCase.assertEquals(a.getText(), "集团介绍");
			} else if (a.getAttribute("class").equals("case")  || a.getAttribute("class").equals("case nav_hover")) {
				TestCase.assertEquals(a.getAttribute("href"), Url.VIEWS_CASE);
				TestCase.assertEquals(a.getText(), "客户案例");
			} else if (a.getAttribute("class").equals("cooperation")  || a.getAttribute("class").equals("cooperation nav_hover")) {
				TestCase.assertEquals(a.getAttribute("href"), Url.VIEWS_COOPERATION);
				TestCase.assertEquals(a.getText(), "商务合作");
			} else if (a.getAttribute("class").equals("update")  || a.getAttribute("class").equals("update nav_hover")) {
				TestCase.assertEquals(a.getAttribute("href"), Url.VIEWS_UPDATE);
				TestCase.assertEquals(a.getText(), "最新动态");
			} else {
				throw new Exception("属性错误："+a.getAttribute("class"));
			}
			TestCase.assertEquals(a.getCssValue("display"), "block");
			TestCase.assertEquals(a.getCssValue("float"), "left");
			TestCase.assertEquals(a.getCssValue("width"), "58px");
			TestCase.assertEquals(a.getCssValue("height"), driver.findElement(By.className("head_nav_wrap")).getCssValue("height"));
			TestCase.assertEquals(a.getCssValue("font-size"), "14px");
			TestCase.assertEquals(a.getCssValue("font-weight"), "bold");
			TestCase.assertEquals(a.getCssValue("margin-right"), "37px");
			TestCase.assertEquals(a.getCssValue("text-align"), "center");
			TestCase.assertEquals(a.getCssValue("line-height"), "32px");
			TestCase.assertEquals(a.getCssValue("color"), "rgba(0, 0, 0, 1)");
		}
		//检测底部模块
		TestCase.assertEquals(driver.findElement(By.className("footer_wrap")).getCssValue("width"), ((Long)((JavascriptExecutor) driver).executeScript("return document.body.clientWidth")).intValue()+"px");
		TestCase.assertEquals(driver.findElement(By.className("footer_wrap")).getCssValue("height"), "472px");
		TestCase.assertEquals(driver.findElement(By.className("footer_wrap")).getCssValue("background-color"), "rgba(247, 247, 247, 1)");
		
		TestCase.assertEquals(driver.findElement(By.className("foot")).getCssValue("margin"), "0px "+(((Long)((JavascriptExecutor) driver).executeScript("return document.body.clientWidth")).intValue()-1200)/2.0+"px");
		TestCase.assertEquals(driver.findElement(By.className("foot")).getCssValue("width"), "1200px");
		TestCase.assertEquals(driver.findElement(By.className("foot")).getCssValue("height"), driver.findElement(By.className("footer_wrap")).getCssValue("height"));		
	}
	
	public void checkPublicTailModule(WebDriver driver) throws Exception {
		//最新动态
		WebElement elenment1 = driver.findElement(By.className("footer_update")); 
		TestCase.assertEquals(elenment1.getCssValue("float"), "left");
		TestCase.assertEquals(elenment1.getCssValue("margin-left"), "30px");
		TestCase.assertEquals(elenment1.getCssValue("margin-top"), "40px");
		TestCase.assertEquals(elenment1.getCssValue("width"), "290px");
		TestCase.assertEquals(elenment1.getCssValue("height"), "190px");
		TestCase.assertEquals(elenment1.getCssValue("padding"), "5px");
		
		TestCase.assertEquals(elenment1.findElement(By.className("footer_title")).getCssValue("display"), "block");
		TestCase.assertEquals(elenment1.findElement(By.className("footer_title")).getCssValue("font-size"), "20px");
		TestCase.assertEquals(elenment1.findElement(By.className("footer_title")).getText(), "最新动态");
		
		TestCase.assertEquals(elenment1.findElement(By.className("footer_title_bar")).getCssValue("margin-top"), "7px");
		TestCase.assertEquals(elenment1.findElement(By.className("footer_title_bar")).getCssValue("display"), "block");
		TestCase.assertEquals(elenment1.findElement(By.className("footer_title_bar")).getCssValue("width"), elenment1.getCssValue("width"));
		TestCase.assertEquals(elenment1.findElement(By.className("footer_title_bar")).getCssValue("height"), "2px");
		TestCase.assertEquals(elenment1.findElement(By.className("footer_title_bar")).getCssValue("background-color"), "rgba(225, 225, 225, 1)");
		
		TestCase.assertEquals(elenment1.findElements(By.tagName("a")).size(), 5);
		for (WebElement a1 : elenment1.findElements(By.tagName("a"))) {
			TestCase.assertEquals(a1.getCssValue("display"), "block");
			TestCase.assertEquals(a1.getCssValue("line-height"), "25px");
			TestCase.assertEquals(a1.getCssValue("color"), "rgba(138, 138, 138, 1)");
			TestCase.assertNotNull(a1.getAttribute("href"));
			TestCase.assertNotNull(a1.getText());
		}
		
		//网站导航
		WebElement elenment2 = driver.findElement(By.className("footer_nav")); 
		TestCase.assertEquals(elenment2.getCssValue("float"), "left");
		TestCase.assertEquals(elenment2.getCssValue("margin-left"), "110px");
		TestCase.assertEquals(elenment2.getCssValue("margin-top"), "40px");
		TestCase.assertEquals(elenment2.getCssValue("padding"), "5px");
		TestCase.assertEquals(elenment2.getCssValue("width"), "146px");
		TestCase.assertEquals(elenment2.getCssValue("height"), "190px");
		
		TestCase.assertEquals(elenment2.findElement(By.className("footer_title")).getCssValue("display"), "block");
		TestCase.assertEquals(elenment2.findElement(By.className("footer_title")).getCssValue("font-size"), "20px");
		TestCase.assertEquals(elenment2.findElement(By.className("footer_title")).getText(), "网站导航");
		
		TestCase.assertEquals(elenment2.findElement(By.className("footer_title_bar")).getCssValue("margin-top"), "7px");
		TestCase.assertEquals(elenment2.findElement(By.className("footer_title_bar")).getCssValue("display"), "block");
		TestCase.assertEquals(elenment2.findElement(By.className("footer_title_bar")).getCssValue("width"), elenment2.getCssValue("width"));
		TestCase.assertEquals(elenment2.findElement(By.className("footer_title_bar")).getCssValue("height"), "2px");
		TestCase.assertEquals(elenment2.findElement(By.className("footer_title_bar")).getCssValue("background-color"), "rgba(225, 225, 225, 1)");
		
		TestCase.assertEquals(elenment2.findElements(By.tagName("a")).size(), 5);
		for (WebElement a2 : elenment2.findElements(By.tagName("a"))) {
			TestCase.assertEquals(a2.getCssValue("display"), "block");
			TestCase.assertEquals(a2.getCssValue("line-height"), "25px");
			TestCase.assertEquals(a2.getCssValue("color"), "rgba(138, 138, 138, 1)");
			if (a2.getText().equals("产品")) {
				TestCase.assertEquals(a2.getAttribute("href"), Url.HOME_PAGE);
			} else if (a2.getText().equals("集团介绍")) {
				TestCase.assertEquals(a2.getAttribute("href"), Url.VIEWS_INTRODUCTION);
			} else if (a2.getText().equals("客户案例")) {
				TestCase.assertEquals(a2.getAttribute("href"), Url.VIEWS_CASE);
			} else if (a2.getText().equals("招商加盟")) {
				TestCase.assertEquals(a2.getAttribute("href"), Url.VIEWS_COOPERATION);
			} else if (a2.getText().equals("最新动态")) {
				TestCase.assertEquals(a2.getAttribute("href"), Url.VIEWS_UPDATE);
			} else {
				throw new Exception("属性未定义: 底部公共模块/网站导航/"+a2.getText());
			}
		}
		
		//常用链接
		WebElement elenment3 = driver.findElement(By.className("footer_link"));
		TestCase.assertEquals(elenment3.getCssValue("float"), "left");
		TestCase.assertEquals(elenment3.getCssValue("margin-left"), "98px");
		TestCase.assertEquals(elenment3.getCssValue("margin-top"), "40px");
		TestCase.assertEquals(elenment3.getCssValue("padding"), "5px");
		TestCase.assertEquals(elenment3.getCssValue("width"), "199px");
		TestCase.assertEquals(elenment3.getCssValue("height"), "190px");
		
		TestCase.assertEquals(elenment3.findElement(By.className("footer_title")).getCssValue("display"), "block");
		TestCase.assertEquals(elenment3.findElement(By.className("footer_title")).getCssValue("font-size"), "20px");
		TestCase.assertEquals(elenment3.findElement(By.className("footer_title")).getText(), "常用链接");
		
		TestCase.assertEquals(elenment3.findElement(By.className("footer_title_bar")).getCssValue("margin-top"), "7px");
		TestCase.assertEquals(elenment3.findElement(By.className("footer_title_bar")).getCssValue("display"), "block");
		TestCase.assertEquals(elenment3.findElement(By.className("footer_title_bar")).getCssValue("width"), elenment3.getCssValue("width"));
		TestCase.assertEquals(elenment3.findElement(By.className("footer_title_bar")).getCssValue("height"), "2px");
		TestCase.assertEquals(elenment3.findElement(By.className("footer_title_bar")).getCssValue("background-color"), "rgba(225, 225, 225, 1)");
		
		TestCase.assertEquals(elenment3.findElements(By.tagName("a")).size(), 5);
		for (WebElement a3 : elenment3.findElements(By.tagName("a"))) {
			TestCase.assertEquals(a3.getCssValue("display"), "block");
			TestCase.assertEquals(a3.getCssValue("line-height"), "25px");
			TestCase.assertEquals(a3.getCssValue("color"), "rgba(138, 138, 138, 1)");
//					if (a3.getText().equals("产品")) {
//						TestCase.assertEquals(a3.getAttribute("href"), Url.HOME_PAGE);
//					} else if (a3.getText().equals("集团介绍")) {
//						TestCase.assertEquals(a3.getAttribute("href"), Url.VIEWS_INTRODUCTION);
//					} else if (a3.getText().equals("客户案例")) {
//						TestCase.assertEquals(a3.getAttribute("href"), Url.VIEWS_CASE);
//					} else if (a3.getText().equals("招商加盟")) {
//						TestCase.assertEquals(a3.getAttribute("href"), Url.VIEWS_COOPERATION);
//					} else if (a3.getText().equals("最新动态")) {
//						TestCase.assertEquals(a3.getAttribute("href"), Url.VIEWS_UPDATE);
//					} else {
//						throw new Exception("属性未定义: 底部公共模块/网站导航/"+a3.getText());
//					}
		}
		
		//微信
		TestCase.assertEquals(driver.findElement(By.className("footer_twc")).getCssValue("float"), "left");
		TestCase.assertEquals(driver.findElement(By.className("footer_twc")).getCssValue("margin-left"), "95px");
		TestCase.assertEquals(driver.findElement(By.className("footer_twc")).getCssValue("margin-top"), "80px");
		TestCase.assertEquals(driver.findElement(By.className("footer_twc")).getCssValue("width"), "94px");
		TestCase.assertEquals(driver.findElement(By.className("footer_twc")).getCssValue("height"), "126px");
		TestCase.assertEquals(driver.findElement(By.className("footer_twc")).getCssValue("text-align"), "center");
		
		TestCase.assertEquals(driver.findElement(By.className("wechart_twc")).getCssValue("border"), "0px none rgb(0, 0, 0)");
		TestCase.assertEquals(driver.findElement(By.className("footer_twc")).findElement(By.className("wechart_twc")).getAttribute("src"), Url.URL+"/imgs/home/home_twc.jpg");
		TestCase.assertEquals(driver.findElement(By.className("footer_twc")).findElement(By.tagName("span")).getText(), "微信扫一扫");
		
		//公司图标+认证图标
		TestCase.assertEquals(driver.findElement(By.className("footer_logo")).getCssValue("clear"), "both");
		TestCase.assertEquals(driver.findElement(By.className("footer_logo")).getCssValue("display"), "block");
		TestCase.assertEquals(driver.findElement(By.className("footer_logo")).getCssValue("margin"), "35px "+(driver.findElement(By.className("foot")).getSize().width-driver.findElement(By.className("footer_logo")).getSize().width)/2+"px 27px");
		TestCase.assertEquals(driver.findElement(By.className("footer_logo")).getCssValue("width"), "170px");
		TestCase.assertEquals(driver.findElement(By.className("footer_logo")).getCssValue("height"), "50px");
		//TestCase.assertEquals(driver.findElement(By.className("footer_logo")).getCssValue("background-color"), "rgba(204, 204, 204, 1)");
		TestCase.assertEquals(driver.findElement(By.className("footer_logo")).getAttribute("src"), Url.URL+"/imgs/home/home_logo2.jpg");
		
		TestCase.assertEquals(driver.findElement(By.className("footer_info")).getCssValue("display"), "block");
		TestCase.assertEquals(driver.findElement(By.className("footer_info")).getCssValue("margin"), "0px "+(driver.findElement(By.className("foot")).getSize().width-driver.findElement(By.className("footer_info")).getSize().width)/2+"px");
		TestCase.assertEquals(driver.findElement(By.className("footer_info")).getCssValue("width"), "370px");
		TestCase.assertEquals(driver.findElement(By.className("footer_info")).getCssValue("height"), "23px");
		TestCase.assertEquals(driver.findElement(By.className("footer_info")).getCssValue("text-align"), "center");
		TestCase.assertEquals(driver.findElement(By.className("footer_info")).getCssValue("line-height"), "23px");
		TestCase.assertEquals(driver.findElement(By.className("footer_info")).getText(), "©杰夫.县域|浙ICP备14029606号-1|杭州电子商务服务联盟");
		
		TestCase.assertEquals(driver.findElement(By.className("footer_val")).getCssValue("margin"), "0px "+(driver.findElement(By.className("foot")).getSize().width-driver.findElement(By.className("footer_val")).getSize().width)/2+"px");
		TestCase.assertEquals(driver.findElement(By.className("footer_val")).getCssValue("width"), "468px");
		TestCase.assertEquals(driver.findElement(By.className("footer_val")).getCssValue("height"), "47px");
		for (WebElement img : driver.findElement(By.className("footer_val")).findElements(By.tagName("img"))) {
			if (img.getAttribute("class").equals("footer_val1")) {
				TestCase.assertEquals(img.getAttribute("src"), Url.URL+"/imgs/home/home_val1.jpg");
			} else if (img.getAttribute("class").equals("footer_val2")) {
				TestCase.assertEquals(img.getAttribute("src"), Url.URL+"/imgs/home/home_val2.jpg");
			} else if (img.getAttribute("class").equals("footer_val3")) {
				TestCase.assertEquals(img.getAttribute("src"), Url.URL+"/imgs/home/home_val3.jpg");
			} else {
				throw new Exception("属性未定义:  底部公共模块/认证图片/"+img.getAttribute("class"));
			}
			TestCase.assertEquals(img.getCssValue("float"), "left");
			TestCase.assertEquals(img.getCssValue("margin"), "25px 12px 0px");
			TestCase.assertEquals(img.getCssValue("width"), "122px");
			TestCase.assertEquals(img.getCssValue("height"), driver.findElement(By.className("footer_val")).getCssValue("height"));
		}
	}
	
	public void checkFloatingWindow(WebDriver driver) throws Exception {
		//浮动窗口
		TestCase.assertEquals(driver.findElement(By.className("float_contact")).getCssValue("position"), "fixed");
		TestCase.assertEquals(driver.findElement(By.className("float_contact")).getCssValue("z-index"), "2");
		TestCase.assertEquals(driver.findElement(By.className("float_contact")).getCssValue("right"), "40px");
		TestCase.assertEquals(driver.findElement(By.className("float_contact")).getCssValue("bottom"), "250px");
		TestCase.assertEquals(driver.findElement(By.className("float_contact")).getCssValue("width"), "47px");
		TestCase.assertEquals(driver.findElement(By.className("float_contact")).getCssValue("height"), "147px");
		
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_contact.sh_contact")).getCssValue("width"), "47px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_contact.sh_contact")).getCssValue("height"), "47px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_contact.sh_contact")).getCssValue("background-image"), "url("+Url.URL+"/imgs/home/float_contact.png)");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_contact.sh_contact")).getCssValue("background-position"), "0px 0px");
		
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_detail_wrap.sh_wrap")).getCssValue("position"), "relative");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_detail_wrap.sh_wrap")).getCssValue("left"), "-170px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_detail_wrap.sh_wrap")).getCssValue("width"), "170px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_detail_wrap.sh_wrap")).getCssValue("height"), "180px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_detail_wrap.sh_wrap")).getCssValue("visibility"), "hidden");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_detail_wrap.sh_wrap")).getCssValue("overflow"), "hidden");
		
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_detail.hide")).getCssValue("width"), "170px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_detail.hide")).getCssValue("height"), "180px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_detail.hide")).getCssValue("background-color"), "rgba(132, 210, 109, 1)");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_detail.hide")).getCssValue("position"), "relative");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".wechat_detail.hide")).getCssValue("visibility"), "hidden");
		
		TestCase.assertEquals(driver.findElement(By.className("wechat_code")).getCssValue("width"), "121px");
		TestCase.assertEquals(driver.findElement(By.className("wechat_code")).getCssValue("height"), "121px");
		TestCase.assertEquals(driver.findElement(By.className("wechat_code")).getCssValue("position"), "absolute");
		TestCase.assertEquals(driver.findElement(By.className("wechat_code")).getCssValue("left"), "15px");
		TestCase.assertEquals(driver.findElement(By.className("wechat_code")).getCssValue("top"), "14px");
		TestCase.assertEquals(driver.findElement(By.className("wechat_code")).getCssValue("background-color"), "rgba(204, 204, 204, 1)");
		TestCase.assertEquals(driver.findElement(By.className("wechat_code")).getCssValue("border"), "0px none rgb(0, 0, 0)");
		TestCase.assertEquals(driver.findElement(By.className("wechat_code")).getAttribute("src"), Url.URL+"/imgs/home/wechat_code.jpg");
		
		TestCase.assertEquals(driver.findElement(By.className("wechat_code_desc")).getCssValue("display"), "block");
		TestCase.assertEquals(driver.findElement(By.className("wechat_code_desc")).getCssValue("width"), driver.findElement(By.cssSelector(".wechat_detail.hide")).getSize().getWidth()+"px");
		TestCase.assertEquals(driver.findElement(By.className("wechat_code_desc")).getCssValue("padding-top"), "146px");
		TestCase.assertEquals(driver.findElement(By.className("wechat_code_desc")).getCssValue("text-indent"), "42px");
		if (driver.findElement(By.cssSelector(".wechat_detail_wrap.sh_wrap")).getCssValue("overflow").equals("visible") && driver.findElement(By.cssSelector(".wechat_detail.hide")).getCssValue("visibility").equals("visible")) {
			TestCase.assertEquals(driver.findElement(By.className("wechat_code_desc")).getText(), "扫码关注");
		} else {
			TestCase.assertEquals(driver.findElement(By.className("wechat_code_desc")).getText(), "");
		}		
		
		TestCase.assertEquals(driver.findElement(By.className("wechat_detail_blank")).getCssValue("position"), "absolute");
		TestCase.assertEquals(driver.findElement(By.className("wechat_detail_blank")).getCssValue("width"), "20px");
		TestCase.assertEquals(driver.findElement(By.className("wechat_detail_blank")).getCssValue("height"), "133px");
		TestCase.assertEquals(driver.findElement(By.className("wechat_detail_blank")).getCssValue("background-color"), "rgba(0, 0, 0, 0)");
		TestCase.assertEquals(driver.findElement(By.className("wechat_detail_blank")).getCssValue("bottom"), "0px");
		TestCase.assertEquals(driver.findElement(By.className("wechat_detail_blank")).getCssValue("right"), "0px");
		
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_contact.sh_contact")).getCssValue("margin-top"), "3px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_contact.sh_contact")).getCssValue("width"), "47px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_contact.sh_contact")).getCssValue("height"), "47px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_contact.sh_contact")).getCssValue("background-image"), "url("+Url.URL+"/imgs/home/float_contact.png)");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_contact.sh_contact")).getCssValue("background-position"), "0px -50px");
		
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail_wrap.sh_wrap")).getCssValue("position"), "relative");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail_wrap.sh_wrap")).getCssValue("left"), "-285px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail_wrap.sh_wrap")).getCssValue("width"), "285px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail_wrap.sh_wrap")).getCssValue("height"), "47px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail_wrap.sh_wrap")).getCssValue("visibility"), "hidden");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail_wrap.sh_wrap")).getCssValue("overflow"), "hidden");
		
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail.hide")).getCssValue("width"), "285px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail.hide")).getCssValue("height"), "47px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail.hide")).getCssValue("background-color"), "rgba(31, 186, 233, 1)");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail.hide")).getCssValue("line-height"), "47px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail.hide")).getCssValue("text-indent"), "20px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail.hide")).getCssValue("font-weight"), "900");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail.hide")).getCssValue("position"), "relative");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail.hide")).getCssValue("visibility"), "hidden");
		if (driver.findElement(By.cssSelector(".tencent_detail_wrap.sh_wrap")).getCssValue("visibility").equals("visible") && driver.findElement(By.cssSelector(".tencent_detail.hide")).equals("visible")) {
			TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail.hide")).getText(), "服务时间:9:00-18:00      咨询请点击 >");
		} else {
			TestCase.assertEquals(driver.findElement(By.cssSelector(".tencent_detail.hide")).getText(), "");
		}
		
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_contact.sh_contact")).getCssValue("margin-top"), "3px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_contact.sh_contact")).getCssValue("width"), "47px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_contact.sh_contact")).getCssValue("height"), "47px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_contact.sh_contact")).getCssValue("background-image"), "url("+Url.URL+"/imgs/home/float_contact.png)");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_contact.sh_contact")).getCssValue("background-position"), "0px -100px");
	
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_detail_wrap.sh_wrap")).getCssValue("position"), "relative");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_detail_wrap.sh_wrap")).getCssValue("left"), "-210px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_detail_wrap.sh_wrap")).getCssValue("width"), "210px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_detail_wrap.sh_wrap")).getCssValue("height"), "80px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_detail_wrap.sh_wrap")).getCssValue("visibility"), "hidden");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_detail_wrap.sh_wrap")).getCssValue("overflow"), "hidden");
		
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_detail.hide")).getCssValue("width"), "210px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_detail.hide")).getCssValue("height"), "80px");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_detail.hide")).getCssValue("background-color"), "rgba(249, 99, 61, 1)");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_detail.hide")).getCssValue("position"), "relative");
		TestCase.assertEquals(driver.findElement(By.cssSelector(".phone_detail.hide")).getCssValue("visibility"), "hidden");
		if (driver.findElement(By.cssSelector(".phone_detail_wrap.sh_wrap")).getCssValue("visibility").equals("visible") && driver.findElement(By.cssSelector(".phone_detail.hide")).equals("visible")) {
			TestCase.assertEquals(driver.findElement(By.className("phone_detail_num")).getText(), "400-888-8888");
			TestCase.assertEquals(driver.findElement(By.className("phone_detail_time")).getText(), "服务时间:9:00-18:00");
		} else {
			TestCase.assertEquals(driver.findElement(By.className("phone_detail_num")).getText(), "");
			TestCase.assertEquals(driver.findElement(By.className("phone_detail_time")).getText(), "");
		}
		TestCase.assertEquals(driver.findElement(By.className("phone_detail_num")).getCssValue("display"), "block");
		TestCase.assertEquals(driver.findElement(By.className("phone_detail_num")).getCssValue("font-size"), "20px");
		TestCase.assertEquals(driver.findElement(By.className("phone_detail_num")).getCssValue("padding"), "19px 0px 8px");
		TestCase.assertEquals(driver.findElement(By.className("phone_detail_num")).getCssValue("text-align"), "center");
		TestCase.assertEquals(driver.findElement(By.className("phone_detail_time")).getCssValue("display"), "block");
		TestCase.assertEquals(driver.findElement(By.className("phone_detail_time")).getCssValue("width"), driver.findElement(By.cssSelector(".phone_detail.hide")).getSize().getWidth()+"px");
		TestCase.assertEquals(driver.findElement(By.className("phone_detail_time")).getCssValue("text-align"), "center");
	}

	/**
	 * 检测页面中所有静态信息，包括图片、地址、文字、提示等内容
	 * @param driver
	 * @throws Exception 
	 */
	public abstract void checkStaticInformation(WebDriver driver) throws Exception;
	
	/**
	 * 左上角页面选择点击操作
	 * @param driver
	 * @param pageName 按钮显示的字
	 * @throws Exception
	 */
	public void clickOtherPage(WebDriver driver, String pageName) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.className("head_nav_wrap")));
		for (WebElement a : driver.findElement(By.className("head_nav_wrap")).findElements(By.tagName("a"))) {
			if (a.getText().equals(pageName)) {
				String url = a.getAttribute("href");
				a.click();
				new Thread().sleep(2000);
				TestCase.assertEquals(driver.getCurrentUrl(), url);
				for (WebElement a1 : driver.findElement(By.className("head_nav_wrap")).findElements(By.tagName("a"))) {
					if (a1.getAttribute("href").equals(url)) {
						TestCase.assertEquals(a1.getAttribute("class"), a1.getAttribute("href").substring(a1.getAttribute("href").lastIndexOf("/")+1, a1.getAttribute("href").lastIndexOf("."))+" nav_hover");
					}else {
						TestCase.assertEquals(a1.getAttribute("class"), a1.getAttribute("href").substring(a1.getAttribute("href").lastIndexOf("/")+1, a1.getAttribute("href").lastIndexOf(".")));
					}
				}
				return;
			}
		}
		throw new Exception("页面不存在: "+pageName);
	}
	
	/**
	 * 点击左上角logo图标
	 * @param driver
	 * @throws Exception
	 */
	public void clickLogo(WebDriver driver) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.className("sub_logo_link")));
		driver.findElement(By.className("sub_logo_link")).click();
		new Thread().sleep(2000);
		TestCase.assertEquals(driver.getCurrentUrl(), Url.HOME_PAGE);
		for (WebElement a1 : driver.findElement(By.className("head_nav_wrap")).findElements(By.tagName("a"))) {
			if (a1.getAttribute("href").equals(Url.HOME_PAGE)) {
				TestCase.assertEquals(a1.getAttribute("class"), a1.getAttribute("href").substring(a1.getAttribute("href").lastIndexOf("/")+1, a1.getAttribute("href").lastIndexOf("."))+" nav_hover");
			}else {
				TestCase.assertEquals(a1.getAttribute("class"), a1.getAttribute("href").substring(a1.getAttribute("href").lastIndexOf("/")+1, a1.getAttribute("href").lastIndexOf(".")));
			}
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param name 默认微信、QQ、电话选一个
	 * @throws Exception
	 */
	public void clickFloatingWindow(WebDriver driver, String name) throws Exception {
		WebElement element;
		if (name.equals("微信")) {
			element = driver.findElement(By.cssSelector(".wechat_contact.sh_contact"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			new Actions(driver).moveToElement(element).build().perform();
			TestCase.assertEquals(element.findElement(By.cssSelector(".wechat_detail_wrap.sh_wrap")).getCssValue("visibility"), "visible");
			TestCase.assertEquals(element.findElement(By.cssSelector("wechat_detail.hide")).getCssValue("visibility"), "visible");
			TestCase.assertEquals(element.findElement(By.className("wechat_code")).getAttribute("src"), Url.URL+"/imgs/home/wechat_code.jpg");
			TestCase.assertEquals(element.findElement(By.className("wechat_code_desc")).getText(), "扫码关注");
		} else if (name.equals("QQ")) {
			element = driver.findElement(By.cssSelector(".tencent_contact.sh_contact"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			new Actions(driver).moveToElement(element).build().perform();
			TestCase.assertEquals(element.findElement(By.cssSelector(".tencent_detail_wrap.sh_wrap")).getCssValue("visibility"), "visible");
			TestCase.assertEquals(element.findElement(By.cssSelector(".tencent_detail.hide")).getCssValue("visibility"), "visible");
			TestCase.assertEquals(element.findElement(By.cssSelector(".tencent_detail.hide")).getText(), "服务时间:9:00-18:00      咨询请点击 >");
		} else if (name.equals("电话")) {
			element = driver.findElement(By.cssSelector(".phone_contact.sh_contact"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			new Actions(driver).moveToElement(element).build().perform();
			TestCase.assertEquals(element.findElement(By.cssSelector(".phone_detail_wrap.sh_wrap")).getCssValue("visibility"), "visible");
			TestCase.assertEquals(element.findElement(By.cssSelector(".phone_detail.hide")).getCssValue("visibility"), "visible");
			TestCase.assertEquals(element.findElement(By.className("phone_detail_num")).getText(), "400-888-8888");
			TestCase.assertEquals(element.findElement(By.className("phone_detail_time")).getText(), "服务时间:9:00-18:00");
		} else {
			throw new Exception("浮动窗口没有找到按钮: "+name);
		}
	}
	
	/**
	 * 检测页面中所有资源是否可打开，包括图片、CSS、JS等内容
	 * @param driver
	 */
	public void checkResourceLink(WebDriver driver) {
		try {
			List<String> resUrls = HtmlResources.getHtmlResUrl(driver.getCurrentUrl(), "", "");
			for (String url : resUrls) {
				Map<String, String> result = HttpRequest.getHtml(url, "");
				if (!result.get("code").equals("200") || result.get("info").equals("")) {
					throw new Exception("资源地址无法下载到资源:"+url+", 返回code:"+result.get("code"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
