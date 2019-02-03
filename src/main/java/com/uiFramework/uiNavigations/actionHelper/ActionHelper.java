package com.uiFramework.uiNavigations.actionHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {
	WebDriver driver;
	
	public ActionHelper(WebDriver driver){
		this.driver =driver;
	}

	
	public  Actions moveToElement(WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		return action;
	}
	
}
