package com.qa.assessment;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import ExcelUtils.FileExcel;

import Utlis.ConstantsAssess;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class assessmentTest {
	
	WebDriver driver= null;
	ExtentTest test;
	ExtentReports report = ConstantsAssess.report; 
//	
	@Before
	public  void setup() {
		
		//FileExcel.setExcelFile(ConstantsAssess.pathTestData + ConstantsAssess.fileTestData, 0);
		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/Admin/Desktop/testing exe/chromedriver.exe");	
				driver = new ChromeDriver();	
		test = report.startTest("The start of the Test");
	}
	
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen()  {
	
		driver.get(ConstantsAssess.websiteURL);
		
		LogInPage create = PageFactory.initElements(driver, LogInPage.class);
		create.logAdmin("Admin", "cf318a2373df4dd29b5cc22c9159fd65");
		create.submitAdmin(); 
		
		HomePage access = PageFactory.initElements(driver, HomePage.class);
		access.linkManage();
		
		ManagePage access1 = PageFactory.initElements(driver, ManagePage.class);
		access1.linkManageUser();
		
		UsersPage access2 = PageFactory.initElements(driver, UsersPage.class);
		access2.linkUser();
		
		test.log(LogStatus.INFO,"Page opened");
		
			
//		driver.manage().window().maximize();
	   
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen()  {
	    
		String username= "timmy";
	    String password= "bababababa";
	    String password2= "bababababa";
	    String fullname= "timmy turner";
	    
		
		CreateUserPage make = PageFactory.initElements(driver, CreateUserPage.class);
		make.creating(username, password, password2, fullname);
		assertEquals(password,password2);
		
		if (password.equals(password2))
		{
			test.log(LogStatus.PASS,"Confirms the passwords match");
		}
		else 
		{
			test.log(LogStatus.FAIL,"The passwords do not match");
		}
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen()  {
	    
		CreateUserPage send = PageFactory.initElements(driver, CreateUserPage.class);
		send.submitting();
		
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen()   {
	   
		driver.get(ConstantsAssess.websiteURL1);
		String word ="timmy";
		
//		UsersPage confirm = PageFactory.initElements(driver, UsersPage.class);
	
		WebElement user = driver.findElement(By.partialLinkText("timmy"));
	    
	    
	    if(user.equals(word))
	    {
	    	test.log(LogStatus.PASS,"Username present");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL,"Not present");
	    }
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4)throws Throwable {
	    
		
		
		CreateUserPage entering = PageFactory.initElements(driver, CreateUserPage.class);
		entering.creating(arg1,arg2,arg3,arg4);
		entering.submitting();
		
		 throw new PendingException();

	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1)  {
		
		driver.get(ConstantsAssess.websiteURL1);
		String word ="user";
		
		WebElement user = driver.findElement(By.className("sortable pane bigtable"));
	    List<WebElement> listofwebelements= user.findElements(By.tagName("a href"));
	    
	    if(listofwebelements.contains(word))
	    {
	    	test.log(LogStatus.PASS,"Username present");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL,"Not present");
	    }
	    
	
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) {
	   
		driver.get(ConstantsAssess.websiteURL1);
		UsersPage user = PageFactory.initElements(driver, UsersPage.class);
		assertEquals("User",user.titleUser()); 
		
		WebElement user1 = driver.findElement(By.id("people"));
		
		if (user1.equals(arg1))
		{
			test.log(LogStatus.PASS,"Username present");
		}
		else
		{
		 	test.log(LogStatus.FAIL,"Not present");
		}
		
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1)  {
	   
		UsersPage user = PageFactory.initElements(driver, UsersPage.class);
		
		WebElement click = driver.findElement(By.partialLinkText("a href"));
		
		if(click.equals(arg1))
		{
			click.click();
		}
		
	    ;
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
	    
		UserProfile name = PageFactory.initElements(driver, UserProfile.class);
		
		name.profileTitle();
		
		if (name.profileTitle().equals(arg1))
		{
			test.log(LogStatus.PASS,"Username present");
		}
		else
		{
			test.log(LogStatus.PASS,"Username present");
		}
		
	    throw new PendingException();
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
	  
	    throw new PendingException();
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
		driver.quit();
		report.endTest(test);
		report.flush();
	}
	
//	
//	
	
	
	

}
