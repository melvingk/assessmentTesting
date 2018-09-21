package com.qa.assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage {
	
	
	@FindBy (xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement userLink;
	
	public void linkUser () {
		
		 userLink.click();
		
	}
	@FindBy (xpath = "//*[@id=\"main-panel\"]/h1")
	private WebElement userTitle;
	
	public WebElement titleUser () {
		
		return userTitle;
		
	}
	
	
	
//	@FindBy (xpath = "//*[@id=\"people\"]")
//	private WebElement ListOfPeople;
//	
//	public WebElement ListOfPeople () {
//		
//		return ListOfPeople;
//		

	

}
//*[@id="main-panel"]/h1