package feishuo.KyyAppUITest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ProtocolHandshake;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import jxl.read.biff.BiffException;

public class LoginTeacher {

	public AndroidDriver driver;
	private static boolean isInstall=false;
	UILogin login=new UILogin();
		
	@BeforeMethod
	public void setUp()throws Exception{
	//启动appium
	BaseTest device=new BaseTest();
	driver=device.getAndroidDriver();
					     
}	

    @DataProvider(name="ok")
    public Object[][]Numbers()throws BiffException,IOException{
    	ExcelData e=new ExcelData("teacherlogin","teacherok");
    	return e.getExcelData();
    }
    @Test(dataProvider="ok")//(enabled=false)//正常登录教师
    public void LoginSuccess_Teacher(HashMap<String,String>data)throws Exception{
    login.Role(driver, "teacher");  
    Reporter.log("选择教师角色");
    login.Login(driver,data.get("thUserid"), data.get("thPassid")); 
    Reporter.log("输入正确的账号和密码");
	Thread.sleep(1000);
	WebElement el_indextitle=driver.findElementByName("口语易");
	Assert.assertEquals(el_indextitle.isEnabled(), true);  
	Reporter.log("判断标题是否口语易");
	Thread.sleep(1000);	
	}
    
    @DataProvider(name="fail01")
    public Object[][]Numbers1()throws BiffException,IOException{
    	ExcelData e=new ExcelData("teacherlogin","teacherfail01");
    	return e.getExcelData();
    }
    @Test(dataProvider="fail01")//(enabled=false)
    public void testLogin_fail01(HashMap<String,String>data)throws Exception{
    		//登录失败的情况-正确的账号和错误的密码
    	login.Role(driver, "teacher");   
    	Reporter.log("选择教师角色");
    	login.Login(driver, data.get("thUserid"), data.get("thPassid")); 
    	Reporter.log("输入正确的账号和错误的密码");
    	Thread.sleep(1000);
    	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/button_login").getText(), "登录"); 
    	Reporter.log("判断是否有登录按钮");
    }

    @DataProvider(name="fail02")
    public Object[][]Numbers2()throws BiffException,IOException{
    	ExcelData e=new ExcelData("teacherlogin","teacherfail02");
    	return e.getExcelData();
    }
    @Test(dataProvider="fail02")//(enabled=false)
    public void testLogin_fail02(HashMap<String,String>data)throws Exception{
    	//登录失败的情况-不存在的教师账号和存在的密码
    	login.Role(driver, "teacher");  
    	Reporter.log("选择教师角色");
    	login.Login(driver, data.get("thUserid"), data.get("thPassid"));  
    	Reporter.log("输入不存在的教师账号和存在的密码");
    	Thread.sleep(1000);
    	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/button_login").getText(), "登录"); 
    	Reporter.log("判断是否有登录按钮");
    }
    
    @DataProvider(name="fail04")
    public Object[][]Numbers4()throws BiffException,IOException{
    	ExcelData e=new ExcelData("teacherlogin","teacherfail04");
    	return e.getExcelData();
    }
    @Test(dataProvider="fail04")//(enabled=false)
    public void testLogin_fail04(HashMap<String,String>data)throws Exception{
    	//登录失败的情况-正确的教师账号和空密码
    	login.Role(driver, "teacher"); 
    	Reporter.log("选择教师角色");
    	login.Login(driver, data.get("thUserid"), data.get("thPassid")); 
    	Reporter.log("输入正确的教师账号和空密码");
    	Thread.sleep(1000);
    	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/button_login").getText(),  "登录"); 
    	Reporter.log("判断是否有登录按钮");
    }
    
    @DataProvider(name="fail05")
    public Object[][]Numbers5()throws BiffException,IOException{
    	ExcelData e=new ExcelData("teacherlogin","teacherfail05");
    	return e.getExcelData();
    }
    @Test(dataProvider="fail05")//(enabled=false)
    public void testLogin_fail05(HashMap<String,String>data)throws Exception{
    	//登录失败的情况-空的教师账号和密码
    	login.Role(driver, "teacher");  
    	Reporter.log("选择教师角色");
    	login.Login(driver, data.get("thUserid"), data.get("thPassid")); 
    	Reporter.log("输入空的教师账号和密码");
    	Thread.sleep(1000);
    	Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/button_login").getText(), "登录");
    	Reporter.log("判断是否有登录按钮");
    }
    
	@AfterMethod
	public void tearDown()throws Exception{
	driver.quit();//退出
}
}
