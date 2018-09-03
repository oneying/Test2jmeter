package feishuo.KyyAppUITest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Prize {

	public AndroidDriver driver;
	UILogin login=new UILogin();
	UIHomePage home=new UIHomePage();
	UIMe me=new UIMe();
	UIPrize exchange=new UIPrize();
	
@BeforeClass
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
	Reporter.log("进入我的");
	me.Prize(driver); 
	Reporter.log("奖品中心");
	Thread.sleep(1000);
}

@Test//(enabled=false)
public void testBuy()throws Exception{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByAccessibilityId("便携简约日记本 10  ").click();  
	Reporter.log("点击便携简约日记本");
	exchange.buy(driver); 
	Reporter.log("点击我要兑换");
	exchange.dialog_ok2(driver); 
	Reporter.log("提示框");//积分不足和未订购时，有提示框，点击确定关闭提示框
	exchange.back(driver);  
	Reporter.log("点击返回");
	Thread.sleep(1000);
}

@Test//(enabled=false)
public void testMore()throws Exception{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	exchange.all(driver); 
	Reporter.log("点击更多");
	driver.findElementByAccessibilityId("彩虹圆珠笔 50  ").click(); 
	Reporter.log("点击彩虹圆珠笔");
	exchange.buy(driver); 
	Reporter.log("点击我要兑换");
	exchange.dialog_ok2(driver); 
	Reporter.log("提示框");//积分不足和未订购时，有提示框，点击确定关闭提示框
	exchange.back(driver); 
	Reporter.log("点击返回");
	Thread.sleep(1000);
	exchange.back(driver); 
	Reporter.log("点击返回");
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
