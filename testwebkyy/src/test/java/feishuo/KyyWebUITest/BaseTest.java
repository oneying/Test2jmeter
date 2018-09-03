package feishuo.KyyWebUITest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//3种浏览器
public class BaseTest {

	 public WebDriver getWebDriver(String browser){

	       WebDriver driver = null;

	       if("ie".equals(browser)){

	       //ie

	       //System.setProperty("webdriver.ie.driver","C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");//64位
	       System.setProperty("webdriver.ie.driver","C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer.exe");//32位
	       driver = new InternetExplorerDriver();

	       }

	       else if ("chrome".equals(browser)){

	       //chrome

	       System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	       driver = new ChromeDriver(); 

	       }  

	       else{

	       //firefox

	       System.setProperty("webdriver.gecko.driver","C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
	       driver = new FirefoxDriver();

	       }

	       driver.manage().window().maximize();//最大化

	       return driver;

	 }
}
