package commonLibs.contacts;

import org.openqa.selenium.WebElement;

public interface IFrame {
	
    public void switchToFrame(WebElement element) throws Exception;
	
	public void switchToFrame(int index) throws Exception;
	
	public void switchToParentpage() throws Exception;

}
