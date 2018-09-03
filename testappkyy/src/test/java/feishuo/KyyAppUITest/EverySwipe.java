package feishuo.KyyAppUITest;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

/*
 * driver（就是把appiudriver对象传进来)
 * num（是只滑动的次数，本人在做相册 翻页测试什么的滑动, 或者滑动到列表底部,就直接输入次数就行了）
 */
public class EverySwipe {

    /** 
     * 上滑 
     *  
     * @param driver 
     * 
     * @param num 
     * @throws InterruptedException 
     */  
    public static void swipeToUp(AndroidDriver<WebElement> driver,int num) throws InterruptedException {  
        int width = driver.manage().window().getSize().width;  
        int height = driver.manage().window().getSize().height;  
        for (int i = 0; i < num; i++) { 
        	TouchAction swipe = new TouchAction(driver).press(width/2,height*3/4).waitAction(2000).moveTo(width/2, height/4).release();
            swipe.perform();
			
        	Thread.sleep(1000);  
        }
    }  
      
    /** 
     * 下拉 
     *  
     * @param driver 
     * 
     * @param num 
     * @throws InterruptedException 
     */  
    public static void swipeToDown(AndroidDriver<WebElement> driver,int num) throws InterruptedException {  
        int width = driver.manage().window().getSize().width;  
        int height = driver.manage().window().getSize().height;  
        System.out.println(width);  
        System.out.println(height);  
        for (int i = 0; i < num; i++) {  
            
            TouchAction swipe = new TouchAction(driver).press(width / 2, height / 4).waitAction(2000).moveTo(width / 2, height * 3 / 4).release();
            swipe.perform();
            
            Thread.sleep(1000);   
        }  
    }  
      
    /** 
     * 向左滑动 
     *   
     * @param driver 
     *  
     * @param num 
     * @throws InterruptedException 
     */  
    public static void swipeToLeft(AndroidDriver<WebElement> driver,int num) throws InterruptedException {  
        int width = driver.manage().window().getSize().width;  
        int height = driver.manage().window().getSize().height;  
        for (int i = 0; i < num; i++) {  
            
            TouchAction swipe = new TouchAction(driver).press(width *9/10, height * 9/10).waitAction(2000).moveTo(width / 10, height * 9/10).release();
            swipe.perform();
            
            Thread.sleep(1000);   
        }  
    }  
      
    /** 
     * 向右滑动 
     *  
     * @param driver 
     * 
     * @param num 
     * @throws InterruptedException 
     */  
    public static void swipeToRight(AndroidDriver<WebElement> driver,int num) throws InterruptedException {  
        int width = driver.manage().window().getSize().width;  
        int height = driver.manage().window().getSize().height;  
        for (int i = 0; i < num; i++) {  
            
            TouchAction swipe = new TouchAction(driver).press(width / 4, height / 2).waitAction(2000).moveTo(width * 3 / 4, height / 2).release();
            swipe.perform();
            
            Thread.sleep(1000);   
        }  
    }  
}
