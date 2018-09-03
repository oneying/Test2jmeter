package feishuo.KyyAppUITest;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class UIMe {
//我的
	public void Name(AndroidDriver<WebElement> driver)throws Exception{
	//用户名
	  driver.findElementById("com.kouyuyi.kyystuapp:id/name_tv").click();
	}
	
	public void Score(AndroidDriver<WebElement> driver)throws Exception{
	//历史成绩
	  driver.findElementByName("历史成绩").click();
	}
	
	public void Buy(AndroidDriver<WebElement> driver)throws Exception{
	//订购
	  driver.findElementByName("订购").click();
	}
	
	public void Cancel(AndroidDriver<WebElement> driver)throws Exception{
	//取消订购
	  driver.findElementByName("取消").click();
	}
	
	public void IBuy(AndroidDriver<WebElement> driver)throws Exception{
	//我要订购
	  driver.findElementByName("我要订购").click();
	}
	
	public void Mobile_pay(AndroidDriver<WebElement> driver)throws Exception{
	//中国移动手机话费支付
	  driver.findElementById("com.kouyuyi.kyystuapp:id/cb_mobile_pay").click();
	  //点击确定
	  driver.findElementById("com.kouyuyi.kyystuapp:id/btn_confirm").click();
	}
	
	public void Normal_pay(AndroidDriver<WebElement> driver)throws Exception{
	//支付宝微信支付
	  driver.findElementById("com.kouyuyi.kyystuapp:id/cb_normal_pay").click();
	//点击确定
	  driver.findElementById("com.kouyuyi.kyystuapp:id/btn_confirm").click();
	}
	
	public void Prize(AndroidDriver<WebElement> driver)throws Exception{
	//奖品中心
	  driver.findElementByName("奖品中心").click();
	}
	
	public void Set(AndroidDriver<WebElement> driver)throws Exception{
	//设置
		EverySwipe swipe=new EverySwipe();
		swipe.swipeToUp(driver, 1);//向上划1下
		driver.findElementByName("设置").click();//点击“设置”
		Thread.sleep(1000);
	}
	
	public void Phonenumber(AndroidDriver<WebElement> driver)throws Exception{
	//手机号
		EverySwipe swipe=new EverySwipe();
		swipe.swipeToUp(driver, 1);//向上划1下
	    driver.findElementByName("手机号").click();
	}
}
