package feishuo.KyyAppUITest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Link {

	public AndroidDriver driver;
	UILogin login=new UILogin();
	EverySwipe swipe=new EverySwipe();

	@BeforeMethod
	public void setUp()throws Exception{
	//启动appium
		BaseTest device=new BaseTest();
		driver=device.getAndroidDriver();
		
	//教师-正常登录
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login.Role(driver, "teacher"); 
		Reporter.log("角色选择教师");
		login.Login(driver, "teacher006", "888888"); 
		Reporter.log("登录教师账号：teacher006");//输入正确的账号和正确的密码
		Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/tv_title").getText(), "口语易");			     
	    //进入首页
		

	}

	@Test//(enabled=false)
	public void testCheckHw1()throws Exception{
		//作业列表-检查作业
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("icon02").click(); 
		Reporter.log("点击作业列表");
		driver.findElementByAccessibilityId("检查作业").click();  
		Reporter.log("点击检查作业");
		driver.findElementByAccessibilityId("查看成绩").click(); 
		Reporter.log("点击查看成绩");
		Thread.sleep(1000);
	}
	
	@Test//(enabled=false)
	public void testCheckHw2()throws Exception{
		//作业历史
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("icon03").click();  
		Reporter.log("点击作业历史");

		Thread.sleep(1000);
	}
	
	@Test//(enabled=false)
	public void testCheckTrain()throws Exception{
		//训练情况
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("icon04").click(); 
		Reporter.log("点击训练情况");

		Thread.sleep(1000);
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
