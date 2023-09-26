package afw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class BrowserWindows {
	WebDriver driver;
	
	@FindBy(css = "#tabButton") WebElement newTab;
	@FindBy(css = "#windowButton") WebElement newWindow;
	@FindBy(css = "#messageWindowButton") WebElement newWindowMessage;
	
	public BrowserWindows(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@Step("Нажать на кнопку «New Tab»")
	public void openTab() {
		newTab.click();
	}
	
	@Step("Нажать на кнопку «New window»")
	public void openWindow() {
		newWindow.click();
	}
	
	@Step("Нажать на кнопку «New window Message»")
	public void openMessageWindow() {
		newWindowMessage.click();
	}
	
	@Step("Закрыть новую вкладку/окно")
	public void closeChild() {
		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		driver.close();
		driver.switchTo().window(originalWindow);
	}
	
	
	
	
	
}
