package pageobject_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pf_HomePage {

	@FindBy(linkText="Sign In") 
	public WebElement signIn_lnk;
	
	@FindBy(className="proper") 
	WebElement valid_Msg;
	
	@FindBy(linkText="Sign Out")
	public WebElement signOut_lnk;
	
	@FindBy(id="srchword")
	public WebElement Search_text;
	
	@FindBy(xpath="//*[@type='button'][@class='newsrchbtn']")
	public WebElement clc_btn;
	
	@FindBy(className="sorrymsg")
	public WebElement Err_msg;
	
	@FindBy(xpath="//*[@id='myDataDiv']/div[1]/p[1]")
	public WebElement valid_searchMsg;
	
	public Pf_HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn(){
		signIn_lnk.click();
	}
	public String validMsg(){
		return valid_Msg.getText();
	}
	public void signOut(){
		signOut_lnk.click();
	}
	public void searchText(String searchKeyword){
		Search_text.sendKeys(searchKeyword);
	}
	public void searchBtn(){
		clc_btn.click();
	}
	public String InvalidSearchMsg(){
		return Err_msg.getText();
	}
	public String validSearchMsg(){
		return valid_searchMsg.getText();
	}
}
