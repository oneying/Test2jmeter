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

public class Class3A extends BaseTest{
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
    
  //从官网入3A课堂
    UINavigationBar Na=new UINavigationBar();
    Na.Class3A(driver); 
    Reporter.log(">>>进入3A课堂");
    Thread.sleep(1000);
  }

  @Test//(enabled=false)
  public void test3Aresult() throws Exception {
	//结果公布
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[2]/a/span[contains(text(),'结果公布')]")).click(); 
	Reporter.log("进入结果公布");
	Thread.sleep(1000);
    
	//操作垂直滚动条，向下移动到底部
	String setscroll = "document.documentElement.scrollTop=" + "3000";  
	JavascriptExecutor down=(JavascriptExecutor) driver; 
	down.executeScript(setscroll);  
	Reporter.log("页面向下滚动到底部");
	
   driver.findElement(By.xpath("//div[@class='filelist']/li[1]/a")).click(); 
	//driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/li[1]/a")).click(); 
	Reporter.log("点击第1个附件");
    Thread.sleep(1000);
  }
  
  @Test//(enabled=false)
  @Parameters("browser")
  public void test3Aactivity(String browser) throws Exception {
	//活动发文
	driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[3]/a/span[contains(text(),'活动发文')]")).click(); 
	Reporter.log("进入活动发文");
    Thread.sleep(1000);
    
	//操作垂直滚动条，向下移动到底部
	String setscroll = "document.documentElement.scrollTop=" + "3000";  
	JavascriptExecutor down=(JavascriptExecutor) driver; 
	down.executeScript(setscroll);  
	Reporter.log("页面向下滚动到底部");
	
    if("firefox".equals(browser)||"chrome".equals(browser)){//火狐和谷歌默认保存
        driver.findElement(By.xpath("//div[@class='filelist']/li[3]/a")).click(); 
        Reporter.log("点击第3个附件");
        Thread.sleep(1000);
    }else if("ie".equals(browser)){
    	Actions action=new Actions(driver);
	    action.moveToElement(driver.findElement(By.xpath("//div[@class='filelist']/li[3]/a"))).click().perform(); 
	    Reporter.log("点击第3个附件");
	    action.release();
	    Thread.sleep(1000);
	    //IE要点击保存按钮，才保存
	    Runtime.getRuntime().exec("C:/Users/admin/.jenkins/workspace/testwebkyy/src/test/resources/Download_ie.exe"); 
	    Reporter.log("点击保存");
    	Thread.sleep(1000);
        }
  }
  
  @Test//(enabled=false)
  public void test3Aupload_kyy() throws Exception {
	// 资源上传-口语易登录
	driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[4]/a/span[contains(text(),'资源上传')]")).click(); 
	Reporter.log("点击资源上传");
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//a[contains(text(),'口语易帐号登陆')])[2]")).click(); 
	Reporter.log("点击口语易账号登录");
	Thread.sleep(1000);
	driver.findElement(By.linkText("Ⅹ")).click(); 
	Reporter.log("关闭登录框");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[4]/a/span[contains(text(),'资源上传')]")).click(); 
	Reporter.log("点击资源上传");
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//a[contains(text(),'口语易帐号登陆')])[2]")).click(); 
	Reporter.log("点击口语易账号登录");
	Thread.sleep(1000);
    driver.findElement(By.id("username")).sendKeys("teacher006"); 
    Reporter.log("输入教师账号登录：teacher006");//输入账号密码登录
    driver.findElement(By.id("userpassword")).sendKeys("888888"); //ie里此处输入密码有问题 
    Reporter.log("输入密码：888888");
    Thread.sleep(500);
    driver.findElement(By.xpath("//h2[@class='kyyreg-title']")).click();//火狐出现警告信息，要点击其他区域取消警告，不然会点击不到登录按钮
    driver.findElement(By.id("loginsubmit")).click(); 
    Reporter.log("点击登录");
	Thread.sleep(1500);
	Set<String>winHandles=driver.getWindowHandles();
	List<String>it=new ArrayList<String>(winHandles);
	driver.switchTo().window(it.get(1)); 
	Reporter.log("跳转到打开的新窗口");
	Reporter.log("判断网址实际值与期望值是否一致");
	Assert.assertEquals(driver.getCurrentUrl(), "http://www.kouyuyi.com/user.do?action=checkLogin_akt");
  }
  
  @Test(enabled=false)
  public void test3Aupload_hjy() throws Exception {
	// 资源上传-和教育登录
	driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[4]/a/span[contains(text(),'资源上传')]")).click(); 
	Reporter.log("点击资源上传");
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//a[contains(text(),'操作指南')])[2]")).click(); 
	Reporter.log("点击操作指南");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='menu_nav']/ul/li[4]/a/span[contains(text(),'资源上传')]")).click(); 
	Reporter.log("点击资源上传");
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//a[contains(text(),'和教育(校讯通)帐号登陆')])[2]")).click();  
	Reporter.log("点击和教育登录");
	Thread.sleep(1000);
	Set<String>winHandles=driver.getWindowHandles();
	List<String>it=new ArrayList<String>(winHandles);
	driver.switchTo().window(it.get(1));  
	Reporter.log("跳转到打开的新窗口");
    driver.findElement(By.id("userName")).sendKeys("13763327191"); 
    Reporter.log("输入和教育账号：13763327191");//输入和教育账号和密码
    driver.findElement(By.id("pwd")).sendKeys("12345678"); 
    Reporter.log("输入密码:12345678");
    driver.findElement(By.className("sub")).click();
    Reporter.log("点击‘授权并登录’");
	Thread.sleep(5000);
	Reporter.log("判断网址实际值与期望值是否一致");
	Assert.assertEquals(driver.getCurrentUrl(), "http://open.ydxxt.com/oauth/login.do?action=selectUserType");
  }
  
  @Test//(enabled=false)
  public void test3Aback()throws Exception{
	  Reporter.log("返回英语易首页");
	  driver.findElement(By.xpath("//div[@class='head']/a[2]/img")).click();
	  Thread.sleep(1500);
	  Reporter.log("判断网址实际值与期望值是否一致");
	  Assert.assertEquals(driver.getCurrentUrl(), "http://www.kouyuyi.com/");
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
