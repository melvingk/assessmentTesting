package com.qa.assessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {

	@FindBy (id= "username")
	private WebElement usernamebox;
	
	@FindBy (xpath= "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordbox1;

	@FindBy (xpath= "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement passwordbox2;
	
	@FindBy (xpath= "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullnamebox;
	
	public void creating (String user, String pass1, String pass2, String full) {
		usernamebox.sendKeys(user);
		passwordbox1.sendKeys(pass1);
		passwordbox2.sendKeys(pass2);
		fullnamebox.sendKeys(full);
		fullnamebox.sendKeys(Keys.ENTER);
		//Thread.sleep(2500);
		
	}
	
	public void submitting () {
	
		fullnamebox.sendKeys(Keys.ENTER);
	}

	

}
