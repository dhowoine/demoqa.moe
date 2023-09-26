package moe.O.demoqa_test;
import elements.TextBox;
import elements.Buttons;
import afw.BrowserWindows;
import afw.Alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("demoqa тесты")
@Feature("ТЕСТОВОЕ ЗАДАНИЕ")
public class AppTest {
	WebDriver driver;
	Wait<WebDriver> wait;
	TextBox objTextBox;
	Buttons objButtons;
	BrowserWindows objBrowserWindows;
	Alerts objAlerts;
	Actions act;
	
	
    @Test
    @Story("Автотест по сценарию")
    public void testDQA() {
    	// open browser
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		// Elements
    	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
    	// text box
    	driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]")).click();
    	objTextBox = new TextBox(driver);
    	objTextBox.enterFullName("User Name");
    	objTextBox.enterEmail("user@email.com");
    	objTextBox.enterCurrentAddress("user Address 1.");
    	objTextBox.enterPermanentAddress("dummy Address 2.");
    	objTextBox.submitInfo();
    	objTextBox.verifyInfo("User Name", "user@email.com", "user Address 1.", "dummy Address 2.");
    	// buttons
    	driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[5]")).click();
    	objButtons = new Buttons(driver);
    	objButtons.justClick(objButtons.clickMe);
    	objButtons.verifyClickMe();
    	objButtons.rightClick(objButtons.rightClickMe);
    	objButtons.verifyRightClickMe();
    	objButtons.doubleClick(objButtons.doubleClickMe);
    	objButtons.verifyDoubleClickMe();
    	
    	// Alerts, Frame n Windows
        new Actions(driver).scrollToElement(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[4]/span"))).perform();
    	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/span")).click();
    	// Browser Windows
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[1]"))).click();
    	objBrowserWindows = new BrowserWindows(driver);
    	objBrowserWindows.openTab();
    	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    	objBrowserWindows.closeChild();
    	objBrowserWindows.openWindow();
    	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    	objBrowserWindows.closeChild();
    	// Alerts
    	driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]")).click();
    	objAlerts = new Alerts(driver);
    	objAlerts.getAlert(objAlerts.alertBtn);
    	objAlerts.confAlert();
    	objAlerts.getAlert(objAlerts.alert5sec);
    	objAlerts.confAlert();
    	objAlerts.getAlert(objAlerts.confBox);
    	objAlerts.confAlert();
    	objAlerts.verifyConfBtn();
    	objAlerts.getAlert(objAlerts.promptBox);
    	objAlerts.promptAlert("Test name");
    	objAlerts.confAlert();
    	objAlerts.verifyPrompt("Test name");
    	
    }
}
