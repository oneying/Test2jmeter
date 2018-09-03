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

public class Train extends BaseTest{
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
	Thread.sleep(2000);
	 
	//训练情况
	driver.findElement(By.linkText("训练情况")).click();  
	Reporter.log("训练情况");
	Thread.sleep(1500);
  }

  @Test//(enabled=false)
  public void testClassTrain() throws Exception {
	  //搜索某个班级
    driver.findElement(By.cssSelector("input.select-button")).click(); 
    Reporter.log("点击班级展开下拉表");
    Thread.sleep(200);
    driver.findElement(By.xpath("//div[@id='select-class']/div/ul/li[2]")).click(); 
    Reporter.log("选第2个班");//li[2]选第2个班
    Thread.sleep(200);
    driver.findElement(By.cssSelector("input.srhBtnC")).click(); 
    Reporter.log("搜索");
    Thread.sleep(1000);
    driver.findElement(By.linkText("查看详情")).click(); 
    Reporter.log("查看详情");
    Thread.sleep(3000);
    //学生详情页
    /*String[] handles=new String[driver.getWindowHandles().size()];
    driver.getWindowHandles().toArray(handles);
    for(int i=0;i<handles.length;i++){
    	System.out.println(handles[i]);//打印浏览器窗口id
    }*/
    Set<String>winHandels=driver.getWindowHandles();
    List<String>it=new ArrayList<String>(winHandels);
    driver.switchTo().window(it.get(1));//跳转到新打开的窗口
    Thread.sleep(1000);
    driver.close();//关闭当前新窗口
    driver.switchTo().window(it.get(0));//回到原有的窗口
    Thread.sleep(1000);
  }
  
  @Test//(enabled=false)
  public void testStuTrain() throws Exception {
	  //搜索某个班级某个学生
	  driver.findElement(By.cssSelector("input.select-button")).click(); 
	  Reporter.log("点击班级展开下拉表");
	  Thread.sleep(200);
	  driver.findElement(By.xpath("//div[@id='select-class']/div/ul/li[1]")).click(); 
	  Reporter.log("选第1个班");//li[1]选第1个班
	  Thread.sleep(200);
	  String NAME="pytest1";//某学生名
	  driver.findElement(By.name("userName")).sendKeys(NAME); 
	  Reporter.log("搜索学生"+NAME);
	  driver.findElement(By.cssSelector("input.srhBtnC")).click();  
	  Reporter.log("搜索");
	  Thread.sleep(1000);
	  //搜索结果
	  String stuName=driver.findElement(By.xpath("//table[@id='tb_01']/tbody/tr[3]/td[2]")).getText();
	  System.out.println(stuName);//打印搜索的学生名
	  Assert.assertEquals(stuName,NAME); 
	  Reporter.log("实际搜索出的学生名与输入的学生名是否一致");
	  
	  driver.findElement(By.linkText("查看详情")).click();  
	  Reporter.log("查看详情");
	  Thread.sleep(2000);
	  //学生详情页
	    String[] handles=new String[driver.getWindowHandles().size()];
	    driver.getWindowHandles().toArray(handles);
	    for(int i=0;i<handles.length;i++){
	    	System.out.println(handles[i]); 
	    	Reporter.log("打印浏览器窗口id"+handles[i]);
	    }
	  Set<String>winHandels=driver.getWindowHandles();
	  List<String>it=new ArrayList<String>(winHandels);
	  driver.switchTo().window(it.get(1)); 
	  Reporter.log("跳转到新打开的窗口");
	  Thread.sleep(1000);
	  //某学生的训练情况
	  String trainTitle=driver.findElement(By.xpath("//div[@class='tit_type1']/span")).getText();//标题：学生名+训练情况11
	  System.out.println(trainTitle);//打印学生训练情况的标题
	  String stu=trainTitle.substring(0, trainTitle.length()-6);//从右边开始去掉6个字符
	  System.out.println(stu);  
	  Reporter.log("打印获得学生名"+stu);
	  Assert.assertEquals(stu,NAME); 
	  Reporter.log("实际训练标题的学生名与输入的学生名是否一致");
	  
	  driver.close();  
	  Reporter.log("关闭当前新窗口");
	  driver.switchTo().window(it.get(0)); 
	  Reporter.log("回到原有的窗口");
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
