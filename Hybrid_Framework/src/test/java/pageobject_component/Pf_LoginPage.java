package pageobject_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pf_LoginPage {
	@FindBy(name="logid")
	public WebElement usename_txt;
	
	@FindBy(name="pswd")
	public WebElement Pwd_txt;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement login_btn;
	
	@FindBy(xpath="//*[contains(text(),'Sorry we were unable')]")
	public WebElement error_msg;
	
	public Pf_LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un,String pwd)
	{
		usename_txt.sendKeys(un);
		Pwd_txt.sendKeys(pwd);
		login_btn.click();
	}
	
	public String getErrorMsg(){
		return error_msg.getText();
	}
}
