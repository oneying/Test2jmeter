package feishuo.KyyAppUITest;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class UIPrize {
//奖品中心
	public void smgz(AndroidDriver<WebElement> driver)throws Exception{
		//树苗规则
		driver.findElementByAccessibilityId("smgz_nav").click();
	}
	
	public void smkc(AndroidDriver<WebElement> driver)throws Exception{
		//树苗库存
		driver.findElementByAccessibilityId("smkc_nav").click();
	}
	
	public void dhjl(AndroidDriver<WebElement> driver)throws Exception{
		//兑换记录
		driver.findElementByAccessibilityId("dhjl_nav").click();
	}
	
	public void back(AndroidDriver<WebElement> driver)throws Exception{
		//返回
		driver.findElementById("com.kouyuyi.kyystuapp:id/ll_back").click();
	}
	
	public void all(AndroidDriver<WebElement> driver)throws Exception{
		//更多
		driver.findElementByAccessibilityId("更多 〉").click();
	}
	
	public void buy(AndroidDriver<WebElement> driver)throws Exception{
		//我要兑换
		driver.findElementByAccessibilityId("我要兑换").click();
	}
	
	public void dialog_ok2(AndroidDriver<WebElement> driver)throws Exception{
		//积分不足和未订购的提示框-确定
		driver.findElementByAccessibilityId("确定 ").click();
	}
	
}
