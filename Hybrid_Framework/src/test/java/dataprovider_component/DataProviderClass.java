package dataprovider_component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;

import generic_component.ExcelRW;

public class DataProviderClass {
	
	@DataProvider(name="dp_ValidSearch")
	public static Iterator<Object[]>  getInvaliddata() throws Exception
	{
		return commondp_logic("Search", "ValidSearch");
	}
	
	@DataProvider(name="dp_InvalidSearch")
	public static Iterator<Object[]>  getInvalidsearch() throws Exception
	{
		return commondp_logic("Search", "InvalidSearch");
	}
	
	
	@DataProvider(name="dp_validlogin")
	public static Iterator<Object[]>  getValiddata() throws Exception
	{
		return commondp_logic("Login", "ValidLogin");
	}
	
	@DataProvider(name="dp_Invalidlogin")
	public static Iterator<Object[]>  getInValiddata() throws Exception
	{
		return commondp_logic("Login", "InvalidLogin");
	}
	
	
	public static Iterator<Object[]> commondp_logic(String sheetname, String sName) throws Exception
	{
		ExcelRW xl = new ExcelRW("D:\\hybridframework\\testdata\\rediff_login.xlsx");
		int rowCount = xl.getRow("Search");
		int columnCont = xl.getColumn("Search");
		
		//declare arraylist
		ArrayList<Object[]> arr_list = new ArrayList<Object[]>();
		
		for(int i=1;i<=rowCount;i++)
		{
			String script_Name = xl.readCell("Search", i, 2);
			String execute_Flag = xl.readCell("Search", i, 3);
			
			if((execute_Flag.equalsIgnoreCase("Y")) && (script_Name.equalsIgnoreCase(sName)))
			{
				//declare map
				Map<String, String> dMap = new HashMap<String, String>();
				
				Object[] x = new Object[1];
				
				for(int j=0; j<columnCont; j++)
				{
					String sKey = xl.readCell("Search", 0, j);
					String value = xl.readCell("Search", i, j);
					
					dMap.put(sKey, value);
										
				}				
				x[0] = dMap;
				
				arr_list.add(x);
			} // end of if condition
			
		} // end of for loop
		
		return arr_list.iterator();
		
	}
	
	

}

