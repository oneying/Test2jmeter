package feishuo.KyyAppUITest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import jxl.read.biff.BiffException;

public class HomePage {//首页
	public AndroidDriver driver;
	UILogin login=new UILogin();
	UIHomePage home=new UIHomePage();
	
@BeforeMethod
public void setUp()throws Exception{
//启动appium
	BaseTest device=new BaseTest();
	driver=device.getAndroidDriver();

//学生-正常登录
	login.Role(driver, "student"); 
	Reporter.log("角色选择学生");
	login.Login(driver, "mzls01", "888888"); 
	Reporter.log("输入学生账号-未订购mzls01");//输入正确的账号和正确的密码
	Thread.sleep(3000);
	//如有更新提示框，先关闭这个提示框
	driver.pressKeyCode(4);  
	Reporter.log("按返回键，取消更新提示框");
	Thread.sleep(1000);
	driver.pressKeyCode(4);  
	Reporter.log("按返回键，取消订购提示框");
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "首页");			     
    //进入首页
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@Test//(enabled=false)
public void testItemMiddle()throws Exception{
    //中间导航栏链接
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	home.Training(driver);  
	Reporter.log("同步训练");
	Thread.sleep(1000);
    driver.pressKeyCode(4); 
    Reporter.log("返回首页");
    home.Exercise(driver);  
    Reporter.log("练习题库");
    Thread.sleep(1000);
	driver.pressKeyCode(4);  
	Reporter.log("返回首页");
	home.Topic(driver);  
	Reporter.log("情景话题");
	Thread.sleep(1000);
	driver.pressKeyCode(4); 
	Reporter.log("返回首页");
	home.Cartoon(driver); 
	Reporter.log("卡通欣赏");
	Thread.sleep(1000);
	driver.pressKeyCode(4); 
	Reporter.log("返回首页");
	
}

@Test//(enabled=false)
public void testPast()throws Exception{
	//往期回顾
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	home.Past(driver); 
	Reporter.log("点击往期回顾");
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "往期回顾"); 
	Reporter.log("判断标题是否往期回顾");
	List<WebElement>item=driver.findElementsById("com.kouyuyi.kyystuapp:id/img_view");
	item.get(0).click();  
	Reporter.log("点击第1个大赛");
	Thread.sleep(1000);
	driver.pressKeyCode(4);  
	Reporter.log("返回往期回顾");
	driver.findElementByName("2016年").click();   
	Reporter.log("选择2016年");
	item.get(0).click();  
	Reporter.log("点击第1个大赛");
	Thread.sleep(1000);
	driver.pressKeyCode(4); 
	Reporter.log("返回往期回顾");
	driver.findElementByName("校级大赛").click();  
	Reporter.log("点击校级大赛");
	item.get(0).click();  
	Reporter.log("点击第1个大赛");
	Thread.sleep(1000);
	driver.pressKeyCode(4);  
	Reporter.log("返回往期回顾");
	driver.findElementByName("市级大赛").click();  
	Reporter.log("点击市级大赛");
	driver.findElementByName("2015年").click(); 
	Reporter.log("选择2015年");
	item.get(0).click(); 
	Reporter.log("点击第1个大赛");
	Thread.sleep(1000);
	driver.pressKeyCode(4); 
	Reporter.log("返回往期回顾");
	Thread.sleep(1000);
	driver.pressKeyCode(4);  
	Reporter.log("返回首页");
}

@Test//(enabled=false)
public void testItemBottom()throws Exception{
    //底部导航栏链接
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	home.Me(driver); 
	Reporter.log("点击我的");
	Thread.sleep(1000);
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "我的"); 
	Reporter.log("判断标题是否我的");
	home.Fighting(driver); 
	Reporter.log("点击评测");
	Thread.sleep(1000);
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "评测"); 
	Reporter.log("判断标题是否评测");
	home.Play(driver); 
	Reporter.log("点击播放");
	Thread.sleep(2000);
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "我的播放");
	Reporter.log("判断标题是否我的播放");
	driver.pressKeyCode(4); 
	Reporter.log("点击返回");
	home.Homework(driver);  
	Reporter.log("点击作业");
	Thread.sleep(1000);
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "作业"); 
	Reporter.log("判断标题是否作业");
	home.Home(driver); 
	Reporter.log("点击首页");
	Thread.sleep(1000);
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "首页"); 
	Reporter.log("判断标题是否首页");
	
}

@AfterMethod
public void tearDown()throws Exception{
	driver.quit();//测试完毕，关闭driver，不关闭将会导致会话还存在，下次启动就会报错
}
}
