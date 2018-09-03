package feishuo.KyyWebUITest;

import org.openqa.selenium.*;

public class UI3AUpload {

	//地区
	public void chooseCity(WebDriver driver,String name)throws Exception{
	   driver.findElement(By.xpath("//div[@id='select-city']")).click();//点击地区展开下拉表
	   WebElement city=driver.findElement(By.xpath("//div[@id='select-city']/div/ul/li[contains(text(),'"+name+"')]"));//选择哪城市
	   Thread.sleep(500);
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",city);
	   city.click();//点击选中的城市
	   Thread.sleep(1000);
	}
	
	//区县
	public void Town(WebDriver driver,String name)throws Exception{
		driver.findElement(By.id("townName")).sendKeys(name);
		Thread.sleep(1000);
	}
	
	//学校/单位
	public void School(WebDriver driver,String name)throws Exception{
		driver.findElement(By.id("schoolName")).sendKeys(name);
		Thread.sleep(1000);
	}
	
	//作者姓名
	public void Username(WebDriver driver,String name)throws Exception{
		driver.findElement(By.id("userName")).sendKeys(name);
		Thread.sleep(1000);
	}
	
	//联系手机
	public void Phone(WebDriver driver,String name)throws Exception{
		driver.findElement(By.id("phoneNo")).sendKeys(name);
		Thread.sleep(1000);
	}
	
	//资源内容相关
	public void Publish(WebDriver driver,String name)throws Exception{
		driver.findElement(By.id("publishName")).sendKeys(name);
		Thread.sleep(1000);
	}
	
	//资源所属年级
	public void chooseGrade(WebDriver driver,String name1,String name2)throws Exception{
		driver.findElement(By.xpath("//div[@id='select-grade']/input[@class='select-button']")).click();//点击年级展开下拉表
	    WebElement grade=driver.findElement(By.xpath("//div[@id='select-grade']/div/ul/li[contains(text(),'"+name1+"')]"));//选择哪年级
	    Thread.sleep(500);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", grade);
	    grade.click();//点击选中的年级
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#select-bookType > input.select-button")).click();//点击册展开下拉表
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div[@id='select-bookType']/div/ul/li[contains(text(),'"+name2+"')]")).click();//选择哪册
	    Thread.sleep(1000);
	}
	
	//资源类型
	public void chooseType(WebDriver driver,int value)throws Exception{
		driver.findElement(By.cssSelector("#select-resourceType > input.select-button")).click();//点击展开下拉表
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@id='select-resourceType']/div/ul/li["+value+"]")).click();//选择哪种类型
	    Thread.sleep(1000);
	}
	
	//资源名称
	public void Filename(WebDriver driver,String name)throws Exception{
		driver.findElement(By.id("fileName")).sendKeys(name);
		Thread.sleep(1000);
	}
	
	//删除已选的文件
	public void DelFile(WebDriver driver,int i)throws Exception{
		//删除第i个文件
		WebElement fileframe=driver.findElement(By.xpath("//div[@id='iframetd']/iframe["+i+"]"));//第几个文件
		driver.switchTo().frame(fileframe);
		driver.findElement(By.id("btn3")).click();//点击删除
        Thread.sleep(1000);
        driver.switchTo().defaultContent();//离开iframe
	}
	
	//上传提交
	public void Sub(WebDriver driver)throws Exception{
	    driver.findElement(By.linkText("上传提交")).click();
	    Thread.sleep(1000);
	}
	//提交成功
	public void OK(WebDriver driver)throws Exception{
	    driver.findElement(By.name("buttn1")).click();
	    Thread.sleep(1000);
	}
}
