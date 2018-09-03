package feishuo.KyyAppUITest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Me {
//我的
	public AndroidDriver driver;
	UILogin login=new UILogin();
	UIHomePage home=new UIHomePage();
	UIMe me=new UIMe();
	
	@BeforeMethod
	public void setUp()throws Exception{
	//启动appium
		BaseTest device=new BaseTest();
		driver=device.getAndroidDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//学生-正常登录
		login.Role(driver, "student"); 
		Reporter.log("角色选择学生");
		login.Login(driver, "mzls01", "888888"); 
		Reporter.log("登录学生账号未订购：mzls01");//输入正确的账号和正确的密码
		//登录后：未订购的学生有提示框，密码为‘888888’的学生有提示框，先取消这2个提示框
		driver.pressKeyCode(4);  
		Reporter.log("按返回键，取消修改密码提示框");
		Thread.sleep(1000);
		driver.pressKeyCode(4); 
		Reporter.log("按返回键，取消订购提示框");
		Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "首页");
		Reporter.log("判断标题是否首页");			     
	    //进入首页
		
		home.Me(driver); 
		Reporter.log("进入我的");
	}

	@Test//(enabled=false)
	public void testInformation()throws Exception{
		//个人信息
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		me.Name(driver); 
		Reporter.log("点击用户名");
		Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "个人信息");
		Reporter.log("判断标题是否个人信息");
		driver.pressKeyCode(4);  
		Reporter.log("返回我的");
	}
	
	@Test//(enabled=false)
	public void testScore()throws Exception{
		//历史成绩
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		me.Score(driver); 
		Reporter.log("点击历史成绩");
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "查看历史成绩"); 
		Reporter.log("判断标题是否历史成绩");
		driver.pressKeyCode(4); 
		Reporter.log("返回我的");
	}
	
	@Test//(enabled=false)
	public void testBuy()throws Exception{
		//订购
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		me.Buy(driver); 
		Reporter.log("点击订购");
		me.Cancel(driver); 
		Reporter.log("取消订购");
		me.Buy(driver); 
		Reporter.log("点击订购");
		me.IBuy(driver);  
		Reporter.log("点击我要订购");
		me.Normal_pay(driver); 
		Reporter.log("支付宝微信支付");
		Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "我要订购");
		driver.pressKeyCode(4); 
		Reporter.log("返回订购");
		me.Mobile_pay(driver); 
		Reporter.log("点击移动支付");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "我要订购");
		driver.pressKeyCode(4); 
		Reporter.log("返回订购");
		Thread.sleep(1000);
		driver.pressKeyCode(4); 
		Reporter.log("返回我的");
	}
	
	@Test//(enabled=false)
	public void testPrize()throws Exception{
		//奖品中心
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		me.Prize(driver); 
		Reporter.log("点击奖品中心");
		Thread.sleep(5000);
		WebElement el=driver.findElementById("com.kouyuyi.kyystuapp:id/tv_title");
		Assert.assertEquals(el.getText(), "奖品中心"); 
		Reporter.log("判断标题是否奖品中心");
		driver.pressKeyCode(4);  
		Reporter.log("返回我的");
	}
	
	@Test//(enabled=false)
	public void testSet()throws Exception{
		//设置
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		me.Set(driver); 
		Reporter.log("点击设置");
		Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "设置"); 
		Reporter.log("判断标题是否设置");
		driver.pressKeyCode(4); 
		Reporter.log("返回我的");
	}
	
	@AfterMethod
	public void tearDown()throws Exception{
		driver.quit();//测试完毕，关闭driver，不关闭将会导致会话还存在，下次启动就会报错
	}
	
	/**
	* 判断元素是否存在
	*/
	public boolean isElementExist(By Locator) {
	try {
	driver.findElement(Locator);
	return true;
	} catch (org.openqa.selenium.NoSuchElementException ex) {
	return false;
	}
	}
}
