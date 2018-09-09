package com.pluralsight;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot {

	 public static String capture(WebDriver driver,String screenShotName) throws IOException
	    {
		 System.out.println("capture start");
	        TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir")+"/ErrorScreenshots/"+screenShotName+".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);  
	        System.out.println("captured----");
	        return dest;
	       
	        
	    }

}
