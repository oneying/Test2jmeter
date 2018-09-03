package feishuo.KyyAppUITest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Cartoon {

	public AndroidDriver driver;
	UILogin login=new UILogin();
	UIHomePage home=new UIHomePage();
	UICartoon cartoon=new UICartoon();
	
@BeforeClass
public void setUp()throws Exception{
//启动appium
	BaseTest device=new BaseTest();
	driver=device.getAndroidDriver();

//学生-正常登录
	login.Role(driver, "student");  
	Reporter.log("角色选择学生");
	login.Login(driver, "mzls01", "888888");  
	Reporter.log("登录学生账号-未订购：mzls01");//输入正确的账号和正确的密码
	//登录后：未订购的学生有提示框，密码为‘888888’的学生有提示框，先取消这2个提示框
	driver.pressKeyCode(4);  
	Reporter.log("按返回键，取消修改密码提示框");
	Thread.sleep(1000);
	driver.pressKeyCode(4);  
	Reporter.log("按返回键，取消订购提示框");
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "首页"); 
	Reporter.log("进入首页");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	home.Cartoon(driver);  
	Reporter.log("进入卡通欣赏");
	Thread.sleep(1000);
}

@Test//(enabled=false)
public void testCartoon()throws Exception{
    //卡通播放
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	cartoon.Download(driver);  
	Reporter.log("下载卡通,等待30秒以内下载完");
	cartoon.Play(driver);  
	Reporter.log("播放卡通");
	Thread.sleep(3000);
	driver.pressKeyCode(4);  
	Reporter.log("按返回键，退出播放，返回卡通列表");
	//筛选卡通
	cartoon.Grade(driver); 
	Reporter.log("点击年级段");
	cartoon.Grade_1_3(driver);  
	Reporter.log("点击1~3年级");
	cartoon.Grade(driver);  
	Reporter.log("点击年级段");
	cartoon.Grade_7_9(driver);  
	Reporter.log("点击初中阶段");
	Assert.assertTrue(driver.findElementByName("初中阶段").isEnabled(), "初中阶段");
	cartoon.State(driver);  
	Reporter.log("点击状态");
	cartoon.State_downloaded(driver); 
	Reporter.log("点击已下载");
	boolean result=isElementExist(By .name("下载"));//“下载”是否存在
	Assert.assertEquals(result, false);  
	Reporter.log("筛选结果有‘播放’，没有‘下载’");
	cartoon.State(driver);  
	Reporter.log("点击状态");
	cartoon.State_notdownload(driver);  
	Reporter.log("点击未下载");
	cartoon.Grade(driver);  
	Reporter.log("点击年级段");
	cartoon.Grade_all(driver);  
	Reporter.log("点击全部");
	cartoon.State(driver);  
	Reporter.log("点击状态");
	cartoon.State_all(driver);  
	Reporter.log("点击全部");
	Assert.assertTrue(driver.findElementByName("播放").isEnabled(), "播放");
	//批量删除卡通
	cartoon.Manage(driver);  
	Reporter.log("点击批量管理");
	cartoon.Cancel(driver); 
	Reporter.log("点击取消删除");
	cartoon.Manage(driver); 
	Reporter.log("点击批量管理");
	cartoon.Delete(driver);  
	Reporter.log("点击确定删除");
	
}

@AfterClass
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