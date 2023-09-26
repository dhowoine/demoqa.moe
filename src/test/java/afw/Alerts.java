package afw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class Alerts {
	WebDriver driver;
	Alert alert;
	Wait<WebDriver> wait;
	
	public @FindBy(css = "button[id=\"alertButton\"]") WebElement alertBtn;
	public @FindBy(css = "button[id=\"timerAlertButton\"]") WebElement alert5sec;
	public @FindBy(css = "button[id=\"confirmButton\"]") WebElement confBox;
	public @FindBy(css = "button[id=\"promtButton\"]") WebElement promptBox;
	
	public Alerts(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@Step("Нажать на кнопку и дождаться появления уведомления")
	public void getAlert(WebElement btn) {
		btn.click();
		alert = wait.until(ExpectedConditions.alertIsPresent());
	}
	
	@Step("Нажать на кнопку «Да» в уведомлении")
	public void confAlert() {
		alert.accept();
	}
	
	@Step("Проверить, что появился текст You selected Ok")
	public void verifyConfBtn() {
		assertTrue(!driver.findElements(By.id("confirmResult")).isEmpty());
	}
	
	@Step("Заполнить поле в уведомление данными")
	public void promptAlert(String arg) {
		alert.sendKeys(arg);
	}
	
	@Step("Проверить, что появился текст You entered _данные_")
	public void verifyPrompt(String arg) {
		if (!driver.findElements(By.id("promptResult")).isEmpty()) {
			assertEquals("You entered " + arg, driver.findElement(By.id("promptResult")).getText());
		}
	}
	
}
