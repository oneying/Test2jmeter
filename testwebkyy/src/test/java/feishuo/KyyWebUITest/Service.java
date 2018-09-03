package feishuo.KyyWebUITest;

import java.util.regex.Pattern;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Service extends BaseTest{
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
    
    //从官网入关于我们
    UINavigationBar Na=new UINavigationBar();
    Na.AboutUs(driver); 
    Reporter.log("关于我们");
    Thread.sleep(1000);
    //客服中心
    driver.findElement(By.linkText("客服中心")).click(); 
    Reporter.log("客服中心");
    Thread.sleep(1500);
  }
  
  @Test//(enabled=false)
  @Parameters("browser")
  public void testService(String browser)throws Exception{
	  //用js把隐藏的显示出来 //chrome不行
	  JavascriptExecutor j=(JavascriptExecutor)driver;
	  j.executeScript("document.getElementById('div1').style.display='block';");
	  
	  driver.findElement(By.xpath("//div[@id='div1']/ul/li[2]/a/img")).click();  
	  Reporter.log("点击第1个客服");
	  Thread.sleep(1000);
	  Set<String>winHandles=driver.getWindowHandles();
	  List<String>it=new ArrayList<String>(winHandles);
	  driver.switchTo().window(it.get(1)); 
	  Reporter.log("跳转到打开的新窗口");
	  Assert.assertEquals(driver.findElement(By.id("open-webaio")).getText(), "发起网页聊天");  
	  Reporter.log("页面上有‘发起网页聊天’这行字");
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