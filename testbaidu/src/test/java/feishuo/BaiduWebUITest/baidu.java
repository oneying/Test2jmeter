package feishuo.BaiduWebUITest;

import java.util.regex.Pattern;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.fail;


public class baidu {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	  @Test(enabled=false)
	  public void testfirefox() throws Exception {
        //火狐
		  System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");  
	      driver = new FirefoxDriver(); 
	      driver.get("http://www.baidu.com/");
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.findElement(By.id("kw")).sendKeys("百科");
          driver.findElement(By.id("su")).click();
          Thread.sleep(1000);
          Reporter.log("This is firefox.这是火狐。");//信息输出到测试报告中
	      driver.quit();
	   
	  }
	  
	  @Test(enabled=false)
	  public void testchrome()throws Exception{
		  //谷歌
		  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	      driver = new ChromeDriver(); 
		  driver.get("http://www.baidu.com/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.findElement(By.id("kw")).sendKeys("百科");
	      driver.findElement(By.id("su")).click();
	      Thread.sleep(1000);
	      Reporter.log("This is chrome.这是谷歌。");//信息输出到测试报告中
		  //退出
		  driver.quit();
	  }

	  @Test(enabled=false)
	  public void testie() throws Exception {
		  //IE
		  System.setProperty("webdriver.ie.driver","C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer.exe");//32位
	      driver = new InternetExplorerDriver();
	      driver.get("http://www.baidu.com/");
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.findElement(By.id("kw")).sendKeys("百科");
          driver.findElement(By.id("su")).click();
          Thread.sleep(1000);
          Reporter.log("This is IE.这是IE。");//信息输出到测试报告中
	      driver.quit();
	  }
	  
	  @Test//(enabled=false)
	  public void testKyyPC() throws Exception {
		  //口语易学生pc端
          System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\口语易\\kyyclient.exe");
	      driver = new ChromeDriver(); 
		  //driver.get("http://www.baidu.com/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     // driver.findElement(By.id("kw")).sendKeys("百科");
	      //driver.findElement(By.id("su")).click();
	      Thread.sleep(1000);
	      Reporter.log("This is kyypc.这是口语易pc端。");//信息输出到测试报告中
		  //退出
		  driver.quit();
	  }
		 
}