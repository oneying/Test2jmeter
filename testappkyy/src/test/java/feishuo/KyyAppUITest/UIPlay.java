package feishuo.KyyAppUITest;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class UIPlay {

	//播放
	public void Grade(AndroidDriver<WebElement> driver,int grade,int book)throws Exception{
		//教材目录
		//选择某年级
		List<WebElement>choosegrade=driver.findElementsByClassName("com.kouyuyi.kyystuapp:id/grade_num");
		choosegrade.get(grade).click();
		//选择某本书
		List<WebElement>choosebook=driver.findElementsById("com.kouyuyi.kyystuapp:id/title_view");
		choosebook.get(book).click();
	}
	
	public void Change(AndroidDriver<WebElement> driver)throws Exception{
		//点击书本名，可更换教材
		driver.findElementById("com.kouyuyi.kyystuapp:id/navigation_tv").click();
	}
	
	public void Pause(AndroidDriver<WebElement> driver)throws Exception{
		//播放
		driver.findElementById("com.kouyuyi.kyystuapp:id/pause_btn").click();
	}
	
	public void Next(AndroidDriver<WebElement> driver)throws Exception{
		//下一首
		driver.findElementById("com.kouyuyi.kyystuapp:id/next_btn").click();
	}
	
	public void Pre(AndroidDriver<WebElement> driver)throws Exception{
		//上一首
		driver.findElementById("com.kouyuyi.kyystuapp:id/pre_btn").click();
	}
	
	public void Download(AndroidDriver<WebElement> driver)throws Exception{
		//下载
		driver.findElementById("com.kouyuyi.kyystuapp:id/item_download_btn").click();
	}
	
	public void Delete(AndroidDriver<WebElement> driver)throws Exception{
		//删除
		driver.findElementById("com.kouyuyi.kyystuapp:id/item_delete_btn").click();	
	}
	public void Delete_no(AndroidDriver<WebElement> driver)throws Exception{
		//取消删除
		driver.findElementByName("取消").click();
	}
	public void Delete_yes(AndroidDriver<WebElement> driver)throws Exception{
		//确定删除
		driver.findElementByName("确定").click();	
	}
	
	public void Check(AndroidDriver<WebElement> driver)throws Exception{
		//勾选
		driver.findElementById("com.kouyuyi.kyystuapp:id/item_checkbox").click();	
	}
	
	public void Name(AndroidDriver<WebElement> driver)throws Exception{
		//音频名
		driver.findElementById("com.kouyuyi.kyystuapp:id/item_name_tv").click();
		
	}
	
	public void CheckStatu(AndroidDriver<WebElement> driver)throws Exception{
		//自定义播放/单循环播放
		driver.findElementById("com.kouyuyi.kyystuapp:id/checkbox").click();
	}
	
	public void List(AndroidDriver<WebElement> driver)throws Exception{
		//展开/收起音频列表
		driver.findElementById("com.kouyuyi.kyystuapp:id/handle_btn").click();
	}
}
