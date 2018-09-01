package monitoring;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import jxl.read.biff.BiffException;

public class New_Replication {
	static WebDriver driver;
    static Calendar cal;
    static Timer timer = new Timer();
    static Calendar getFirstTime() {
        cal = Calendar.getInstance();
        int hour =cal.get(Calendar.HOUR_OF_DAY);
        int currentMinute = cal.get(Calendar.MINUTE);
        
        if (currentMinute <= 10) {
        	cal.set(Calendar.MINUTE,7);
        }
        else if (currentMinute <= 20) {
        	cal.set(Calendar.MINUTE, Calendar.MINUTE+1);
        }
        else if (currentMinute <= 30) {
        	cal.set(Calendar.MINUTE, Calendar.MINUTE+1);
        }
        else if (currentMinute <= 40) {
        		cal.set(Calendar.MINUTE, Calendar.MINUTE+1);
        }
        else if (currentMinute <50) {
        	cal.set(Calendar.MINUTE, Calendar.MINUTE+1);
          }
        else if (currentMinute >= 50) {
        	cal.set(Calendar.MINUTE, Calendar.MINUTE+1);
        }
        cal.set(Calendar.SECOND, 0);
        return cal;
    }
    public static void main(String... args) throws BiffException, IOException {
        Calendar firstTaskTime = getFirstTime();
        System.out.println("Task will start at: " + firstTaskTime.getTime());
        System.setProperty("webdriver.chrome.driver",
				"/home/sumitkumar/workspace/All_Url/Plugins/chromedriver");
		driver = new ChromeDriver();
		driver.navigate().to("http://192.168.4.137/replication_monitor.php");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("                               Replication                              ");
		System.out.println("--------------------------------------------------------------------------------------");
    	System.out.printf("%10s %40s %30s", "DRAW TIME", "LATE SECOND", "CURRENT TIME");
    	System.out.println();
    	System.out.println("--------------------------------------------------------------------------------------");
    		timer.schedule(new checkRep(), firstTaskTime.getTime(),1000*30);//1000 * 60 * 15
    		try {
    			TimeUnit.MINUTES.sleep(640);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		timer.cancel();
        System.out.println("All Online Draw is Over Thank you !!!");
        //closeFile();
        driver.close();
    }
}
class checkRep extends TimerTask{ 
	public void run() {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ss");
		List<WebElement> ToDoExpense = null ;
			Wait<WebDriver> wait12 = new FluentWait<WebDriver>(New_Replication.driver)
	            .withTimeout(30, TimeUnit.SECONDS)
	            .pollingEvery(2, TimeUnit.SECONDS)
	            .ignoring(TimeoutException.class)
	            .ignoring(NoSuchElementException.class);
		Function<WebDriver, List<WebElement>> abc=new Function<WebDriver, List<WebElement>>() {
	        public List<WebElement> apply(WebDriver driver) {     	
	            driver.navigate().refresh();
	            List<WebElement> ele = driver.findElements(By.tagName("font"));
	            return ele;
	        }
	    };
	    int count=0;
			try{
				ToDoExpense = wait12.until(abc);
				String color;
				System.out.println("ok");
				for (int i = 0; i<ToDoExpense.size(); i++) {
					color="";
					color = ToDoExpense.get(i).getCssValue("color");
		            System.out.println("color is : " + color);
		            if(color.equals("rgba(255, 0, 0, 1)")) {
		            	System.out.println("ok11");
		            	Assert.assertTrue(false);
		            	System.out.println("ok12");
		            	//break;
		            }
		        }
				System.out.println("ok1");
			}
			catch (AssertionError e) {
				// TODO: handle exception
				System.out.println("ok2");
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "Red found", "Error found", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("ok");
				System.out.println("ok3");
			}
        if(ToDoExpense != null && count==0 ){
	    	System.out.format("%10s %40s %30s"," ok ",sdf.format(new Date()),now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)+ ":" + sdf.format(new Date()));
	    	System.out.println("ok4");
	    	System.out.println();
        }
	 }
}
