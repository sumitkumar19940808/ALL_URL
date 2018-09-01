package monitoring;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class createfolders {

	    String createfolder(String directoryPath) {
		Date current = new Date();
		SimpleDateFormat sdfr = new SimpleDateFormat("dd-MMM-yyyy");
		String dateString = sdfr.format(current);
		directoryPath = directoryPath + dateString;
		File dir = new File(directoryPath);
		boolean exists = dir.exists();
		String str = String.valueOf(exists);
		if (str.equals("true")) {
			System.out.println("Folder is already created");
		} else {
			System.out.println("Not exists, but we create it new for you");
			dir.mkdir();
		}
		return directoryPath;

	}

//	public static void main(String args[]) {
//		createfolders obj = new createfolders();
//		obj.createfolder("/mnt/usernarender/Automation_Runs_Output/Apache_Status/");
//		obj.createfolder("/mnt/usernarender/Automation_Runs_Output/Checkme/");
//		obj.createfolder("/mnt/usernarender/Automation_Runs_Output/Replications/");
//		
//	}
}
