package feishuo.KyyAppUITest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class UIExercise {


	public void Change(AndroidDriver<WebElement> driver)throws Exception{
		//点击选择教材
	    driver.findElementByName("选择教材").click();
	}
	
	public void Unit(AndroidDriver<WebElement> driver)throws Exception{
		//单元同步
	    driver.findElementByName("单元同步").click();
	}
	
	public void Special(AndroidDriver<WebElement> driver)throws Exception{
		//专项练习
	    driver.findElementByName("专项练习").click();
	}
	
	public void Listen(AndroidDriver<WebElement> driver)throws Exception{
		//听力练习
	    driver.findElementByName("听力练习").click();
	}
	
	public void Written(AndroidDriver<WebElement> driver)throws Exception{
		//笔试练习
	    driver.findElementByName("笔试练习").click();
	}
	
	public void Oneunit(AndroidDriver<WebElement> driver,int index)throws Exception{
		//选择某单元或专项
	    List<WebElement>tit=driver.findElementsById("com.kouyuyi.kyystuapp:id/lesson_title_tv");
	    tit.get(index).click();
	}
	
	public void Grade(AndroidDriver<WebElement> driver,int grade,int book)throws Exception{
		//教材目录
		//选择某年级
		List<WebElement>choosegrade=driver.findElementsByClassName("android.widget.RadioButton");
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
	
	public void Cancel(AndroidDriver<WebElement> driver)throws Exception{
		//取消练习
	    driver.findElementById("com.kouyuyi.kyystuapp:id/dialog_cancel").click();
	}
	
	public void xxx(AndroidDriver<WebElement> driver)throws Exception{
		//
	}
	
}
