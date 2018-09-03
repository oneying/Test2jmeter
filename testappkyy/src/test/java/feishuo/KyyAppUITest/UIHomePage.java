package feishuo.KyyAppUITest;



import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;

public class UIHomePage {
//首页
	
	public void Training(AndroidDriver<WebElement> driver)throws Exception{
		//中间导航栏-同步训练
		List<WebElement>item=driver.findElementsById("com.kouyuyi.kyystuapp:id/item_layout");
		item.get(0).click();//点击同步训练
	}
	
	public void Exercise(AndroidDriver<WebElement> driver)throws Exception{
		//中间导航栏-练习题库
		List<WebElement>item=driver.findElementsById("com.kouyuyi.kyystuapp:id/item_layout");
		item.get(1).click();//点击练习题库
	}
	
	public void Topic(AndroidDriver<WebElement> driver)throws Exception{
		//中间导航栏-情景话题
		List<WebElement>item=driver.findElementsById("com.kouyuyi.kyystuapp:id/item_layout");
		item.get(2).click();//点击情景话题
	}
	
	public void Cartoon(AndroidDriver<WebElement> driver)throws Exception{
		//中间导航栏-卡通欣赏
		List<WebElement>item=driver.findElementsById("com.kouyuyi.kyystuapp:id/item_layout");
		item.get(3).click();//点击卡通欣赏
	}
	
	public void Past(AndroidDriver<WebElement> driver)throws Exception{
	    //往期回顾
		driver.findElementById("com.kouyuyi.kyystuapp:id/old_tv").click();
	}
	
	public void Home(AndroidDriver<WebElement> driver)throws Exception{
		//底部导航栏-首页
		driver.findElementById("com.kouyuyi.kyystuapp:id/home_radio_first").click();
	}
	
	public void Homework(AndroidDriver<WebElement> driver)throws Exception{
		//底部导航栏-作业
		driver.findElementById("com.kouyuyi.kyystuapp:id/home_radio_homework").click();
	}
	
	public void Play(AndroidDriver<WebElement> driver)throws Exception{
		//底部导航栏-播放
		driver.findElementById("com.kouyuyi.kyystuapp:id/home_play_iv").click();
	}
	
	public void Fighting(AndroidDriver<WebElement> driver)throws Exception{
		//底部导航栏-评测
		driver.findElementById("com.kouyuyi.kyystuapp:id/home_radio_fighting").click();
	}
	
	public void Me(AndroidDriver<WebElement> driver)throws Exception{
		//底部导航栏-我的
		driver.findElementById("com.kouyuyi.kyystuapp:id/home_radio_me").click();
	}
}
