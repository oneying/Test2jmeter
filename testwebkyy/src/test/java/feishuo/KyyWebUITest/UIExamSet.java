package feishuo.KyyWebUITest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIExamSet {
	//创建考试
	public String demand,msg;
	
	public void chooseclass(WebDriver driver,String classid) throws Exception {
	    driver.findElement(By.id(classid)).click();//选择班级：class-1是全部  
	}
	
	public void time(WebDriver driver,String starttime,String endtime)throws Exception{ 
	       //***此程序目前下年下月都不能选,待修改
	        // 开始时间，默认今天
		    //时间格式2017,4,2
		    driver.findElement(By.id("d_ftime")).click();
		    WebElement starFrame = driver.findElement(By.xpath("//html/body/div[contains(@style,'left: 370px')]/iframe"));
	        driver.switchTo().frame(starFrame);
		    driver.findElement(By.xpath("//td[@onclick='day_Click("+starttime+");']")).click();//starttime格式：2017,4,2
		    driver.switchTo().defaultContent();
		    
		    // 结束时间，默认今天
		    //时间格式2017,4,2
		    driver.findElement(By.id("d_etime")).click();//点击结束时间
		    WebElement endFrame = driver.findElement(By.xpath("//html/body/div[contains(@style,'left: 870px')]/iframe"));
	        driver.switchTo().frame(endFrame);
		    driver.findElement(By.xpath("//td[@onclick='day_Click("+endtime+");']")).click();//endtime格式：2017,5,1
		    driver.switchTo().defaultContent();
		}
		
	       public void ftime_hm(WebDriver driver,String hourid,String minuteid)throws Exception{
		    // 开始时间的小时
		    driver.findElement(By.xpath("//div[@id='h_ftime']/i")).click();
		    Thread.sleep(500);
		    //hourid:范围00~23，即0点到23点。
		    WebElement hourelement = driver.findElement(By.xpath("//div[@id='h_ftime']/div/ul/li[@data-value='"+hourid+"']"));
	        //使用JavaScript的scrollIntoView()函数将滚动条滑动到页面的制定元素位置
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", hourelement);
	        hourelement.click();
	        Thread.sleep(500);
		    
		    // 开始时间的分钟
		    driver.findElement(By.xpath("//div[@id='m_ftime']/i")).click();
		    Thread.sleep(500);
		    //minuteid:范围00~59，即0分到59分。
		    WebElement minuteelement = driver.findElement(By.xpath("//div[@id='m_ftime']/div/ul/li[@data-value='"+minuteid+"']"));
	        //使用JavaScript的scrollIntoView()函数将滚动条滑动到页面的制定元素位置
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", minuteelement);
	        minuteelement.click();
		    Thread.sleep(500);
		    }
		
		    public void etime_hm(WebDriver driver,String hourid,String minuteid)throws Exception{
		    // 结束时间的小时
		    driver.findElement(By.xpath("//div[@id='h_etime']/i")).click();
		    Thread.sleep(500);
		    //hourid:范围00~23，即0点到23点。
		    WebElement hourelement = driver.findElement(By.xpath("//div[@id='h_etime']/div/ul/li[@data-value='"+hourid+"']"));
	        //使用JavaScript的scrollIntoView()函数将滚动条滑动到页面的制定元素位置
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", hourelement);
	        hourelement.click();
	        Thread.sleep(500);
		    
		    // 结束时间的分钟
		    driver.findElement(By.xpath("//div[@id='m_etime']/i")).click();
		    Thread.sleep(500);
		    //minuteid:范围00~59，即0分到59分。
		    WebElement minuteelement = driver.findElement(By.xpath("//div[@id='m_etime']/div/ul/li[@data-value='"+minuteid+"']"));
	        //使用JavaScript的scrollIntoView()函数将滚动条滑动到页面的制定元素位置
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", minuteelement);
	        minuteelement.click();
		    Thread.sleep(500);
		    }
		
		
		public void pop_1(WebDriver driver)throws Exception{
		    // 考试要求-常用语1
		    driver.findElement(By.id("popRequireBox")).click();
		    driver.findElement(By.linkText("请同学们认真完成考试并按时提交")).click();
		}
		
		public void pop_2(WebDriver driver)throws Exception{
		    // 考试要求-常用语2
		    driver.findElement(By.id("popRequireBox")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'请同学们认真完成考试并按时提交')])[2]")).click();
		}
		
		 public void pop_close(WebDriver driver)throws Exception{
			    // 关闭常用语框
			    driver.findElement(By.id("popRequireBox")).click();
			    driver.findElement(By.id("closeMinPop01")).click();
	    }
		 
		 public String getDemand(){
			 //这是考试要求
			 return demand;
		 }
		 public void setDemand(String demand){//可输入50字以内
			 this.demand=demand;
		 }
		public void demand(WebDriver driver)throws Exception{
		// 考试要求-键盘输入
		    driver.findElement(By.id("homeWorkDemand")).click();
		    driver.findElement(By.id("homeWorkDemand")).clear();
		    driver.findElement(By.id("homeWorkDemand")).sendKeys(getDemand());//考试要求可输入50字以内
		}
		   
		    public void chooesAudio(WebDriver driver)throws Exception{
		    // 提交录音:默认不勾选
		    driver.findElement(By.id("SubAudio")).click();
		    }
		    
		    public void showScore(WebDriver driver,int i)throws Exception{
			    // 是否显示分数:默认不显示
			    driver.findElement(By.id("showScore"+i)).click();//1是全部不显示分数，2是全部显示分数，3是付费用户显示分数
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
		    driver.findElement(By.xpath("(//a[contains(text(),'请同学们认真完成考试并按时提交')])[4]")).click();
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
			
			public void addexam(WebDriver driver)throws Exception{
			// 添加考试试题
		    driver.findElement(By.id("AddExamDet")).click();
		    Thread.sleep(500);
			}
			
		    public void choosegrade(WebDriver driver,String gradeid)throws Exception{
		    driver.findElement(By.id("select-grade")).click();//点击展开年级下拉表
		    Thread.sleep(500);
		    //gradeid:范围1001~1012，即一年级到高三，-1为全部年级。
		    WebElement gradeelement = driver.findElement(By.xpath("//div[@id='select-grade']/div/ul/li[@data-value='"+gradeid+"']"));
	        //使用JavaScript的scrollIntoView()函数将滚动条滑动到页面的制定元素位置
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", gradeelement);
	        gradeelement.click();
		    Thread.sleep(500);
		    }
		    
		    public void chooseType(WebDriver driver,int typeid)throws Exception{
		    //考试类型
		    driver.findElement(By.id("select-examType")).click();//点击展开考试类型下拉表
		    Thread.sleep(500);
		    driver.findElement(By.xpath("//div[@id='select-examType']/div/ul/li[@data-value='"+typeid+"']")).click();//-1是全部，0是水平考试，1是听力考试
            Thread.sleep(500);
		    }
		    
		    public void search(WebDriver driver)throws Exception{
		    driver.findElement(By.id("testSearch")).click();//点击搜索
			Thread.sleep(500);
		    }
		    
		    //选择试卷
		    public void chooseExamPaper(WebDriver driver,int i)throws Exception{
		    driver.findElement(By.xpath("//table[@id='tb_01']/tbody/tr["+i+"]/td/a[contains(text(),'查看试题')]")).click();//tr[2]是第1行试卷，查看第i行的试卷
		    Thread.sleep(1000);
		    driver.findElement(By.cssSelector("#_Draghandle_0 > div")).click();//关闭试卷
		    driver.findElement(By.xpath("//table[@id='tb_01']/tbody/tr["+i+"]/td/div")).click();//tr[2]是第1行试卷,选择第i行的试卷
		    Thread.sleep(500);
		    driver.findElement(By.id("confirmSC")).click();//确认选择
			Thread.sleep(500);
		    }
		    
		    public void amendhw(WebDriver driver)throws Exception{
		    	driver.findElement(By.id("amendSC")).click();//修改口语考试
		    	Thread.sleep(500);
		    }
		    
		    public void ExamSetOK(WebDriver driver)throws Exception{
		    	//提交考试
		    driver.findElement(By.linkText("确认提交")).click();
		    Thread.sleep(1000);
		  }
		    public void setOK(WebDriver driver)throws Exception{
		    	//确定发布考试和发送短信
		    driver.findElement(By.id("_ButtonOK_0")).click();
		    Thread.sleep(1000);
		  }
		    public void cancel(WebDriver driver)throws Exception{
		    	//取消发布作业和系统提示：添加考试成功
		    driver.findElement(By.id("_ButtonCancel_0")).click();
		    Thread.sleep(1000);
		    }
	}

