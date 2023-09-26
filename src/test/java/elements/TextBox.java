package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import io.qameta.allure.Step;

public class TextBox {
	WebDriver driver;

	@FindBy(css = "input[id=\"userName\"]") WebElement userName;
	@FindBy(css = "input[id=\"userEmail\"]") WebElement userEmail;
	@FindBy(css = "textarea[id=\"currentAddress\"]") WebElement currentAddress;
	@FindBy(css = "textarea[id=\"permanentAddress\"]") WebElement permanentAddress;
	@FindBy(css = "button[id=\"submit\"]") WebElement submit;
	
	public TextBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@Step("Заполнить Full Name")
	public void enterFullName(String arg) {
		userName.sendKeys(arg);
	}
	
	@Step("Заполнить Email")
	public void enterEmail(String arg) {
		userEmail.sendKeys(arg);
	}
	
	@Step("Заполнить Current Address,")
	public void enterCurrentAddress(String arg) {
		currentAddress.sendKeys(arg);
	}
	
	@Step("Заполнить Permanent Address")
	public void enterPermanentAddress(String arg) {
		permanentAddress.sendKeys(arg);
	}
	
	@Step("Нажать на кнопку «Submit»")
	public void submitInfo() {
		submit.click();
	}
	
	@Step("Проверить, что данные в блоке сохранены корректно")
	public void verifyInfo(String name, String email, String curAdd, String perAdd) {
		if (name != null) {
			assertEquals("Name:" + name, driver.findElement(By.cssSelector("p#name")).getText());
		}
		
		if (email != null) {
			assertEquals("Email:" + email, driver.findElement(By.cssSelector("p#email")).getText());
		}
		
		if (curAdd != null) {
			assertEquals("Current Address :" + curAdd, driver.findElement(By.cssSelector("p#currentAddress")).getText());
		}
		
		if (perAdd != null) {
			assertEquals("Permananet Address :" + perAdd, driver.findElement(By.cssSelector("p#permanentAddress")).getText());
		}
	}
	

}
