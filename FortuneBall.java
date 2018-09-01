package monitoring;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
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
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;


public class FortuneBall {
	static int col = 00;
	static int dropdown =2;
	static WebDriver driver;
	static Workbook wbook;
    static WritableWorkbook wwbCopy;
    static String ExecutedTestCasesSheet;
    static WritableSheet shSheet;
    static Calendar cal;
    static Timer timer = new Timer();
    static Calendar getFirstTime() {
        cal = Calendar.getInstance();
        int hour =cal.get(Calendar.HOUR_OF_DAY);
        int currentMinute = cal.get(Calendar.MINUTE);
        
        if (currentMinute <= 10) {
        	cal.set(Calendar.MINUTE, 05);
        }
        else if (currentMinute <= 20) {
//        	if(hour >=15 && hour<=18)
//        		cal.set(Calendar.MINUTE, 39);
//        	else 
        		cal.set(Calendar.MINUTE, 35);
        }
//        else if (currentMinute <= 30) {
//        	cal.set(Calendar.MINUTE, 35);
//        }
        else if (currentMinute >= 50) {
//        	if(hour >=15 && hour<=18)
//        		cal.set(Calendar.MINUTE, 20);
//        	else 
        		cal.set(Calendar.MINUTE, 35);
        }
//        else if (currentMinute <45) {
//        	 cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
//             cal.set(Calendar.MINUTE,5);
//          }
        else if (currentMinute <= 40) {
          cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
          cal.set(Calendar.MINUTE,5);
        }
        cal.set(Calendar.SECOND, 0);
        return cal;
    }
//    public static void setValueIntoCell(String strSheetName,int iColumnNumber, int iRowNumber,String strData) throws WriteException
//    {
//    	WritableFont cellFont = new WritableFont(WritableFont.TIMES,14);
//    	cellFont.setBoldStyle(WritableFont.BOLD); 
//    	WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
//    	cellFormat.setWrap(true); 
//        WritableSheet wshTemp = wwbCopy.getSheet(strSheetName);
//        Label labTemp = new Label(iColumnNumber, iRowNumber, strData,cellFormat);
//        try {
//            wshTemp.addCell(labTemp);
//             } 
//            catch (Exception e) 
//            {
//                e.printStackTrace();
//            }
//    }
//    
//    public static void closeFile()
//    {
//        try {
//            // Closing the writable work book
//            wwbCopy.write();
//            wwbCopy.close();
//
//            // Closing the original work book
//            wbook.close();
//        } catch (Exception e)
//
//        {
//            e.printStackTrace();
//        }
//    }    

    public static void main(String... args) throws BiffException, IOException {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
    	//Calendar now = Calendar.getInstance();
		//PrintStream o = new PrintStream(new File("A.txt"));
        Calendar firstTaskTime = getFirstTime();
        System.out.println("Task will start at: " + firstTaskTime.getTime());
        System.setProperty("webdriver.chrome.driver",
				"C://Users//sudhanshu//workspace//chromedriver.exe");
		driver = new ChromeDriver();
		//driver.navigate().to("http://192.168.4.9/commonresultpos/commondmpos/lastresultlogwin7dmGoasnd.htm");
		driver.navigate().to("http://192.168.4.9/commonresultpos/commondmpos/show_results.php3?gamecode=29");
		//wbook = Workbook.getWorkbook(new File("/home/software-179/workspace/MoniterURL/src/monitoring/Monitoring_status_28.06.2017.xls"));
		//wwbCopy = Workbook.createWorkbook(new File("/home/software-179/workspace/MoniterURL/src/monitoring/Monitoring_statusEVE"+dateFormat.format(date)+".xls"), wbook);
		//shSheet = wwbCopy.getSheet(0);
		//int hour =now.get(Calendar.HOUR_OF_DAY);
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("                               Fortune Mumbai Result Auto                              ");
		System.out.println("--------------------------------------------------------------------------------------");
    	System.out.printf("%10s %40s %30s", "DRAW TIME", "LATE SECOND", "CURRENT TIME");
    	System.out.println();
    	System.out.println("--------------------------------------------------------------------------------------");
//    	if(hour >=15 && hour<=18){
//    		timer.schedule(new MorningResult(), firstTaskTime.getTime(), 1000*60*20);//1000 * 60 * 15
//    	}
//    	else {
    		timer.schedule(new EveningResult(), firstTaskTime.getTime(),1000*60*30);//1000 * 60 * 15
//		}
		//System.out.println("3 minutes difference occured" +now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE));
    	//300 morning // Evening 180 // Night 205
//    	if(hour >=15 && hour<=18){//Evening
//    		try {
//    			TimeUnit.MINUTES.sleep(180);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }	
//    	}else if (hour >=10 && hour<15) {//Morning
    		try {
    			TimeUnit.MINUTES.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//		}else{//Night
//			try {
//    			TimeUnit.MINUTES.sleep(205);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//		}
		timer.cancel();
        System.out.println("All Online Draw is Over Thank you !!!");
        //closeFile();
        driver.close();
    }
}
class EveningResult extends TimerTask{ 
	public void run() {
		Calendar now = Calendar.getInstance();
		//GoaResultAuto.count++;
		SimpleDateFormat sdf = new SimpleDateFormat("ss");
		FortuneBall.col= FortuneBall.col + 1;
		FortuneBall.dropdown =FortuneBall.dropdown +1;
		FortuneBall.driver.findElement(By.xpath("/html/body/form/select/option["+FortuneBall.dropdown+"]")).click();
		String DrawTime=FortuneBall.driver.findElement(By.xpath("/html/body/form/select/option["+FortuneBall.dropdown+"]")).getText();
		WebElement ToDoExpense = null ;
			Wait<WebDriver> wait12 = new FluentWait<WebDriver>(FortuneBall.driver)
	            .withTimeout(60, TimeUnit.SECONDS)
	            .pollingEvery(2, TimeUnit.SECONDS)
	            .ignoring(TimeoutException.class)
	            .ignoring(NoSuchElementException.class);
		Function<WebDriver, WebElement> abc=new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	        	FortuneBall.driver.findElement(By.xpath("/html/body/form/input[2]")).click();
	            driver.navigate().refresh();
	            return driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[2]/td[2]"));
	        }
	    };
	    int count=0;
			try{
				ToDoExpense = wait12.until(abc);
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
//	    	for(int i=1; i<=3;i++){
//	    		try {
//	    			GoaResultAuto.setValueIntoCell("Sheet1", GoaResultAuto.col, 4, sdf.format(new Date())+" Sec");
//					GoaResultAuto.setValueIntoCell("Sheet1",GoaResultAuto.col, 5, sdf.format(new Date())+" Sec");
//					GoaResultAuto.setValueIntoCell("Sheet1",GoaResultAuto.col , 6,sdf.format(new Date())+" Sec");
//				} catch (WriteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		   }
	    	System.out.format("%10s %40s %30s",ToDoExpense.getText() ,sdf.format(new Date()),now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)+ ":" + sdf.format(new Date()));
	    	System.out.println();
        }
//        else{
//        	System.out.format("%10s %30s %30s", DrawTime,"Result Delayed By"+ sdf.format(new Date()),now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)+ ":" + sdf.format(new Date()));
//	    	System.out.println();
//        }
        
//       GoaResultAuto.timer.schedule(new MorningResult(), CalculateTimeForUpgrade());
	 }
//	 public long CalculateTimeForUpgrade(){
//			int test=GoaResultAuto.count++;
//			int check;
//			System.out.println(test);
//				if(GoaResultAuto.count >2){
//					check= 1000*59*20;
//					System.out.println("ok if");
//					return check;
//				}
//				else{
//					System.out.println("ok else");
//					return 	1000*59*15;
//				}
//		}
}



















