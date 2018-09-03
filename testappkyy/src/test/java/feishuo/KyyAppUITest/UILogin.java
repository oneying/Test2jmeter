package feishuo.KyyAppUITest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.*;

public class UILogin {
//登录界面相关

		//选择登录的角色
		public void Role(AndroidDriver<WebElement> driver,String role) throws Exception{
		driver.findElementById("com.kouyuyi.kyystuapp:id/switch_role_tv").click();//点击角色切换
		if(role=="student"){
		 driver.findElement(By.id("com.kouyuyi.kyystuapp:id/radio_student")).click();//点击学生角色
		}else if(role=="teacher"){
		 driver.findElement(By.id("com.kouyuyi.kyystuapp:id/radio_teacher")).click();//点击教师角色
		}else if(role=="parent"){
		 driver.findElement(By.id("com.kouyuyi.kyystuapp:id/radio_parent")).click();//点击家长角色
		}
		Thread.sleep(1000);//1秒
		}
			
		//输入用户名和密码
		public void Login(AndroidDriver<WebElement> driver,String name,String pass) throws Exception{
		driver.findElementById("com.kouyuyi.kyystuapp:id/clear_iv").click();//点击“x”清空用户名输入框
		WebElement el_user=driver.findElement(By.id("com.kouyuyi.kyystuapp:id/input_username"));
		el_user.click();//点击用户名输入框
		el_user.sendKeys(name);//输入用户名
		
		WebElement el_passwd=driver.findElement(By.id("com.kouyuyi.kyystuapp:id/input_password"));
		el_passwd.click();//点击密码输入框
        //先清空密码框
		/*要删除一段文字:
		1. 获取文本长度
		2. 移动到文本最后
		3. 按下删除按钮，直到和文本一样长度
		*/
		driver.pressKeyCode(123);//光标移到文本最后
		for (int i = 0; i < 10; i++) {//获取不到密码框里文本长度，预设10次。
			driver.pressKeyCode(67);//按退格键
		}
		
		//再输入密码
		el_passwd.sendKeys(pass);
		//driver.pressKeyCode(4);//按返回键，收起键盘（有些手机会出现键盘，有些不出现）
		Thread.sleep(500);
		//点击登录
		driver.findElementById("com.kouyuyi.kyystuapp:id/button_login").click();
		Thread.sleep(5000);    	
		}
		
}
