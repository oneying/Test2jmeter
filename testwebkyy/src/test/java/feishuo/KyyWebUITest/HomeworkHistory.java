package feishuo.KyyWebUITest;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;


public class HomeworkHistory extends BaseTest{
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
    Reporter.log("进入教师频道");
    Thread.sleep(1000);
	UITeacherLogin teacher=new UITeacherLogin();
	teacher.Teacherlogin(driver,"teacher006","888888"); 
	Reporter.log("登录教师账号teacher006");//登录正确的账号和密码
	Thread.sleep(2000);
  // 历史作业
    driver.findElement(By.linkText("• 历史作业")).click(); 
    Reporter.log("历史作业");
    Thread.sleep(1500);
    
  }

  @Test//(enabled = false)
  public void testHwScore()throws Exception{
	  //查看详情-作业成绩
	    driver.findElement(By.linkText("查看详情")).click();   
	    Reporter.log("查看详情");
	    Thread.sleep(500);
	    Assert.assertTrue(driver.findElement(By.linkText("作业成绩")).isEnabled(),"页面有：作业成绩 这个链接");
	    Assert.assertTrue(driver.findElement(By.xpath("//table[@id='tb_01']/tbody/tr/td[3][contains(.,'学号')]")).isEnabled(), "页面有：学号 这行字");
  }
  
  @Test//(enabled = false)
  public void testHwContent()throws Exception{
	  //查看详情-作业内容
	    driver.findElement(By.linkText("查看详情")).click(); 
	    Reporter.log("查看详情");
	    Thread.sleep(500);
	    driver.findElement(By.linkText("作业内容")).click(); 
	    Reporter.log("作业内容");
	    Thread.sleep(500);
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='tab2']/div[2][contains(.,'作业要求')]")).isEnabled(), "页面有：作业要求 这行字");
  }
  
  @Test//(enabled = false)
  public void testHwUncommitted()throws Exception{
	  //查看详情-未交作业名单
	    driver.findElement(By.linkText("查看详情")).click();  
	    Reporter.log("查看详情");
	    Thread.sleep(500);
	    driver.findElement(By.linkText("未交作业名单")).click(); 
	    Reporter.log("未交作业名单");
	    Thread.sleep(500);
	    Assert.assertTrue(driver.findElement(By.xpath("//table[@id='tb_01']/tbody/tr/td[3][contains(.,'作业情况')]")).isEnabled(), "页面有：作业情况 这行字");
  }
  
  @Test//(enabled = false)
  public void testHwScorelist()throws Exception{
	  //查看详情-作业得分详情
	    driver.findElement(By.linkText("查看详情")).click();  
	    Reporter.log("查看详情");
	    Thread.sleep(500);
	    driver.findElement(By.linkText("作业得分详情")).click(); 
	    Reporter.log("作业得分详情");
	    Thread.sleep(500);
	    Assert.assertTrue(driver.findElement(By.xpath("//table[@id='tb_01']/tbody/tr/td[3][contains(.,'单元得分')]")).isEnabled(), "页面有：单元得分 这行字");
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='tab4']/div[2]/a[contains(text(),'批量写评语')]")).isEnabled(),"页面有：批量写评语 这个链接");
  }


  @Test//(enabled = false)
  public void testHwWriteCommentAll()throws Exception{
	  //历史作业-批量写评语,不选择学生的情况
	  driver.findElement(By.linkText("查看详情")).click();  
	  Reporter.log("查看详情");
	  Thread.sleep(500);
	  driver.findElement(By.linkText("作业得分详情")).click(); 
	  Reporter.log("作业得分详情");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//div[@id='tab4']/div[@class='TB_listTit']/a[contains(text(),'批量写评语')]")).click(); 
	  Reporter.log("批量写评语");
	  
	  //定位到批量写评语框
	  WebElement dFrame=driver.findElement(By.xpath("//div[@id='_DialogDiv_0']/div/div[@id='_Container_0']/iframe[@id='_DialogFrame_0']"));
      driver.switchTo().frame(dFrame);//iframe评语框id：_DialogFrame_0
      //点击分数
      driver.findElement(By.id("check-6")).click();
      driver.findElement(By.id("check-5")).click();
      driver.findElement(By.id("check-2")).click();
      driver.findElement(By.id("check-1")).click();
      driver.findElement(By.id("check-3")).click();
      driver.findElement(By.id("check-4")).click(); 
      Reporter.log("点击分数");
	  driver.findElement(By.id("popCommandBox")).click(); 
	  Reporter.log("点击常用语");
	  driver.findElement(By.id("closeMinPop")).click(); 
	  Reporter.log("关闭常用语");
	  driver.findElement(By.id("popCommandBox")).click(); 
	  Reporter.log("点击常用语");
	  driver.findElement(By.linkText("这次作业成绩不是很好，加油！")).click(); 
	  Reporter.log("选择评语");
	  driver.findElement(By.id("popCommandBox")).click();  
	  Reporter.log("点击常用语");
	  driver.findElement(By.linkText("很好！")).click();  
	  Reporter.log("选择评语");
	  driver.findElement(By.id("popCommandBox")).click();  
	  Reporter.log("点击常用语");
      driver.findElement(By.linkText("完成的不错！")).click();  
      Reporter.log("选择评语");
      
      //评语输入超过100字，系统提示：评语的内容不能超过100个字！（还可以输入0个字）
      driver.findElement(By.id("commandText")).sendKeys("test：这是输入的评语内容——字数超过100字： 口语易可以针对英语口语水平做出智能化评测。学生可进行跟读、并获得客观的打分，通过分数的高低判断自己英语发音的准确性，为英语学习者提供了一个敢说敢练的平台，与学校教育相辅相成，让孩子的英语口语水平得到大幅提高！"); 
      Reporter.log("输入评语");
      
      Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'评语的内容不能超过100个字')]")).isEnabled(),"弹框：评语的内容不能超过100个字"); 
      Reporter.log("提示框");
      driver.findElement(By.id("_ButtonCancel_0")).click();
      
      Assert.assertTrue(driver.findElement(By.xpath("//div[@class='commandTextTipBox']/span[contains(.,'（还可以输入0个字）')]")).isEnabled(),"页面有：'（还可以输入0个字）'这行字");  
      Reporter.log("判断字数");
      
      //点击确定，系统提示：请选择学生！
      driver.findElement(By.xpath("//div[@class='btnAreaBox']/a")).click(); 
      Reporter.log("点击确定");
      Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'请选择学生')]")).isEnabled(),"弹框：请选择学生");
      driver.findElement(By.id("_ButtonCancel_0")).click(); 
      Reporter.log("提示框");
       
      driver.switchTo().defaultContent();//离开iframe
	  driver.findElement(By.xpath("//div[@id='_Draghandle_0']/div"));  
	  Reporter.log("关闭评语框");
	
  }
  
  @Test//(enabled=false)
  public void testHomeworkHistoryFind() throws Exception {
	  //历史作业-搜索,选择班级的情况
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//div[@id='select-class']/i")).click();   
	  Reporter.log("点击展开下拉表");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//div[@id='select-class']/div/ul/li[2]")).click();  
	  Reporter.log("选择第1个班");//li[1]是--请选择--，li[2]是下拉表的第1个班
	  driver.findElement(By.cssSelector("input.srhBtnC")).click();  
	  Reporter.log("点击搜索");
	  Thread.sleep(500);
  }
  
  @Test//(enabled=false)
  public void testHwNextPage()throws Exception{
	  //历史作业-翻页
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
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
