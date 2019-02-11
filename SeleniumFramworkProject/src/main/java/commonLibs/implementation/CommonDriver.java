package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibs.contacts.ICommonDriver;

public class CommonDriver implements ICommonDriver{

	private WebDriver driver;
	private int pageLoadTimeout;
	private int elementDetectionTimeout;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	public CommonDriver(String browserType) {
		
		pageLoadTimeout = 30;
		elementDetectionTimeout = 10;
		
		browserType = browserType.trim();
		
		if (browserType.equalsIgnoreCase("chrome")){
			System.setProperty("webDriver.chrome.driver", "E:\\chromedriver.exe");
		    driver = new ChromeDriver();
		    
		}  else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"E:/geckodriver.exe");
           	driver = new FirefoxDriver();

		}	
	}

	@Override
	public void navigateToFirstUrl(String url) throws Exception {
		url = url.trim();
		
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		driver.get(url);
		
	}

	@Override
	public String getTitle() throws Exception {
		return driver.getTitle();
	}

	@Override
	public String getCurrentUrl() throws Exception {
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() throws Exception {
		return driver.getPageSource();
	}

	@Override
	public void navigateToUrl(String url) throws Exception {
		url = url.trim();
		driver.navigate().to(url);
		
	}

	@Override
	public void navigateForward() throws Exception {
		driver.navigate().forward();
		
	}

	@Override
	public void navigateBackward() throws Exception {
		driver.navigate().back();
		
	}

	@Override
	public void refresh() throws Exception {
		driver.navigate().refresh();
		
	}

	@Override
	public void closeBrowser() throws Exception {
		if(driver!=null){
			driver.close();
		}
		
	}

	@Override
	public void closeAllBrowsers() throws Exception {
		if(driver!=null){
			driver.quit();
		}
		
	}

	
}
