package com.qa.assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagePage {
	

	@FindBy (xpath = "//*[@id=\"management-links\"]/tbody/tr[15]/td[2]/div[1]/a")
	private WebElement manageUserLink;
	
	public void linkManageUser() {
		
		 manageUserLink.click();

}
}
