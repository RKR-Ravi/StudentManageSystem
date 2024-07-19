package GenericUtitlity;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis=new FileInputStream("‪‪‪‪‪‪‪‪‪‪C:\\Users\\hi\\Desktop\\DA\\commondata.Properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(key);
		return data;
	}
}
