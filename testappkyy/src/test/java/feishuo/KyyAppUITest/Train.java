package feishuo.KyyAppUITest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Train {//同步训练

	public AndroidDriver driver;
	UILogin login=new UILogin();
	UIHomePage home=new UIHomePage();
	UIBooklist chooseBook=new UIBooklist();
	String Grade="com.kouyuyi.kyystuapp:id/id_recyclerview";//年级选择栏
	
	@BeforeClass
	public void setUp()throws Exception{
	//启动appium
		BaseTest device=new BaseTest();
		driver=device.getAndroidDriver();

	//学生-正常登录
		login.Role(driver, "student"); 
		Reporter.log("角色选择学生");
		login.Login(driver, "mzls01", "888888"); 
		Reporter.log("登录学生账号未订购mzls01");//输入正确的账号和正确的密码
		Thread.sleep(3000);
		//如有更新提示框，先关闭这个提示框
		driver.pressKeyCode(4);  
		Reporter.log("按返回键，取消更新提示框");
		Thread.sleep(1000);
		driver.pressKeyCode(4); 
		Reporter.log("按返回键，取消订购提示框");
		Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "首页");			     
	    //进入首页
		
		home.Training(driver);
		Reporter.log("进入同步训练");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(enabled=false)
	public void testChoose()throws Exception{
		//选择书本、单元
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean result=isElementExist(By .id(Grade));//年级选择栏
		if(result==false){  
			Reporter.log("如果进入了单元列表，可直接选单元");
			chooseBook.Unit(driver, 2); 
			Reporter.log("选择第3单元");
		}else{ 
			Reporter.log("如果进入了目录，要先选书本再选单元");
			chooseBook.Grade(driver, 1, 3);  
			Reporter.log("选择2年级和第3本书");
			chooseBook.Unit(driver, 2); 
			Reporter.log("选择第3单元");
		}
        chooseBook.Cancel(driver); 
        Reporter.log("点击取消");
	}
	
	@Test//(enabled=false)
	public void testTrainWord()throws Exception{
		//单词练习
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean result=isElementExist(By .id(Grade));//年级选择栏
		if(result==false){ 
			Reporter.log("如果进入了单元列表，可直接选单元");
			chooseBook.Unit(driver, 2); 
			Reporter.log("选择单元");
		}else{ 
			Reporter.log("如果进入了目录，要先选书本再选单元");
			chooseBook.Grade(driver, 1, 3); 
			Reporter.log("选择2年级和第3书本");
			chooseBook.Unit(driver, 2); 
			Reporter.log("选择第2单元");
		}
		
        chooseBook.Word(driver); 
        Reporter.log("点击单词练习");
        chooseBook.Download(driver); 
        Reporter.log("批量下载");
        boolean res1=isElementExist(By .name("我明白"));  
        Reporter.log("所有素材已下载完毕提示框");
        if(res1==true){
        	driver.findElementByName("我明白").click();  
        	Reporter.log("点击我明白");
        }
        chooseBook.Part(driver,0); 
        Reporter.log("选择第1Part");
        chooseBook.Play(driver); 
        Reporter.log("播放/停止播放单词");
        driver.findElementById("com.kouyuyi.kyystuapp:id/record_cp").click(); 
        Reporter.log("点击录音");
        boolean res2=isElementExist(By .name("我要订购"));//未订购提示框
        if(res2==true){ 
        	Reporter.log("未订购提示框");
        	driver.findElementByName("取消").click(); 
        	Reporter.log("点击取消");
        }
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElementById("com.kouyuyi.kyystuapp:id/record_cp").isEnabled());//录音按钮存在
        
        chooseBook.PlayList(driver);  
        Reporter.log("播放列表-点击底部的播放按钮");
        
        driver.pressKeyCode(4);  
        Reporter.log("返回Part");
        Thread.sleep(1000);
        
        chooseBook.Delete(driver); 
        Reporter.log("批量删除");
        chooseBook.NoDelete(driver); 
        Reporter.log("取消删除");
        chooseBook.Delete(driver); 
        Reporter.log("批量删除");
        chooseBook.YseDelete(driver); 
        Reporter.log("确定删除");
        Thread.sleep(1000);
        driver.pressKeyCode(4);  
        Reporter.log("返回单元列表");
	}
	
	@Test(enabled=false)
	public void testTrainText()throws Exception{
		//课文练习
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean result=isElementExist(By .id("com.kouyuyi.kyystuapp:id/id_recyclerview"));//年级选择栏
		if(result==false){ 
			Reporter.log("如果进入了单元列表，可直接选单元");
			chooseBook.Unit(driver, 2); 
			Reporter.log("选择第3单元");
		}else{ 
			Reporter.log("如果进入了目录，要先选书本再选单元");
			chooseBook.Grade(driver, 1, 3); 
			Reporter.log("选择1年级和第4本书");
			chooseBook.Unit(driver, 0);  
			Reporter.log("选择第1单元");
		}
		
        chooseBook.Text(driver); 
        Reporter.log("点击课文练习");
        chooseBook.Download(driver);  
        Reporter.log("批量下载");
        boolean res1=isElementExist(By .name("我明白"));//所有素材已下载完毕提示框
        if(res1==true){  
        	Reporter.log("所有素材已下载完毕提示框");
        	driver.findElementByName("我明白").click();   
        	Reporter.log("点击我明白");
        }
        chooseBook.Part(driver,0);   
        Reporter.log("选择第1Part");
        chooseBook.Play(driver);  
        Reporter.log("播放/停止播放句子");
        driver.findElementById("com.kouyuyi.kyystuapp:id/record_cp").click();  
        Reporter.log("点击录音");
        boolean res2=isElementExist(By .name("我要订购"));//未订购提示框
        if(res2==true){   
        	Reporter.log("未订购提示框");
        	driver.findElementByName("取消").click();  
        	Reporter.log("点击取消");
        }
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElementById("com.kouyuyi.kyystuapp:id/record_cp").isEnabled());
        
        chooseBook.PlayList(driver);   
        Reporter.log("播放列表-点击底部的播放按钮");
        
        driver.pressKeyCode(4);   
        Reporter.log("返回Part");
        Thread.sleep(1000);
        
        chooseBook.Delete(driver);  
        Reporter.log("批量删除");
        chooseBook.NoDelete(driver);  
        Reporter.log("取消删除");
        chooseBook.Delete(driver);  
        Reporter.log("批量删除");
        chooseBook.YseDelete(driver);   
        Reporter.log("确定删除");
        Thread.sleep(1000);
        driver.pressKeyCode(4);   
        Reporter.log("返回单元列表");
	}
	

	@Test(enabled=false)
	public void testChange()throws Exception{
		//更换教材
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean result=isElementExist(By .id("com.kouyuyi.kyystuapp:id/id_recyclerview"));//年级选择栏
		if(result==false){  
			Reporter.log("如果进入了单元列表，可直接选单元");
			chooseBook.Unit(driver, 2);  
			Reporter.log("选择第3单元");
		}else{   
			Reporter.log("如果进入了目录，要先选书本再选单元");
			chooseBook.Grade(driver, 1, 3);  
			Reporter.log("选择第2年级和第3本书");
			chooseBook.Unit(driver, 2);  
			Reporter.log("选择第3单元");
		}
        chooseBook.Cancel(driver);  
        Reporter.log("点击取消");
        
        chooseBook.Change(driver);  
        Reporter.log("点击书本名");
        chooseBook.Grade(driver, 2, 1);  
        Reporter.log("选择3年级和第1本书");
		chooseBook.Unit(driver, 1);  
		Reporter.log("选择第2单元");
		chooseBook.Cancel(driver);   
		Reporter.log("点击取消");
		
        chooseBook.Change(driver);  
        Reporter.log("点击书本名");
        chooseBook.Grade(driver, 1, 2);  
        Reporter.log("选择2年级和第2本书");
		chooseBook.Unit(driver, 0);
		Reporter.log("选择第1单元");
		chooseBook.Cancel(driver); 
		Reporter.log("点击取消");
        
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
