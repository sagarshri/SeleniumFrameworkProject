package commonLibs.implementation;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contacts.IJavaScript;

public class JavaScript implements IJavaScript{

	private WebDriver driver;
	private JavascriptExecutor jsEngine;
	
	public JavaScript(WebDriver driver) {
		this.driver=driver;
		jsEngine = (JavascriptExecutor)driver;
		
	}
	
	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {
		jsEngine.executeScript(scriptToExecute);
		
	}

	@Override
	public void scrollDown(int x, int y) throws Exception {
		String jsCommand = String.format("window.scrollBy(%d, %d)", x, y);
		jsEngine.executeScript(jsCommand);
	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		// TODO Auto-generated method stub
		return jsEngine.executeAsyncScript(scriptToExecute).toString();
	}

}
