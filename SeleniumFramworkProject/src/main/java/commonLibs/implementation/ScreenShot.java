package commonLibs.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contacts.IScreenShot;

public class ScreenShot implements IScreenShot{
	
	private WebDriver driver;
	
	public ScreenShot(WebDriver driver) {
		this.driver=driver;
	}

	@Override
	public String captureAndSaveScreenshot(String fileName) throws Exception {
		
		fileName = fileName.trim();
		File imgFile, tempFile;
		imgFile = new File(fileName);
		
		if(imgFile.exists()){
			throw new Exception("File Already Exist....");
		}
		
		TakesScreenshot camera = (TakesScreenshot) driver;
		
		tempFile = camera.getScreenshotAs(OutputType.FILE);
		
		//FileUtils comes with java.io but for maven project we need to add dependency in pom.xml
		FileUtils.moveFile(tempFile, imgFile);
		
		return imgFile.getAbsolutePath();
	}

}
