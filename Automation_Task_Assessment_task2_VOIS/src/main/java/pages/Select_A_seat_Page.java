package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Select_A_seat_Page extends PageBase {

	public Select_A_seat_Page(WebDriver driver) {
		super(driver);
	}

	// elements--------------------------------------

	@FindBy(xpath = "/html/body/main/form/section/div/div[6]/div[2]/div[2]/div/div/div[1]")
	public WebElement filter;
	@FindBy(xpath = "/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[1]/div[1]/div[3]/div/input[4]")
	public WebElement selectSeat;
	@FindBy(xpath = "/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[1]/div/h6")
	public WebElement clickOnSeat;
	@FindBy(id = "Forwardboarding-tab")
	public WebElement boardingPointTab;
	@FindBy(xpath = "/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div/div/ul/li")
	public List<WebElement> boardingPointList;
	@FindBy(xpath = "/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/ul/li")
	public List<WebElement> droppingPointList;
	@FindBy(xpath = "/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[3]/div/p/a")
	public WebElement passengerDetails;
	@FindBy(xpath = "//*[contains(@id,'passengerNameForward')]")
	public WebElement passengerName;
	@FindBy(xpath = "//*[contains(@id,'genderCodeIdForward')]")
	public WebElement passengerGender;
	@FindBy(xpath = "//*[contains(@id,'passengerAgeForward')]")
	public WebElement passengerAge;
	@FindBy(xpath = "//*[contains(@id,'concessionIdsForward')]")
	public WebElement consession;
	@FindBy(id = "PgBtn")
	public WebElement makePayment;
	@FindBy(id = "mobileNo")
	public WebElement mobPhone;
	@FindBy(id = "email")
	public WebElement email;
	@FindBy(xpath = "/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/ul/li")
	public List<WebElement> seatList ;
	// methods---------------------------------------

	public void wait_Till_elment_be_Visible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickOnItem(WebElement element) {
		element.click();
	}

	public void wait_Till_elment_be_clickcable_THEN_click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		clickOnItem(element);
	}

	public void Take_List_And_String_To_Select_An_Item_contains_Text(List<WebElement> list, String text) {

		int sizeOfList = list.size();
		for (int i = 0; i < sizeOfList; i++) {
			if (list.get(i).getText().contains(text)) {
				clickOnItem(list.get(i));
				break;
			}
		}

	}

	public void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void selectAnItemFromSelectList(WebElement element, String text) {
		Select selectList = new Select(element);
		selectList.selectByVisibleText(text);

	}
	public void Select_A_Seat(List<WebElement> seatList) {
		int sizeOfSeatList = seatList.size();

		for (int i = 0; i < sizeOfSeatList; i++) {
			if (seatList.get(i).getAttribute("class").equalsIgnoreCase("availSeatClassS")) {
				clickOnItem(seatList.get(i));
				break;
			}
		}
	}
}
