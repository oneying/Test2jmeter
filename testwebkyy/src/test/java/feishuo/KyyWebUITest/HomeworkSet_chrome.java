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

public class HomeworkSet_chrome extends BaseTest{
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
	  Actions action=new Actions(driver);
	  
			//chrome：选择班级：class-1是全部
		    action.moveToElement(driver.findElement(By.id("class-1"))).click().perform();
		    Reporter.log("选择全部"); //鼠标移动到元素
		  //鼠标事件释放
		    action.release();
    
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    
    homeset.pop_1(driver); 
    Reporter.log("选常用语1");
    homeset.pop_close(driver); 
    Reporter.log("打开和关闭常用语框");

		//chrome：勾选短信
	    action.moveToElement(driver.findElement(By.id("SubMsg"))).click().perform();  
	    Reporter.log("勾选发送短信");//鼠标移动到元素
	  //鼠标事件释放
	    action.release();
	 
    homeset.Msg_1(driver);  
    Reporter.log("选常用语1");
    homeset.msg_close(driver);  
    Reporter.log("打开和关闭常用语框");
    
		//chrome：添加口语作业
	    //鼠标移动到元素
		action.moveToElement(driver.findElement(By.id("AddHomeworkDet"))).click().perform(); 
		Reporter.log("添加口语作业");
		action.moveToElement(driver.findElement(By.id("changeBox"))).click().perform(); 
		Reporter.log("更换素材");
		action.moveToElement(driver.findElement(By.id("junior_0"))).click().perform(); 
		Reporter.log("选小学");//学段：junior_0是小学，1是初中，2是高中
		action.moveToElement(driver.findElement(By.id("grade_3"))).click().perform();  
		Reporter.log("选3年级");//年级：grade_1是一年级，12是高三
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("book-2"))).click().perform();  
	    Reporter.log("选第1课本");//课本：book-2是第1行第1列的课本，book-3是第1行第2列的课本
	    action.moveToElement(driver.findElement(By.id("confirmSB"))).click().perform(); 
	    Reporter.log("确定");
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.xpath("(//div[@name='chooseUnit'])[2]"))).click().perform(); 
	    Reporter.log("选第2单元");//目录单元，[2]是第2单元
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform();//朗读ts1_1
	    action.moveToElement(driver.findElement(By.id("tx1_1"))).click().perform();//背诵tx1_1
	    action.moveToElement(driver.findElement(By.id("ld1_1"))).click().perform();//听说ld1_1
	    action.moveToElement(driver.findElement(By.id("bs1_1"))).click().perform();//听写bs1_1  
	    Thread.sleep(500); 
	    Reporter.log("朗读、背诵、听说、听写");
	    action.moveToElement(driver.findElement(By.id("confirmSC"))).click().perform();
	    Reporter.log("确认选择");
		Thread.sleep(500);
	    //鼠标事件释放
	    action.release();
    
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
	  Actions action=new Actions(driver);
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    
    homeset.setDemand("这是输入的作业要求。");
    homeset.homeworkdemand(driver); 
    Reporter.log("作业要求");
    
		//chrome：添加口语作业
	    //鼠标移动到元素
		action.moveToElement(driver.findElement(By.id("AddHomeworkDet"))).click().perform(); 
		Reporter.log("添加口语作业");
		action.moveToElement(driver.findElement(By.id("changeBox"))).click().perform();  
		Reporter.log("更换素材");
		action.moveToElement(driver.findElement(By.id("junior_0"))).click().perform(); 
		Reporter.log("小学");//学段：junior_0是小学，1是初中，2是高中
		action.moveToElement(driver.findElement(By.id("grade_3"))).click().perform(); 
		Reporter.log("3年级");//年级：grade_1是一年级，12是高三
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("book-2"))).click().perform();  
	    Reporter.log("第1课本");//课本：book-2是第1行第1列的课本，book-3是第1行第2列的课本
	    action.moveToElement(driver.findElement(By.id("confirmSB"))).click().perform(); 
	    Reporter.log("确定");
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.xpath("(//div[@name='chooseUnit'])[2]"))).click().perform(); 
	    Reporter.log("第2单元");//目录单元，[2]是第2单元
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform();//朗读ts1_1
	    action.moveToElement(driver.findElement(By.id("tx1_1"))).click().perform();//背诵tx1_1
	    action.moveToElement(driver.findElement(By.id("ld1_1"))).click().perform();//听说ld1_1
	    action.moveToElement(driver.findElement(By.id("bs1_1"))).click().perform();//听写bs1_1
	    Thread.sleep(500);  
	    Reporter.log("朗读、背诵、听说、听写");
	    action.moveToElement(driver.findElement(By.id("confirmSC"))).click().perform();  
	    Reporter.log("确认选择");
		Thread.sleep(500);
	    //鼠标事件释放
	    action.release();
	
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
	  Actions action=new Actions(driver);
	  
		//chrome：选择班级：class-1是全部
	    action.moveToElement(driver.findElement(By.id("class-1"))).click().perform();  
	    Reporter.log("班级全部");//鼠标移动到元素
	  //鼠标事件释放
	    action.release();
	 
    /*homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    
		//chrome：不勾选录音
	    action.moveToElement(driver.findElement(By.id("SubAudio"))).click().perform(); 
	    Reporter.log("不勾选提交录音");//鼠标移动到元素
	  //鼠标事件释放
	    action.release();
	 
		//chrome：添加口语作业
	    //鼠标移动到元素
		action.moveToElement(driver.findElement(By.id("AddHomeworkDet"))).click().perform();  
		Reporter.log("添加口语作业");
		action.moveToElement(driver.findElement(By.id("changeBox"))).click().perform(); 
		Reporter.log("更换素材");
		action.moveToElement(driver.findElement(By.id("junior_0"))).click().perform();  
		Reporter.log("小学");//学段：junior_0是小学，1是初中，2是高中
		action.moveToElement(driver.findElement(By.id("grade_3"))).click().perform(); 
		Reporter.log("3年级");//年级：grade_1是一年级，12是高三
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("book-2"))).click().perform(); 
	    Reporter.log("第1课本");//课本：book-2是第1行第1列的课本，book-3是第1行第2列的课本
	    action.moveToElement(driver.findElement(By.id("confirmSB"))).click().perform(); 
	    Reporter.log("确定");
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.xpath("(//div[@name='chooseUnit'])[2]"))).click().perform();  
	    Reporter.log("第2单元");//目录单元，[2]是第2单元
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform();//朗读ts1_1
	    action.moveToElement(driver.findElement(By.id("tx1_1"))).click().perform();//背诵tx1_1
	    action.moveToElement(driver.findElement(By.id("ld1_1"))).click().perform();//听说ld1_1
	    action.moveToElement(driver.findElement(By.id("bs1_1"))).click().perform();//听写bs1_1
	    Thread.sleep(500);  
	    Reporter.log("朗读、背诵、听说、听写");
	    action.moveToElement(driver.findElement(By.id("confirmSC"))).click().perform();   
	    Reporter.log("确认选择");
		Thread.sleep(500);
	    //鼠标事件释放
	    action.release();
    
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
	  Actions action=new Actions(driver);
	 
			//chrome：选择班级：class-1是全部
		    action.moveToElement(driver.findElement(By.id("class-1"))).click().perform(); 
		    Reporter.log("班级全部");//鼠标移动到元素
		  //鼠标事件释放
		    action.release();
		 
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    
    homeset.setDemand("ps：这是输入的作业要求。");
    homeset.homeworkdemand(driver); 
    Reporter.log("作业要求");
    homeset.pop_close(driver); 
    Reporter.log("打开和关闭常用语框");

		//chrome：勾选短信
	    action.moveToElement(driver.findElement(By.id("SubMsg"))).click().perform(); 
	    Reporter.log("勾选短信");//鼠标移动到元素
	  //鼠标事件释放
	    action.release();
	 
		//chrome：添加口语作业
	    //鼠标移动到元素
		action.moveToElement(driver.findElement(By.id("AddHomeworkDet"))).click().perform();  
		Reporter.log("添加口语作业");
		action.moveToElement(driver.findElement(By.id("changeBox"))).click().perform(); 
		Reporter.log("更换素材");
		action.moveToElement(driver.findElement(By.id("junior_0"))).click().perform(); 
		Reporter.log("小学");//学段：junior_0是小学，1是初中，2是高中
		action.moveToElement(driver.findElement(By.id("grade_3"))).click().perform(); 
		Reporter.log("3年级");//年级：grade_1是一年级，12是高三
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("book-2"))).click().perform(); 
	    Reporter.log("第1本书");//课本：book-2是第1行第1列的课本，book-3是第1行第2列的课本
	    action.moveToElement(driver.findElement(By.id("confirmSB"))).click().perform();
	    Reporter.log("确定");
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.xpath("(//div[@name='chooseUnit'])[2]"))).click().perform();  
	    Reporter.log("第2单元");//目录单元，[2]是第2单元
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform();//朗读ts1_1
	    action.moveToElement(driver.findElement(By.id("tx1_1"))).click().perform();//背诵tx1_1
	    action.moveToElement(driver.findElement(By.id("ld1_1"))).click().perform();//听说ld1_1
	    action.moveToElement(driver.findElement(By.id("bs1_1"))).click().perform();//听写bs1_1
	    Thread.sleep(500); 
	    Reporter.log("朗读、背诵、听说、听写");
	    action.moveToElement(driver.findElement(By.id("confirmSC"))).click().perform(); 
	    Reporter.log("确认选择");
		Thread.sleep(500);
	    //鼠标事件释放
	    action.release();
    
    homeset.HomeworkSetOK(driver);  
    Reporter.log("提交作业");
    
  //系统提示：请输入短信通知的内容
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='_Container_0']/div[2]/span[contains(.,'请输入短信通知的内容')]")).isEnabled(),"弹框：请输入短信通知的内容");
    homeset.cancel(driver); 
    Reporter.log("输入短信");
    
    Assert.assertTrue(driver.findElement(By.id("class-1")).isEnabled(),"页面有：选择班级:全部");
 
  }

  @Test//(enabled = false)
  public void testdemandToolong() throws Exception {
    //作业要求超过50字的情况
	  Actions action=new Actions(driver);
	  
			//chrome：选择班级：class-1是全部
		    action.moveToElement(driver.findElement(By.id("class-1"))).click().perform(); 
		    Reporter.log("班级全部");//鼠标移动到元素
		  //鼠标事件释放
		    action.release();
		 
    /*homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    
    homeset.setDemand("test：这是输入的作业要求——字数超过50字： 口语易可以针对英语口语水平做出智能化评测。学生可进行跟读、并获得客观的打分，通过分数的高低判断自己英语发音的准确性，为英语学习者提供了一个敢说敢练的平台，与学校教育相辅相成，让孩子的英语口语水平得到大幅提高！。");
    homeset.homeworkdemand(driver);  
    Reporter.log("作业要求");

    homeset.msg_close(driver);  
    Reporter.log("打开和关闭常用语框");
    
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Bz_homeworkStep1']/div[8]/div[2]/div/div/span[contains(.,'（还可以输入0个字）')]")).isEnabled(),"页面作业要求下有：（还可以输入0个字）这行字");
    
  }
  
  @Test//(enabled = false)
  public void testmsgToolong() throws Exception {
    //短信内容超过50字的情况
	  Actions action=new Actions(driver);
	  
			//chrome：选择班级：class-1是全部
		    action.moveToElement(driver.findElement(By.id("class-1"))).click().perform();  
		    Reporter.log("班级全部");//鼠标移动到元素
		  //鼠标事件释放
		    action.release();
    
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
	  Actions action=new Actions(driver);
	  
			//chrome：选择班级：class-1是全部
			
		    action.moveToElement(driver.findElement(By.id("class-1"))).click().perform();  
		    Reporter.log("班级全部");//鼠标移动到元素
		  //鼠标事件释放
		    action.release();
    
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分
    */
    
    homeset.pop_1(driver);//选常用语1
    
		//chrome：添加口语作业
	    //鼠标移动到元素
		action.moveToElement(driver.findElement(By.id("AddHomeworkDet"))).click().perform(); 
		Reporter.log("添加口语作业");
		action.moveToElement(driver.findElement(By.id("changeBox"))).click().perform();  
		Reporter.log("更换素材");
		action.moveToElement(driver.findElement(By.id("junior_0"))).click().perform();  
		Reporter.log("小学");//学段：junior_0是小学，1是初中，2是高中
		action.moveToElement(driver.findElement(By.id("grade_3"))).click().perform();  
		Reporter.log("3年级");//年级：grade_1是一年级，12是高三
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("book-2"))).click().perform(); 
	    Reporter.log("第1本书");//课本：book-2是第1行第1列的课本，book-3是第1行第2列的课本
	    action.moveToElement(driver.findElement(By.id("confirmSB"))).click().perform();  
	    Reporter.log("确定");
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.xpath("(//div[@name='chooseUnit'])[2]"))).click().perform();  
	    Reporter.log("第2单元");//目录单元，[2]是第2单元
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform();//朗读ts1_1
	    action.moveToElement(driver.findElement(By.id("tx1_1"))).click().perform();//背诵tx1_1
	    action.moveToElement(driver.findElement(By.id("ld1_1"))).click().perform();//听说ld1_1
	    action.moveToElement(driver.findElement(By.id("bs1_1"))).click().perform();//听写bs1_1
	    Thread.sleep(500);  
	    Reporter.log("朗读、背诵、听说、听写");
	    action.moveToElement(driver.findElement(By.id("confirmSC"))).click().perform();  
	    Reporter.log("确认选择");
		Thread.sleep(500);
	    //鼠标事件释放
	    action.release();
	  
    for(int i=1;i<5;i++){//上面选了4个作业素材，Ced1-Ced4为取消第1到第4个素材
    	action.moveToElement(driver.findElement(By.id("Ced"+i))).click().perform();
    	action.release();
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
	  Actions action=new Actions(driver);
	  
			//chrome：选择班级：class-1是全部
		    action.moveToElement(driver.findElement(By.id("class-1"))).click().perform(); 
		    Reporter.log("班级全部");//鼠标移动到元素
		  //鼠标事件释放
		    action.release();
		  
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分*/
    
    homeset.pop_1(driver); 
    Reporter.log("选常用语1");
    
		//chrome：添加口语作业
	    //鼠标移动到元素
		action.moveToElement(driver.findElement(By.id("AddHomeworkDet"))).click().perform();  
		Reporter.log("添加口语作业");
		action.moveToElement(driver.findElement(By.id("changeBox"))).click().perform(); 
		Reporter.log("更换素材");
		action.moveToElement(driver.findElement(By.id("junior_0"))).click().perform();  
		Reporter.log("小学");//学段：junior_0是小学，1是初中，2是高中
		action.moveToElement(driver.findElement(By.id("grade_3"))).click().perform(); 
		Reporter.log("3年级");//年级：grade_1是一年级，12是高三
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("book-2"))).click().perform();  
	    Reporter.log("第1本书");//课本：book-2是第1行第1列的课本，book-3是第1行第2列的课本
	    action.moveToElement(driver.findElement(By.id("confirmSB"))).click().perform(); 
	    Reporter.log("确定");
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform(); 
	    Reporter.log("朗读");//朗读ts1_1
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("confirmSC"))).click().perform(); 
	    Reporter.log("确认选择");
		Thread.sleep(500);
	    //鼠标事件释放
	    action.release();
	 
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Bz_afterlistBox']/div[9]/div[contains(.,'已选择1项作业')]")).isEnabled(),"页面有：'已选择1项作业'这行字");
    
  }
  
  @Test//(enabled = false)
  public void testselect_10homework() throws Exception {
    //选择10项素材的情况
	  Actions action=new Actions(driver);
	 
			//chrome：选择班级：class-1是全部
		    action.moveToElement(driver.findElement(By.id("class-1"))).click().perform(); 
		    Reporter.log("班级全部");//鼠标移动到元素
		  //鼠标事件释放
		    action.release();
		  
    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分*/
    
    homeset.pop_1(driver);  
    Reporter.log("选常用语1");
    
		//chrome：添加口语作业
	    //鼠标移动到元素
		action.moveToElement(driver.findElement(By.id("AddHomeworkDet"))).click().perform(); 
		Reporter.log("添加口语作业");
		action.moveToElement(driver.findElement(By.id("changeBox"))).click().perform(); 
		Reporter.log("更换素材");
		action.moveToElement(driver.findElement(By.id("junior_0"))).click().perform(); 
		Reporter.log("小学");//学段：junior_0是小学，1是初中，2是高中
		action.moveToElement(driver.findElement(By.id("grade_3"))).click().perform();  
		Reporter.log("3年级");//年级：grade_1是一年级，12是高三
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("book-2"))).click().perform(); 
	    Reporter.log("第1本书");//课本：book-2是第1行第1列的课本，book-3是第1行第2列的课本
	    action.moveToElement(driver.findElement(By.id("confirmSB"))).click().perform(); 
	    Reporter.log("确定");
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.xpath("(//div[@name='chooseUnit'])[2]"))).click().perform(); 
	    Reporter.log("第2单元");//目录单元，[2]是第2单元
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform();//朗读ts1_1
	    action.moveToElement(driver.findElement(By.id("tx1_1"))).click().perform();
	    action.moveToElement(driver.findElement(By.id("ld1_1"))).click().perform();
	    action.moveToElement(driver.findElement(By.id("bs1_1"))).click().perform();
	    Thread.sleep(500);  
	    Reporter.log("朗读、背诵、听说、听写");
	    action.moveToElement(driver.findElement(By.id("confirmSC"))).click().perform();  
	    Reporter.log("确认选择");
		Thread.sleep(500);
		
		homeset.amendhw(driver);  
		Reporter.log("修改口语作业");
		action.moveToElement(driver.findElement(By.id("changeBox"))).click().perform(); 
		Reporter.log("更换素材");
		action.moveToElement(driver.findElement(By.id("junior_0"))).click().perform(); 
		Reporter.log("小学");//学段：junior_0是小学，1是初中，2是高中
		action.moveToElement(driver.findElement(By.id("grade_3"))).click().perform(); 
		Reporter.log("3年级");//年级：grade_1是一年级，12是高三
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("book-2"))).click().perform();  
	    Reporter.log("第1本书");//课本：book-2是第1行第1列的课本，book-3是第1行第2列的课本
	    action.moveToElement(driver.findElement(By.id("confirmSB"))).click().perform(); 
	    Reporter.log("确定");
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.xpath("(//div[@name='chooseUnit'])[3]"))).click().perform(); 
	    Reporter.log("第3单元");//目录单元，[3]是第3单元
	    Thread.sleep(500);
	    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform();//朗读ts1_1
	    action.moveToElement(driver.findElement(By.id("tx1_1"))).click().perform();
	    action.moveToElement(driver.findElement(By.id("ld1_1"))).click().perform();
	    action.moveToElement(driver.findElement(By.id("bs1_1"))).click().perform();
	    Thread.sleep(500); 
	    Reporter.log("朗读、背诵、听说、听写");
	    action.moveToElement(driver.findElement(By.id("confirmSC"))).click().perform(); 
	    Reporter.log("确认选择");
		Thread.sleep(500);
	 
	    homeset.amendhw(driver); 
	    Reporter.log("修改口语作业");
	    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform();//选择1个素材
	    action.moveToElement(driver.findElement(By.id("tx1_1"))).click().perform();//选择1个素材，以上共选了10个素材
	    Thread.sleep(500);  
	    Reporter.log("共选了10个素材");
	    action.moveToElement(driver.findElement(By.id("confirmSC"))).click().perform();  
	    Reporter.log("确认选择");
		Thread.sleep(500);
		
	    //鼠标事件释放
	    action.release();
	  
   
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Bz_afterlistBox']/div[9]/div[contains(.,'已选择10项作业')]")).isEnabled(),"页面有：'已选择10项作业'这行字");
    
  }
  
  @Test//(enabled = false)
  public void testselect_11homework() throws Exception {
    //选择11项素材的情况
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  Actions action=new Actions(driver);

			//chrome：选择班级：class-1是全部
		    action.moveToElement(driver.findElement(By.id("class-1"))).click().perform();  
		    Reporter.log("班级全部");//鼠标移动到元素
		  //鼠标事件释放
		    action.release();
		
	    /* homeset.time(driver,"2017,3,29","2017,4,1");//如果不设置时间，就默认今天
    homeset.etime_hm(driver,20,30);//时分*/
	    
	    homeset.pop_1(driver); 
	    Reporter.log("选常用语1");
	    
			//chrome：添加口语作业
		    //鼠标移动到元素
			action.moveToElement(driver.findElement(By.id("AddHomeworkDet"))).click().perform();  
			Reporter.log("添加口语作业");
			action.moveToElement(driver.findElement(By.id("changeBox"))).click().perform();  
			Reporter.log("更换素材");
			action.moveToElement(driver.findElement(By.id("junior_0"))).click().perform(); 
			Reporter.log("小学");//学段：junior_0是小学，1是初中，2是高中
			action.moveToElement(driver.findElement(By.id("grade_3"))).click().perform(); 
			Reporter.log("3年级");//年级：grade_1是一年级，12是高三
		    Thread.sleep(500);
		    action.moveToElement(driver.findElement(By.id("book-2"))).click().perform(); 
		    Reporter.log("第1本书");//课本：book-2是第1行第1列的课本，book-3是第1行第2列的课本
		    action.moveToElement(driver.findElement(By.id("confirmSB"))).click().perform(); 
		    Reporter.log("确定");
		    Thread.sleep(500);
		    action.moveToElement(driver.findElement(By.xpath("(//div[@name='chooseUnit'])[2]"))).click().perform(); 
		    Reporter.log("第2单元");//目录单元，[2]是第2单元
		    Thread.sleep(500);
		    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform();//朗读ts1_1
		    action.moveToElement(driver.findElement(By.id("tx1_1"))).click().perform();
		    action.moveToElement(driver.findElement(By.id("ld1_1"))).click().perform();
		    action.moveToElement(driver.findElement(By.id("bs1_1"))).click().perform();
		    Thread.sleep(500);  
		    Reporter.log("朗读、背诵、听说、听写");
		    action.moveToElement(driver.findElement(By.id("confirmSC"))).click().perform(); 
		    Reporter.log("确认选择");
			Thread.sleep(500);
			
			homeset.amendhw(driver);//修改口语作业
			action.moveToElement(driver.findElement(By.id("changeBox"))).click().perform(); 
			Reporter.log("更换素材");
			action.moveToElement(driver.findElement(By.id("junior_0"))).click().perform();  
			Reporter.log("小学");//学段：junior_0是小学，1是初中，2是高中
			action.moveToElement(driver.findElement(By.id("grade_3"))).click().perform(); 
			Reporter.log("3年级");//年级：grade_1是一年级，12是高三
		    Thread.sleep(500);
		    action.moveToElement(driver.findElement(By.id("book-2"))).click().perform(); 
		    Reporter.log("第1本书");//课本：book-2是第1行第1列的课本，book-3是第1行第2列的课本
		    action.moveToElement(driver.findElement(By.id("confirmSB"))).click().perform(); 
		    Reporter.log("确定");
		    Thread.sleep(500);
		    action.moveToElement(driver.findElement(By.xpath("(//div[@name='chooseUnit'])[3]"))).click().perform();  
		    Reporter.log("第3单元");//目录单元，[3]是第3单元
		    Thread.sleep(500);
		    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform();//朗读ts1_1
		    action.moveToElement(driver.findElement(By.id("tx1_1"))).click().perform();
		    action.moveToElement(driver.findElement(By.id("ld1_1"))).click().perform();
		    action.moveToElement(driver.findElement(By.id("bs1_1"))).click().perform();
		    Thread.sleep(500); 
		    Reporter.log("朗读、背诵、听说、听写");
		    action.moveToElement(driver.findElement(By.id("confirmSC"))).click().perform(); 
		    Reporter.log("确认选择");
			Thread.sleep(500);
		 
		    homeset.amendhw(driver);  
		    Reporter.log("修改口语作业");
		    action.moveToElement(driver.findElement(By.id("ts1_1"))).click().perform();//选择1个素材
		    action.moveToElement(driver.findElement(By.id("tx1_1"))).click().perform();//选择1个素材，以上共选了10个素材
		    action.moveToElement(driver.findElement(By.id("ld1_1"))).click().perform();  
		    Reporter.log("共选11个素材");//选择第11个素材
		    Thread.sleep(500);
			
		    //鼠标事件释放
		    action.release();
	    
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
