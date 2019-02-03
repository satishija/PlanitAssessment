package com.uiFramework.testScripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.uiFramework.excelReader.ReadExcel;
import com.uiFramework.pageObject.BookTicket;
import com.uiFramework.pageObject.HomePage;
import com.uiFramework.pageObject.ReturnBooking;
import com.uiFramework.testBase.BaseTest;
import com.uiFramework.uiNavigations.actionHelper.Generic;
import com.uiFramework.utils.DateUtil;

public class TestCase extends BaseTest{
	
	String toBookingAmount;
	String returnBookingAmount;
	
	
	@Test(priority=0)
	public void verifyAbhiBusToolTip() throws Exception {
		HomePage homepage = new HomePage();
		driver.get(getEnvironmentKey("url"));
		Generic.checkPageIsReady();
		homepage.getLogoText();
		assertEquals(homepage.getLogoText(), ReadExcel.getCellData("Sheet1", 1, 2));
	}	
	
	@Test(priority=1)
	public void searchForJourney(){
				
		HomePage homepage = new HomePage();
		driver.get(getEnvironmentKey("url"));
		String source = ReadExcel.getCellData("Sheet1",1,0);
		homepage.enterLeavingFromEditBox(source);
		String destination = ReadExcel.getCellData("Sheet1",1,1);
		homepage.enterGoingToEditBox(destination);
		homepage.enterDateOfJourney("locator",DateUtil.genarateDate(1));
		homepage.enterReturnDateOfJourney("locator",DateUtil.genarateDate(2));
		homepage.clickOnSearchButton();
	}
	
	@Test(priority=2)
	public void selectTravelsAndSelectSeat() throws Exception{
		 
		BookTicket bookTicket=new BookTicket();
		bookTicket.selectOperator("Aditya Travels");
		bookTicket.selectAvailableSeat();
		toBookingAmount=bookTicket.getJourneyToAmount();
		bookTicket.selectBoardingAndPrintAddress();
		bookTicket.clickOnBookReturn();
	}
	@Test(priority=3)
	public void bookReturnTickets() throws Exception{
		ReturnBooking returnBooking=new ReturnBooking();
		returnBooking.selectReturnJourneyOperator();
		returnBooking.selectReturnJourneyAvailableSeat();
		returnBookingAmount=returnBooking.getReturnAmount();
		returnBooking.selectReturnBoardingAndPrintAddress();
	}
	@Test(priority=4)
	public void amountAndJourneyDetailsValidation() throws Exception{
		ReturnBooking returnBooking=new ReturnBooking();
		String onwordJourneyDetails=returnBooking.getOnwardJourneyDetails();
		System.out.println(onwordJourneyDetails);
		String returnJourneyDetail=returnBooking.getReturnJourneyDetails();
		System.out.println(returnJourneyDetail);
		String netPayableAmount=returnBooking.getNetPayable();
		System.out.println(netPayableAmount);
	}
	
	
}
