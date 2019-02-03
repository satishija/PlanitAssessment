package com.uiFramework.uiNavigations.actionHelper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.uiFramework.testBase.BaseTest;

/*This class is used for generic actions performed on the web elements
 * like click and scroll until page loads*/
public class Generic extends BaseTest {

	public static void click(WebElement element) {
		checkPageIsReady();
		if (element.isDisplayed())
			element.click();
	}

	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public static void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}
		// This loop will rotate for 25 times to check If page Is ready after
		// every 1 second.
		// You can replace your value with 25 If you wants to Increase or
		// decrease wait time.
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	public static String getText(WebElement element) {
		checkPageIsReady();
		String text = null;
		if (element.isDisplayed()) {
			text= element.getText();
		}
		return text;
	}

}
