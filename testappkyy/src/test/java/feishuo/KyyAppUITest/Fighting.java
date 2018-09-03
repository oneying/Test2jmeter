package feishuo.KyyAppUITest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Fighting {

	public AndroidDriver driver;
	UILogin login=new UILogin();
	UIHomePage home=new UIHomePage();
	UIFighting fight=new UIFighting();

@BeforeMethod
public void setUp()throws Exception{
//启动appium
	BaseTest device=new BaseTest();
	driver=device.getAndroidDriver();

//学生-正常登录
	login.Role(driver, "student"); 
	Reporter.log("角色选择学生");
	login.Login(driver, "mzls01", "888888"); 
	Reporter.log("登录学生账号-未订购:mzls01");//输入正确的账号和正确的密码
	//登录后：未订购的学生有提示框，密码为‘888888’的学生有提示框，先取消这2个提示框
	driver.pressKeyCode(4);  
	Reporter.log("按返回键，取消修改密码提示框");
	Thread.sleep(1000);
	driver.pressKeyCode(4); 
	Reporter.log("按返回键，取消订购提示框");
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "首页");			     
    //进入首页
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	home.Fighting(driver); 
	Reporter.log("进入评测");
	Thread.sleep(3000);
}

@Test//(enabled=false)
public void testPlay()throws Exception{
	//评测
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	boolean result=isElementExist(By .id("com.kouyuyi.kyystuapp:id/guide_img"));//引导图是否存在
	//System.out.println(result);
	if(result==true){ 
		Reporter.log("有引导图");
		fight.Guide(driver); 
		Reporter.log("点击一下取消引导图");
		fight.Level(driver); 
		Reporter.log("点击1个水平测试");
	}else{
		fight.Level(driver);  
		Reporter.log("点击1个水平测试");
	}
	
	Thread.sleep(5000);
    fight.Play(driver);  
    Reporter.log("播放");
    fight.Play(driver);  
    Reporter.log("停止播放");
    fight.Remark(driver);  
    Reporter.log("播放名师");
    fight.Remark(driver);  
    Reporter.log("停止播放名师");
    fight.Record(driver);  
    Reporter.log("录音");
    fight.Record(driver);  
    Reporter.log("停止录音");
    fight.Again(driver); 
    Reporter.log("重新闯关");
    fight.MyAudio(driver); 
    Reporter.log("播放用户录音");	
    fight.MyAudio(driver);  
    Reporter.log("停止播放用户录音");
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
