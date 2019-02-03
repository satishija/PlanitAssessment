package com.uiFramework.pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.testBase.BaseTest;
import com.uiFramework.uiNavigations.actionHelper.Generic;

public class BookTicket extends BaseTest{
	
	public BookTicket(){
		
	}
	
	public void selectOperator(String operatorId) throws Exception{
		WebElement operator = getLocator("TravelsOpId");
		Generic.click(operator);
		List<WebElement> listOfOperators=getLocators("ElemtsInOpIdTo");
		for (WebElement operatorName : listOfOperators) {
			String sp = operatorName.getText().trim();
			if (sp.equals(operatorId)) {
				System.out.println("ok --good");
				Generic.click(operatorName);
				return;
			}
		}
		WebElement otherOperator=listOfOperators.get(0);
		Generic.click(otherOperator);
	}
	public void selectAvailableSeat() throws Exception{
		Generic.click(getLocator("btnSelectSeat"));
		List<WebElement> seatsAvailable=getLocators("SeatsAvailable");
		System.out.println("seatsAvailable::" + seatsAvailable.size());
		WebElement ele = seatsAvailable.get(0);
		System.out.println("o item ::" +ele );
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
		Generic.click(ele);
	}
	
	public String getJourneyToAmount() throws Exception {
		Thread.sleep(2000);
		 WebElement element = getLocator("ToAmount");
		String amount = Generic.getText(element);
		System.out.println("Journey amount ::" + amount);
		return amount;
	}
	
	public void selectBoardingAndPrintAddress() throws Exception {
		WebElement boardPoint = getLocator("BoardingPoint");
		Select sboardPoint = new Select(boardPoint);
		List<WebElement> lboardPoint = sboardPoint.getOptions();
		if (lboardPoint.size() > 1) {
			sboardPoint.selectByIndex(1);
			WebElement boardAddress = sboardPoint.getFirstSelectedOption();
			String selectedItem = boardAddress.getText();
			System.out.println("selected boarding point :: " + selectedItem);
		} else {
			System.out.println("No address displayed..");
		}
		try {

			if (getLocator("BoardingPointAddress").isDisplayed()) {
				String bordingPointAddress = getLocator("BoardingPointAddress").getText();
				System.out.println("bordingPointAddress ::" + bordingPointAddress);
			}
		} catch (Exception e) {
			System.out.println("bording Point Address is not displayed");
		}
	}
	
	public ReturnBooking clickOnBookReturn() throws Exception {
		WebElement element = getLocator("btnReturnBook");
		Generic.click(element);
		System.out.println("Clicked on return button....");
		return new ReturnBooking();
	}
	
	

}
