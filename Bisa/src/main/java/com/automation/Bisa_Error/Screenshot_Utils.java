package com.automation.Bisa_Error;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.Bisa.Base_Library;

public class Screenshot_Utils extends Base_Library {
	
	/*String timeStamp;
	File screenShotName;
	File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE)
	//The below method will save the screen shot in d drive with name "screenshot.png"
    timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	screenShotName = new File("D:\\myCodeSpace\\Bisa\\Screenshots"+timeStamp+".png");
	FileUtils.copyFile(scrFile, screenShotName);
	 
	String filePath = screenShotName.toString();
//	String path = "<img src="\"file://"" alt="\"\"/" />";
//	Reporter.log(path);
	 
	}
*/
	
	 public static void takeSnapShot(String screenshotName) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)d);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination""
	                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

	                File DestFile=new File("D:\\myCodeSpace\\Bisa\\Screenshots\\"+screenshotName+timestamp+".png");

	                //Copy file at destination
	                System.out.println("Screenshot Taken");

	                FileUtils.copyFile(SrcFile, DestFile);

	    }
}
