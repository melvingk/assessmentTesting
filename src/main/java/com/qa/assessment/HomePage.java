package com.qa.assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy (xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manageLink;
	
	public void linkManage() {
		
	  manageLink.click();


}
}