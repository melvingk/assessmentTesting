package com.qa.assessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {
	
		@FindBy (id="j_username")
		private WebElement LogInUser;
		
		@FindBy (xpath= "//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
		private WebElement passwordbox;

		public void logAdmin (String user, String pass) {
			LogInUser.sendKeys(user);
			passwordbox.sendKeys(pass);
			
			//Thread.sleep(2500)
		}
		
		public void submitAdmin () {
		
			passwordbox.sendKeys(Keys.ENTER);
		}


}
