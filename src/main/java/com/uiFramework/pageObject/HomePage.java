package com.uiFramework.pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.uiFramework.testBase.BaseTest;
import com.uiFramework.uiNavigations.actionHelper.ActionHelper;
import com.uiFramework.uiNavigations.actionHelper.Generic;


public class HomePage extends BaseTest {

	public String getLogoText() throws Exception {
		
		WebElement abhiBusLogo = getLocator("abhiBusLogo");
		ActionHelper ac = new ActionHelper(driver);
		ac.moveToElement(abhiBusLogo);
		return abhiBusLogo.getAttribute("alt");
	}

	public void enterLeavingFromEditBox(String source) {
		try {
			WebElement LeavingFrom = getLocator("LeavingFrom");
			LeavingFrom.click();
			Thread.sleep(1000);
			LeavingFrom.sendKeys(source);
			List<WebElement> leavingFromList = getLocators("EleInLeavingFrom");
			for (WebElement optionToselect : leavingFromList) {
				if (optionToselect.getText().equalsIgnoreCase(source)) {
					optionToselect.click();
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterGoingToEditBox(String destination) {
		try {
			WebElement goingTo = getLocator("GoingTo");
			goingTo.click();
			goingTo.sendKeys(destination);
			Thread.sleep(2000);
			List<WebElement> goingToListOptions = getLocators("EleInGoingTo");
			
			Thread.sleep(3000);
			for (WebElement glistOptins : goingToListOptions) {
				if (glistOptins.getText().equalsIgnoreCase(destination)) {
					glistOptins.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterDateOfJourney(String locator, String date) {
		((JavascriptExecutor) driver).executeScript("document.getElementById('datepicker1').value='"+date+"';");
	}

	public void enterReturnDateOfJourney(String locator, String date) {
		((JavascriptExecutor) driver).executeScript("document.getElementById('datepicker2').value='"+date+"';");
	}

	public BookTicket clickOnSearchButton() {
		BookTicket booking = null;
		try {
			WebElement searchButton = getLocator("SearchBtn");
			Generic.click(searchButton);
			booking= new BookTicket();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booking;
	}
}
