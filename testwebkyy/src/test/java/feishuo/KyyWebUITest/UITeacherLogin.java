package feishuo.KyyWebUITest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UITeacherLogin {

	 public void Teacherlogin(WebDriver driver,String useid,String passid) throws Exception {
		    
		    // 教师登录
		    driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys(useid);
		    driver.findElement(By.id("userpassword")).clear();
		    driver.findElement(By.id("userpassword")).sendKeys(passid);
		    //driver.findElement(By.name("checksave")).click();//记住密码
		    Thread.sleep(500);
		    driver.findElement(By.xpath("//div[@class='teacher_tit']")).click();//火狐出现警告信息，要点击其他区域取消警告，不然会点击不到登录按钮
		    driver.findElement(By.id("loginsubmit")).click();//登录
		  }
}
