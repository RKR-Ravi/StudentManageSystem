package GenericUtitlity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility implements Paths{
	
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis1=new FileInputStream(filepath);
		//FileInputStream fis=new FileInputStream("C:\\Users\\hi\\Desktop\\DA\\commondata.Properties");
		Properties pobj=new Properties();
		pobj.load(fis1);
		String data=pobj.getProperty(key);
		return data;
		
	}

}
