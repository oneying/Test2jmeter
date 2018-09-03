package feishuo.KyyWebUITest;

import java.util.regex.Pattern;
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

public class Class3Aintroduce_chrome extends BaseTest{
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
    
  //从官网入教师频道
    UINavigationBar Na=new UINavigationBar();
    Na.TeacherAbout(driver); 
    Reporter.log(">>>进入教师频道");
    Thread.sleep(1000);
	UITeacherLogin teacher=new UITeacherLogin();
	teacher.Teacherlogin(driver,"mzteacher03","888888");  
	Reporter.log("输入教师账号登录：mzteacher03");//登录正确的账号和密码
	Thread.sleep(1500);
  }

  @Test//(enabled=false)
  public void test3Aresult() throws Exception {
	// 3A介绍-结果公布
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.linkText("3A课堂"))).click().perform(); 
	Reporter.log("点击3A课堂");
	Thread.sleep(1000);
	driver.findElement(By.linkText("• 3A介绍")).click();  
	Reporter.log("点击3A介绍");
	Thread.sleep(1000);
	Set<String>winHandles=driver.getWindowHandles();
	List<String>it=new ArrayList<String>(winHandles);
	driver.switchTo().window(it.get(1));  
	Reporter.log("跳转到打开的新窗口");

	driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[2]/a/span[contains(text(),'结果公布')]")).click(); 
	Reporter.log("点击结果公布");
	Thread.sleep(2000);
	action.release();//鼠标事件释放
  }
  
  @Test//(enabled=false)
  public void test3Aactivity() throws Exception {
	// 3A介绍-活动发文
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.linkText("3A课堂"))).click().perform(); 
	Reporter.log("点击3A课堂");
	Thread.sleep(1000);
	driver.findElement(By.linkText("• 3A介绍")).click(); 
	Reporter.log("点击3A介绍");
	Thread.sleep(1000);
	Set<String>winHandles=driver.getWindowHandles();
	List<String>it=new ArrayList<String>(winHandles);
	driver.switchTo().window(it.get(1)); 
	Reporter.log("跳转到打开的新窗口");

	driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[3]/a/span[contains(text(),'活动发文')]")).click(); 
	Reporter.log("点击活动发文");
    Thread.sleep(2000);
    action.release();
  }
  
  @Test//(enabled=false)
  public void test3Aupload() throws Exception {
	// 3A介绍-资源上传
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.linkText("3A课堂"))).click().perform(); 
	Reporter.log("点击3A课堂");
	Thread.sleep(1000);
	driver.findElement(By.linkText("• 3A介绍")).click(); 
	Reporter.log("点击3A介绍");
	Thread.sleep(1000);
	Set<String>winHandles=driver.getWindowHandles();
	List<String>it=new ArrayList<String>(winHandles);
	driver.switchTo().window(it.get(1)); 
	Reporter.log("跳转到打开的新窗口");

	driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[4]/a/span[contains(text(),'资源上传')]")).click(); 
	Reporter.log("点击资源上传");
	Thread.sleep(2000);
	action.release();
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
