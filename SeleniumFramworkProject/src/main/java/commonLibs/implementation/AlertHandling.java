package commonLibs.implementation;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commonLibs.contacts.IAlert;

public class AlertHandling implements IAlert{

	WebDriver driver;
	
	public AlertHandling(WebDriver driver) {
		this.driver = driver;
	}
	
	public Alert getAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	@Override
	public void acceptAlert() throws Exception {
		getAlert().accept();
		
	}

	@Override
	public void rejectAlert() throws Exception {
		getAlert().dismiss();
		
	}

	@Override
	public String getMessageFromAlert() throws Exception {
		
		return getMessageFromAlert();
	}

}
