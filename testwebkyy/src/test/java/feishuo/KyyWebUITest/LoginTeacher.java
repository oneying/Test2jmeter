package feishuo.KyyWebUITest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.util.HashMap;
import jxl.read.biff.BiffException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTeacher extends BaseTest{
  WebDriver driver;
  private boolean acceptNextAlert = true;
  UITeacherLogin teacher=new UITeacherLogin();
 
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
  }


  @DataProvider(name="ok")
  public Object[][] Numbers() throws BiffException, IOException{
	  ExcelData e=new ExcelData("teacherlogin", "teacherok");
      return e.getExcelData();
  }
  @Test(dataProvider="ok")//(enabled = false)
  public void testLoginTeacher_OK(HashMap<String, String> data) throws Exception {
    // 教师登录：正常登录
    teacher.Teacherlogin(driver,data.get("thUserid"),data.get("thPassid"));   
    Reporter.log("输入正确的账号和密码"); //正常登录：正确的账号和密码
    Thread.sleep(2000);
    String title=driver.getTitle();
    Assert.assertEquals(title,"英语口语智能评测训练系统");  
    Reporter.log("能登录");//判断教师登录后是否进入英语口语智能评测训练系统
  }
  
  @DataProvider(name="fail01")
  public Object[][] Numbers1() throws BiffException, IOException{
	  ExcelData e=new ExcelData("teacherlogin", "teacherfail01");
      return e.getExcelData();
  }
  @Test(dataProvider="fail01")//(enabled = false)
  public void testLoginTeacher_fail01(HashMap<String, String> data) throws Exception {
    // 教师登录：输入错误密码的情况
    teacher.Teacherlogin(driver,data.get("thUserid"),data.get("thPassid"));   
    Reporter.log("输入正确的账号和错误的密码");//不能登录：错误密码
    Thread.sleep(2000);
    Assert.assertEquals(closeAlertAndGetItsText(), "用户名和密码不正确，请输入正确的用户密码重登陆!");  
    Reporter.log("不能登录");//判断密码错误，不能进入系统
  }
  
  @DataProvider(name="fail02")
  public Object[][] Numbers2() throws BiffException, IOException{
	  ExcelData e=new ExcelData("teacherlogin", "teacherfail02");
      return e.getExcelData();
  }
  @Test(dataProvider="fail02")//(enabled = false)
  public void testLoginTeacher_fail02(HashMap<String, String> data) throws Exception {
    // 教师登录：输入不存在的账号的情况
    teacher.Teacherlogin(driver,data.get("thUserid"),data.get("thPassid")); 
    Reporter.log("输入不存在的账号");//不能登录：没有此账号
    Thread.sleep(2000);
    Assert.assertEquals(closeAlertAndGetItsText(), "用户名和密码不正确，请输入正确的用户密码重登陆!");  Reporter.log("不能登录");//判断账号错误，不能进入系统
  }
  
  @Test//(enabled = false)
  public void testLoginTeacher_fail03() throws Exception {
    // 教师登录：账号和密码为空的情况
    teacher.Teacherlogin(driver,"",""); 
    Reporter.log("不输入账号和密码");//不能登录：空的账号和密码
    Thread.sleep(2000);
    Assert.assertEquals(closeAlertAndGetItsText(), "你所输入的 用户登录名 为空！"); 
    Reporter.log("不能登录");//判断账号密码为空，不能进入系统
  }
  
  @DataProvider(name="fail04")
  public Object[][] Numbers4() throws BiffException, IOException{
	  ExcelData e=new ExcelData("teacherlogin", "teacherfail04");
      return e.getExcelData();
  }
  @Test(dataProvider="fail04")//(enabled = false)
  public void testLoginTeacher_fail04(HashMap<String, String> data) throws Exception {
    // 教师登录：密码为空的情况
    teacher.Teacherlogin(driver,data.get("thUserid"),data.get("thPassid")); 
    Reporter.log("不输入密码");//不能登录：空密码
    Thread.sleep(2000);
    Assert.assertEquals(closeAlertAndGetItsText(), "你所输入的 密 码 为空！");
    Reporter.log("不能登录");//判断密码为空，不能进入系统
  }
  
  @DataProvider(name="fail05")
  public Object[][] Numbers5() throws BiffException, IOException{
	  ExcelData e=new ExcelData("teacherlogin", "teacherfail05");
      return e.getExcelData();
  }
  @Test(dataProvider="fail05")//(enabled = false)
  public void testLoginTeacher_fail05(HashMap<String, String> data) throws Exception {
    // 教师登录：账号为空的情况
    teacher.Teacherlogin(driver,data.get("thUserid"),data.get("thPassid")); 
    Reporter.log("不输入账号");//不能登录：空账号
    Thread.sleep(2000);
    Assert.assertEquals(closeAlertAndGetItsText(), "你所输入的 用户登录名 为空！");  
    Reporter.log("不能登录");//判断账号为空，不能进入系统
  }
  
  @Test//(enabled = false)
  public void testLoginTeacher_fail06() throws Exception {
    // 教师登录：密码为1位的情况
    teacher.Teacherlogin(driver,"teacher006","8"); 
    Reporter.log("密码输入长度1位");//不能登录：密码长度错误
    Thread.sleep(2000);
    Assert.assertEquals(closeAlertAndGetItsText(), "你输入的 密 码 长度必须限制在2到20之间");   Reporter.log("不能登录");//判断密码长度错误，不能进入系统
  }
  
  @Test//(enabled = false)
  public void testLoginTeacher_fail07() throws Exception {
    // 教师登录：密码为21位的情况
    teacher.Teacherlogin(driver,"teacher006","1234567890qwertyuiopA"); 
    Reporter.log("密码输入长度21位");//不能登录：密码长度错误
    Thread.sleep(2000);
    Assert.assertEquals(closeAlertAndGetItsText(), "你输入的 密 码 长度必须限制在2到20之间");  Reporter.log("不能登录");//判断密码长度错误，不能进入系统
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
