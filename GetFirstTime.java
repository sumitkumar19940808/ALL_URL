package monitoring;

import java.util.Calendar;
import java.util.List;
import java.util.Timer;

import org.openqa.selenium.WebElement;

public class GetFirstTime {
	static Calendar cal;
    static Timer timer = new Timer();
//    static Calendar getFirstTime(List<WebElement> options) {
    static Calendar getFirstTime() {
    	//for(WebElement items:options ) {
    		//System.out.println(items.getText());
    	//}
        cal = Calendar.getInstance();
        int hour =cal.get(Calendar.HOUR_OF_DAY);
        int currentMinute = cal.get(Calendar.MINUTE);
        
        if (currentMinute <= 10) {
        	cal.set(Calendar.MINUTE, 20);
        }
        else if (currentMinute <= 20) {
        		cal.set(Calendar.MINUTE, 20);
        }
        else if (currentMinute <= 30) {
        	cal.set(Calendar.MINUTE, 22);
        }
        else if (currentMinute <= 40) {
        		cal.set(Calendar.MINUTE, 20);
        }
        else if (currentMinute <50) {
            cal.set(Calendar.MINUTE,48);
//        	cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
//            cal.set(Calendar.MINUTE,0);
          }
        else if (currentMinute >= 50) {
          cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
          cal.set(Calendar.MINUTE,0);
        }
        cal.set(Calendar.SECOND, 0);
        return cal;
    }

}
