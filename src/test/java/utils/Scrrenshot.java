package utils;




import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.apache.commons.io.FileUtils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Scrrenshot {
	
	public static void takeScreenshot(WebDriver driver) throws IOException, InvalidFormatException
	{
		
		 XWPFDocument docx = new XWPFDocument();
	        XWPFParagraph par = docx.createParagraph();
	        XWPFRun run = par.createRun();
	        
	        
	      
	           TakesScreenshot obj=(TakesScreenshot)driver;
	 		   File srcFile= obj.getScreenshotAs(OutputType.FILE);
	           String title=driver.getTitle();
	  		   String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	            
	            File destFile=new File("C:\\Screenshot\\"+title+"_"+timeStamp+".png");
	            FileUtils.copyFile(srcFile, destFile);
	            InputStream pic=new FileInputStream("C:\\Screenshot\\"+title+"_"+timeStamp+".png");
	        	
	            run.addBreak();
	        	run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG,"C:\\Screenshot\\"+title+"_"+timeStamp+".png", Units.toEMU(350), Units.toEMU(350));
	        	FileOutputStream out = new FileOutputStream("C:\\Screenshot\\images.docx"); 
	        	pic.close();
	        	//TimeUnit.SECONDS.sleep(1);
                docx.write(out);
                
            

	}

}
