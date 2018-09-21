package com.qa.assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfile {
	
	@FindBy (xpath = "//*[@id=\"main-panel\"]/h1")
	private WebElement profileTitle;
	
	public WebElement profileTitle () {
		
		return profileTitle;
		
	}
	

}
