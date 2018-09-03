package feishuo.KyyAppUITest;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class UIFighting {
//评测
	public void RankingList(AndroidDriver<WebElement> driver)throws Exception{
		//排行榜
		driver.findElementById("com.kouyuyi.kyystuapp:id/title_right_iv").click();
	}
	
	public void Level(AndroidDriver<WebElement> driver)throws Exception{
		//水平测试
		driver.findElementById("com.kouyuyi.kyystuapp:id/item_img_layout").click();
	}
	
	public void Guide(AndroidDriver<WebElement> driver)throws Exception{
		//引导图
		driver.findElementById("com.kouyuyi.kyystuapp:id/guide_img").click();
	}
	
	public void Play(AndroidDriver<WebElement> driver)throws Exception{
		//播放
		driver.findElementById("com.kouyuyi.kyystuapp:id/play_cp").click();
	}
	
	public void Record(AndroidDriver<WebElement> driver)throws Exception{
		//录音
		driver.findElementById("com.kouyuyi.kyystuapp:id/record_cp").click();
	}
	
	public void Remark(AndroidDriver<WebElement> driver)throws Exception{
		//名师
		driver.findElementById("com.kouyuyi.kyystuapp:id/remark_cp").click();
	}
	
	public void MyAudio(AndroidDriver<WebElement> driver)throws Exception{
		//用户录音播放
		driver.findElementById("com.kouyuyi.kyystuapp:id/my_audio_cp").click();
	}
	
	public void Again(AndroidDriver<WebElement> driver)throws Exception{
		//重新闯关
		driver.findElementById("com.kouyuyi.kyystuapp:id/left_iv").click();
	}
	
	public void Strengthen(AndroidDriver<WebElement> driver)throws Exception{
		//我要加强
		driver.findElementById("com.kouyuyi.kyystuapp:id/right_iv").click();
	}
}
