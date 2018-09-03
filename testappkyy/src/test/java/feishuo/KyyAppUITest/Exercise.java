package feishuo.KyyAppUITest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Exercise {

	public AndroidDriver driver;
	UILogin login=new UILogin();
	UIHomePage home=new UIHomePage();
	UIExercise exercise=new UIExercise();
	EverySwipe swipe=new EverySwipe();
	
	@BeforeClass
	public void setUp()throws Exception{
	//启动appium
		BaseTest device=new BaseTest();
		driver=device.getAndroidDriver();

	//学生-正常登录
		login.Role(driver, "student");  
		Reporter.log("角色选择学生");
		login.Login(driver, "cs0009", "888888");  
		Reporter.log("登录学生账号-未订购：cs0009");//输入正确的账号和正确的密码
		//登录后：未订购的学生有提示框，密码为‘888888’的学生有提示框，先取消这2个提示框
		driver.pressKeyCode(4);  
		Reporter.log("按返回键，取消修改密码提示框");
		Thread.sleep(1000);
		driver.pressKeyCode(4);  
		Reporter.log("按返回键，取消订购提示框");
		Assert.assertEquals(driver.findElementById("com.kouyuyi.kyystuapp:id/title_view").getText(), "首页");			     
	    //进入首页
		
		home.Exercise(driver);  
		Reporter.log("进入练习题库");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test//(enabled=false)
	public void testChoose()throws Exception{
		//选择书本、单元
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean result=isElementExist(By .id("com.kouyuyi.kyystuapp:id/id_recyclerview"));//年级选择栏
		if(result==false){  
			Reporter.log("进入了单元列表，可直接选单元");
			exercise.Unit(driver, 0);  
			Reporter.log("选择第1单元");
		}else{ 
			Reporter.log("进入了目录，要先选书本再选单元");
			exercise.Grade(driver, 7, 1);  
			Reporter.log("选择8年级和第1本书");
			exercise.Unit(driver, 0);  
			Reporter.log("选择第1单元");
		}
		boolean res1=isElementExist(By .name("我要订购"));//未订购提示框
        if(res1==true){
        	driver.findElementByName("取消").click(); 
        	Reporter.log("点击取消订购");
        }else{
        	exercise.Cancel(driver); 
        	Reporter.log("点击取消练习");
        }
        Thread.sleep(1000);	
        
        exercise.Change(driver); 
        Reporter.log("更换教材");
        Thread.sleep(1000);	
        exercise.Grade(driver, 8, 1); 
        Reporter.log("选择9年级和第1本书");
        Thread.sleep(1000);
        
        exercise.Change(driver);  
        Reporter.log("更换教材");
        Thread.sleep(1000);	
        exercise.Grade(driver, 6, 1);  
        Reporter.log("选择7年级和第1本书");
        Thread.sleep(1000);
        
	}
	
	@Test//(enabled=false)
	public void testListen()throws Exception{
		//听力练习
		//选择书本、单元
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean result1=isElementExist(By .id("com.kouyuyi.kyystuapp:id/id_recyclerview"));//年级选择栏
		if(result1==false){ 
			Reporter.log("进入了单元列表，可直接选单元");
			exercise.Unit(driver, 0);  
			Reporter.log("选择第1单元");
		}else{  
			Reporter.log("进入了目录，要先选书本再选单元");
			exercise.Grade(driver, 6, 1);  
			Reporter.log("选择7年级和第1本书");
			exercise.Unit(driver, 0); 
			Reporter.log("选择第1单元");
		}
        boolean res1=isElementExist(By .name("我要订购"));//未订购提示框
        if(res1==true){
        	driver.findElementByName("取消").click();    
        	Reporter.log("点击取消订购");
        }else{
        	exercise.Listen(driver);   
        	Reporter.log("点击听力练习");
        	//进入做题
        	boolean res4=isElementExist(By .id("com.kouyuyi.kyystuapp:id/no_data_tv")); 
        	Reporter.log("没有习题");//暂无数据
        	if(res4==true){
        		driver.pressKeyCode(4);  
        		Reporter.log("返回单元同步列表");
        	}
        	else{
    	    //题目总数
    	    String num=driver.findElementById("com.kouyuyi.kyystuapp:id/nav_size_tv").getText();
    	    int i = Integer.parseInt(num);  
    	    Reporter.log("题目总数i="+i);
    	    //System.out.println(i);
    	    for(int s=0;s<i;s++){
    	    	boolean res2=isElementExist(By .id("com.kouyuyi.kyystuapp:id/checkBox"));//选择题
    	    	boolean res3=isElementExist(By .className("android.widget.EditText"));//填空题
    	    	driver.findElement(By.id("com.kouyuyi.kyystuapp:id/playBtn")).click();  
    	    	Reporter.log("点击播放/停止按钮");
    	    	
    	    	Reporter.log("第"+s+"题");
    	    	
    	    	if(res2==true){  
    	    		Reporter.log("选择题");
    	    	//System.out.println("选择题");
    	    	List<WebElement>check=driver.findElementsById("com.kouyuyi.kyystuapp:id/checkBox");
    	    	check.get(0).click(); 
    	    	Reporter.log("点击A");
    	    	}
    	    	
    	    	else if(res3==true){  
    	    		Reporter.log("填空题");
    	    	//System.out.println("填空题");
    	    	List<WebElement>edit2=driver.findElementsByClassName("android.widget.EditText");
        	    int j=edit2.size();  
        	    Reporter.log("获取有"+j+"个填空框");
        	    //System.out.println(j);
    	    	for(int k=0;k<j;k++){  
    	    		Reporter.log("第"+k+"个填空框");
    	    		edit2.get(k).sendKeys("Good!");  
    	    		Reporter.log("输入Good!");
    	    		Thread.sleep(500);
    	    	}
    	    	swipe.swipeToLeft(driver, 1); 
    	    	Reporter.log("往左划一下进入下题");
    	    	Thread.sleep(500);
    	    	}
    	    	
    	    }
    	  //做完提交
    	    driver.findElementByName("提交并查看练习报告和解析").click();  
    	    Reporter.log("点击提交并查看练习报告和解析");
    	    driver.findElementByName("错题解析").click(); 
    	    Reporter.log("点击错题解析");
    	    driver.findElementByName("全部解析").click();  
    	    Reporter.log("点击全部解析");
            Thread.sleep(3000);	
            driver.pressKeyCode(4);  
            Reporter.log("返回单元同步列表");
        }
	}
	}
	
	@Test//(enabled=false)
	public void testWrite()throws Exception{
		//笔试练习
		//选择书本、单元
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean result2=isElementExist(By .id("com.kouyuyi.kyystuapp:id/id_recyclerview"));//年级选择栏
		if(result2==false){  
			Reporter.log("进入了单元列表，可直接选单元");
			exercise.Unit(driver);  
			Reporter.log("单元同步");
			exercise.Unit(driver, 0);  
			Reporter.log("选择第1单元");
		}else{   
			Reporter.log("进入了目录，要先选书本再选单元");
			exercise.Grade(driver, 6, 1);  
			Reporter.log("选择7年级和第1本书");
			exercise.Unit(driver);   
			Reporter.log("单元同步");
			exercise.Unit(driver, 0);  
			Reporter.log("选择第1单元");
		}
        boolean res1=isElementExist(By .name("我要订购"));//未订购提示框
        if(res1==true){
        	driver.findElementByName("取消").click();   
        	Reporter.log("取消订购");
        }else{
        	exercise.Written(driver);   
        	Reporter.log("笔试练习");
        	//进入做题
        	boolean res4=isElementExist(By .id("com.kouyuyi.kyystuapp:id/no_data_tv"));//暂无数据
        	if(res4==true){   
        		Reporter.log("没有习题");
        		driver.pressKeyCode(4);  
        		Reporter.log("返回单元同步列表");
        	}
        	else{
    	    String num=driver.findElementById("com.kouyuyi.kyystuapp:id/nav_size_tv").getText();//获取题目总数
    	    int i = Integer.parseInt(num); 
    	    Reporter.log("题目总数i="+i);
    	    //System.out.println(i);
    	    for(int s=0;s<i;s++){
    	    	boolean res2=isElementExist(By .id("com.kouyuyi.kyystuapp:id/checkBox"));//选择题
    	    	boolean res3=isElementExist(By .className("android.widget.EditText"));//填空题
    	    	
    	    	Reporter.log("第"+s+"题");
    	    	
    	    	if(res2==true){  
    	    		Reporter.log("选择题");
    	    	//System.out.println("选择题");
    	    	List<WebElement>check=driver.findElementsById("com.kouyuyi.kyystuapp:id/checkBox");
    	    	check.get(0).click();  
    	    	Reporter.log("点击A");
    	    	}
    	    	
    	    	else if(res3==true){ 
    	    		Reporter.log("填空题");
    	    	//System.out.println("填空题");
    	    	List<WebElement>edit2=driver.findElementsByClassName("android.widget.EditText");
        	    int j=edit2.size();  
        	    Reporter.log("获取有"+j+"个填空框");
        	    //System.out.println(j);
    	    	for(int k=0;k<j;k++){  
    	    		Reporter.log("第"+k+"个填空框");
    	    		edit2.get(k).sendKeys("nice"); 
    	    		Reporter.log("输入nice");
    	    		Thread.sleep(500);
    	    	}
    	    	swipe.swipeToLeft(driver, 1);  
    	    	Reporter.log("往左划一下进入下题");
    	    	Thread.sleep(500);
    	    	}
    	    	
    	    }
    	  //做完提交
    	    driver.findElementByName("提交并查看练习报告和解析").click(); 
    	    Reporter.log("提交并查看练习报告和解析");
    	    driver.findElementByName("错题解析").click();  
    	    Reporter.log("错题解析");
    	    driver.findElementByName("全部解析").click(); 
    	    Reporter.log("全部解析");
            Thread.sleep(3000);	
            driver.pressKeyCode(4);  
            Reporter.log("返回单元同步列表");
        }

        }

	}
	
	@Test//(enabled=false)
	public void testSpecial()throws Exception{
		//专项练习
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean result3=isElementExist(By .id("com.kouyuyi.kyystuapp:id/id_recyclerview"));//年级选择栏
		if(result3==false){ 
			Reporter.log("进入了单元列表，可直接选单元");
			exercise.Special(driver);  
			Reporter.log("专项练习");
			exercise.Unit(driver, 0);  
			Reporter.log("选择第1单元");
		}else{  
			Reporter.log("进入了目录，要先选书本再选单元");
			exercise.Grade(driver, 6, 1); 
			Reporter.log("选择7年级和第1本书");
			exercise.Special(driver);  
			Reporter.log("专项练习");
			exercise.Unit(driver, 0);  
			Reporter.log("选择第1单元");
		}

        boolean res1=isElementExist(By .name("我要订购"));//未订购提示框
        if(res1==true){
        	driver.findElementByName("取消").click();  
        	Reporter.log("取消订购");
        }else{
        	//进入做题
        	boolean res4=isElementExist(By .id("com.kouyuyi.kyystuapp:id/no_data_tv"));//暂无数据
        	if(res4==true){  
        		Reporter.log("没有习题");
        		driver.pressKeyCode(4);  
        		Reporter.log("返回单元列表");
        	}
        	else{
    	    String num=driver.findElementById("com.kouyuyi.kyystuapp:id/nav_size_tv").getText();//获取题目总数
    	    int i = Integer.parseInt(num); 
    	    Reporter.log("题目总数i="+i);
    	    //System.out.println(i);
    	    for(int s=0;s<i;s++){
    	    	boolean res2=isElementExist(By .id("com.kouyuyi.kyystuapp:id/checkBox"));//选择题
    	    	boolean res3=isElementExist(By .className("android.widget.EditText"));//填空题
    	    	
    	    	Reporter.log("第"+s+"题");
    	    	
    	    	if(res2==true){ 
    	    		Reporter.log("选择题");
    	    	//System.out.println("选择题");
    	    	List<WebElement>check=driver.findElementsById("com.kouyuyi.kyystuapp:id/checkBox");
    	    	check.get(0).click(); 
    	    	Reporter.log("点击A");
    	    	}
    	    	
    	    	else if(res3==true){ 
    	    		Reporter.log("填空题");
    	    	//System.out.println("填空题");
    	    	List<WebElement>edit2=driver.findElementsByClassName("android.widget.EditText");
        	    int j=edit2.size(); 
        	    Reporter.log("获取有"+j+"个填空框");
        	    //System.out.println(j);
    	    	for(int k=0;k<j;k++){ 
    	    		Reporter.log("第"+k+"个填空框");
    	    		edit2.get(k).sendKeys("666");  
    	    		Reporter.log("输入666");
    	    		Thread.sleep(500);
    	    	}
    	    	swipe.swipeToLeft(driver, 1);  
    	    	Reporter.log("往左划一下进入下题");
    	    	Thread.sleep(500);
    	    	}
    	    	
    	    }
    	  //做完提交
    	    driver.findElementByName("提交并查看练习报告和解析").click(); 
    	    Reporter.log("提交并查看练习报告和解析");
    	    driver.findElementByName("错题解析").click();  
    	    Reporter.log("错题解析");
    	    driver.findElementByName("全部解析").click();  
    	    Reporter.log("全部解析");
            Thread.sleep(3000);	
            driver.pressKeyCode(4);  
            Reporter.log("返回单元列表");
        }

        }

	}
	
	@AfterClass
	public void tearDown()throws Exception{
		driver.quit();//测试完毕，关闭driver，不关闭将会导致会话还存在，下次启动就会报错
	}
	
	/**
	* 判断元素是否存在
	*/
	public boolean isElementExist(By Locator) {
	try {
	driver.findElement(Locator);
	return true;
	} catch (org.openqa.selenium.NoSuchElementException ex) {
	return false;
	}
	}
}
