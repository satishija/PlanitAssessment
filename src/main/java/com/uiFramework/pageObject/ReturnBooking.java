package com.uiFramework.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.testBase.BaseTest;
import com.uiFramework.uiNavigations.actionHelper.Generic;

public class ReturnBooking extends BaseTest{

	public void selectReturnJourneyOperator() throws Exception {
		System.out.println("--------Now select the “Return tickets” as mentioned from Step 6 to Step 10-------------");
		WebElement operatorReturn =getLocator("btnReturnOperatorFilter");
		Generic.click(operatorReturn);
		List<WebElement> listOfOperators=getLocators("retrunListOperators");
		for (WebElement returnOperator : listOfOperators) 
		{
			String sp1 = returnOperator.getText().trim();
			if (sp1.equals("Aeon connect")) {
				System.out.println("ok return operator selected --good");
				returnOperator.click();
				break;
			}
		}
		
	}
	
	public void selectReturnJourneyAvailableSeat() throws Exception {
		WebElement element=getLocator("btnReturnSelectSeat");
		Generic.scrollToElement(element);
		Generic.click(element);
		Thread.sleep(2000);
		Generic.click(getLocator("btnReturnSeat"));
	}
	
	public String getReturnAmount() throws Exception {
		String ramount=Generic.getText(getLocator("lblReturnFare"));
		System.out.println("Return Journey amount ::" + ramount);
		return ramount;
		
	}
	
	
	public void selectReturnBoardingAndPrintAddress() throws Exception {
		WebElement rboardPoint=getLocator("lstReturnBoardingPoint");
		Select rsboardPoint = new Select(rboardPoint);
		List<WebElement> rlboardPoint = rsboardPoint.getOptions();
		if (rlboardPoint.size()>1){
		rsboardPoint.selectByIndex(1);
		WebElement rboardAddress = rsboardPoint.getFirstSelectedOption();
		String selectedItem = rboardAddress.getText();
		System.out.println("selected boarding point :: " + selectedItem);
		}else {
			System.out.println("No address displayed..");
		}
		try {
			if (getLocator("lblReturnBoardingAddress").isDisplayed())
			{
	        String bordingPointAddress= getLocator("lblReturnBoardingAddress").getText();
	         System.out.println("Return Journey Boarding Address ::" + bordingPointAddress);
	       }
			}catch(Exception e){
				System.out.println("bordingPointAddress is not displayed");
			}
		Thread.sleep(2000);
		Generic.click(getLocator("btnContinuePayment"));
		
	} 
	
	public String getOnwardJourneyDetails() throws Exception {

		String toFrom = Generic.getText(getLocator("lblOnwardJourney"));
		System.out.println("toFrom " + toFrom);
		String toJourneyBoardingPoint = Generic.getText(getLocator("lblOnwardBoarding"));
		System.out.println("toJourneyBoardingPoint " + toJourneyBoardingPoint);
		return toFrom;

	}

	public String getReturnJourneyDetails() throws Exception {
		Thread.sleep(2000);
		String fromTo = Generic.getText(getLocator("lblReturnJourney"));
	     System.out.println("fromTo " + fromTo);
	     String returnJourneyBoardingPoint=Generic.getText(getLocator("lblReturnBoarding"));
		System.out.println("returnJourneyBoardingPoint " + returnJourneyBoardingPoint);
		return fromTo;
		
	}

	public String getNetPayable() {

		String netpayable = driver.findElement(By.xpath("//*[@id='NetAmountmsg']")).getAttribute("textContent");
		return netpayable;
		
	}
	
}
