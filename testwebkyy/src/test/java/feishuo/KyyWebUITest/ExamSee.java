package feishuo.KyyWebUITest;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class ExamSee extends BaseTest{
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
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//等待元素出现，最长等30秒
    
  //从官网入教师频道
    UINavigationBar Na=new UINavigationBar();
    Na.TeacherAbout(driver); 
    Reporter.log("进入教师频道");
    Thread.sleep(1000);
	UITeacherLogin teacher=new UITeacherLogin();
	teacher.Teacherlogin(driver,"mzteacher03","888888"); 
	Reporter.log("登录教师账号mzteacher03");//登录正确的账号和密码
	Thread.sleep(1500);
  // 考试列表
	if("firefox".equals(browser)||"ie".equals(browser)){
	  driver.findElement(By.linkText("考试管理")).click();  
	  Reporter.log("考试管理");
	  Thread.sleep(1000);
      driver.findElement(By.linkText("• 考试列表")).click();  
      Reporter.log("考试列表");
      Thread.sleep(1000);
	}else if("chrome".equals(browser)){
 	  Actions action=new Actions(driver);
 	  action.moveToElement(driver.findElement(By.linkText("考试管理"))).click().perform(); 
 	  Reporter.log("考试管理");
 	  Thread.sleep(1000);
      driver.findElement(By.linkText("• 考试列表")).click(); 
      Reporter.log("考试列表");
      Thread.sleep(1000); 
      action.release();
    }
  }

  @Test//(enabled = false)
  public void testExamSeeResult() throws Exception {
    // 考试列表：查看成绩
    driver.findElement(By.linkText("查看成绩")).click(); 
    Reporter.log("查看成绩");
    Thread.sleep(5000);
    Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table_type1']/tbody/tr/td[contains(text(),'班级人数')]")).isEnabled(), "页面有：班级人数 这行字");  
    Reporter.log("页面有：班级人数 这行字");
    driver.findElement(By.linkText("学生列表")).click(); 
    Reporter.log("学生列表");
    Thread.sleep(1000);
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='tab4']/table[@id='tb_01']/tbody/tr/td[2][contains(text(),'学生姓名')]")).isEnabled(), "页面有：学生姓名 这行字"); 
    Reporter.log("页面有：学生姓名 这行字");
    
  }
  
  @Test//(enabled = false)
  public void testExamSeeTest() throws Exception {
    // 考试列表：查看试题
    driver.findElement(By.linkText("查看试题")).click(); 
    Reporter.log("查看试题");
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("#_Draghandle_0 > div")).click(); 
    Reporter.log("关闭试题");
  }
  
  @Test//(enabled = false)
  public void testExamSeeFind() throws Exception {
	  //考试列表-搜索
	  driver.findElement(By.xpath("//div[@id='select-class']/input[2]")).click();  
	  Reporter.log("点击展开下拉表");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@id='select-class']/div/ul/li[1]")).click(); 
	  Reporter.log("li[1]是下拉表第1个班");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//div[@id='select-examType']/input[2]")).click();  
	  Reporter.log("点击展开下拉表");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@id='select-examType']/div/ul/li[2]")).click(); 
	  Reporter.log("li[1]是下拉表的全部，2是水平考试");
	  Thread.sleep(500);
	  driver.findElement(By.cssSelector("input.srhBtnC")).click();  
	  Reporter.log("点击搜索");
	  Thread.sleep(1000);
  }
  
  @Test//(enabled=false)
  public void testExamNextPage()throws Exception{
	  //考试列表-翻页
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
