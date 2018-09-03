package feishuo.KyyWebUITest;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePage extends BaseTest{
    public WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
		    
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
	driver = this.getWebDriver(browser); 
	Reporter.log("===正在运行的浏览器是："+browser+"===");//要打开哪个浏览器，分别运行ie.xml,firefox.xml,chrome.xml即可
	web_ip IP=new web_ip();
	IP.getip(driver);  
	Reporter.log("进入官网");//获得网址,进入首页
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	    
	
	}

	@Test(enabled = false)
	public void testLinkHomePage()throws Exception{	
		//点击首页
	    UINavigationBar Na=new UINavigationBar();
	    Na.HomePage(driver);   
	    Reporter.log("进入首页");
	    Thread.sleep(1000);
	    System.out.println(driver.getCurrentUrl());
	    Assert.assertEquals(driver.getCurrentUrl(), "http://www.kouyuyi.com/", "首页网址");
	    }
	
	@Test(enabled = false)
	public void testLinkTeacher()throws Exception{	
		//点击教师频道
	    UINavigationBar Na=new UINavigationBar();
	    Na.TeacherAbout(driver);  
	    Reporter.log("进入教师频道");
	    Thread.sleep(1000);
	    System.out.println(driver.getCurrentUrl());
	    Assert.assertEquals(driver.getCurrentUrl(), "http://www.kouyuyi.com/user.do?action=tlogin", "教师频道网址");
	    }
	
	@Test(enabled = false)
	public void testLinkParent()throws Exception{	
		//点击家长频道
	    UINavigationBar Na=new UINavigationBar();
	    Na.ParentAbout(driver);  
	    Reporter.log("进入家长频道");
	    Thread.sleep(1000);
	    System.out.println(driver.getCurrentUrl());
	    Assert.assertEquals(driver.getCurrentUrl(), "http://www.kouyuyi.com/user.do?action=plogin", "家长频道网址");
	    }
	
	@Test(enabled = false)
	public void testLinkDownload()throws Exception{	
		//点击下载中心
	    UINavigationBar Na=new UINavigationBar();
	    Na.DownloadCenter(driver); 
	    Reporter.log("进入下载中心");
	    Thread.sleep(1000);
	    System.out.println(driver.getCurrentUrl());
	    Assert.assertEquals(driver.getCurrentUrl(), "http://www.kouyuyi.com/new_download.html", "下载中心网址");
	    }
	
	@Test(enabled = false)
	public void testLinkClass3A()throws Exception{	
		//点击3A课堂
	    UINavigationBar Na=new UINavigationBar();
	    Na.Class3A(driver); 
	    Reporter.log("进入3A课堂");
	    Thread.sleep(1000);
	    System.out.println(driver.getCurrentUrl());
	    Assert.assertEquals(driver.getCurrentUrl(), "http://www.kouyuyi.com/3AKT/", "3A课堂网址");
	    }
	
	@Test(enabled = false)
	public void testLinkActivity()throws Exception{	
		//点击活动中心
	    UINavigationBar Na=new UINavigationBar();
	    Na.ActivityCenter(driver); 
	    Reporter.log("进入活动中心");
	    Thread.sleep(1000);
	    System.out.println(driver.getCurrentUrl());
	    Assert.assertEquals(driver.getCurrentUrl(), "http://www.kouyuyi.com/act_center.html", "活动中心网址");
	    }
	
	@Test(enabled = false)
	public void testLinkAboutUs()throws Exception{	
		//点击关于我们
	    UINavigationBar Na=new UINavigationBar();
	    Na.AboutUs(driver); 
	    Reporter.log("进入关于我们");
	    Thread.sleep(1000);
	    System.out.println(driver.getCurrentUrl());
	    Assert.assertEquals(driver.getCurrentUrl(), "http://www.kouyuyi.com/new_aboutus.html", "关于我们网址");
	    }
	
	@Test//(enabled=false)
	@Parameters("browser")
	public void testUP(String browser)throws Exception{
		//回到顶部

		//操作垂直滚动条，向下移动600像素
		//if("firefox".equals(browser)||"ie".equals(browser)){
		String setscroll = "document.documentElement.scrollTop=" + "600";  
		JavascriptExecutor down=(JavascriptExecutor) driver; 
		down.executeScript(setscroll);
		//}else if("chrome".equals(browser)){
		//String setscroll = "document.body.scrollTop=" + "600";  
		//JavascriptExecutor down=(JavascriptExecutor) driver; 
		//down.executeScript(setscroll);
		//}  
		Reporter.log("页面向下滚动");
		Thread.sleep(500); 
		//点击向上箭头按钮 
        driver.findElement(By.id("floatup")).click(); 
        Reporter.log("回到顶部");
        Thread.sleep(500);
	}
	
	@Test(enabled=false)
	public void testQQ1()throws Exception{
		//悬浮的QQ图标
		//点击QQ图标
        WebElement w1=driver.findElement(By.id("floatqq"));
        WebElement w2=driver.findElement(By.xpath("//li[@id='floatqq']/div/p[3]/a/span"));//点击列表的第3个
        Actions action=new Actions(driver);
        action.clickAndHold(w1).build().perform();
        Reporter.log("点击悬浮的QQ图标");//火狐不行
	    w2.click(); 
	    Reporter.log("点击列表里的第3个客服");
		Thread.sleep(1000);
	}
	
	@Test//(enabled=false)
	@Parameters("browser")
	public void testBottomQQ(String browser)throws Exception{
		//底部的服务QQ
		//操作垂直滚动条，向下移动到底部
		
		String setscroll = "document.documentElement.scrollTop=" + "3000";  
		JavascriptExecutor down=(JavascriptExecutor) driver; 
		down.executeScript(setscroll);  
		Reporter.log("页面向下滚动到底部");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='service_con']/ul/li[3]/a/span")).click(); 
		Reporter.log("点击第3个QQ");
        Thread.sleep(1000);
	}
	
	@Test//(enabled=false)
	@Parameters("browser")
	public void testBottomUs(String browser)throws Exception{
		//底部的关于我们
		//操作垂直滚动条，向下移动到底部
		
		String setscroll = "document.documentElement.scrollTop=" + "3000";  
		JavascriptExecutor down=(JavascriptExecutor) driver; 
		down.executeScript(setscroll);
		Reporter.log("页面向下滚动到底部");
		Thread.sleep(1000);
		driver.findElement(By.linkText("关于我们")).click(); 
		Reporter.log("点击关于我们");
        Thread.sleep(1000);
	    Assert.assertEquals(driver.getCurrentUrl(), "http://www.kouyuyi.com/new_aboutus.html", "关于我们网址");
	}
	
	@AfterMethod(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
