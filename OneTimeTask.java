package monitoring;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OneTimeTask {

	public static void main (String[] args) {
//        System.out.println("Main thread: " + Thread.currentThread());
//        Timer timer = new Timer();
//        final long start = System.currentTimeMillis();
//        timer.schedule(new TimerTask(){
//            @Override
//            public void run () {
//                System.out.print("Task invoked: " +
//                                                     (System.currentTimeMillis() - start) + " ms");
//                System.out.println(" - " + Thread.currentThread());
//                timer.cancel();
//            }
//        }, 1000);
		/*System.setProperty("webdriver.chrome.driver", "/home/sumitkumar/workspace/All_Url/Plugins/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://192.168.4.9/commonresultpos/commondmpos/show_results.php3?gamecode=58");
		WebElement ele = driver.findElement(By.tagName("select"));
		TakesScreenshot ss = ((TakesScreenshot)driver);
		File f = ss.getScreenshotAs(OutputType.FILE);
		File df = new File("/home/sumitkumar/workspace/All_Url/Plugins/sum.png");
		try {
			FileUtils.copyFile(f, df);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		LinkedList<Integer> ll  = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		
    }

}
