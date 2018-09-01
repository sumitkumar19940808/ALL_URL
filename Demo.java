package URL;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo {
	private WebDriver driver1;
	DesiredCapabilities capabilities ;
	Robot robot;
	ChromeOptions options = new ChromeOptions();
//	FirefoxOptions options1 = new FirefoxOptions();
	String displayClock ="http://192.168.4.9/clock/displayserverclock.php";
	//String moniterURL = "http://192.168.4.63/urlmonitor.php";
	String apacheAll[] ={"http://192.168.4.61/stat1729","http://192.168.4.63/stat1729","http://192.168.4.64/stat1729","http://192.168.4.125/stat1729"};
	String replicationMonitor[] ={"http://192.168.3.39/replication_monitor.php","http://192.168.4.181/replication_monitor.php","http://192.168.4.137/replication_monitor.php","http://192.168.4.140/replication_monitor.php"};
	String checkME[] ={"http://220.226.204.182/checkme.php","http://182.73.108.210/checkme.php","http://220.226.204.179/checkme.php","https://192.168.4.9/dbmonitorpun.php","http://182.73.108.210:19000/checkme.php"};
	String allOtherURL[] = {"https://192.168.4.9/dbmonitor.php","http://172.20.5.6/serverstatuspinger/","http://192.168.4.63/urlmonitor.php"};
	String extraReplication[]= {"http://192.168.4.138/replication_monitor.php","http://192.168.4.139/replication_monitor.php"};
	public void zoomIN(){
		for(int j=0;j<=7;j++){
			// Toolkit.getDefaultToolkit().beep();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
		}
	}
	public void zoomIN2(){
		for(int j=0;j<=4;j++){
			// Toolkit.getDefaultToolkit().beep();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
		}
	}
	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) throws InterruptedException, AWTException {
		try {
			if  (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C://Users//sudhanshu//workspace//chromedriver.exe");
//				options.addExtensions(new File("C:/Users/sudhanshu/workspace/Plugins/GetCRX.crx"));
//				options.addExtensions(new File("C:/Users/sudhanshu/workspace/Plugins/Easy Auto Refresh.crx"));
				options.addArguments("load-extension=C:\\Users\\sudhanshu\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\aabcgdmkeabbnleenpncegpcngjpnjkc\\4.7_0");
				options.addArguments("disable-infobars");
				capabilities = DesiredCapabilities.chrome();         
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				robot = new Robot();
				//driver1 = new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C://Users//sudhanshu//workspace//Plugins//geckodriver32.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				// options1.setLogLevel(Level.ALL);
				driver1 = new FirefoxDriver(capabilities);
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}
  @Test
	public void apacheStatus() throws InterruptedException, AWTException { 
		for(int i = 0; i<=apacheAll.length-1;i++){
			//Toolkit.getDefaultToolkit().beep();
			WebDriver driver = new ChromeDriver(capabilities);
			driver.navigate().to(apacheAll[i]);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_W);
			if (i==0){
				driver.manage().window().setSize(new Dimension(460, 280));
				driver.manage().window().setPosition(new Point(-5,0));
			}
			if (i==1){
				driver.manage().window().setSize(new Dimension(460, 310));
				driver.manage().window().setPosition(new Point(-5,260));
			}
			else if(i==2){
				driver.manage().window().setSize(new Dimension(460, 280));
				driver.manage().window().setPosition(new Point(-5,550));
			}
			else if(i==3){
				driver.manage().window().setSize(new Dimension(460, 310));
				driver.manage().window().setPosition(new Point(440,0));
			}
		}
	}
  @Test
  public void checkMe() throws InterruptedException {
	  for(int i = 0; i<=checkME.length-1;i++){
		  WebDriver driver = new ChromeDriver(capabilities);
			driver.navigate().to(checkME[i]);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_W);
			if (i==0){
				driver.manage().window().setSize(new Dimension(460, 250));
				driver.manage().window().setPosition(new Point(440,280));
				zoomIN();
			}
			if (i==1){
				driver.manage().window().setSize(new Dimension(460, 250));
				driver.manage().window().setPosition(new Point(440,460));
				zoomIN();
			}
			if (i==2){
				driver.manage().window().setSize(new Dimension(460,250));
				//driver.manage().window().setPosition(new Point(3650,250)); next screen
				driver.manage().window().setPosition(new Point(440,600));
				zoomIN();
			}
			if (i==3){
				driver.manage().window().setSize(new Dimension(390,390));
				driver.manage().window().setPosition(new Point(3650,0));
				zoomIN();
			}
			if (i==4){
				driver.manage().window().setSize(new Dimension(460,250));
				driver.manage().window().setPosition(new Point(440,800));
				zoomIN();
			}
	  }
  }
  
  @Test
  public void replicationStatus() throws InterruptedException {
	  for(int i = 0; i<=replicationMonitor.length-1;i++){
			WebDriver driver = new ChromeDriver(capabilities);
			Thread.sleep(200);
			driver.navigate().to(replicationMonitor[i]);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_W);
			if (i==0){
//				driver.manage().window().setSize(new Dimension(620, 400));
//				driver.manage().window().setPosition(new Point(880,650));
				driver.manage().window().setSize(new Dimension(460, 310));
				driver.manage().window().setPosition(new Point(-5,780));
				zoomIN2();
			}
			if (i==1){
				driver.manage().window().setSize(new Dimension(740,1040));
				driver.manage().window().setPosition(new Point(2555,0));
				zoomIN2();
			}
			if (i==2){
				driver.manage().window().setSize(new Dimension(550,700));
				driver.manage().window().setPosition(new Point(3280,500));
				zoomIN2();
			}
			if (i==3){
				driver.manage().window().setSize(new Dimension(620, 400));
				driver.manage().window().setPosition(new Point(880,650));
				zoomIN2();
			}
	  }
  }
  
  @Test
  public void allOtherURL() throws InterruptedException{
	  for(int i = 0; i<=allOtherURL.length-1;i++){
		  WebDriver driver = new ChromeDriver(capabilities);
		  Thread.sleep(200);
			driver.navigate().to(allOtherURL[i]);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_W);
			if (i==0){
				driver.manage().window().setSize(new Dimension(400,550));
				driver.manage().window().setPosition(new Point(3280,0));
				zoomIN2();
			}
			if (i==1){
				driver.manage().window().setSize(new Dimension(1280,1040));
				driver.manage().window().setPosition(new Point(4030,0));
				zoomIN2();
			}
			if (i==2){
				driver.manage().window().setSize(new Dimension(320,710));
				driver.manage().window().setPosition(new Point(1180,0));
				for(int j=0;j<1;j++){
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_MINUS);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_MINUS);
				}
			}
	  }
  }
  @Test
  public void displayMoniterURL() throws InterruptedException {
	  Thread.sleep(500);
		driver1.navigate().to(displayClock);
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(500);
		driver1.manage().window().setPosition(new Point(1000,1500));
		driver1.manage().window().setSize(new Dimension(300,700 ));
//		driver1.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"n");
//		  String parentWindow = driver1.getWindowHandle();
//		  Set<String> handles =  driver1.getWindowHandles();
//		     for(String windowHandle  : handles)
//		         {
//		         if(!windowHandle.equals(parentWindow))
//		            {
//		        	 driver1.switchTo().window(windowHandle);
//		        	 driver1.navigate().to(moniterURL);
//		        	 driver1.manage().window().setSize(new Dimension(300, 700));
//		        	 driver1.manage().window().setPosition(new Point(600,0));
//		            }
//		         }
	  }
  	@Test
  	public void extraRep() throws InterruptedException{
  		Thread.sleep(500);
  		 for(int i = 0; i<=extraReplication.length-1;i++){
  			WebDriver driver = new ChromeDriver(capabilities);
			Thread.sleep(200);
			driver.navigate().to(extraReplication[i]);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_W);
			if (i==0){
				driver.manage().window().setSize(new Dimension(550,700));
				driver.manage().window().setPosition(new Point(3700,500));
				zoomIN2();	
			}
			if (i==1){
				driver.manage().window().setSize(new Dimension(550,700));
				driver.manage().window().setPosition(new Point(4200,500));
				zoomIN2();	
			}
  			 
  		 }
  		
  	}
}

