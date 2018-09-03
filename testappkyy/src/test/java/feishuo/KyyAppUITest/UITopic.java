package feishuo.KyyAppUITest;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class UITopic {
//情景话题
	public void Grade(AndroidDriver<WebElement> driver,int grade,int book)throws Exception{
		//教材目录
		//选择某年级
		List<WebElement>choosegrade=driver.findElementsByClassName("com.kouyuyi.kyystuapp:id/grade_num");
		choosegrade.get(grade).click();
		//选择某本书
		List<WebElement>choosebook=driver.findElementsById("com.kouyuyi.kyystuapp:id/title_view");
		choosebook.get(book).click();
	}
	public void Unit(AndroidDriver<WebElement> driver,int unit)throws Exception{
	    //单元列表
		//选择某单元
		List<WebElement>chooseunit=driver.findElementsById("com.kouyuyi.kyystuapp:id/lesson_title_tv");
		chooseunit.get(unit).click();
	}
	
	public void Change(AndroidDriver<WebElement> driver)throws Exception{
		//点击书本名更换教材
	    driver.findElementById("com.kouyuyi.kyystuapp:id/textView").click();
	}
	
	public void Download(AndroidDriver<WebElement> driver)throws Exception{
		//批量下载
	    driver.findElementById("com.kouyuyi.kyystuapp:id/download_layout").click();
	}
	
	public void Delete(AndroidDriver<WebElement> driver)throws Exception{
		//批量删除
	    driver.findElementById("com.kouyuyi.kyystuapp:id/delete_layout").click();
	}
	
	public void NoDelete(AndroidDriver<WebElement> driver)throws Exception{
		//取消删除
	    driver.findElementById("com.kouyuyi.kyystuapp:id/dialog_left_btn").click();
	}
	
	public void YseDelete(AndroidDriver<WebElement> driver)throws Exception{
		//确定删除
	    driver.findElementById("com.kouyuyi.kyystuapp:id/dialog_right_btn").click();
	}
	
	public void Part(AndroidDriver<WebElement> driver,int num)throws Exception{
		//Part
		List<WebElement>choose=driver.findElementsById("com.kouyuyi.kyystuapp:id/item_title_tv");
		choose.get(num).click();//选择某Part
	}

	
	public void Play(AndroidDriver<WebElement> driver)throws Exception{
		//播放音频
		driver.findElementById("com.kouyuyi.kyystuapp:id/conversation_layout").click();
		Thread.sleep(500);
		//停止播放音频
		driver.findElementById("com.kouyuyi.kyystuapp:id/play_cp").click();
		Thread.sleep(500);
	}
	
	public void PlayList(AndroidDriver<WebElement> driver)throws Exception{
		//播放列表-点击底部的播放按钮
		driver.findElementById("com.kouyuyi.kyystuapp:id/play_stop_iv").click();//开始播放
		Thread.sleep(500);
		driver.findElementById("com.kouyuyi.kyystuapp:id/playmode_btn").click();//点击播放模式
		Thread.sleep(1000);
		driver.findElementById("com.kouyuyi.kyystuapp:id/play_stop_iv").click();//停止播放
		Thread.sleep(500);
	}
}
