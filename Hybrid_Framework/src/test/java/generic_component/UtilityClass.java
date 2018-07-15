package generic_component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass {

	public String reading_properties(String skey) throws IOException
	{
		FileInputStream fis = new FileInputStream("src/test/resources/login.properties");
		Properties prop= new Properties();
		prop.load(fis);
		
		return prop.getProperty(skey);
	}
}
