package feishuo.KyyWebUITest;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class ExamSet extends BaseTest{
  public WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  UIExamSet examset=new UIExamSet();
  
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
  // 创建考试
	driver.findElement(By.linkText("考试管理")).click();  
	Reporter.log("考试管理");
	Thread.sleep(1000);
	driver.findElement(By.linkText("• 创建考试")).click(); 
	Reporter.log("创建考试");
    Thread.sleep(1000);
  }

  @Test//(enabled = false)
  public void testExamSet() throws Exception {
    // 创建考试-正常创建考试
   examset.chooseclass(driver, "class-1");  
   Reporter.log("选择班级全部");
   /*
    //不设时间就默认今天
   examset.time(driver, "2017,4,18", "2017,4,19");//考试时间
   examset.ftime_hm(driver, "09","00");//开始时分
   examset.etime_hm(driver, "13","30");//结束时分
   */
   examset.pop_1(driver);  
   Reporter.log("考试要求，常用语1");
   
   examset.chooesAudio(driver); 
   Reporter.log("勾选提交录音");
   examset.showScore(driver, 2);  
   Reporter.log("勾选全部显示分数");
   
   examset.chooesMsg(driver); 
   Reporter.log("勾选短信通知");
   examset.Msg_1(driver); 
   Reporter.log("短信内容，常用语1");
   
   examset.addexam(driver); 
   Reporter.log("添加口语考试");
   examset.chooseExamPaper(driver, 2); 
   Reporter.log("查看并选择第1行试卷");
   
   examset.ExamSetOK(driver); 
   Reporter.log("确认提交");
   examset.setOK(driver); 
   Reporter.log("确定发送短信");
   
   Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'创建考试成功')]")).isEnabled(),"弹框：创建考试成功");
   examset.cancel(driver);  
   Reporter.log("系统提示：创建考试成功");
  }
  
  @Test//(enabled = false)
  public void testExamNoclass() throws Exception {
    // 创建考试-不选择班级
   /*
    //不设时间就默认今天
   examset.time(driver, "2017,4,18", "2017,4,19");//考试时间
   examset.ftime_hm(driver, "09","00");//开始时分
   examset.etime_hm(driver, "13","30");//结束时分
   */
   examset.pop_1(driver);  
   Reporter.log("考试要求，常用语1");

   examset.pop_close(driver); 
   Reporter.log("关闭考试要求常用语框");
   examset.msg_close(driver); 
   Reporter.log("关闭短信内容常用语框");
   
   examset.addexam(driver);  
   Reporter.log("添加口语考试");
   examset.chooseExamPaper(driver, 2);  
   Reporter.log("查看并选择第1行试卷");
   
   examset.ExamSetOK(driver); 
   Reporter.log("确认提交");

   Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'请选择班级')]")).isEnabled(),"弹框：请选择班级");
   examset.cancel(driver);  
   Reporter.log("系统提示：请选择班级");
  }
  
  @Test//(enabled = false)
  public void testExamNodemend() throws Exception {
    // 创建考试-不填写考试要求
   examset.chooseclass(driver, "class-1");  
   Reporter.log("选择班级全部");
   /*
    //不设时间就默认今天
   examset.time(driver, "2017,4,18", "2017,4,19");//考试时间
   examset.ftime_hm(driver, "09","00");//开始时分
   examset.etime_hm(driver, "13","30");//结束时分
   */
  
   examset.chooesAudio(driver);  
   Reporter.log("不勾选提交录音");
   examset.showScore(driver, 3);  
   Reporter.log("勾选付费用户显示分数");
   
   examset.chooesMsg(driver);  
   Reporter.log("勾选短信通知");
   examset.Msg_2(driver);   
   Reporter.log("短信内容，常用语2");
   
   examset.addexam(driver);   
   Reporter.log("添加口语考试");
   examset.chooseExamPaper(driver, 2);   
   Reporter.log("查看并选择第1行试卷");
   
   examset.ExamSetOK(driver);   
   Reporter.log("确认提交");

   Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'请填写考试要求')]")).isEnabled(),"弹框：请填写考试要求");
   examset.cancel(driver);   
   Reporter.log("系统提示：请填写考试要求");
  }
  
  @Test//(enabled = false)
  public void testExamNomsg() throws Exception {
    // 创建考试-勾选短信通知但不填写短信内容
   examset.chooseclass(driver, "class-1");  
   Reporter.log("选择班级全部");
   /*
    //不设时间就默认今天
   examset.time(driver, "2017,4,18", "2017,4,19");//考试时间
   examset.ftime_hm(driver, "09","00");//开始时分
   examset.etime_hm(driver, "13","30");//结束时分
   */
   examset.pop_2(driver);   
   Reporter.log("考试要求，常用语1");
   
   examset.chooesAudio(driver);  
   Reporter.log("勾选提交录音");
   examset.showScore(driver, 2);   
   Reporter.log("勾选全部显示分数");
   
   examset.chooesMsg(driver);  
   Reporter.log("勾选短信通知");
   
   examset.addexam(driver);  
   Reporter.log("添加口语考试");
   examset.chooseExamPaper(driver, 3);  
   Reporter.log("查看并选择第2行试卷");
   
   examset.ExamSetOK(driver);//确认提交
  
   Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'请输入短信通知的内容')]")).isEnabled(),"弹框：请输入短信通知的内容");
   examset.cancel(driver);   
   Reporter.log("系统提示：请输入短信通知的内容");
  }
  
  @Test//(enabled = false)
  public void testExamDemendtooLong() throws Exception {
    // 创建考试-考试要求字数超过50字
   examset.chooseclass(driver, "class-1"); 
   Reporter.log("选择班级全部");
   /*
    //不设时间就默认今天
   examset.time(driver, "2017,4,18", "2017,4,19");//考试时间
   examset.ftime_hm(driver, "09","00");//开始时分
   examset.etime_hm(driver, "13","30");//结束时分
   */
 //考试要求，输入超过50字
   examset.setDemand("test：这是输入的考试要求——字数超过50字： 口语易可以针对英语口语水平做出智能化评测。学生可进行跟读、并获得客观的打分，通过分数的高低判断自己英语发音的准确性，为英语学习者提供了一个敢说敢练的平台，与学校教育相辅相成，让孩子的英语口语水平得到大幅提高！");
   examset.demand(driver);  
   Reporter.log("输入考试要求");
  
   Assert.assertTrue(driver.findElement(By.xpath("//div[@class='requireTextTipBox']/span[contains(.,'（还可以输入0个字）')]")).isEnabled(),"考试要求输入框下（还可以输入0个字）的判断是否正确");  
   Reporter.log("判断考试要求字数");
 
}
  @Test//(enabled = false)
  public void testExamMsgtooLong() throws Exception {
    // 创建考试-短信内容字数超过50字
   examset.chooseclass(driver, "class-1"); 
   Reporter.log("选择班级全部");
   /*
    //不设时间就默认今天
   examset.time(driver, "2017,4,18", "2017,4,19");//考试时间
   examset.ftime_hm(driver, "09","00");//开始时分
   examset.etime_hm(driver, "13","30");//结束时分
   */
 //短信内容，输入超过50字
   examset.setMsg("test：这是输入的短信内容——字数超过50字： 口语易可以针对英语口语水平做出智能化评测。学生可进行跟读、并获得客观的打分，通过分数的高低判断自己英语发音的准确性，为英语学习者提供了一个敢说敢练的平台，与学校教育相辅相成，让孩子的英语口语水平得到大幅提高！");
   examset.Msgtext(driver);  
   Reporter.log("输入短信内容");
  
   Assert.assertTrue(driver.findElement(By.xpath("//div[@class='msgTextTipBox']/span[contains(.,'（还可以输入0个字）')]")).isEnabled(),"短信内容输入框下（还可以输入0个字）的判断是否正确"); 
   Reporter.log("判断短信内容字数");
}
  
  @Test//(enabled = false)
  public void testExamChange() throws Exception {
    // 创建考试-修改口语考试
   examset.chooseclass(driver, "class-1"); 
   Reporter.log("选择班级全部");
   /*
    //不设时间就默认今天
   examset.time(driver, "2017,4,18", "2017,4,19");//考试时间
   examset.ftime_hm(driver, "09","00");//开始时分
   examset.etime_hm(driver, "13","30");//结束时分
   */
 //考试要求，输入不超过50字
   examset.setDemand("test：这是输入的考试要求~~~"); 
   examset.demand(driver);  
   Reporter.log("输入考试要求");
 
   examset.chooesAudio(driver);  
   Reporter.log("勾选提交录音");
   examset.showScore(driver, 2); 
   Reporter.log("勾选全部显示分数");

   examset.addexam(driver);  
   Reporter.log("添加口语考试");
   examset.chooseExamPaper(driver, 2); 
   Reporter.log("查看并选择第1行试卷");

   //修改口语考试
   examset.amendhw(driver); 
   Reporter.log("修改口语考试");
   examset.chooseExamPaper(driver, 5); 
   Reporter.log("查看并选择第4行试卷");

   examset.ExamSetOK(driver); 
   Reporter.log("确认提交");

   Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'创建考试成功')]")).isEnabled(),"弹框：创建考试成功");
   examset.cancel(driver);  
   Reporter.log("系统提示：创建考试成功");
  }
  
  @Test//(enabled = false)
  public void testExamSearch() throws Exception {
    // 创建考试-搜索考试试卷
   examset.addexam(driver); 
   Reporter.log("添加口语考试");
   driver.findElement(By.linkText("下一页")).click(); 
   Reporter.log("下一页");
   Thread.sleep(300);
   driver.findElement(By.linkText("上一页")).click(); 
   Reporter.log("上一页");
   Thread.sleep(300);
   examset.choosegrade(driver, "1010"); 
   Reporter.log("选高一");
   examset.chooseType(driver, 1);  
   Reporter.log("选听力考试");
   examset.search(driver);  
   Reporter.log("点击搜索");
   Thread.sleep(1000);
   examset.choosegrade(driver, "1006"); 
   Reporter.log("选六年级");
   examset.chooseType(driver, 0); 
   Reporter.log("选水平考试");
   examset.search(driver); 
   Reporter.log("点击搜索");
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
