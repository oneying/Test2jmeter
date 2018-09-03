package feishuo.KyyAppUITest;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableBiMap.Builder;

import io.appium.java_client.android.AndroidDriver;

public class SetHomework {
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
		Reporter.log("登录教师账号teacher006");//输入正确的账号和正确的密码
		Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/tv_title").getText(), "口语易"); 
		Reporter.log("判断标题是否口语易");	 		     
	    //进入首页
		driver.findElementByAccessibilityId("icon01").click();  
		Reporter.log("点击布置作业");

	}

	@Test//(enabled=false)
	public void testSet()throws Exception{
		//布置作业
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByAccessibilityId("口语易测试学校六年级1班").click(); 
        Reporter.log("选择口语易测试学校六年级1班");
        swipe.swipeToUp(driver, 1); 
        Reporter.log("向上划一下 ");
        driver.findElementByAccessibilityId("提交录音 ").click();  
        Reporter.log("勾选提交录音");
        List<WebElement>ed=driver.findElementsByClassName("android.widget.EditText");
        ed.get(2).sendKeys("要求：请按时完成作业。"); 
        Reporter.log("输入作业要求");
        swipe.swipeToUp(driver, 1);  
        Reporter.log("向上划一下");
        driver.findElementByAccessibilityId("发送短信 ").click(); 
        Reporter.log("勾选发送短信");
        ed.get(3).sendKeys("内容：请按时完成作业。"); 
        Reporter.log("输入短信内容");
        driver.findElementByAccessibilityId("作业单元选择").click(); 
        Reporter.log("点击作业单元选择");
        driver.findElementByAccessibilityId("-- 请选择 --").click(); 
        Reporter.log("点击选择课程");
        List<WebElement> cl=driver.findElementsById("android:id/text1");//课程列表
        cl.get(1).click(); 
        Reporter.log("点击第1课");
        List<WebElement>ts=driver.findElementsByAccessibilityId("听说 ");
        ts.get(0).click();  
        Reporter.log("点击part1听说");
        
        driver.findElementByAccessibilityId(" 确 定 ").click(); 
        Reporter.log("点击确定");
        driver.findElementByAccessibilityId("确定布置作业").click(); 
        Reporter.log("点击确定布置作业");
        Thread.sleep(5000);
	}
	
	@Test//(enabled=false)
	public void testCheck_unit()throws Exception{
        //不选择作业单元选择
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByAccessibilityId("口语易测试学校六年级1班").click(); 
        Reporter.log("选择口语易测试学校六年级1班");
        driver.findElementByAccessibilityId("确定布置作业").click();
        Reporter.log("点击确定布置作业");
        Assert.assertTrue(driver.findElementByAccessibilityId("请选择作业单元").isEnabled());
        Reporter.log("有提示语：请选择作业单元");
	}
	
	@Test//(enabled=false)
	public void testCheck_class()throws Exception{
		//不选择班级
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("确定布置作业").click(); 
        Reporter.log("点击确定布置作业");
        Assert.assertTrue(driver.findElementByAccessibilityId("请选择班级").isEnabled()); 
        Reporter.log("有提示语：请选择班级");
        
	}
	
	@Test//(enabled=false)
	public void testCheck_message()throws Exception{
        //勾选发送短信，不填短信内容
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
        driver.findElementByAccessibilityId("口语易测试学校六年级1班").click(); 
        Reporter.log("选择口语易测试学校六年级1班");
        swipe.swipeToUp(driver, 1); 
        Reporter.log("向上划一下 ");
        driver.findElementByAccessibilityId("提交录音 ").click();  
        Reporter.log("勾选提交录音");
        List<WebElement>ed=driver.findElementsByClassName("android.widget.EditText");
        ed.get(2).sendKeys("要求：请按时完成作业。");  
        Reporter.log("输入作业要求");
        swipe.swipeToUp(driver, 1); 
        Reporter.log("向上划一下");
        driver.findElementByAccessibilityId("发送短信 ").click();  
        Reporter.log("勾选发送短信");
        driver.findElementByAccessibilityId("作业单元选择").click();  
        Reporter.log("点击作业单元选择");
        driver.findElementByAccessibilityId("-- 请选择 --").click();  
        Reporter.log("点击选择课程");
        List<WebElement> cl=driver.findElementsById("android:id/text1");//课程列表
        cl.get(1).click(); 
        Reporter.log("点击第1课");
        List<WebElement>ts=driver.findElementsByAccessibilityId("听说 ");
        ts.get(0).click(); 
        Reporter.log("点击part1听说 ");
        driver.findElementByAccessibilityId(" 确 定 ").click(); 
        Reporter.log("点击确定");
        driver.findElementByAccessibilityId("确定布置作业").click(); 
        Reporter.log("点击确定布置作业");
        Assert.assertTrue(driver.findElementByAccessibilityId("请输入短信内容").isEnabled()); 
        Reporter.log("有提示语：请输入短信内容");
        
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
