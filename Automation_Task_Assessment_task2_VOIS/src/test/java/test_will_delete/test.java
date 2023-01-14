package test_will_delete;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.PaymentPage;
import pages.Select_A_seat_Page;
import tests.TestBase;

public class test extends TestBase {
	HomePage homepage;
	Select_A_seat_Page selectAseatPage;
	PaymentPage paymentPage ;

	
	@BeforeClass
	public void beforeEachTestCase() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		homepage = new HomePage(driver);
		homepage.openURL("https://ksrtc.in/oprs-web/guest/home.do?h=1");
		driver.manage().window().setSize(new Dimension(1024, 768));
		System.out.println("- browser resolution = " + driver.manage().window().getSize());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterClass
	public void clearEnvironment() {
		driver.quit();
	}

	@Test
	public void test_new() {

		selectAseatPage=new Select_A_seat_Page(driver);
		paymentPage = new PaymentPage(driver);
//		homepage = new HomePage(driver);
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// - Open this website: “https://ksrtc.in/oprs-web/guest/home.do?h=1”
		// driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");

//		driver.manage().window().setSize(new Dimension(1024, 768));
//		System.out.println("- browser resolution = " + driver.manage().window().getSize());
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// - Choose the following ((from "CHIKKAMAGALURU" to "BENGALURU”)) from the
//		WebElement leavingFrom = driver.findElement(By.id("fromPlaceName"));
//		leavingFrom.sendKeys("CHIKKAMAGALURU");
		homepage.sendKeys(homepage.leavingFrom, "CHIKKAMAGALURU");

//		List<WebElement> select_leavingFromList = driver.findElements(By.xpath("/html/body/ul[1]/li"));

//		int sizeOfListFrom = select_leavingFromList.size();
//		for (int i = 0; i < sizeOfListFrom; i++) {
//			if (select_leavingFromList.get(i).getText().equalsIgnoreCase("CHIKKAMAGALURU")) {
//				select_leavingFromList.get(i).click();
//				break;
//			}
//		}
//		

		homepage.Take_List_String_To_Select_An_Item(homepage.select_leavingFromList, "CHIKKAMAGALURU");

//		WebElement select_leavingFromItem = driver.findElement(By.id("toPlaceName"));
//		wait.until(ExpectedConditions.elementToBeClickable(select_leavingFromItem));
//		select_leavingFromItem.click();

		homepage.wait_Till_elment_be_clickcable_THEN_click(homepage.select_leavingFromItem);

//		List<WebElement> select_leavingToList = driver.findElements(By.xpath("/html/body/ul[2]/li"));

//		Take_Drive_List_String_To_Select_An_Item(driver, select_leavingToList, "BENGALURU");

		homepage.Take_List_String_To_Select_An_Item(homepage.select_leavingToList, "BENGALURU");

		// - Choose the arrival date only
//		WebElement arrivalDate = driver.findElement(By.id("txtJourneyDate"));
//		arrivalDate.click();
		homepage.clikOnItem(homepage.arrivalDate);

//		List<WebElement> dates = driver.findElements(By.xpath("/html/body/div/table//td"));

//		Take_Drive_List_String_To_Select_An_Item(driver, dates, "19");

		homepage.Take_List_String_To_Select_An_Item(homepage.dates, "19");

		// - Click “Search for bus”
//		WebElement SearchForBus = driver.findElement(By.xpath("/html/body/main/form/div[1]/div/div[2]/div[3]/button"));
//		SearchForBus.click();
	
		homepage.clikOnItem(homepage.SearchForBus);
		
		// - Select a seat steps
		// wait till make sure the search result be there
//		WebElement filter = driver
//				.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[2]/div[2]/div/div/div[1]"));

//		wait.until(ExpectedConditions.visibilityOf(filter));

		selectAseatPage.wait_Till_elment_be_Visible(selectAseatPage.filter);
		// select a seat
//		WebElement selectSeat = driver.findElement(By.xpath(
//				("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[1]/div[1]/div[3]/div/input[4]")));
//		wait.until(ExpectedConditions.elementToBeClickable(selectSeat));
//		selectSeat.click();
	
		selectAseatPage.wait_Till_elment_be_clickcable_THEN_click(selectAseatPage.selectSeat);
		
		// wait till make sure the next view be there

//		WebElement clickOnSeat = driver.findElement(By.xpath(
//				"/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[1]/div/h6"));
//		wait.until(ExpectedConditions.visibilityOf(clickOnSeat));
		
		selectAseatPage.wait_Till_elment_be_Visible(selectAseatPage.clickOnSeat);
		
		// - Choose the boarding point and dropping point

		// Choose the boarding point
//		WebElement boardingPointTab = driver.findElement(By.id("Forwardboarding-tab"));
//		wait.until(ExpectedConditions.elementToBeClickable(boardingPointTab));
//		boardingPointTab.click();

		selectAseatPage.wait_Till_elment_be_clickcable_THEN_click(selectAseatPage.boardingPointTab);
		
//		List<WebElement> boardingPointList = driver.findElements(By.xpath(
//				"/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div/div/ul/li"));

//		Take_Drive_List_String_To_Select_An_Item_contains_Text(boardingPointList, "CHIKKAMAGALURU");

		selectAseatPage.Take_List_And_String_To_Select_An_Item_contains_Text(selectAseatPage.boardingPointList, "CHIKKAMAGALURU");
		// Choose the dropping point

//		List<WebElement> droppingPointList = driver.findElements(By.xpath(
//				"/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/ul/li"));

//		Take_Drive_List_String_To_Select_An_Item_contains_Text(droppingPointList, "BENGALURU");
	
		selectAseatPage.Take_List_And_String_To_Select_An_Item_contains_Text(selectAseatPage.droppingPointList, "BENGALURU");

		// - Fill the “Customer” and “Passenger” details (Note: you can use this phone
		// number: 6789125987)
//		WebElement mobPhone = driver.findElement(By.id("mobileNo"));
//		mobPhone.sendKeys("6789125987");
	
		selectAseatPage.sendText(selectAseatPage.mobPhone, "6789125987");
	
//		WebElement email = driver.findElement(By.id("email"));
//		email.sendKeys("test@test.com");

		selectAseatPage.sendText(selectAseatPage.email, "test@test.com");
		
		// choose a seat to can enter the passenger data
//		List<WebElement> seatList = driver.findElements(By.xpath(
//				"/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/ul/li"));
//		Select_A_Seat(seatList);
	
		selectAseatPage.Select_A_Seat(selectAseatPage.seatList);
		
		// fill passenger details
//		WebElement passengerDetails = driver.findElement(By.xpath(
//				"/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[3]/div/p/a"));
//		passengerDetails.click();

		selectAseatPage.clickOnItem(selectAseatPage.passengerDetails);
		
		
//		WebElement passengerName = driver.findElement(By.xpath("//*[contains(@id,'passengerNameForward')]"));
//		passengerName.sendKeys("test");

		selectAseatPage.sendText(selectAseatPage.passengerName, "test");
		
//		Select passengerGender = new Select(driver.findElement(By.xpath("//*[contains(@id,'genderCodeIdForward')]")));
//		passengerGender.selectByVisibleText("MALE");

		selectAseatPage.selectAnItemFromSelectList(selectAseatPage.passengerGender, "MALE");
		
//		WebElement passengerAge = driver.findElement(By.xpath("//*[contains(@id,'passengerAgeForward')]"));
//		passengerAge.sendKeys("29");

		selectAseatPage.sendText(selectAseatPage.passengerAge,"29");
		
		
//		Select selectConsession = new Select(driver.findElement(By.xpath("//*[contains(@id,'concessionIdsForward')]")));
//		selectConsession.selectByVisibleText("GENERAL PUBLIC");

		selectAseatPage.selectAnItemFromSelectList(selectAseatPage.consession, "GENERAL PUBLIC");
		
		
		// - Click on “make payment” and fill all the fields without submitting the payment
//		WebElement makePayment = driver.findElement(By.id("PgBtn"));
//		makePayment.click();

		//click on make payment button 

		selectAseatPage.clickOnItem(selectAseatPage.makePayment);
		
		
//		WebElement iframeElement = driver.findElement(By.xpath("/html/body/div/iframe"));
		driver.switchTo().frame(paymentPage.iframeElement);
//		WebElement cardPaymentMethod = driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div/div[3]/div[3]/form/div[2]/div[1]/div[1]/div[1]/div/div/div[2]/div/button[1]/div/div[1]/div[1]/div[1]"));
//		cardPaymentMethod.click();
		paymentPage.clickOnItem(paymentPage.cardPaymentMethod);

//		WebElement cardName = driver.findElement(By.id("card_number"));
//      cardName.sendKeys("123456789");
		
		paymentPage.sendText(paymentPage.cardName, "123456789");
		
//		WebElement cardexpiry = driver.findElement(By.id("card_expiry"));
//		cardexpiry.sendKeys("1234");
		paymentPage.sendText(paymentPage.cardexpiry, "1234");

//		WebElement cardHolderName = driver.findElement(By.id("card_name"));
//		cardHolderName.sendKeys("test");
		paymentPage.sendText(paymentPage.cardHolderName, "test");

//		WebElement CVV = driver.findElement(By.id("card_cvv"));
//		CVV.sendKeys("123");
		paymentPage.sendText(paymentPage.CVV, "123");

	}

	public void Take_Drive_List_String_To_Select_An_Item(WebDriver driver, List<WebElement> list, String text) {

		int sizeOfList = list.size();
		for (int i = 0; i < sizeOfList; i++) {
			if (list.get(i).getText().equalsIgnoreCase(text)) {
				list.get(i).click();
				break;
			}
		}

	}

	public void Take_Drive_List_String_To_Select_An_Item_contains_Text(List<WebElement> list, String text) {

		int sizeOfList = list.size();
		for (int i = 0; i < sizeOfList; i++) {
			if (list.get(i).getText().contains(text)) {
				list.get(i).click();
				break;
			}
		}

	}

	public void Select_A_Seat(List<WebElement> seatList) {
		int sizeOfSeatList = seatList.size();

		for (int i = 0; i < sizeOfSeatList; i++) {
			System.out.println(seatList.get(i).getAttribute("class"));
			if (seatList.get(i).getAttribute("class").equalsIgnoreCase("availSeatClassS")) {
				seatList.get(i).click();
				break;
			}
		}
	}

}
