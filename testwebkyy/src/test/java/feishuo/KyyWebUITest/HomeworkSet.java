package feishuo.KyyWebUITest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomeworkSet extends BaseTest{
  public WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  UIHomeworkSet homeset=new UIHomeworkSet();
  
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
	teacher.Teacherlogin(driver,"mzteacher03","888888"); 
	Reporter.log("登录教师账号mzteacher03");//登录正确的账号和密码
	Thread.sleep(1500);
  // 布置作业
    driver.findElement(By.linkText("• 布置作业")).click();  
    Reporter.log("布置作业");
    Thread.sleep(1000);
    
  }

  @Test//(enabled = false)
  public void testHomeworkSet() throws Exception {
    //正常布置作业
	  
	    homeset.chooseclass(driver,"class-1"); 
	    Reporter.log("选择全部");//class-1是勾选全部
    
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    
    homeset.pop_1(driver); 
    Reporter.log("选常用语1");
    homeset.pop_close(driver); 
    Reporter.log("打开和关闭常用语框");

    homeset.chooesMsg(driver);
    Reporter.log("勾选发送短信");
    
    homeset.Msg_1(driver);  
    Reporter.log("选常用语1");
    homeset.msg_close(driver);  
    Reporter.log("打开和关闭常用语框");
    
    homeset.addhw(driver);//添加口语作业
    homeset.choosegrade(driver,"junior_0","grade_3","book-2"); 
    Reporter.log("选择年级和课本");
    homeset.chooseunit(driver,2,"ts1_1","tx1_1","ld1_1","bs1_1"); 
    Reporter.log("选择单元和素材");
    
    homeset.HomeworkSetOK(driver); 
    Reporter.log("提交作业");
    homeset.setOK(driver); 
    Reporter.log("确定发布作业");
    homeset.setOK(driver); 
    Reporter.log("确定发短信");
    
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'添加作业成功')]")).isEnabled(),"弹框：添加作业成功");
    homeset.cancel(driver);  
    Reporter.log("系统提示：添加作业成功");
  }
  
  @Test//(enabled = false)
  public void testNOclass() throws Exception {
    //不选择班级的情况
	  
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    
    homeset.setDemand("这是输入的作业要求。");
    homeset.homeworkdemand(driver); 
    Reporter.log("作业要求");
    
    homeset.addhw(driver); 
    Reporter.log("添加口语作业");
    homeset.choosegrade(driver,"junior_0","grade_3","book-2"); 
    Reporter.log("选择年级和课本");
    homeset.chooseunit(driver,2,"ts1_1","tx1_1","ld1_1","bs1_1"); 
    Reporter.log("选择单元和素材");

    homeset.HomeworkSetOK(driver); 
    Reporter.log("提交作业");
    
  //系统提示：请选择班级
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'请选择班级')]")).isEnabled(),"弹框：请选择班级");
    homeset.cancel(driver); 
    Reporter.log("系统提示：请选择班级");
    
    Assert.assertTrue(driver.findElement(By.id("class-1")).isEnabled(),"页面有：选择班级:全部");
  }

  @Test//(enabled = false)
  public void testNOdemand() throws Exception {
    //不填写作业要求的情况
	  	
    homeset.chooseclass(driver,"class-1"); 
    Reporter.log("班级全部");//class-1是勾选全部
	  
    /*homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    	
    homeset.chooesAudio(driver); 
    Reporter.log("不勾选录音");
    
    homeset.addhw(driver); 
    Reporter.log("添加口语作业");
    homeset.choosegrade(driver,"junior_0","grade_3","book-2"); 
    Reporter.log("选择年级和课本");
    homeset.chooseunit(driver,2,"ts1_1","tx1_1","ld1_1","bs1_1");  
    Reporter.log("选择单元和素材");
    
    homeset.HomeworkSetOK(driver); 
    Reporter.log("提交作业");
    
  //系统提示：请填写作业要求
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'请填写作业要求')]")).isEnabled(),"弹框：请填写作业要求");
    homeset.cancel(driver); 
    Reporter.log("系统提示：请填写作业要求");
    
    Assert.assertTrue(driver.findElement(By.id("class-1")).isEnabled(),"页面有：选择班级:全部");
  }
  
  @Test//(enabled = false)
  public void testNOmsg() throws Exception {
    //勾选短信通知但不填写短信内容的情况
	
	    homeset.chooseclass(driver,"class-1"); 
	    Reporter.log("班级全部");//class-1是勾选全部
    
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    
    homeset.setDemand("ps：这是输入的作业要求。");
    homeset.homeworkdemand(driver);  
    Reporter.log("作业要求");
    homeset.pop_close(driver); 
    Reporter.log("打开和关闭常用语框");

    homeset.chooesMsg(driver); 
    Reporter.log("勾选短信");
    
    homeset.addhw(driver); 
    Reporter.log("添加口语作业");
    homeset.choosegrade(driver,"junior_0","grade_3","book-2");
    Reporter.log("选择年级和课本");
    homeset.chooseunit(driver,2,"ts1_1","tx1_1","ld1_1","bs1_1"); 
    Reporter.log("选择单元和素材");
    
    homeset.HomeworkSetOK(driver);  
    Reporter.log("提交作业");
    
  //系统提示：请输入短信通知的内容
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'请输入短信通知的内容')]")).isEnabled(),"弹框：请输入短信通知的内容");
    homeset.cancel(driver); 
    Reporter.log("系统提示：请输入短信通知的内容");
    
    Assert.assertTrue(driver.findElement(By.id("class-1")).isEnabled(),"页面有：选择班级:全部");
 
  }

  @Test//(enabled = false)
  public void testdemandToolong() throws Exception {
    //作业要求超过50字的情况

	    homeset.chooseclass(driver,"class-1"); 
	    Reporter.log("班级全部");//class-1是勾选全部
    
    /*homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    
    homeset.setDemand("test：这是输入的作业要求——字数超过50字： 口语易可以针对英语口语水平做出智能化评测。学生可进行跟读、并获得客观的打分，通过分数的高低判断自己英语发音的准确性，为英语学习者提供了一个敢说敢练的平台，与学校教育相辅相成，让孩子的英语口语水平得到大幅提高！。");
    homeset.homeworkdemand(driver); 
    Reporter.log("输入作业要求");

    homeset.msg_close(driver);  
    Reporter.log("打开和关闭常用语框");
    
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Bz_homeworkStep1']/div[8]/div[2]/div/div/span[contains(.,'（还可以输入0个字）')]")).isEnabled(),"页面作业要求下有：（还可以输入0个字）这行字");
    
  }
  
  @Test//(enabled = false)
  public void testmsgToolong() throws Exception {
    //短信内容超过50字的情况	
	    homeset.chooseclass(driver,"class-1"); 
	    Reporter.log("班级全部");//class-1是勾选全部
    
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分*/
    
    homeset.setMsg("test：这是输入的短信内容——字数超过50字： 口语易可以针对英语口语水平做出智能化评测。学生可进行跟读、并获得客观的打分，通过分数的高低判断自己英语发音的准确性，为英语学习者提供了一个敢说敢练的平台，与学校教育相辅相成，让孩子的英语口语水平得到大幅提高！。");
    homeset.Msgtext(driver); 
    Reporter.log("短信内容");

    homeset.pop_close(driver);  
    Reporter.log("打开和关闭常用语框");
    
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Bz_homeworkStep1']/div[14]/div[2]/div/div/span[contains(.,'（还可以输入0个字）')]")).isEnabled(),"页面短信内容下有：（还可以输入0个字）这行字");
    
  }
  
  @Test//(enabled = false)
  public void testselect_0homework() throws Exception {
    //取消勾选口语素材（即选择0项素材）的情况
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	    homeset.chooseclass(driver,"class-1"); 
	    Reporter.log("班级全部");//class-1是勾选全部
    
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    
    homeset.pop_1(driver); 
    Reporter.log("选常用语1");
    
    homeset.addhw(driver);  
    Reporter.log("添加口语作业");
    homeset.choosegrade(driver,"junior_0","grade_3","book-2"); 
    Reporter.log("选择年级和课本");
    homeset.chooseunit(driver,2,"ts1_1","tx1_1","ld1_1","bs1_1"); 
    Reporter.log("选择单元和素材");
    
    for(int i=1;i<5;i++){//上面选了4个作业素材，Ced1-Ced4为取消第1到第4个素材
    	driver.findElement(By.id("Ced"+i)).click();
    } 
    Reporter.log("取消素材");
    
    homeset.HomeworkSetOK(driver); 
    Reporter.log("提交作业");
    
  //系统提示：请选择作业素材
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'请选择作业素材')]")).isEnabled(),"弹框：请选择作业素材");
    homeset.cancel(driver);  
    Reporter.log("系统提示：请选择作业素材");
    
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Bz_afterlistBox']/div[9]/div[contains(.,'已选择0项作业')]")).isEnabled(),"页面有：'已选择0项作业'这行字");
    
  }
  
  @Test//(enabled = false)
  public void testselect_1homework() throws Exception {
    //选择1项素材的情况
		
	    homeset.chooseclass(driver,"class-1"); 
	    Reporter.log("班级全部"); //class-1是勾选全部
    
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分*/
    
    homeset.pop_1(driver); 
    Reporter.log("选常用语1");
    
    homeset.addhw(driver);  
    Reporter.log("添加口语作业");
    homeset.choosegrade(driver,"junior_0","grade_3","book-2"); 
    Reporter.log("选择年级和课本");
    driver.findElement(By.id("ts1_1")).click(); 
    Reporter.log("选择1个素材");
    Thread.sleep(500);
    driver.findElement(By.id("confirmSC")).click(); 
    Reporter.log("确认选择");
	Thread.sleep(500);
    
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Bz_afterlistBox']/div[9]/div[contains(.,'已选择1项作业')]")).isEnabled(),"页面有：'已选择1项作业'这行字");
    
  }
  
  @Test//(enabled = false)
  public void testselect_10homework() throws Exception {
    //选择10项素材的情况	
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	    homeset.chooseclass(driver,"class-1"); 
	    Reporter.log("班级全部");//class-1是勾选全部
    
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分*/
    
    homeset.pop_1(driver);  
    Reporter.log("选常用语1");
    
    homeset.addhw(driver); 
    Reporter.log("添加口语作业");
    homeset.choosegrade(driver,"junior_0","grade_3","book-2"); 
    Reporter.log("选择年级和课本");
    homeset.chooseunit(driver,2,"ts1_1","tx1_1","ld1_1","bs1_1");  
    Reporter.log("选择第2单元和4个素材");
    homeset.amendhw(driver);  
    Reporter.log("修改口语作业");
    homeset.choosegrade(driver,"junior_0","grade_3","book-2");  
    Reporter.log("选择年级和课本");
    homeset.chooseunit(driver,3,"ts1_1","tx1_1","ld1_1","bs1_1"); 
    Reporter.log("选择第3单元和4个素材");
    homeset.amendhw(driver); 
    Reporter.log("修改口语作业");
    driver.findElement(By.id("ts1_1")).click();//选择1个素材
    driver.findElement(By.id("tx1_1")).click(); 
    Reporter.log("共选了10个素材");//选择1个素材，以上共选了10个素材
    Thread.sleep(500);
    driver.findElement(By.id("confirmSC")).click(); 
    Reporter.log("确认选择");
	Thread.sleep(500);
    
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Bz_afterlistBox']/div[9]/div[contains(.,'已选择10项作业')]")).isEnabled(),"页面有：'已选择10项作业'这行字");
    
  }
  
  @Test//(enabled = false)
  public void testselect_11homework() throws Exception {
    //选择11项素材的情况
	 	
	    homeset.chooseclass(driver,"class-1"); 
	    Reporter.log("班级全部");//class-1是勾选全部
	    
	    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分*/
	    
	    homeset.pop_1(driver); 
	    Reporter.log("选常用语1");
	    
	    homeset.addhw(driver); 
	    Reporter.log("添加口语作业");
	    homeset.choosegrade(driver,"junior_0","grade_3","book-2");  
	    Reporter.log("选择年级和课本");
	    homeset.chooseunit(driver,2,"ts1_1","tx1_1","ld1_1","bs1_1"); 
	    Reporter.log("选择第2单元和4个素材");
	    homeset.amendhw(driver); 
	    Reporter.log("修改口语作业");
	    homeset.choosegrade(driver,"junior_0","grade_3","book-2"); 
	    Reporter.log("选择年级和课本");
	    homeset.chooseunit(driver,3,"ts1_1","tx1_1","ld1_1","bs1_1"); 
	    Reporter.log("选择第3单元和4个素材");
	    homeset.amendhw(driver);  
	    Reporter.log("修改口语作业");
	    driver.findElement(By.id("ts1_1")).click(); 
	    Reporter.log("选择1个素材");
	    driver.findElement(By.id("tx1_1")).click(); 
	    Reporter.log("选择1个素材，以上共选了10个素材");
	    driver.findElement(By.id("ld1_1")).click(); 
	    Reporter.log("选择第11个素材");
	    Thread.sleep(500);
	    
	    //系统提示：不能选择超过10项作业
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'不能选择超过10项作业')]")).isEnabled(),"弹框：不能选择超过10项作业");
	    homeset.cancel(driver);  
	    Reporter.log("系统提示：不能选择超过10项作业");
	    
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Bz_homeworkStep2']/div[8]/div[contains(.,'已选择10项作业')]")).isEnabled(),"页面有：'已选择10项作业'这行字");
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
