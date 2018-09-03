package feishuo.KyyWebUITest;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity extends BaseTest{
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
	Reporter.log("进入官网");//获得网址
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	    
	
	//从官网入活动 中心
    UINavigationBar Na=new UINavigationBar();
    Na.ActivityCenter(driver); 
    Reporter.log(">>>进入活动中心");
    Thread.sleep(2000);
	}

	@Test//(enabled = false)
	public void testBanner()throws Exception{
	//banner链接
		Actions action=new Actions(driver);//谷歌和IE可以action，火狐不可以
		int i=2; 
		Reporter.log("i=2");
		action.moveToElement(driver.findElement(By.xpath("//div[@id='banner_tabs']/ol[@id='bannerCtrl']/li["+i+"]"))).perform(); 
		Reporter.log("鼠标悬停选中banner上的第"+i+"个圆形按钮");
		Thread.sleep(1000);
		action.release();// 释放鼠标操作
		driver.findElement(By.xpath("//div[@id='banner_tabs']/ul[@class='slides']/li["+i+"]")).click(); 
		Reporter.log("点击第"+i+"张banner图片");
		Thread.sleep(1000);
    }
	
	@Test//(enabled = false)
	public void testPast()throws Exception{
	//往期大赛
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("往期口语大赛")).click();  
		Reporter.log("进入往期口语大赛");
		Thread.sleep(1500);
		Select sel=new Select(driver.findElement(By.name("year"))); 
		Reporter.log("选择年份");
		sel.selectByValue("2015");  
		Reporter.log("选择2015年");//-1是全部，2015是2015年
		Thread.sleep(1500);
		//div[x]是列表里第x个大赛
		//driver.findElement(By.xpath("//body/table[3]/tbody/tr/td/div/div[4]/table/tbody/tr[1]/td[2]/a/img")).click();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//body/table[3]/tbody/tr/td/div/div[4]/table/tbody/tr[1]/td[2]/a/img"))).click().perform();
		Reporter.log("选择第4个大赛");
		Thread.sleep(1500);
		driver.navigate().back(); 
		Reporter.log("浏览器后退一页");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[1]")).click(); 
		Reporter.log("点击首页");
		Thread.sleep(1000);
	}
	
	@Test//(enabled = false)
	public void testNextpage()throws Exception{
	//往期大赛-翻页
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("往期口语大赛")).click(); 
		Reporter.log("进入往期口语大赛");
		Thread.sleep(1500);
		String setscroll = "document.documentElement.scrollTop=" + "3000";  
		JavascriptExecutor down=(JavascriptExecutor) driver; 
		down.executeScript(setscroll);  
		Reporter.log("页面向下滚动到底部");
		Thread.sleep(1000);
		driver.findElement(By.linkText("尾页")).click(); 
		Reporter.log("点击尾页");
		Thread.sleep(1000);

		down.executeScript(setscroll);  
		Reporter.log("页面向下滚动到底部");
		driver.findElement(By.linkText("上页")).click(); 
		Reporter.log("点击上页");
		Thread.sleep(1000);
		
		down.executeScript(setscroll);  
		Reporter.log("页面向下滚动到底部");
		driver.findElement(By.linkText("下页")).click();  
		Reporter.log("点击下页");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='wq_fenyeDIV']/a[contains(text(),'首页')]")).click(); 
		Reporter.log("点击翻页按钮栏的首页");
		Thread.sleep(1000);
	}
	
	@Test//(enabled = false)
	public void testIntroduce()throws Exception{
	//口语易介绍，关于我们
		driver.findElement(By.linkText("口语易介绍")).click(); 
		Reporter.log("点击口语易介绍");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[1]")).click(); 
		Reporter.log("点击首页");
		Thread.sleep(1000);
		driver.findElement(By.linkText("关于我们")).click();
		Reporter.log("点击关于我们");
		Thread.sleep(1000);
	}
	
	@Test//(enabled = false)
	public void test3A()throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[5]")).click(); 
		Reporter.log("点击3A课堂");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='head']/a[2]")).click();
		Reporter.log("点击返回英语易首页");
		Thread.sleep(1000);
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
