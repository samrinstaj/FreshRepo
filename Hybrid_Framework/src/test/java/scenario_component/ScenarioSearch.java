package scenario_component;

import java.util.Map;

import org.testng.annotations.Test;

import generic_component.BaseClass;
import pageobject_component.Pf_HomePage;

public class ScenarioSearch extends BaseClass{
	@Test(dataProvider="dp_InvalidSearch",dataProviderClass= dataprovider_component.DataProviderClass.class)	
	public void testInvalidSearch(Map<String,String> search){
	
	String srch_txt=search.get("Keyword");
	String Exp_Result = search.get("Expected Results");

	
	Pf_HomePage home_page = new Pf_HomePage(driver);
	home_page.searchText(srch_txt);
	home_page.searchBtn();
	String actualResults = home_page.InvalidSearchMsg();
	
	if(Exp_Result.equalsIgnoreCase(actualResults)){
		System.out.println("passed");
	}
	else	
	{
		System.out.println("failed");
	}
	}
	
	@Test(dataProvider="dp_ValidSearch",dataProviderClass= dataprovider_component.DataProviderClass.class)	
	public void testValidSearch(Map<String,String> search){
	
	String srch_txt=search.get("Keyword");
	String Exp_Result = search.get("Expected Results");
	
	Pf_HomePage home_page = new Pf_HomePage(driver);
	home_page.searchText(srch_txt);
	home_page.searchBtn();
    String actualResults=home_page.validSearchMsg();
	
	if(Exp_Result.equalsIgnoreCase(actualResults)){
		System.out.println("passed");
	}
	else
	{
		System.out.println("failed");
	}
}
}

