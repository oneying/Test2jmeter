package feishuo.KyyWebUITest;

import java.util.regex.Pattern;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Class3Aupload extends BaseTest{
  public WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  UI3AUpload upload=new UI3AUpload();
  
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
	Thread.sleep(2000);
  // 3A课堂-资源上传
	if("firefox".equals(browser)||"ie".equals(browser)){
	    driver.findElement(By.linkText("3A课堂")).click(); 
	    Reporter.log("点击3A课堂");
	    Thread.sleep(1500);
	  		
        driver.findElement(By.linkText("• 资源上传")).click();  
        Reporter.log("点击资源上传");
        Thread.sleep(1000);
    }else if("chrome".equals(browser)){
    	Actions action=new Actions(driver);
    	action.moveToElement(driver.findElement(By.linkText("3A课堂"))).click().perform();  
    	Reporter.log("点击3A课堂");
    	Thread.sleep(1500);
	  	
        action.moveToElement(driver.findElement(By.linkText("• 资源上传"))).click().perform(); 
        Reporter.log("点击资源上传"); 
        Thread.sleep(1000);
        action.release();
    }
  }
  
  @Test//(enabled=false)
  @Parameters("browser")
  public void test3Aput(String browser) throws Exception {
    //正常上传资源的情况
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    upload.chooseCity(driver, "测试");  
    Reporter.log("选择城市");
    upload.Town(driver, "区县test");  
    Reporter.log("填写区县");
    upload.School(driver, "学校单位test");  
    Reporter.log("填写学校");
    upload.Username(driver, "作者姓名test"); 
    Reporter.log("填写作者名");
    upload.Phone(driver, "12345678901"); 
    Reporter.log("填写手机号");
    upload.Publish(driver, "testxxx版"); 
    Reporter.log("填写资源内容相关");
    upload.chooseGrade(driver, "高一", "全册"); 
    Reporter.log("选择年级");
    upload.chooseType(driver, 3); 
    Reporter.log("选择资源类型");
    upload.Filename(driver, "test资源名称");  
    Reporter.log("填写资源名称");

    //用Autolt上传文件
    int i=5;//最多上传5次
    for(int n=1;n<=i;n++){ 
    	Reporter.log("上传第"+n+"个文件");
    	
    WebElement fileframe=driver.findElement(By.xpath("//div[@id='iframetd']/iframe["+n+"]"));
	driver.switchTo().frame(fileframe);
	driver.findElement(By.id("file")).click(); 
	Reporter.log("选择文件");
    Thread.sleep(1000);
    if("firefox".equals(browser)){
        Runtime.getRuntime().exec("C:/Users/admin/.jenkins/workspace/testwebkyy/src/test/resources/3Aupload_firefox.exe");
        Thread.sleep(5000);
        }
    else if("ie".equals(browser)){
        Runtime.getRuntime().exec("C:/Users/admin/.jenkins/workspace/testwebkyy/src/test/resources/3Aupload_ie.exe");
        Thread.sleep(5000);
        }
    else if("chrome".equals(browser)){
        Runtime.getRuntime().exec("C:/Users/admin/.jenkins/workspace/testwebkyy/src/test/resources/3Aupload_chrome.exe");
        Thread.sleep(5000);
        }
    driver.switchTo().defaultContent();//离开iframe
    
  //操作垂直滚动条，向下移动到底部
  	if("ie".equals(browser)){
  	String setscroll = "document.documentElement.scrollTop=" + "2500";  
  	JavascriptExecutor down=(JavascriptExecutor) driver; 
  	down.executeScript(setscroll);
  	}else if("firefox".equals(browser)||"chrome".equals(browser)){
  	String setscroll = "document.body.scrollTop=" + "2500";  
  	JavascriptExecutor down=(JavascriptExecutor) driver; 
  	down.executeScript(setscroll);
  	} 
      Reporter.log("页面向下滚动到底部");
  	
    }
    
    upload.DelFile(driver, 2); 
    Reporter.log("删除已选的第2个文件");
    upload.Sub(driver); 
    Reporter.log("上传提交");
    upload.OK(driver); 
    Reporter.log("提交成功");
    Thread.sleep(1000);
  }

  @Test//(enabled=false)
  public void testNotown() throws Exception {
    //不填写区县的情况
    upload.chooseCity(driver, "测试"); 
    Reporter.log("选择城市");
    upload.School(driver, "学校单位test"); 
    Reporter.log("填写学校");
    upload.Username(driver, "作者姓名test"); 
    Reporter.log("填写作者名");
    upload.Phone(driver, "12345678901"); 
    Reporter.log("填写手机号");
    upload.Publish(driver, "testxxx版");  
    Reporter.log("填写资源内容相关");
    upload.chooseGrade(driver, "高一", "全册");  
    Reporter.log("选择年级");
    upload.chooseType(driver, 1);  
    Reporter.log("选择资源类型");
    upload.Filename(driver, "test资源名称");  
    Reporter.log("填写资源名称");
    upload.Sub(driver); 
    Reporter.log("上传提交");
    Thread.sleep(500);
    assertEquals(closeAlertAndGetItsText(), "县区不能为空"); 
    Reporter.log("提示县区不能为空");
  }
  
  @Test//(enabled=false)
  public void testNoschool() throws Exception {
    //不填写学校的情况
    upload.chooseCity(driver, "测试"); 
    Reporter.log("选择城市");
    upload.Town(driver, "区县test"); 
    Reporter.log("填写区县");
    upload.Username(driver, "作者姓名test");  
    Reporter.log("填写作者名");
    upload.Phone(driver, "12345678901"); 
    Reporter.log("填写手机号");
    upload.Publish(driver, "testxxx版"); 
    Reporter.log("填写资源内容相关");
    upload.chooseGrade(driver, "高一", "全册"); 
    Reporter.log("选择年级");
    upload.chooseType(driver, 1); 
    Reporter.log("选择资源类型");
    upload.Filename(driver, "test资源名称"); 
    Reporter.log("填写资源名称");
    upload.Sub(driver); 
    Reporter.log("上传提交");
    Thread.sleep(500);
    assertEquals(closeAlertAndGetItsText(), "学校/单位不能为空");
    Reporter.log("提示学校/单位不能为空");
  }
  
  @Test//(enabled=false)
  public void testNouesrname() throws Exception {
    //不填写作者姓名的情况
    upload.chooseCity(driver, "测试"); 
    Reporter.log("选择城市");
    upload.Town(driver, "区县test"); 
    Reporter.log("填写区县");
    upload.School(driver, "学校单位test"); 
    Reporter.log("填写学校");
    upload.Phone(driver, "12345678901");  
    Reporter.log("填写手机号");
    upload.Publish(driver, "testxxx版");  
    Reporter.log("填写资源内容相关");
    upload.chooseGrade(driver, "高一", "全册"); 
    Reporter.log("选择年级");
    upload.chooseType(driver, 5); 
    Reporter.log("选择资源类型");
    upload.Filename(driver, "test资源名称"); 
    Reporter.log("填写资源名称");
    upload.Sub(driver);  
    Reporter.log("上传提交");
    Thread.sleep(500);
    assertEquals(closeAlertAndGetItsText(), "姓名不能为空"); 
    Reporter.log("提示姓名不能为空");
  }
  
  @Test//(enabled=false)
  public void testNophone_1() throws Exception {
    //不填写联系手机的情况
    upload.chooseCity(driver, "测试"); 
    Reporter.log("选择城市");
    upload.Town(driver, "区县test");  
    Reporter.log("填写区县");
    upload.School(driver, "学校单位test"); 
    Reporter.log("填写学校");
    upload.Username(driver, "作者姓名test"); 
    Reporter.log("填写作者名");
    upload.Publish(driver, "testxxx版"); 
    Reporter.log("填写资源内容相关");
    upload.chooseGrade(driver, "高一", "全册"); 
    Reporter.log("选择年级");
    upload.chooseType(driver, 2); 
    Reporter.log("选择资源类型");
    upload.Filename(driver, "test资源名称"); 
    Reporter.log("填写资源名称");
    upload.Sub(driver); 
    Reporter.log("上传提交");
    Thread.sleep(500);
    assertEquals(closeAlertAndGetItsText(), "联系手机不能为空");
    Reporter.log("提示联系手机不能为空");
  }
  
  @Test//(enabled=false)
  public void testNophone_2() throws Exception {
    //填写的联系手机不为11位的情况
    upload.chooseCity(driver, "测试"); 
    Reporter.log("选择城市");
    upload.Town(driver, "区县test"); 
    Reporter.log("填写区县");
    upload.School(driver, "学校单位test"); 
    Reporter.log("填写学校");
    upload.Username(driver, "作者姓名test"); 
    Reporter.log("填写作者名");
    upload.Phone(driver, "1234567890123"); 
    Reporter.log("填写手机号");
    upload.Publish(driver, "testxxx版"); 
    Reporter.log("填写资源内容相关");
    upload.chooseGrade(driver, "高一", "全册"); 
    Reporter.log("选择年级");
    upload.chooseType(driver, 4);  
    Reporter.log("选择资源类型");
    upload.Filename(driver, "test资源名称");  
    Reporter.log("填写资源名称");
    upload.Sub(driver); 
    Reporter.log("上传提交");
    Thread.sleep(500);
    assertEquals(closeAlertAndGetItsText(), "手机号码应该是11位"); 
    Reporter.log("提示手机号码应该是11位");
  }
  
  @Test//(enabled=false)
  public void testNopublish() throws Exception {
    //不填写内容相关的情况
    upload.chooseCity(driver, "测试"); 
    Reporter.log("选择城市");
    upload.Town(driver, "区县test"); 
    Reporter.log("填写区县");
    upload.School(driver, "学校单位test");  
    Reporter.log("填写学校");
    upload.Username(driver, "作者姓名test"); 
    Reporter.log("填写作者名");
    upload.Phone(driver, "12345678901"); 
    Reporter.log("填写手机号");
    upload.chooseGrade(driver, "高一", "全册"); 
    Reporter.log("选择年级");
    upload.chooseType(driver, 2); 
    Reporter.log("选择资源类型");
    upload.Filename(driver, "test资源名称");  
    Reporter.log("填写资源名称");
    upload.Sub(driver); 
    Reporter.log("上传提交");
    Thread.sleep(500);
    assertEquals(closeAlertAndGetItsText(), "资源内容相关不能为空"); 
    Reporter.log("资源内容相关不能为空");
  }
  
  @Test//(enabled=false)
  public void testNograde() throws Exception {
    //不选年级的情况
    upload.chooseCity(driver, "测试"); 
    Reporter.log("选择城市");
    upload.Town(driver, "区县test"); 
    Reporter.log("填写区县");
    upload.School(driver, "学校单位test"); 
    Reporter.log("填写学校");
    upload.Username(driver, "作者姓名test");  
    Reporter.log("填写作者名");
    upload.Phone(driver, "12345678901"); 
    Reporter.log("填写手机号");
    upload.Publish(driver, "testxxx版"); 
    Reporter.log("填写资源内容相关");
    upload.chooseType(driver, 3); 
    Reporter.log("选择资源类型");
    upload.Filename(driver, "test资源名称"); 
    Reporter.log("填写资源名称");
    upload.Sub(driver);  
    Reporter.log("上传提交");
    Thread.sleep(500);
    assertEquals(closeAlertAndGetItsText(), "请选择资源所属年级"); 
    Reporter.log("提示请选择资源所属年级");
  }
  
  @Test//(enabled=false)
  public void testNofilename() throws Exception {
    //不填写资源名称的情况
    upload.chooseCity(driver, "测试");  
    Reporter.log("选择城市");
    upload.Town(driver, "区县test"); 
    Reporter.log("填写区县");
    upload.School(driver, "学校单位test"); 
    Reporter.log("填写学校");
    upload.Username(driver, "作者姓名test"); 
    Reporter.log("填写作者名");
    upload.Phone(driver, "12345678901");  
    Reporter.log("填写手机号");
    upload.Publish(driver, "testxxx版"); 
    Reporter.log("填写资源内容相关");
    upload.chooseGrade(driver, "高一", "全册");  
    Reporter.log("选择年级");
    upload.chooseType(driver, 4); 
    Reporter.log("选择资源类型");
    upload.Sub(driver);  
    Reporter.log("上传提交");
    Thread.sleep(500);
    assertEquals(closeAlertAndGetItsText(), "上传资源名称不能为空");
    Reporter.log("提示上传资源名称不能为空");
  }
  
  @Test//(enabled=false)
  public void testNofile() throws Exception {
    //不上传文件的情况
    upload.chooseCity(driver, "测试");   
    Reporter.log("选择城市");
    upload.Town(driver, "区县test"); 
    Reporter.log("填写区县");
    upload.School(driver, "学校单位test"); 
    Reporter.log("填写学校");
    upload.Username(driver, "作者姓名test"); 
    Reporter.log("填写作者名");
    upload.Phone(driver, "12345678901"); 
    Reporter.log("填写手机号");
    upload.Publish(driver, "testxxx版"); 
    Reporter.log("填写资源内容相关");
    upload.chooseGrade(driver, "高一", "全册"); 
    Reporter.log("选择年级");
    upload.chooseType(driver,1); 
    Reporter.log("选择资源类型");
    upload.Filename(driver, "test资源名称"); 
    Reporter.log("填写资源名称");
    upload.Sub(driver); 
    Reporter.log("上传提交");
    Thread.sleep(500);
    assertEquals(closeAlertAndGetItsText(), "没有上传资源文件"); 
    Reporter.log("提示没有上传资源文件");
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
