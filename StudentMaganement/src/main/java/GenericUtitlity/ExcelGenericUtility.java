package GenericUtitlity;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelGenericUtility implements Paths{
	
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(Excelpath);
		//FileInputStream fis=new FileInputStream("./Testdata/StudentManageSystem.xlsx");
		Workbook b=WorkbookFactory.create(fis);
		String data=b.getSheet(sheetName).getRow(rowNum).getCell(celNum).toString();
		b.close();
		return data;
	}

}
