package feishuo.KyyAppUITest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import jxl.read.biff.BiffException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ProtocolHandshake;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginStudent{//学生登录
	public AndroidDriver driver;
	UILogin login=new UILogin();
	UIHomePage home=new UIHomePage();
	UIMe me=new UIMe();
	UISet exit=new UISet();
	
@BeforeClass
public void setUp()throws Exception{
//启动appium
	BaseTest device=new BaseTest();
	driver=device.getAndroidDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			     
}

@DataProvider(name="ok")
public Object[][]Numbers()throws BiffException,IOException{
	ExcelData e=new ExcelData("studentlogin","studentok");
	return e.getExcelData();
}
@Test(dataProvider="ok")//(enabled=false)//测试
public void testLogin_OK(HashMap<String,String>data)throws Exception{
		//学生-正常登录
	login.Role(driver, "student"); 
	Reporter.log("角色选择：学生");
	login.Login(driver, data.get("thUserid"), data.get("thPassid")); 
	Reporter.log("输入正确的账号和正确的密码");
	Thread.sleep(3000);
	//如有更新提示框，先关闭这个提示框
	driver.pressKeyCode(4);  
	Reporter.log("按返回键，取消更新提示框");
	Thread.sleep(1000);
	driver.pressKeyCode(4);  
	Reporter.log("按返回键，取消订购提示框");
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "首页"); 
	Reporter.log("进入首页");
    
	home.Me(driver); 
	Reporter.log("我的");
	Thread.sleep(1000);
	//每天第1次登录后点击‘我的’：密码为‘888888’的学生有提示框，先取消这个提示框
	driver.pressKeyCode(4);  
	Reporter.log("按返回键，取消修改密码提示框");
	me.Set(driver); 
	Reporter.log("设置");
	Thread.sleep(1000);
	exit.ExitLogin_yes(driver); 
	Reporter.log("退出登录");
	Thread.sleep(1000);
}

@DataProvider(name="fail01")
public Object[][]Numbers1()throws BiffException,IOException{
	ExcelData e=new ExcelData("studentlogin","studentfail01");
	return e.getExcelData();
}
@Test(dataProvider="fail01")//(enabled=false)
public void testLogin_fail01(HashMap<String,String>data)throws Exception{
		//学生-正确的学生账号和错误的密码登录
	login.Role(driver, "student");  
	Reporter.log("角色选择：学生");
	login.Login(driver, data.get("thUserid"), data.get("thPassid")); 
	Reporter.log("输入正确的学生账号和错误的密码");
	Thread.sleep(1000);
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/button_login").getText(), "登录"); 
	Reporter.log("判断能否登录");
}

@DataProvider(name="fail02")
public Object[][]Numbers2()throws BiffException,IOException{
	ExcelData e=new ExcelData("studentlogin","studentfail02");
	return e.getExcelData();
}
@Test(dataProvider="fail02")//(enabled=false)
public void testLogin_fail02(HashMap<String,String>data)throws Exception{
		//学生-不存在的学生账号和存在的密码登录
	login.Role(driver, "student"); 
	Reporter.log("角色选择：学生");
	login.Login(driver, data.get("thUserid"), data.get("thPassid")); 
	Reporter.log("不存在的学生账号和存在的密码");
	Thread.sleep(1000);
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/button_login").getText(), "登录"); 
	Reporter.log("判断能否登录");
}

@DataProvider(name="fail04")
public Object[][]Numbers4()throws BiffException,IOException{
	ExcelData e=new ExcelData("studentlogin","studentfail04");
	return e.getExcelData();
}
@Test(dataProvider="fail04")//(enabled=false)
public void testLogin_fail04(HashMap<String,String>data)throws Exception{
		//学生-存在的学生账号和空的密码登录
	login.Role(driver, "student"); 
	Reporter.log("角色选择：学生");
	login.Login(driver, data.get("thUserid"), data.get("thPassid")); 
	Reporter.log("存在的学生账号和空的密码");
	Thread.sleep(1000);
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/button_login").getText(), "登录"); 
	Reporter.log("判断能否登录");
}

@DataProvider(name="fail05")
public Object[][]Numbers5()throws BiffException,IOException{
	ExcelData e=new ExcelData("studentlogin","studentfail02");
	return e.getExcelData();
}
@Test(dataProvider="fail05")//(enabled=false)
public void testLogin_fail05(HashMap<String,String>data)throws Exception{
		//学生-空的学生账号和密码登录
	login.Role(driver, "student"); 
	Reporter.log("角色选择：学生");
	login.Login(driver, data.get("thUserid"), data.get("thPassid")); 
	Reporter.log("空的学生账号和密码");
	Thread.sleep(1000);
	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/button_login").getText(), "登录"); 
	Reporter.log("判断能否登录");
}

@AfterClass
public void tearDown()throws Exception{
	driver.quit();//测试完毕，关闭driver，不关闭将会导致会话还存在，下次启动就会报错
}
}


