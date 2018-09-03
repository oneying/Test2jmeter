package feishuo.KyyAppUITest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
//安卓手机配置

	public AndroidDriver getAndroidDriver() throws Exception{
		AndroidDriver driver = null;
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
		
		//********红米2A
		capabilities.setCapability("deviceName","HM 2A");
		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");
		capabilities.setCapability("udid","1L520W120468");//物理机ID
		
		
		
		//---配置测试apk---
		capabilities.setCapability("appPackage","com.kouyuyi.kyystuapp");
		capabilities.setCapability("appActivity","com.kouyuyi.kyystuapp.zj.MainActivity");//启动
		capabilities.setCapability("appWaitActivity", ".activity.LoginActivity");//登录
		capabilities.setCapability("sessionOverride", true);//每次启动时覆盖session，否则第二次后运行会报错不能新建session  
		capabilities.setCapability("unicodeKeyboard", true);//设置键盘支持中文输入  
		capabilities.setCapability("resetKeyboard", true);//设置默认键盘为appium的键盘  

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//初始化
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
}
}


