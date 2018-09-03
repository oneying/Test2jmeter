package feishuo.KyyAppUITest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Calculator {
	
	public AndroidDriver driver;
	
	@Test
	public void testCalculator() throws Exception{
		
        //启动appium
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		//*******安卓模拟器
        /*capabilities.setCapability("deviceName","Android Emulator");
		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.2");
		*/
		
		//********华为honor
		/*capabilities.setCapability("deviceName","NEM-TL00H");
		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","6.0");
		capabilities.setCapability("udid","4YUDU16510018241");//物理机ID
        */
		
		//---配置测试apk---,华为honor的计算器
		/*capabilities.setCapability("appPackage","com.android.calculator2");
		capabilities.setCapability("appActivity",".Calculator");
		capabilities.setCapability("sessionOverride", true);//每次启动时覆盖session，否则第二次后运行会报错不能新建session  
		capabilities.setCapability("unicodeKeyboard", true);//设置键盘支持中文输入  
		capabilities.setCapability("resetKeyboard", false);//设置默认键盘为appium的键盘  
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//初始化
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//计算
		driver.findElementByName("1").click();
		driver.findElementByName("2").click();
		driver.findElementById("com.android.calculator2:id/del").click();
		driver.findElementById("com.android.calculator2:id/plus").click();
		driver.findElementByName("3").click();
		driver.findElementById("com.android.calculator2:id/equal").click();//1+3=4
		Thread.sleep(2000);
		Reporter.log("计算器：1+3=4");
		*/
		
		
		//********红米2A
		capabilities.setCapability("deviceName","HM 2A");
		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");
		capabilities.setCapability("udid","1L520W120468");//物理机ID
		
		
		
		driver.quit();//退出

}
	
}
