package feishuo.KyyWebUITest;


import java.util.regex.Pattern;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class lessonBeforeShow extends BaseTest{
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
	teacher.Teacherlogin(driver,"teacher006","888888");  
	Reporter.log("登录教师账号teacher006");//登录正确的账号和密码
	Thread.sleep(2000);
  // 课前秀
	driver.findElement(By.linkText("课前秀")).click(); 
	Reporter.log("进入课前秀");
    Thread.sleep(1500);
  }
//火狐浏览器：点不到‘更换教材’的“确定”按钮
  @Test//(enabled=false)
  public void testLessonBeforeShow() throws Exception {
    // 课前秀
	 
	WebElement kxqFrame = driver.findElement(By.xpath("//div[@id='kqxRcontent']/iframe[@id='kqx-frame']"));
    driver.switchTo().frame(kxqFrame);
    driver.findElement(By.xpath("//div[@class='select_junior']/ul/li[2]/a")).click();  
    Reporter.log("初中");//li[2]选择初中
    driver.findElement(By.linkText("九年级")).click(); 
    Reporter.log("九年级");
    driver.findElement(By.id("book-313")).click(); 
    Reporter.log("选课本");
    driver.findElement(By.xpath("//div[@class='subBookBox']/div/a[1]")).click(); 
    Reporter.log("确定");
    Thread.sleep(2000);
    driver.findElement(By.linkText("更换素材")).click(); 
    Reporter.log("更换素材");
    driver.findElement(By.xpath("//div[@class='select_junior']/ul/li[1]/a")).click(); 
    Reporter.log("小学");//li[1]选择小学
    driver.findElement(By.linkText("三年级")).click(); 
    Reporter.log("3年级");
    driver.findElement(By.id("book-10085")).click(); 
    Reporter.log("选课本");
    driver.findElement(By.xpath("//div[@class='subBookBox']/div/a[1]")).click(); 
    Reporter.log("确定");
    driver.findElement(By.id("item_lesson_10208")).click(); 
    Reporter.log("选单元");
    Thread.sleep(2000);
    driver.findElement(By.linkText("更换素材")).click(); 
    Reporter.log("更换素材");
    driver.findElement(By.xpath("//div[@class='select_junior']/ul/li[3]/a")).click(); 
    Reporter.log("高中");//li[3]选择高中
    driver.findElement(By.linkText("高二")).click();  
    Reporter.log("高二");
    driver.findElement(By.id("book-320")).click(); 
    Reporter.log("选课本");
    driver.findElement(By.xpath("//div[@class='subBookBox']/div/a[1]")).click(); 
    Reporter.log("确定");
    driver.findElement(By.id("item_lesson_320105")).click();  
    Reporter.log("选单元");
    Thread.sleep(2000);
    //视频
    driver.findElement(By.xpath("//div[@id='tab1']/div/ul/li[3]")).click(); 
    Reporter.log("第3个视频");//li[3]为第3个视频
    Thread.sleep(2000);
    driver.findElement(By.linkText("查看题目")).click(); 
    Reporter.log("查看题目");
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("#_Draghandle_0 > div")).click();  
    Reporter.log("关闭");//关闭
    driver.findElement(By.linkText("教学介绍")).click(); 
    Reporter.log("教学介绍");
    Thread.sleep(1000);
    driver.findElement(By.linkText("课前秀")).click(); 
    Reporter.log("返回课前秀");//返回课前秀
    Thread.sleep(2000);
    //音频
    driver.findElement(By.xpath("//div[@id='tab1']/div/ul/li[1]")).click(); 
    Reporter.log("第1个音频");//li[1]为第1个音频
    Thread.sleep(2000);
    driver.findElement(By.linkText("完整显示模式")).click(); 
    Reporter.log("完整显示模式");
    driver.findElement(By.linkText("听歌填词模式")).click();  
    Reporter.log("听歌填词模式");
    Thread.sleep(1000);
    driver.findElement(By.linkText("教学介绍")).click(); 
    Reporter.log("教学介绍");
    Thread.sleep(1000);
    driver.findElement(By.linkText("课前秀")).click(); 
    Reporter.log("返回课前秀");
    Thread.sleep(2000);
    //什么是课前秀
    driver.findElement(By.linkText("什么是课前秀?")).click(); 
    Reporter.log("什么是课前秀");
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("#_Draghandle_0 > div")).click(); 
    Reporter.log("关闭");
    Thread.sleep(200);

    driver.switchTo().defaultContent();
    
  }

  @Test//(enabled=false)
  @Parameters("browser")
  public void testDownload(String browser)throws Exception{
	  //下载文本
	    WebElement kxqFrame = driver.findElement(By.xpath("//div[@id='kqxRcontent']/iframe[@id='kqx-frame']"));
	    driver.switchTo().frame(kxqFrame);
	    driver.findElement(By.xpath("//div[@class='select_junior']/ul/li[2]/a")).click(); 
	    Reporter.log("初中");//li[2]选择初中
	    driver.findElement(By.linkText("八年级")).click(); 
	    Reporter.log("八年级");
	    driver.findElement(By.xpath("//div[@class='subBookBox']/div/a[1]")).click(); 
	    Reporter.log("确定");//确定
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@id='tab1']/div/ul/li[1]")).click(); 
	    Reporter.log("第1个素材");//li[1]为第1个
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("下载文本")).click();  
	    Reporter.log("下载文本");//程序点击不到火狐的保存按钮
	    Thread.sleep(1000);
	    if("ie".equals(browser)){//IE要点击保存按钮，才保存到默认路径
	        Runtime.getRuntime().exec("C:\\Users\\admin\\.jenkins\\workspace\\testwebkyy\\src\\test\\resources\\Download_ie.exe");
	        Thread.sleep(5000);
	        }
	    driver.switchTo().defaultContent();
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
