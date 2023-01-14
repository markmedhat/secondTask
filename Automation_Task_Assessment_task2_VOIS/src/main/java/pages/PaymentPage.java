package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageBase {

	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	// elements---------------------------------------------
	@FindBy(xpath = "/html/body/div/iframe")
	public WebElement iframeElement;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[3]/div[3]/form/div[2]/div[1]/div[1]/div[1]/div/div/div[2]/div/button[1]/div/div[1]/div[1]/div[1]")
	public WebElement cardPaymentMethod;
	@FindBy(id = "card_number")
	public WebElement cardName;
	@FindBy(id = "card_expiry")
	public WebElement cardexpiry;
	@FindBy(id = "card_name")
	public WebElement cardHolderName;
	@FindBy(id = "card_cvv")
	public WebElement CVV;
	// methods----------------------------------------------
	public void clickOnItem(WebElement element) {
		element.click();
	}
	public void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
}
