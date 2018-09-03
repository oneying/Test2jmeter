package feishuo.KyyAppUITest;

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

public class Play {

	public AndroidDriver driver;
	UILogin login=new UILogin();
	UIHomePage home=new UIHomePage();
	UIPlay play=new UIPlay();

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
	
	home.Play(driver);  
	Reporter.log("进入播放");
	Thread.sleep(3000);
}

@Test//(enabled=false)
public void testPlay()throws Exception{
	//播放
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 Reporter.log("删除按钮是否存在");
	while(isElementExist(By .id("com.kouyuyi.kyystuapp:id/item_delete_btn"))==true){	
		play.Delete(driver); 
		Reporter.log("点击删除");
	    play.Delete_yes(driver); 
	    Reporter.log("点击确定");
	}
	boolean result=isElementExist(By .id("com.kouyuyi.kyystuapp:id/pause_btn"));//播放按钮是否存在
	//System.out.println(result);
	if(result==true){ 
		Reporter.log("如果进入了播放，可直接下载");
		play.Download(driver); 
		Reporter.log("选择下载1个音频");
	}else{ 
		Reporter.log("如果进入了目录，要先选书本");
		play.Grade(driver, 1, 3); 
		Reporter.log("选择2年级和第3本书");
		play.Download(driver);  
		Reporter.log("选择下载1个音频");
	}
	
	Thread.sleep(3000);
	play.Check(driver);  
	Reporter.log("勾选1个音频");
	play.Pause(driver);  
	Reporter.log("点击播放");
	Thread.sleep(1000);
	play.Pause(driver); 
	Reporter.log("再次点击暂停播放");
	
}

@Test//(enabled=false)
public void testChange()throws Exception{
//更换教材
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
Reporter.log("删除按钮是否存在");
while(isElementExist(By .id("com.kouyuyi.kyystuapp:id/item_delete_btn"))==true){	
	play.Delete(driver); 
	Reporter.log("点击删除");
    play.Delete_yes(driver); 
    Reporter.log("点击确定");
}
boolean result=isElementExist(By .id("com.kouyuyi.kyystuapp:id/pause_btn"));//播放按钮是否存在
System.out.println(result);
if(result==true){ 
	Reporter.log("如果进入了播放，可直接下载");
	play.Download(driver); 
	Reporter.log("选择下载1个音频");
}else{ 
	Reporter.log("如果进入了目录，要先选书本");
	play.Grade(driver, 1, 3); 
	Reporter.log("选择2年级和第3本书");
	play.Download(driver); 
	Reporter.log("选择下载1个音频");
}

play.Change(driver); 
Reporter.log("点击书本名更换教材");
play.Grade(driver, 3, 2); 
Reporter.log("选择4年级和第2本书");
play.Download(driver); 
Reporter.log("选择下载1个音频");
Thread.sleep(3000);
play.Check(driver);  
Reporter.log("勾选1个音频");
play.Pause(driver);  
Reporter.log("点击播放");
Thread.sleep(1000);
play.Pause(driver);  
Reporter.log("再次点击暂停播放");
}

@Test//(enabled=false)
public void testStatu()throws Exception{
	//播放模式-单循环播放
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Reporter.log("删除按钮是否存在");
	while(isElementExist(By .id("com.kouyuyi.kyystuapp:id/item_delete_btn"))==true){	
		play.Delete(driver); 
		Reporter.log("点击删除");
	    play.Delete_yes(driver); 
	    Reporter.log("点击确定");
	}
	boolean result=isElementExist(By .id("com.kouyuyi.kyystuapp:id/pause_btn"));//播放按钮是否存在
	System.out.println(result);
	if(result==true){ 
		Reporter.log("如果进入了播放，可直接下载");
		play.Download(driver); 
		Reporter.log("选择下载1个音频");
	}else{  
		Reporter.log("如果进入了目录，要先选书本");
		play.Grade(driver, 1, 3);
		Reporter.log("选择2年级和第3本书");
		play.Download(driver); 
		Reporter.log("选择下载1个音频");
	}
	
	Thread.sleep(3000);
	play.CheckStatu(driver); 
	Reporter.log("点击变成单循环播放");
	play.Name(driver);  
	Reporter.log("点击音频名播放");
	Thread.sleep(1000);
	play.Pause(driver); 
	Reporter.log("点击暂停播放");
	play.CheckStatu(driver);  
	Reporter.log("点击变成自定义播放");
	
}

@Test//(enabled=false)
public void testList()throws Exception{
	//下一首/上一首
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//删除按钮是否存在
	while(isElementExist(By .id("com.kouyuyi.kyystuapp:id/item_delete_btn"))==true){	
		play.Delete(driver);  
		Reporter.log("点击删除");
	    play.Delete_yes(driver); 
	    Reporter.log("点击确定");
	}
	boolean result=isElementExist(By .id("com.kouyuyi.kyystuapp:id/pause_btn"));//播放按钮是否存在
	//System.out.println(result);
	if(result==true){ 
		Reporter.log("如果进入了播放，可直接下载");
		//下载按钮是否存在
		while(isElementExist(By .id("com.kouyuyi.kyystuapp:id/item_download_btn"))==true){	
			play.Download(driver); 
			Reporter.log("下载音频");
			Thread.sleep(5000);
		}
		
	}else{ 
		Reporter.log("如果进入了目录，要先选书本");
		play.Grade(driver, 1, 3); 
		Reporter.log("选择2年级和第3本书");
		//下载按钮是否存在
		while(isElementExist(By .id("com.kouyuyi.kyystuapp:id/item_download_btn"))==true){	
			play.Download(driver); 
			Reporter.log("下载音频");
			Thread.sleep(5000);
			}
	}
	
    play.Check(driver); 
    Reporter.log("勾选音频");
	
	play.Pause(driver); 
	Reporter.log("点击播放");
	Thread.sleep(1000);
	play.Next(driver); 
	Reporter.log("点击下一首按钮");
	Thread.sleep(1000);
	play.Pre(driver); 
	Reporter.log("点击上一首按钮");
	Thread.sleep(1000);
	play.Pause(driver);  
	Reporter.log("再次点击暂停播放");
	play.List(driver); 
	Reporter.log("点击展开音频列表");
	Thread.sleep(1000);
	play.List(driver);  
	Reporter.log("再次点击收起音频列表");
	
	play.CheckStatu(driver); 
	Reporter.log("点击变成单循环播放");
	play.Name(driver); 
	Reporter.log("点击音频名播放");
	play.Next(driver);  
	Reporter.log("点击下一首按钮");
	Thread.sleep(1000);
	play.Pre(driver);  
	Reporter.log("点击上一首按钮");
	Thread.sleep(1000);
	play.Pause(driver); 
	Reporter.log("点击暂停播放");
	play.CheckStatu(driver); 
	Reporter.log("点击变成自定义播放");
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

