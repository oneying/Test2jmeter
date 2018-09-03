package feishuo.KyyAppUITest;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class UISet {
//设置
    
	
	public void Clear_no(AndroidDriver<WebElement> driver)throws Exception{
	//清除缓存-取消
	  driver.findElementById("com.kouyuyi.kyystuapp:id/clear_layout").click();
	  driver.findElementByName("算了吧").click();
	}
	
	public void Clear_yes(AndroidDriver<WebElement> driver)throws Exception{
	//清除缓存-确定
		driver.findElementById("com.kouyuyi.kyystuapp:id/clear_layout").click();
	  driver.findElementByName("就要清除").click();
	}
	
	public void change_password(AndroidDriver<WebElement> driver,String old,String new1,String new2)throws Exception{
	//修改密码
	  driver.findElementById("com.kouyuyi.kyystuapp:id/layout_change_password").click();
	  //输入当前密码
	  driver.findElementById("com.kouyuyi.kyystuapp:id/edt_old_password").sendKeys(old);
	  //输入新密码
	  driver.findElementById("com.kouyuyi.kyystuapp:id/edt_new_password").sendKeys(new1);
	  //再次输入新密码
	  driver.findElementById("com.kouyuyi.kyystuapp:id/edt_new_password_affirm").sendKeys(new2);
	  //确定
	  driver.findElementById("com.kouyuyi.kyystuapp:id/btn_confirm").click();
	}
	
	public void Cancel(AndroidDriver<WebElement> driver)throws Exception{
	//取消
	  driver.findElementById("com.kouyuyi.kyystuapp:id/dialog_left_btn").click();
	}
	
	public void Sure(AndroidDriver<WebElement> driver)throws Exception{
	//确定
	  driver.findElementById("com.kouyuyi.kyystuapp:id/dialog_right_btn").click();
	}
	
	public void feedback(AndroidDriver<WebElement> driver)throws Exception{
	//意见反馈
	  driver.findElementById("com.kouyuyi.kyystuapp:id/feedback").click();
	}
	
	public void suggestion(AndroidDriver<WebElement> driver,String content,String contact)throws Exception{
	//建议
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_suggestion").click();
	  //输入详细内容
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_content").sendKeys(content); 
	  //输入联系方式
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_contact").sendKeys(contact); 
	  //提交
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_commit").click(); 
	}
	
	public void consult(AndroidDriver<WebElement> driver,String content,String contact)throws Exception{
	//咨询
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_consult").click();
	  //输入详细内容
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_content").sendKeys(content); 
	  //输入联系方式
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_contact").sendKeys(contact); 
	  //提交
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_commit").click(); 
	}
	
	public void complain(AndroidDriver<WebElement> driver,String content,String contact)throws Exception{
	//投诉
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_complain").click();
	  //输入详细内容
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_content").sendKeys(content); 
	  //输入联系方式
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_contact").sendKeys(contact); 
	  //提交
	  driver.findElementById("com.kouyuyi.kyystuapp:id/tv_commit").click(); 
	}
	
	public void about(AndroidDriver<WebElement> driver)throws Exception{
	//关于口语易
	  driver.findElementById("com.kouyuyi.kyystuapp:id/about_layout").click();
	}
	
	public void problem(AndroidDriver<WebElement> driver)throws Exception{
	//常见问题
	  driver.findElementById("com.kouyuyi.kyystuapp:id/problem_layout").click();
	}
	
	public void welcome(AndroidDriver<WebElement> driver)throws Exception{
	//欢迎页
	  driver.findElementById("com.kouyuyi.kyystuapp:id/welcome_layout").click();
	}
	
	public static void ExitLogin_no(AndroidDriver<WebElement> driver) throws InterruptedException{
		//退出登录-取消
	   driver.findElementById("com.kouyuyi.kyystuapp:id/exit_btn").click();//点击退出登录
	   driver.findElementByName("取消").click();//不退出
	   Thread.sleep(1000);
	}
	
	public static void ExitLogin_yes(AndroidDriver<WebElement> driver) throws InterruptedException{
		//退出登录-注销
		driver.findElementById("com.kouyuyi.kyystuapp:id/exit_btn").click();//点击退出登录
	    driver.findElementByName("注销").click();//退出
	    Thread.sleep(1000);
	
	}
}
