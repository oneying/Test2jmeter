package feishuo.KyyWebUITest;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class HomeworkSee_chrome extends BaseTest{
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
	Thread.sleep(1500);
  // 作业列表
     
    Thread.sleep(1000);
    
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
  }

  @Test//(enabled = false)
  public void testHwset()throws Exception{
	  //作业列表里的布置作业
	 
	  String classname_result,classid_result,chooseclassid_result;
	  
	  int i=1;//如果有多个班，1是列表第1个班，2是第2个班
	  
	  //班级名
	  String classname=driver.findElement(By.xpath("//div[@id='c_homeworklist']/div["+i+"]/div/span")).getText();
	  classname_result=classname.substring(3);  
	  Reporter.log("班级名"+classname_result);//获得classname里第3个及之后的字符，得到班级名
	 
	  //班级id对应的链接
	  String classid=driver.findElement(By.xpath("//div[@id='c_homeworklist']/div["+i+"]/div/a")).getAttribute("href");
	  classid_result=classid.substring(55);  
	  Reporter.log("班级id"+classid_result);//获得classid里第55个及之后的字符，得到班级id
	  
	  //点击班级名右边的布置作业
	  driver.findElement(By.xpath("//div[@id='c_homeworklist']/div["+i+"]/div/a[contains(text(),'布置作业')]")).click(); 
	  Reporter.log("点击班级名右边的布置作业");
	  Thread.sleep(1000);
	  
	//转到布置作业页面，判断哪个班被选中
	  //获得已勾选的班级名
	  String chooseclassname=driver.findElement(By.xpath("//div[@id='Bz_homeworkStep1']/div[3]/div[2]/div/ul/*/div/div/div/label[@class='checked']")).getText();
	 
	  //获得已勾选的班级id
	  String chooseclassid=driver.findElement(By.xpath("//div[@id='Bz_homeworkStep1']/div[3]/div[2]/div/ul/*/div/div/div/input[@checked='']")).getAttribute("id");
	  chooseclassid_result=chooseclassid.substring(6);//获得chooseclassid里第6个及之后的字符，得到班级id
	  /*
	  System.out.print(chooseclassname);
	  System.out.println("="+classname_result);
	  System.out.print(chooseclassid_result);
	  System.out.println("="+classid_result);
	  */
	  Assert.assertEquals(chooseclassname, classname_result,"错误：布置作业里勾选的班级名与作业列表选的班级名不一致");
	  Assert.assertEquals(chooseclassid_result, classid_result,"错误：布置作业里勾选的班级id与作业列表选的班级id不一致");  
	  Reporter.log("转到布置作业页面，"+chooseclassname+",id:"+chooseclassid_result+"班被选中");
	  
  }
  
  @Test//(enabled = false)
  public void testHwcheck()throws Exception{
	  //作业列表-检查作业-作业成绩
	  driver.findElement(By.linkText("检查作业")).click();  
	  Reporter.log("检查作业");
	  Assert.assertTrue(driver.findElement(By.linkText("作业成绩")).isEnabled(),"页面有：作业成绩 这个链接");
	  Assert.assertTrue(driver.findElement(By.linkText("批量写评语")).isEnabled(),"页面有：批量写评语 这个链接");
	  Assert.assertTrue(driver.findElement(By.xpath("//table[@id='tb_01']/tbody/tr/td[3][contains(.,'学号')]")).isEnabled(), "页面有：学号 这行字");

  }
  
  @Test//(enabled = false)
  public void testHwContent01()throws Exception{
	  //检查作业-作业内容
	    driver.findElement(By.linkText("检查作业")).click();  
	    Reporter.log("检查作业");
	    Thread.sleep(500);
	    driver.findElement(By.linkText("作业内容")).click();  
	    Reporter.log("检查作业");
	    Thread.sleep(500);
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='tab2']/div[2][contains(.,'作业要求')]")).isEnabled(), "页面有：作业要求 这行字");
  }
  
  @Test//(enabled = false)
  public void testHwUncommitted01()throws Exception{
	  //检查作业-未交作业名单
	    driver.findElement(By.linkText("检查作业")).click(); 
	    Reporter.log("检查作业");
	    Thread.sleep(500);
	    driver.findElement(By.linkText("未交作业名单")).click(); 
	    Reporter.log("未交作业名单");
	    Thread.sleep(500);
	    Assert.assertTrue(driver.findElement(By.xpath("//table[@id='tb_01']/tbody/tr/td[3][contains(.,'作业情况')]")).isEnabled(), "页面有：作业情况 这行字");
}
  
  @Test//(enabled = false)
  public void testHwScorelist01()throws Exception{
	  //检查作业-作业得分详情
	    driver.findElement(By.linkText("检查作业")).click(); 
	    Reporter.log("检查作业");
	    Thread.sleep(500);
	    driver.findElement(By.linkText("作业得分详情")).click(); 
	    Reporter.log("作业得分详情");
	    Thread.sleep(500);
	    Assert.assertTrue(driver.findElement(By.xpath("//table[@id='tb_01']/tbody/tr/td[3][contains(.,'单元得分')]")).isEnabled(), "页面有：单元得分 这行字");
	    Assert.assertTrue(driver.findElement(By.linkText("批量写评语")).isEnabled(),"页面有：批量写评语 这个链接");
}
  @Test//(enabled = false)
  public void testHwWriteCommentAll()throws Exception{
	  //检查作业-批量写评语,不选择学生的情况
	  Actions action=new Actions(driver);
	  
	  driver.findElement(By.linkText("检查作业")).click();  
	  Reporter.log("检查作业");
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("批量写评语")).click();   
	  Reporter.log("批量写评语");
	  
	  //定位到批量写评语框
	  WebElement dFrame=driver.findElement(By.xpath("//div[@id='_DialogDiv_0']/div/div[@id='_Container_0']/iframe[@id='_DialogFrame_0']"));
      driver.switchTo().frame(dFrame);//iframe评语框id：_DialogFrame_0
      //点击分数
      action.moveToElement(driver.findElement(By.id("check-6"))).click().perform();
      action.moveToElement(driver.findElement(By.id("check-4"))).click().perform();
      action.moveToElement(driver.findElement(By.id("check-2"))).click().perform();
      action.moveToElement(driver.findElement(By.id("check-1"))).click().perform();
      action.moveToElement(driver.findElement(By.id("check-3"))).click().perform();
      action.moveToElement(driver.findElement(By.id("check-5"))).click().perform(); 
      Reporter.log("点击分数");
      action.release();
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
