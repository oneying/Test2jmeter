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

public class Parents extends BaseTest{
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
    
  //从官网入家长频道
    UINavigationBar Na=new UINavigationBar();
    Na.ParentAbout(driver); 
    Reporter.log("进入家长频道");
    Thread.sleep(1000);
    UIParentLogin parent=new UIParentLogin();
    parent.Parentlogin(driver, "cs0012", "888888");  
    Reporter.log("登录账号cs0012");
	Thread.sleep(1500);
  }

  @Test//(enabled=false)
  public void testChildScore() throws Exception {
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	  WebElement childframe=driver.findElement(By.xpath("//div[@id='sidebar']/iframe[@id='iFrame2']"));
	  driver.switchTo().frame(childframe);
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("cs0012")).click();  
	  Reporter.log("点击孩子名cs0012");
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();//离开childframe
	  //作业成绩
	  driver.findElement(By.linkText("作业成绩")).click(); 
	  Reporter.log("作业成绩");
	  Thread.sleep(1000);
	  //查看作业得分详情框
	  driver.findElement(By.xpath("//table[@id='tb_lc']/tbody/*/td/span[contains(text(),'查看详细')]")).click(); 
	  Reporter.log("查看详细");//已提交作业才有‘查看详细’
	  Thread.sleep(1000);
	  //查看作业录音回放框
	  WebElement homeworkframe=driver.findElement(By.xpath("//div[@id='_Container_0']/iframe[@id='_DialogFrame_0']"));
	  driver.switchTo().frame(homeworkframe);
	  driver.findElement(By.xpath("//img[@alt='听录音']")).click(); 
	  Reporter.log("听录音");
	  Thread.sleep(1000);
	  //关闭作业录音回放框
	  driver.findElement(By.xpath("//tr[@id='_Draghandle_0']/td[2]/div[2]")).click();  
	  Reporter.log("关闭作业录音回放框");
	  driver.switchTo().defaultContent();//离开homeworkframe
	  Thread.sleep(1000);
	  //关闭作业得分详情框
	  driver.findElement(By.xpath("//tr[@id='_Draghandle_0']/td[2]/div[2]")).click(); 
	  Reporter.log("关闭作业得分详情框");
	  //翻页-作业多才有翻页
	  
	  driver.findElement(By.linkText("下页")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("尾页")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("上页")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("首页")).click();
	  Thread.sleep(1000);
	  
  }
  
  @Test//(enabled=false)
  public void testChildTrain() throws Exception {
	  //训练成绩
	  WebElement childframe=driver.findElement(By.xpath("//div[@id='sidebar']/iframe[@id='iFrame2']"));
	  driver.switchTo().frame(childframe);
	  driver.findElement(By.linkText("cs0012")).click(); 
	  Reporter.log("点击孩子名cs0012");
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();//离开childframe
	  driver.findElement(By.linkText("训练成绩")).click(); 
	  Reporter.log("训练成绩");
	  Thread.sleep(1000);
	  //翻页
	  driver.findElement(By.linkText("下页")).click(); 
	  Reporter.log("下页");
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("尾页")).click(); 
	  Reporter.log("尾页");
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("上页")).click();
	  Reporter.log("上页");
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("首页")).click(); 
	  Reporter.log("首页");
	  Thread.sleep(1000);
	  //今日作业
	  driver.findElement(By.linkText("今日作业")).click(); 
	  Reporter.log("今日作业");
	  Thread.sleep(1000);
  }
  
  @Test//(enabled=false)
  public void testAddChild() throws Exception {
	  //添加其他孩子账号
	  String childname="mztest003";//正确的账号
	  String childpasswd="888888";//正确的密码
	  WebElement childframe=driver.findElement(By.xpath("//div[@id='sidebar']/iframe[@id='iFrame2']"));
	  driver.switchTo().frame(childframe);
	  driver.findElement(By.name("userName")).sendKeys(childname); 
	  Reporter.log("输入孩子账号"+childname);
	  driver.findElement(By.name("pwd")).sendKeys(childpasswd); 
	  Reporter.log("输入孩子账号的密码"+childpasswd);
	  driver.findElement(By.cssSelector("td > input[name=\"button1\"]")).click(); 
	  Reporter.log("点击新增");
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("mztest003")).click(); 
	  Reporter.log("查看新增孩子的今日作业");
	  driver.switchTo().defaultContent();//离开childframe
	  Thread.sleep(1000);
	  //输入相同的账号
	  // 页面刷新，需要重新获取元素，否则会报错
	  childframe=driver.findElement(By.xpath("//div[@id='sidebar']/iframe[@id='iFrame2']"));
	  driver.switchTo().frame(childframe);
	  driver.findElement(By.name("userName")).sendKeys(childname); 
	  Reporter.log("输入孩子账号"+childname);
	  driver.findElement(By.name("pwd")).sendKeys(childpasswd); 
	  Reporter.log("输入孩子账号的密码"+childpasswd);
	  driver.findElement(By.cssSelector("td > input[name=\"button1\"]")).click();
	  Reporter.log("点击新增");
	  Thread.sleep(1000);
	  assertEquals(closeAlertAndGetItsText(), "添加的帐号已存在");  
	  Reporter.log("该孩子账号已存在，不能再新增");
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();//离开childframe
	  //取消删除新增的孩子账号
	  // 页面刷新，需要重新获取元素，否则会报错
	  childframe=driver.findElement(By.xpath("//div[@id='sidebar']/iframe[@id='iFrame2']"));
	  driver.switchTo().frame(childframe);
	  driver.findElement(By.xpath("//div[@class='l_box']/ul/li[2]/span/input")).click(); 
	  Reporter.log("删除新增孩子");
	  Thread.sleep(1000);
	  driver.switchTo().alert().dismiss();  
	  Reporter.log("取消删除");
	  Thread.sleep(1000); 
	  driver.switchTo().defaultContent();//离开childframe
	  //删除新增的孩子账号
	  // 页面刷新，需要重新获取元素，否则会报错
	  childframe=driver.findElement(By.xpath("//div[@id='sidebar']/iframe[@id='iFrame2']"));
	  driver.switchTo().frame(childframe);
	  driver.findElement(By.xpath("//div[@class='l_box']/ul/li[2]/span/input")).click(); 
	  Reporter.log("删除新增孩子");
	  Thread.sleep(1000);
	  assertEquals(closeAlertAndGetItsText(), "删除后将不能恢复,确认要删除吗？"); 
	  Reporter.log("确定删除");
	  Thread.sleep(1000); 
	  driver.switchTo().defaultContent();//离开childframe
  }
  
  @Test//(enabled=false)
  public void testChildPwd()throws Exception{
	  String childname="mztest003";//孩子账号
	  //输入错误的密码
	  WebElement childframe=driver.findElement(By.xpath("//div[@id='sidebar']/iframe[@id='iFrame2']"));
	  driver.switchTo().frame(childframe);
	  driver.findElement(By.name("userName")).sendKeys(childname);  
	  Reporter.log("输入孩子账号"+childname);
	  driver.findElement(By.name("pwd")).sendKeys("1234567ab");   
	  Reporter.log("输入错误密码1234567ab");
	  driver.findElement(By.cssSelector("td > input[name=\"button1\"]")).click(); 
	  Reporter.log("点击新增");
	  Thread.sleep(1000);
	  assertEquals(closeAlertAndGetItsText(), "用户名密码错误");  
	  Reporter.log("密码错误，不能新增");
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();//离开childframe
	  //不输入密码
	  childframe=driver.findElement(By.xpath("//div[@id='sidebar']/iframe[@id='iFrame2']"));
	  driver.switchTo().frame(childframe);
	  driver.findElement(By.name("userName")).sendKeys(childname);  
	  Reporter.log("输入孩子账号"+childname);
	  driver.findElement(By.name("pwd")).sendKeys(""); 
	  Reporter.log("不输入密码");
	  driver.findElement(By.cssSelector("td > input[name=\"button1\"]")).click(); 
	  Reporter.log("点击新增");
	  Thread.sleep(1000);
	  assertEquals(closeAlertAndGetItsText(), "用户名密码错误"); 
	  Reporter.log("密码错误，不能新增");
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();//离开childframe
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