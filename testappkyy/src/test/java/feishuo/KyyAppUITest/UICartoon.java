package feishuo.KyyAppUITest;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class UICartoon {

public void Manage(AndroidDriver<WebElement>driver)throws Exception{
	//批量管理
	driver.findElementById("com.kouyuyi.kyystuapp:id/title_right_iv").click();
}	

public void Cancel(AndroidDriver<WebElement>driver)throws Exception{
	//好心保留
	driver.findElementById("com.kouyuyi.kyystuapp:id/dialog_left_btn").click();
}	

public void Delete(AndroidDriver<WebElement>driver)throws Exception{
	//无情删除
	driver.findElementById("com.kouyuyi.kyystuapp:id/dialog_right_btn").click();
}	

public void Download(AndroidDriver<WebElement>driver)throws Exception{
	//下载
	driver.findElementByName("下载").click();
}

public void Play(AndroidDriver<WebElement>driver)throws Exception{
	//播放
	driver.findElementByName("播放").click();
}

public void Grade(AndroidDriver<WebElement>driver)throws Exception{
	//年级段
	driver.findElementById("com.kouyuyi.kyystuapp:id/button1").click();
}

public void Grade_all(AndroidDriver<WebElement>driver)throws Exception{
	//全部
	driver.findElementByName("全部").click();
}

public void Grade_1_3(AndroidDriver<WebElement>driver)throws Exception{
	//1~3年级
	driver.findElementByName("1~3年级").click();
}
public void Grade_4_6(AndroidDriver<WebElement>driver)throws Exception{
	//4~6年级
	driver.findElementByName("4~6年级").click();
}
public void Grade_7_9(AndroidDriver<WebElement>driver)throws Exception{
	//初中阶段
	driver.findElementByName("初中阶段").click();
}

public void Grade_10_12(AndroidDriver<WebElement>driver)throws Exception{
	//高中阶段
	driver.findElementByName("高中阶段").click();
}

public void State(AndroidDriver<WebElement>driver)throws Exception{
	//状态
	driver.findElementById("com.kouyuyi.kyystuapp:id/button2").click();
}

public void State_all(AndroidDriver<WebElement>driver)throws Exception{
	//全部
	driver.findElementByName("全部").click();
}

public void State_downloaded(AndroidDriver<WebElement>driver)throws Exception{
	//已下载
	driver.findElementByName("已下载").click();
}

public void State_notdownload(AndroidDriver<WebElement>driver)throws Exception{
	//未下载
	driver.findElementByName("未下载").click();
}

}
