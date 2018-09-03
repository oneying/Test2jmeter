package feishuo.KyyWebUITest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UINavigationBar {
//导航栏
	
	public void HomePage(WebDriver driver)throws Exception{
		//首页
		driver.findElement(By.xpath("//div[@class='kyy_menu']/ul/li[1]/a/span")).click();
	}
	
	public void TeacherAbout(WebDriver driver)throws Exception{
		//教师频道
		driver.findElement(By.xpath("//div[@class='kyy_menu']/ul/li[2]/a/span")).click();
	}
	
	public void ParentAbout(WebDriver driver)throws Exception{
		//家长频道
		driver.findElement(By.xpath("//div[@class='kyy_menu']/ul/li[3]/a/span")).click();
	}
	
	public void DownloadCenter(WebDriver driver)throws Exception{
		//下载中心
		driver.findElement(By.xpath("//div[@class='kyy_menu']/ul/li[4]/a/span")).click();
	}
	
	public void Class3A(WebDriver driver)throws Exception{
		//3A课堂
		driver.findElement(By.xpath("//div[@class='kyy_menu']/ul/li[5]/a/span")).click();
	}
	
	public void ActivityCenter(WebDriver driver)throws Exception{
		//活动中心
		driver.findElement(By.xpath("//div[@class='kyy_menu']/ul/li[6]/a/span")).click();
	}
	
	public void AboutUs(WebDriver driver)throws Exception{
		//关于我们
		driver.findElement(By.xpath("//div[@class='kyy_menu']/ul/li[7]/a/span")).click();
	}
}
