package scenario_component;

import java.util.Map;

import generic_component.BaseClass;

import org.testng.annotations.Test;

import pageobject_component.Pf_HomePage;
import pageobject_component.Pf_LoginPage;

public class ScenarioLogin extends BaseClass{
	
	@Test(dataProvider="dp_Invalidlogin",dataProviderClass= dataprovider_component.DataProviderClass.class)	
	public void testInvalidlogin(Map<String,String> login)
	{
		String Uname = login.get("UserName");
		String Pwd = login.get("Password");
		String Exp_Result = login.get("Expected Results");
		
		Pf_HomePage home_page = new Pf_HomePage(driver);
		home_page.clickSignIn();
		
		Pf_LoginPage login_page = new Pf_LoginPage(driver);
		login_page.login(Uname, Pwd);
		
		String actualResults =login_page.getErrorMsg();

		
		if(Exp_Result.equalsIgnoreCase(actualResults)){
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		
	}
	
	@Test(dataProvider="dp_validlogin",dataProviderClass= dataprovider_component.DataProviderClass.class)	
	public void testValidlogin(Map<String,String> login)
	{
		String Uname = login.get("UserName");
		String Pwd = login.get("Password");
		String Exp_Result = login.get("Expected Results");
		
		Pf_HomePage home_page = new Pf_HomePage(driver);
		home_page.clickSignIn();
		
		Pf_LoginPage login_page = new Pf_LoginPage(driver);
		login_page.login(Uname, Pwd);
		
		String actualResults =login_page.getErrorMsg();

		if(Exp_Result.equalsIgnoreCase(actualResults)){
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		
	}
}
