package feishuo.KyyWebUITest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import jxl.read.biff.BiffException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MyClass_ie extends BaseTest{
  WebDriver driver;
  private boolean acceptNextAlert = true;
 
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
    Reporter.log("进入教师频道");
    Thread.sleep(1000);
	UITeacherLogin teacher=new UITeacherLogin();
	teacher.Teacherlogin(driver,"teacher006","888888");  
	Reporter.log("登录教师账号teacher006");//登录正确的账号和密码
	Thread.sleep(1500);
	 
    // 班级管理
    driver.findElement(By.linkText("班级管理")).click();  
    Reporter.log("进入班级管理");
	Thread.sleep(1000);
  }

  @Test(enabled=false)
  public void testMyClass() throws Exception {
    //搜索某班级
	Select sel=new Select(driver.findElement(By.id("select-class")));//班级
	sel.selectByIndex(4);  
	Reporter.log("选第5个班");//(0)是下拉表的第1个班，(1)是第2个班
    driver.findElement(By.cssSelector("input.srhBtnC")).click();  
    Reporter.log("搜索");
    Thread.sleep(1000);
    driver.findElement(By.linkText("尾页")).click(); 
    Reporter.log("翻页");
    Thread.sleep(1000);
    driver.findElement(By.linkText("上页")).click(); 
    Reporter.log("上页");
    Thread.sleep(1000);
    driver.findElement(By.linkText("下页")).click();  
    Reporter.log("下页");
    Thread.sleep(1000);
    driver.findElement(By.linkText("首页")).click(); 
    Reporter.log("首页");
    Thread.sleep(1000);
    driver.findElement(By.linkText("下页")).click(); 
    Reporter.log("下页");
    Thread.sleep(1000);
  }

  @Test(enabled=false)
  public void testSearchStu() throws Exception {
    //搜索某班级某学生
	Select sel=new Select(driver.findElement(By.id("select-class")));//班级
	sel.selectByIndex(3); 
	Reporter.log("选第4个班");//(0)是下拉表的第1个班，(1)是第2个班
    driver.findElement(By.name("userName")).sendKeys("cs0006");   
    Reporter.log("搜学生名cs0006");
    driver.findElement(By.cssSelector("input.srhBtnC")).click();   
    Reporter.log("搜索");
    Thread.sleep(1000);
  }
  
  @Test(enabled=false)
  public void testSearchStatus() throws Exception {
    //搜索某班级使用状态
	Select sel=new Select(driver.findElement(By.id("select-class")));//班级
	sel.selectByIndex(3);  
	Reporter.log("选第4个班");//(0)是下拉表的第1个班，(1)是第2个班
    //使用状态
	Select sta=new Select(driver.findElement(By.id("select-status")));//使用状态
	sta.selectByValue("1");  
	Reporter.log("选未开通");//-1是不限，0是开通，1是未开通
    driver.findElement(By.cssSelector("input.srhBtnC")).click(); 
    Reporter.log("搜索");
    Thread.sleep(2000);
    Select stat=new Select(driver.findElement(By.id("select-status")));//使用状态
    stat.selectByValue("0"); 
    Reporter.log("选开通");//-1是不限，0是开通，1是未开通
    driver.findElement(By.cssSelector("input.srhBtnC")).click(); 
    Reporter.log("搜索");
    Thread.sleep(2000);
    }
  
  @Test//(enabled=false)
  public void testSearchStuSta() throws Exception {
    //搜索某班级某学生使用状态
	Select sel=new Select(driver.findElement(By.id("select-class")));//班级
	sel.selectByIndex(3); 
	Reporter.log("选第4个班");//(0)是下拉表的第1个班，(1)是第2个班
    //使用状态
	Select sta=new Select(driver.findElement(By.id("select-status")));//使用状态
	sta.selectByValue("1");  
	Reporter.log("选未开通");//-1是不限，0是开通，1是未开通
	driver.findElement(By.name("userName")).sendKeys("cs0006"); 
	Reporter.log("搜学生名cs0006");//搜学生名cs0006
    driver.findElement(By.cssSelector("input.srhBtnC")).click();  
    Reporter.log("搜索");
    Thread.sleep(1000);
  }
  
  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
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
