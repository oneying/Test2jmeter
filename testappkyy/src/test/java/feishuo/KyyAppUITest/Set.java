package feishuo.KyyAppUITest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Set {

	public AndroidDriver driver;
	UILogin login=new UILogin();
	UIHomePage home=new UIHomePage();
	UIMe me=new UIMe();
	UISet set=new UISet();
	
@BeforeMethod
public void setUp()throws Exception{
//启动appium
	BaseTest device=new BaseTest();
	driver=device.getAndroidDriver();

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
    //进入首页
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	home.Me(driver); 
	Reporter.log("我的");
	Thread.sleep(1500);
	me.Set(driver); 
	Reporter.log("设置");
	Thread.sleep(1000);
}

@Test//(enabled=false)
public void testClear()throws Exception{
	//清除缓存
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	set.Clear_no(driver);  
	Reporter.log("取消清除");
	set.Clear_yes(driver);  
	Reporter.log("确定清除");
}

@Test//(enabled=false)
public void testChange()throws Exception{
	//正常修改密码
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	set.change_password(driver, "888888", "12ab345", "12ab345"); 
	Reporter.log("改密码");//改密码
	Thread.sleep(1000);
	set.Sure(driver); 
	Reporter.log("确定");
	Thread.sleep(1000);
	set.ExitLogin_yes(driver);  
	Reporter.log("退出登录");
	login.Login(driver, "mzls01", "12ab345");  
	Reporter.log("重新登录");//输入账号和刚修改的密码
	//登录后：未订购的学生有提示框，先取消这个提示框
	driver.pressKeyCode(4);   
	Reporter.log("按返回键，取消订购提示框");
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "首页");			     
    //进入首页
	home.Me(driver);  
	Reporter.log("我的");
	Thread.sleep(1000);
	me.Set(driver);  
	Reporter.log("设置");
	set.change_password(driver, "12ab345","888888" , "888888");  
	Reporter.log("改密码");
	Thread.sleep(1000);
	set.Sure(driver);  
	Reporter.log("确定");
}

@Test(enabled=false)
public void testFeedback()throws Exception{
	//意见反馈
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	set.feedback(driver);//意见反馈
	set.suggestion(driver, "测试：建议-12345m一天nbvc。", "@bvfd");//建议
	Reporter.log("建议");
	set.feedback(driver);//意见反馈
	set.complain(driver, "测试：投诉-12345m一天nbvc。", "@bvfd");//投诉
	Reporter.log("投诉");
	set.feedback(driver);//意见反馈
	set.consult(driver, "测试：咨询-12345m一天nbvc。", "@bvfd");//咨询
	Reporter.log("咨询");
}

@Test//(enabled=false)
public void testAbout()throws Exception{
	//关于口语易
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	set.about(driver); 
	Reporter.log("关于口语易");
	Thread.sleep(1000);
	driver.pressKeyCode(4);  
	Reporter.log("返回设置");
}

@Test//(enabled=false)
public void testProblem()throws Exception{
	//常见问题
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	set.problem(driver);  
	Reporter.log("常见问题");
	Thread.sleep(1000);
	driver.pressKeyCode(4);  
	Reporter.log("返回设置");
}

@Test//(enabled=false)
public void testWelcome()throws Exception{
	//欢迎页
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	set.welcome(driver);  
	Reporter.log("欢迎页");
	Thread.sleep(1000);
	driver.pressKeyCode(4); 
	Reporter.log("返回设置");
}

@Test//(enabled=false)
public void testExitLogin()throws Exception{
	//退出登录
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	set.ExitLogin_no(driver); 
	Reporter.log("不退出");
	set.ExitLogin_yes(driver); 
	Reporter.log("退出");
	
	login.Login(driver, "mzls01", "888888"); 
	Reporter.log("重新登录");//输入账号和密码
	driver.pressKeyCode(4);  
	Reporter.log("按返回键，取消修改密码提示框");
	Thread.sleep(1000);
	//登录后：未订购的学生有提示框，先取消这个提示框
	driver.pressKeyCode(4);  
	Reporter.log("按返回键，取消订购提示框");
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "首页");			     
    //进入首页
	home.Me(driver);  
	Reporter.log("我的");
	Thread.sleep(1000);
	me.Set(driver);  
	Reporter.log("设置");
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
