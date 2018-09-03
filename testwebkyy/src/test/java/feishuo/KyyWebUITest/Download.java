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

public class Download extends BaseTest{
  public WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @BeforeMethod(alwaysRun = true)
  @Parameters("browser")
  public void setUp(String browser) throws Exception {
	driver = this.getWebDriver(browser);  
	Reporter.log("===正在运行的浏览器是："+browser+"===");//要打开哪个浏览器，分别运行ie.xml,firefox.xml,chrome.xml即可
	web_ip IP=new web_ip();
	IP.getip(driver);//获得网址
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
  //从官网入下载中心
    UINavigationBar Na=new UINavigationBar();
    Na.DownloadCenter(driver); 
    Reporter.log("进入下载中心");
	Thread.sleep(1500);
  }
  //用chrome可自动下载；程序点击不到火狐的保存按钮；由于程序点击不到IE的保存按钮,IE会暂停运行，再手动点击下载的保存或取消，IE继续运行；
  @Test//(enabled=false)
  @Parameters("browser")
  public void testAboutInstall(String browser)throws Exception{
	  //安装说明
	  driver.findElement(By.linkText("安装说明")).click(); 
	  Reporter.log("安装说明");
	  Thread.sleep(1000);
  }
  
  @Test//(enabled=false)
  @Parameters("browser")
  public void testAboutInstall_TV(String browser)throws Exception{
	  //安装说明视频http://kouyuyi03.oss.aliyuncs.com/student.mp4
	  driver.findElement(By.linkText("安装说明视频")).click(); 
	  Reporter.log("安装说明视频");
	  Thread.sleep(1000);
  }
  
  @Test//(enabled=false)
  @Parameters("browser")
  public void testStudentPC(String browser)throws Exception{
	  //下载学生PC版
	  driver.findElement(By.xpath("//div[@class='download_pc']/div/a")).click(); 
	  Reporter.log("下载学生PC版");
	  Thread.sleep(1000);
  }
  
  @Test//(enabled=false)
  @Parameters("browser")
  public void testAndroid(String browser)throws Exception{
	//下载安卓版
	  driver.findElement(By.xpath("//div[@class='download_and']/div[@class='and_btn']/a")).click(); 
	  Reporter.log("下载安卓版");
	  Thread.sleep(1000);
  }
  
  @Test//(enabled=false)
  @Parameters("browser")
  public void testIOS(String browser)throws Exception{
	//下载苹果版https://itunes.apple.com/app/id1094104399
	  driver.findElement(By.xpath("//div[@class='download_ios']/div[@class='ios_btn']/a")).click(); 
	  Reporter.log("下载苹果版");
	  Thread.sleep(1000);
  }
  
  @Test//(enabled=false)
  @Parameters("browser")
  public void testTeacherPC(String browser)throws Exception{
	//下载教师PC版
	  driver.findElement(By.xpath("//div[@class='download_tea_pc']/div[@class='pc_tea_btn']/a")).click(); 
	  Reporter.log("下载教师PC版");
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