package monitoring;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


import com.google.common.base.Function;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;


public class GoaResultAuto extends GetFirstTime {
	static int col = 00;
	static int dropdown =9;
	static int dropdownpun =8;
	static WebDriver driver;
	static WebDriver driverpun;
	static int time = 1000*5;

    public static void main(String... args) throws BiffException, IOException {
    	/*System.setProperty("webdriver.chrome.driver","/home/sumitkumar/workspace/All_Url/Plugins/chromedriver");
    	driver = new ChromeDriver();
    	driverpun = new ChromeDriver();
    	driver.navigate().to("http://192.168.4.9/commonresultpos/commondmpos/show_results.php3?gamecode=58");
    	driverpun.navigate().to("http://192.168.4.9/commonresultpos/commondmpos/show_results_punjab.php?gamecode=58");
//    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
		WebElement dropdownDrawTime = driver.findElement(By.name("drawtime"));
		Select drawTime = new Select(dropdownDrawTime);
		List<WebElement> options = drawTime.getOptions();*/
        Calendar firstTaskTime = getFirstTime();/*
        System.out.println("Task will start at: " + firstTaskTime.getTime());
		//driver.navigate().to("http://192.168.4.9/commonresultpos/commondmpos/lastresultlogwin7dmGoasnd.htm");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("                               Online Mumbai Result Auto                              ");
		System.out.println("--------------------------------------------------------------------------------------");
    	System.out.printf("%10s %40s %30s", "DRAW TIME", "LATE SECOND", "CURRENT TIME");
    	System.out.println();
    	System.out.println("--------------------------------------------------------------------------------------");*/
    		timer.schedule(new MorningResult(driver,driverpun), firstTaskTime.getTime(),time);//1000 * 60 * 15
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
class MorningResult extends TimerTask{
	WebDriver driver;
	WebDriver driverpun;
	int time;
	MorningResult(WebDriver driver2, WebDriver driver3){
		this.driver=driver2;
		this.driverpun=driver3;
		//this.time=time;
		//time = 1000 *20;
		System.out.println("123");
	}
	public int[] sorting(String firstResult) {
		String stresult[] = new String[100];
		int result[] = new int[100];
		List<String> list = Arrays.asList(firstResult.split(","));
		int count = 0;
        for (String name : list) {
            stresult[count] = name;
            count++;
        }
       
        for (int r = 0; r <= count - 1; r++) {
            result[r] = Integer.parseInt(stresult[r].trim());
        }            
        Arrays.sort(result);
        for(int i=0 ; i< result.length;i++) {
        	System.out.print(result[i]+" ");
        }
        System.out.println();
		return result;
	}
	public void run() {
		
		
		Calendar now = Calendar.getInstance();
		System.out.println(now.get(Calendar.MINUTE)+ ":" + now.get(Calendar.SECOND));
		//GoaResultAuto.count++;
		/*GoaResultAuto.col= GoaResultAuto.col + 1;
		GoaResultAuto.dropdown =GoaResultAuto.dropdown +1;
		GoaResultAuto.dropdownpun =GoaResultAuto.dropdownpun +1;
		driver.findElement(By.xpath("/html/body/form/select/option["+GoaResultAuto.dropdown+"]")).click();
		driverpun.findElement(By.xpath("/html/body/form/select/option["+GoaResultAuto.dropdownpun+"]")).click();
		String DrawTime=GoaResultAuto.driver.findElement(By.xpath("/html/body/form/select/option["+GoaResultAuto.dropdown+"]")).getText();
		WebElement ToDoExpense = null ;
		Wait<WebDriver> wait12 = new FluentWait<WebDriver>(driver)
	            .withTimeout(60, TimeUnit.SECONDS)
	            .pollingEvery(2, TimeUnit.SECONDS)
	            .ignoring(TimeoutException.class)
	            .ignoring(NoSuchElementException.class);
		Function<WebDriver, WebElement> abc=new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	        	GoaResultAuto.driver.findElement(By.xpath("/html/body/form/input[2]")).click();
	            driver.navigate().refresh();
	            return driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[2]/td[2]"));
	        }
	    };
	    WebElement ToDoExpensepun = null ;
		Wait<WebDriver> wait12pun = new FluentWait<WebDriver>(driverpun)
            .withTimeout(60, TimeUnit.SECONDS)
            .pollingEvery(2, TimeUnit.SECONDS)
            .ignoring(TimeoutException.class)
            .ignoring(NoSuchElementException.class);
	Function<WebDriver, WebElement> abcpun=new Function<WebDriver, WebElement>() {
        public WebElement apply(WebDriver driver) {
        	driverpun.findElement(By.xpath("/html/body/form/input[2]")).click();
            driverpun.navigate().refresh();
            return driverpun.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[2]/td[2]"));
        }
    };
	    int count=0;
			try{
				ToDoExpense = wait12.until(abc);
				ToDoExpensepun = wait12pun.until(abcpun);
				//   /html/body/form/table[2]/tbody/tr[2]/td[5]
				//   /html/body/form/table[2]/tbody/tr[3]/td[5]
				//   /html/body/form/table[2]/tbody/tr[4]/td[5]
				//   /html/body/form/table[2]/tbody/tr[5]/td[5]
			}
			catch (Exception e) {
				// TODO: handle exception
				count = count +1;
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Result Delayed", "Draw Time: " + DrawTime, JOptionPane.INFORMATION_MESSAGE);
				try{
					ToDoExpense =wait12.until(abc);
					System.out.format("%10s %40s %30s", DrawTime,"Result Delayed By "+count+" min",now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)+ ":" + sdf.format(new Date()));
			    	System.out.println();
					
				}catch(TimeoutException  ex){
					count = count +1;
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "Result Delayed", "Draw Time: " + DrawTime, JOptionPane.INFORMATION_MESSAGE);
					try{
						ToDoExpense =wait12.until(abc);
						System.out.format("%10s %40s %30s", DrawTime,"Result Delayed By "+count+" min",now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)+ ":" + sdf.format(new Date()));
				    	System.out.println();
					}catch(TimeoutException px){
						count = count +1;
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null, "Result Delayed", "Draw Time: " + DrawTime, JOptionPane.INFORMATION_MESSAGE);
						System.out.format("%10s %40s %30s", DrawTime,"Result Delayed By More than "+count+" min",now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)+ ":" + sdf.format(new Date()));
				    	System.out.println();
					}
				}
			}
        if(ToDoExpense != null && count==0 ){
	    	System.out.format("%10s %40s %30s",ToDoExpense.getText() ,sdf.format(new Date()),now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)+ ":" + sdf.format(new Date()));
	    	System.out.println();
	    	for(int i=2 ; i<=5 ; i++) {
				String firstResult = driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr["+i+"]/td[5]")).getText();
				String firstResultpun = driverpun.findElement(By.xpath("/html/body/form/table[2]/tbody/tr["+i+"]/td[5]")).getText();
				if(i==5) {
					int [] first = sorting(firstResult);
					int [] second = sorting(firstResultpun);
					if(Arrays.equals(first, second)) {
						System.out.println("~~~~~~  Fourth rank is ok ~~~~~~");
					}
					else
						System.out.println("    problem is 4th prize rank");
				}else {
					if(!firstResult.equals(firstResultpun)) {
						System.out.print("    "+firstResult +"  "+firstResultpun);
						System.out.println("  ~~ There is a problem");
					}else {
						System.out.print("    "+firstResult +"  "+firstResultpun);
						System.out.println("~~~~~~  Fourth rank is ok ~~~~~~");
					}
				}
			}
        }*/
	 }
}



















