package monitoring;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Replications extends createfolders {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver","C://Users//sudhanshu//workspace//Plugins//chromedriver.exe");
		createfolders obj = new createfolders();
		String path = obj.createfolder("D:/Automation_Runs_Output/Replications/Goa_Replications/");
		String path1 = obj
				.createfolder("D:/Automation_Runs_Output/Replications/Arunachal_Replications/");
		String path2 = obj.createfolder("D:/Automation_Runs_Output/Replications/Mizoram_Replications/");
		String path3 = obj.createfolder("D:/Automation_Runs_Output/Replications/Sikkim_Replications/");

		WebDriver driver = new ChromeDriver();
		WebDriver driver1 = new ChromeDriver();
		WebDriver driver2 = new ChromeDriver();
		WebDriver driver3 = new ChromeDriver();
		try {
			driver.get("http://192.168.4.137/replication_monitor.php");
		} catch (Exception e) {
			Date current = new Date();
			File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot2, new File(path + "/" + current + ".png"));

		}
		try {
			driver1.get("http://192.168.4.138/replication_monitor.php");
		} catch (Exception e) {
			File screenshot2 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
			Date current = new Date();
			FileUtils.copyFile(screenshot2, new File(path1 + "/" + current + ".png"));

		}
		try {
			driver2.get("http://192.168.4.139/replication_monitor.php");
		} catch (Exception e) {
			File screenshot2 = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
			Date current = new Date();
			FileUtils.copyFile(screenshot2, new File(path2 + "/" + current + ".png"));

		}
		try {
			driver3.get("http://192.168.4.140/replication_monitor.php");
		} catch (Exception e) {
			File screenshot2 = ((TakesScreenshot) driver3).getScreenshotAs(OutputType.FILE);
			Date current = new Date();
			FileUtils.copyFile(screenshot2, new File(path3 + "/" + current + ".png"));

		}
		try {
			for (int i = 1; i <= 10; i++) {
				driver.navigate().refresh();
				driver1.navigate().refresh();
				driver2.navigate().refresh();
				driver3.navigate().refresh();
				// First replication
				if (driver.getPageSource().contains("red") || driver.getPageSource().contains("#FF0000")) {
					driver.get("http://192.168.4.137/replication_monitor.php");
					for(int k=0;k<=4;k++)
					{
					Toolkit.getDefaultToolkit().beep();
					}
					Thread.sleep(1000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("alert('Slave in increasing')");
					Thread.sleep(2000);
					try {
						driver.switchTo().alert().accept();
					} catch (Exception e) {
						System.out.println("Invalid alert");
					}
					Date cur_date_2 = new Date();
					js.executeScript("window.scrollBy(0,10)", "");
					File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenshot2, new File(path + "/" + cur_date_2 + ".png"));
					js.executeScript("window.scrollBy(0,603)", "");
					Thread.sleep(1000);
					Date cur_date_3 = new Date();
					File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenshot2, new File(path + "/" + cur_date_3 + ".png"));
					js.executeScript("window.scrollBy(0,610)", "");
					Thread.sleep(1000);
					Date cur_date_4 = new Date();
					File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenshot2, new File(path + "/" + cur_date_4 + ".png"));

					js.executeScript("window.scrollBy(0,-1223)", "");

				}
				// Second replication
				if (driver1.getPageSource().contains("red") || driver1.getPageSource().contains("#FF0000")) {
					driver1.get("http://192.168.4.138/replication_monitor.php");
					for(int k=0;k<=4;k++)
					{
					Toolkit.getDefaultToolkit().beep();
					}
					Thread.sleep(1000);
					JavascriptExecutor js = (JavascriptExecutor) driver1;
					js.executeScript("alert('Slave in increasing')");
					Thread.sleep(2000);
					try {
						driver1.switchTo().alert().accept();
					} catch (Exception e) {
						System.out.println("Invalid alert");
					}
					Date cur_date_2 = new Date();
					js.executeScript("window.scrollBy(0,10)", "");
					File screenshot2 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenshot2, new File(path1 + "/" + cur_date_2 + ".png"));
				}
				// Third replication
				if (driver2.getPageSource().contains("red") || driver2.getPageSource().contains("#FF0000")) {
					driver2.get("http://192.168.4.139/replication_monitor.php");
					for(int k=0;k<=4;k++)
					{
					Toolkit.getDefaultToolkit().beep();
					}
					Thread.sleep(1000);
					JavascriptExecutor js = (JavascriptExecutor) driver2;
					js.executeScript("alert('Slave in increasing')");
					Thread.sleep(2000);
					try {
						driver2.switchTo().alert().accept();
					} catch (Exception e) {
						System.out.println("Invalid alert");
					}
					Date cur_date_2 = new Date();
					js.executeScript("window.scrollBy(0,10)", "");
					File screenshot2 = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenshot2, new File(path2 + "/" + cur_date_2 + ".png"));
				}
				// Fourth replication
				if (driver3.getPageSource().contains("red") || driver3.getPageSource().contains("#FF0000")) {

					// System.out.println(driver3.getPageSource());
					driver3.get("http://192.168.4.140/replication_monitor.php");
					for(int k=0;k<=4;k++)
					{
					Toolkit.getDefaultToolkit().beep();
					}
					Thread.sleep(1000);
					JavascriptExecutor js = (JavascriptExecutor) driver3;
					js.executeScript("alert('Slave in increasing')");
					Thread.sleep(2000);
					try {
						driver3.switchTo().alert().accept();
					} catch (Exception e) {
						System.out.println("Invalid alert");
					}
					Date cur_date_2 = new Date();
					js.executeScript("window.scrollBy(0,10)", "");
					File screenshot2 = ((TakesScreenshot) driver3).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenshot2, new File(path3 + "/" + cur_date_2 + ".png"));
				}

				if (i == 10) {
					i = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("Url has closed" + e.getMessage());
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(1000);
		}
	}
}
