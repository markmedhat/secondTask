package tests;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.PaymentPage;
import pages.Select_A_seat_Page;

public class TaskTwo_firstScenario_SelectASeat_Then_Payment_Test extends TestBase {
	HomePage homepage;
	Select_A_seat_Page selectAseatPage;
	PaymentPage paymentPage;

	@Test(dataProvider = "home_seatDate_passenger_payment")
	public void TaskTwo_firstScenario_SelectASeat_Then_Payment(String leavingFrom , String leavingTo , String arrivalDate ,String mobNumber , String Email , String passengerName ,String passengerGender ,String passengerAge ,String consession , String cardName, String cardexpiry , String cardHolderName , String CVV) {
		homepage = new HomePage(driver);
		selectAseatPage = new Select_A_seat_Page(driver);
		paymentPage = new PaymentPage(driver);
		// - Choose the following ((from "CHIKKAMAGALURU" to "BENGALURU”)) from the
		homepage.sendKeys(homepage.leavingFrom, leavingFrom);
		homepage.Take_List_String_To_Select_An_Item(homepage.select_leavingFromList, leavingFrom);
		homepage.wait_Till_elment_be_clickcable_THEN_click(homepage.select_leavingFromItem);
		homepage.Take_List_String_To_Select_An_Item(homepage.select_leavingToList, leavingTo);
		// - Choose the arrival date only
		homepage.clikOnItem(homepage.arrivalDate);
		homepage.Take_List_String_To_Select_An_Item(homepage.dates, arrivalDate);
		// - Click “Search for bus”
		homepage.clikOnItem(homepage.SearchForBus);
		selectAseatPage.wait_Till_elment_be_Visible(selectAseatPage.filter);
		// - Select a seat steps
		// wait till make sure the search result be there
		selectAseatPage.wait_Till_elment_be_Visible(selectAseatPage.filter);
		// select a seat
		selectAseatPage.wait_Till_elment_be_clickcable_THEN_click(selectAseatPage.selectSeat);
		// wait till make sure the next view be there
		selectAseatPage.wait_Till_elment_be_Visible(selectAseatPage.clickOnSeat);
		// - Choose the boarding point and dropping point
		// Choose the boarding point
		selectAseatPage.wait_Till_elment_be_clickcable_THEN_click(selectAseatPage.boardingPointTab);
		selectAseatPage.Take_List_And_String_To_Select_An_Item_contains_Text(selectAseatPage.boardingPointList,
				"CHIKKAMAGALURU");
		// Choose the dropping point
		selectAseatPage.Take_List_And_String_To_Select_An_Item_contains_Text(selectAseatPage.droppingPointList,
				"BENGALURU");
		selectAseatPage.sendText(selectAseatPage.mobPhone, mobNumber);
		selectAseatPage.sendText(selectAseatPage.email, Email);
		// choose a seat to can enter the passenger data
		selectAseatPage.Select_A_Seat(selectAseatPage.seatList);
		// fill passenger details
		selectAseatPage.clickOnItem(selectAseatPage.passengerDetails);
		selectAseatPage.sendText(selectAseatPage.passengerName, passengerName);
		selectAseatPage.selectAnItemFromSelectList(selectAseatPage.passengerGender, passengerGender);
		selectAseatPage.sendText(selectAseatPage.passengerAge, passengerAge);
		selectAseatPage.selectAnItemFromSelectList(selectAseatPage.consession, consession);
		// - Click on “make payment” and fill all the fields without submitting the
		// payment
		// click on make payment button
		selectAseatPage.clickOnItem(selectAseatPage.makePayment);
		// select card payment method then fill all fileds without submitting the
		// payment
		driver.switchTo().frame(paymentPage.iframeElement);
		paymentPage.clickOnItem(paymentPage.cardPaymentMethod);
		paymentPage.sendText(paymentPage.cardName, cardName);
		paymentPage.sendText(paymentPage.cardexpiry, cardexpiry);
		paymentPage.sendText(paymentPage.cardHolderName, cardHolderName);
		paymentPage.sendText(paymentPage.CVV, CVV);

	}
	
	//HomePageDate_select_a_seatDate_mobile_and_email_select_a_seatPassengerDetails_passengerName_passengerGender_passengerAge_consession_cardPaymentMethod_cardName_cardexpiry_cardHolderName_CVV
	@DataProvider(name = "home_seatDate_passenger_payment")
	public static Object[][] allData()
	{
		return new Object[][] {
			{"CHIKKAMAGALURU","BENGALURU","19", "6789125987","test@test.com" , "test","MALE","29","GENERAL PUBLIC" , "test" , "1234" ,"test"  ,"123" }	};
	}
	
	

}
