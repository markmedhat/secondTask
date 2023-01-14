package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	

	// elements ------------------------------------------------
	@FindBy(id = "fromPlaceName")
	public WebElement leavingFrom;

	@FindBy(xpath = "/html/body/ul[1]/li")
	public List<WebElement> select_leavingFromList;

	@FindBy(id = "toPlaceName")
	public WebElement select_leavingFromItem;

	@FindBy(xpath = "/html/body/ul[2]/li")
	public List<WebElement> select_leavingToList;

	@FindBy(id = "txtJourneyDate")
	public WebElement arrivalDate;

	@FindBy(xpath = "/html/body/div/table//td")
	public List<WebElement> dates;

	@FindBy(xpath = "/html/body/main/form/div[1]/div/div[2]/div[3]/button")
	public WebElement SearchForBus;

	// methods -------------------------------------------------
	
	public void openURL(String URL) {
		driver.get(URL);
	}
	
	public void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void clikOnItem(WebElement element) {
		element.click();
	}

	public void Take_List_String_To_Select_An_Item(List<WebElement> list, String text) {

		int sizeOfList = list.size();
		for (int i = 0; i < sizeOfList; i++) {
			if (list.get(i).getText().equalsIgnoreCase(text)) {
				clikOnItem(list.get(i));
				break;
			}
		}

	}

	public void wait_Till_elment_be_clickcable_THEN_click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		clikOnItem(element);
	}

	
}
