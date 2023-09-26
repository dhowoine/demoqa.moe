package elements;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import io.qameta.allure.Step;

public class Buttons {
	WebDriver driver;
	Actions act;
	
	public @FindBy(xpath = "//button[text()=\"Click Me\"]") WebElement clickMe;
	public @FindBy(css = "button[id=\"rightClickBtn\"]") WebElement rightClickMe;
	public @FindBy(css = "button[id=\"doubleClickBtn\"]") WebElement doubleClickMe;
	
	
	public Buttons(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	
	@Step("Нажать лкм на кнопку")
	public void justClick(WebElement btn) {
		btn.click();
	}
	
	@Step("Нажать пкм на кнопку")
	public void rightClick(WebElement btn) {
		act.contextClick(btn).perform();
	}
	
	@Step("Дважды нажать лкм на кнопку")
	public void doubleClick(WebElement btn) {
		act.doubleClick(btn).perform();
	}
	
	@Step("Проверить, что появился текст «You have done a dynamic click»")
	public void verifyClickMe() {
		assertTrue(!driver.findElements(By.id("dynamicClickMessage")).isEmpty());
	}
	
	@Step("Проверить, что появился текст «You have done a right click»")
	public void verifyRightClickMe() {
		assertTrue(!driver.findElements(By.id("rightClickMessage")).isEmpty());
	}
	
	@Step("Проверить, что появился текст «You have done a double click»")
	public void verifyDoubleClickMe() {
		assertTrue(!driver.findElements(By.id("doubleClickMessage")).isEmpty());
	}
}
