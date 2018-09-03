package feishuo.KyyWebUITest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;

public class UIHomeworkSet {
	public String demand,msg;
    
	 // 布置作业

	public void chooseclass(WebDriver driver,String classid) throws Exception {
	    driver.findElement(By.id(classid)).click();//选择班级：class-1是全部  
	}
	
	public void time(WebDriver driver,String starttime,String endtime)throws Exception{ 
       //***此程序目前下年下月都不能选,待修改
        // 开始时间，默认今天
	    //时间格式2017,4,2
	    driver.findElement(By.id("ftime")).click();
	    WebElement starFrame = driver.findElement(By.xpath("//html/body/div[contains(@style,'left: 370px')]/iframe"));
        driver.switchTo().frame(starFrame);
	    driver.findElement(By.xpath("//td[@onclick='day_Click("+starttime+");']")).click();//starttime格式：2017,4,2
	    driver.switchTo().defaultContent();
	    
	    // 结束时间，默认今天
	    //时间格式2017,4,2
	    driver.findElement(By.id("etime")).click();//第一次点击结束时间，结束时间变成跟开始时间一致
	    driver.findElement(By.id("etime")).click();//第二次点击结束时间，弹出修改时间框，修改结束时间
	    WebElement endFrame = driver.findElement(By.xpath("//html/body/div[contains(@style,'left: 600px')]/iframe"));
        driver.switchTo().frame(endFrame);
	    driver.findElement(By.xpath("//td[@onclick='day_Click("+endtime+");']")).click();//endtime格式：2017,5,1
	    driver.switchTo().defaultContent();
	}
	
	    public void etime_hm(WebDriver driver,int hourid,int minuteid)throws Exception{
	    // 结束时间的小时
	    driver.findElement(By.xpath("//div[@id='E_time1']/i")).click();
	    Thread.sleep(500);
	    //hourid:范围00~23，即0点到23点。
	    WebElement hourelement = driver.findElement(By.xpath("//div[@id='E_time1']/div/ul/li[@data-value='"+hourid+"']"));
        //使用JavaScript的scrollIntoView()函数将滚动条滑动到页面的制定元素位置
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", hourelement);
        hourelement.click();
        Thread.sleep(500);
	    
	    // 结束时间的分钟
	    driver.findElement(By.xpath("//div[@id='E_time2']/i")).click();
	    Thread.sleep(500);
	    //minuteid:范围00~59，即0分到59分。
	    WebElement minuteelement = driver.findElement(By.xpath("//div[@id='E_time2']/div/ul/li[@data-value='"+minuteid+"']"));
        //使用JavaScript的scrollIntoView()函数将滚动条滑动到页面的制定元素位置
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", minuteelement);
        minuteelement.click();
	    Thread.sleep(500);
	    }
	
	
	public void pop_1(WebDriver driver)throws Exception{
	    // 作业要求-常用语1
	    driver.findElement(By.id("popRequireBox")).click();
	    driver.findElement(By.linkText("请同学们认真完成作业并按时提交")).click();
	}
	
	public void pop_2(WebDriver driver)throws Exception{
	    // 作业要求-常用语2
	    driver.findElement(By.id("popRequireBox")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'请同学们认真完成作业并按时提交')])[2]")).click();
	}
	
	 public void pop_close(WebDriver driver)throws Exception{
		    // 关闭常用语框
		    driver.findElement(By.id("popRequireBox")).click();
		    driver.findElement(By.id("closeMinPop01")).click();
    }
	 
	 public String getDemand(){
		 //这是作业要求
		 return demand;
	 }
	 public void setDemand(String demand){//可输入50字以内
		 this.demand=demand;
	 }
	public void homeworkdemand(WebDriver driver)throws Exception{
	// 作业要求-键盘输入
	    driver.findElement(By.id("homeWorkDemand")).click();
	    driver.findElement(By.id("homeWorkDemand")).clear();
	    driver.findElement(By.id("homeWorkDemand")).sendKeys(getDemand());//作业要求可输入50字以内
	}
	   
	    public void chooesAudio(WebDriver driver)throws Exception{
	    // 提交录音:默认勾选
	    driver.findElement(By.id("SubAudio")).click();
	    }
	    
	    public void chooesMsg(WebDriver driver)throws Exception{
	    // 勾选短信通知
	    driver.findElement(By.id("SubMsg")).click();
	    }
	    
	    public void Msg_1(WebDriver driver)throws Exception{
	    // 短信常用语1
	    driver.findElement(By.id("popMsgBox")).click();
	    driver.findElement(By.cssSelector("#msgWordBox > p > a")).click();
	    }
	    
	    public void Msg_2(WebDriver driver)throws Exception{
	    // 短信常用语2
	    driver.findElement(By.id("popMsgBox")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'请同学们认真完成作业并按时提交')])[4]")).click();
	    }
	    
	    public String getMsg(){
	    	//这是短信通知
			 return msg;
		 }
		 public void setMsg(String msg){//可输入50字以内
			 this.msg=msg;
		 }
	    public void Msgtext(WebDriver driver)throws Exception{
	    // 键盘输入短信内容
	    driver.findElement(By.id("msgText")).click();
	    driver.findElement(By.id("msgText")).clear();
	    driver.findElement(By.id("msgText")).sendKeys(getMsg());
	    }
	    
	   
		public void msg_close(WebDriver driver)throws Exception{
	    // 关闭短信常用语框
	    driver.findElement(By.id("popMsgBox")).click();
	    driver.findElement(By.id("closeMinPop02")).click();
	    }
		
		public void addhw(WebDriver driver)throws Exception{
		// 添加口语作业
	    driver.findElement(By.id("AddHomeworkDet")).click();
	    Thread.sleep(500);
		}
		
	    public void choosegrade(WebDriver driver,String juniorid,String gradeid,String bookid)throws Exception{
	    driver.findElement(By.id("changeBox")).click();//更换素材
	    
	    driver.findElement(By.id(juniorid)).click();//学段：junior_0是小学，1是初中，2是高中
	    driver.findElement(By.id(gradeid)).click();//年级：grade_1是一年级，12是高三
	    Thread.sleep(500);
	    driver.findElement(By.id(bookid)).click();//课本：book-2是第1行第1列的课本，book-3是第1行第2列的课本
	    driver.findElement(By.id("confirmSB")).click();//确定
	    Thread.sleep(500);
	    }
	    public void chooseunit(WebDriver driver,int unitid,String langduid,String beisongid,String tingshuoid,String tingxieid)throws Exception{
	    driver.findElement(By.xpath("(//div[@name='chooseUnit'])["+unitid+"]")).click();//目录单元，[2]是第2单元
	    Thread.sleep(500);
	    driver.findElement(By.id(langduid)).click();//朗读ts1_1
	    Thread.sleep(500);
	    driver.findElement(By.id(beisongid)).click();//背诵tx1_1
	    Thread.sleep(500);
	    driver.findElement(By.id(tingshuoid)).click();//听说ld1_1
	    Thread.sleep(500);
	    driver.findElement(By.id(tingxieid)).click();//听写bs1_1
	    Thread.sleep(500);
	    driver.findElement(By.id("confirmSC")).click();//确认选择
		Thread.sleep(500);
	    }
	    
	    public void amendhw(WebDriver driver)throws Exception{
	    	driver.findElement(By.id("amendSC")).click();//修改口语作业素材
	    	Thread.sleep(500);
	    }
	    
	    public void HomeworkSetOK(WebDriver driver)throws Exception{
	    	//提交作业
	    driver.findElement(By.linkText("确认提交")).click();
	    Thread.sleep(1000);
	  }
	    public void setOK(WebDriver driver)throws Exception{
	    	//确定发布作业和发送短信
	    driver.findElement(By.id("_ButtonOK_0")).click();
	    Thread.sleep(1000);
	  }
	    public void cancel(WebDriver driver)throws Exception{
	    	//取消发布作业和系统提示：添加作业成功
	    driver.findElement(By.id("_ButtonCancel_0")).click();
	    Thread.sleep(1000);
	    }
}
