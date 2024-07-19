package studentmanagement;

import java.io.File;

import org.testng.annotations.Test;
import BaseClassUtility.BaseClass;
import ObjectRepository.AddStudentPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.StudentPage;
public class CreateStudentTest extends BaseClass{
	
	@Test
	public void CreateStudTest() throws Throwable {
		wu.waitForPageToLoad(driver);
		HomePage hp=new HomePage(driver);
		hp.getStudentlink().click();
		hp.getAddstudentlink().click();
		AddStudentPage asp=new AddStudentPage(driver);
		asp.getIndexEdt().sendKeys(eu.getDataFromExcel("Sheet1",1,0));
		asp.getFullnameEdt().sendKeys(eu.getDataFromExcel("Sheet1", 1, 1));
		String name=eu.getDataFromExcel("Sheet1", 1, 2);
		asp.getIntialEdt().sendKeys(eu.getDataFromExcel("Sheet1", 1, 2));
		asp.getAddressEdt().sendKeys(eu.getDataFromExcel("Sheet1", 1, 3));
		asp.getEmailEdt().sendKeys(eu.getDataFromExcel("Sheet1", 1, 4));
		asp.getPhoneEdt().sendKeys(eu.getDataFromExcel("Sheet1", 1, 5));
		asp.getBdateEdt().sendKeys(eu.getDataFromExcel("Sheet1", 1, 6));
		wu.waitForElementPresent(driver,asp.getGenderEdt());
		asp.getGenderEdt();
		asp.getMaleEdt().click();
		String filepath="‪./Testdata/OIP.jpeg";
		File file=new File(filepath);
		String path=file.getAbsolutePath();
		wu.waitForElementPresent(driver,asp.getFileEdt());
		asp.getFileEdt();
		asp.getFileEdt().sendKeys("C:\\Users\\hi\\eclipse-workspace\\StudentMaganement\\Testdata\\OIP.jpeg");
		asp.getGfullnameEdt().sendKeys(eu.getDataFromExcel("Sheet1",2,1));
		asp.getGinitialEdt().sendKeys(eu.getDataFromExcel("Sheet1", 2,2));
		asp.getGaddressEdt().sendKeys(eu.getDataFromExcel("Sheet1",2,3));
		asp.getGemailEdt().sendKeys(eu.getDataFromExcel("Sheet1",2,4));
		asp.getGphoneEdt().sendKeys(eu.getDataFromExcel("Sheet1",2,5));
		asp.getGbdateEdt().sendKeys(eu.getDataFromExcel("Sheet1",2,6));
		asp.getGgender().click();
		wu.select(asp.getGgender(),"Male");
		asp.getGchooseBtn().sendKeys("C:\\Users\\hi\\eclipse-workspace\\StudentMaganement\\Testdata\\OIP.jpeg");
		asp.getNextBtn().click();
		//wu.waitForElementPresent(driver,asp.getGradedropdown());
		asp.getGradedropdown();
		wu.select(asp.getGradedropdown(),"Grade D");
		wu.waitForElementPresent(driver,asp.getChechbox());
		asp.getChechbox().click();
		asp.getSubmitbtn().click();
		wu.waitForElementPresent(driver,asp.getCloseBtn());
		asp.getCloseBtn().click();
		hp.getProfileImage().click();
		hp.getLogoutlink().click();
		LoginPage lp=new LoginPage(driver);
		String URL2=fu.getDataFromProperties("url");
		String USERNAME2=fu.getDataFromProperties("studentusername");
		String PASSWORD2=fu.getDataFromProperties("studentpassword");
		wu.waitForElementPresent(driver,lp.getUsernameEdt());
		lp.getUsernameEdt().sendKeys(USERNAME2);
		lp.getPasswordEdt().sendKeys(PASSWORD2);
		lp.getLoginBtn().click();
		//lp.LoginToapp1(URL2, USERNAME2, PASSWORD2);
		StudentPage sp=new StudentPage(driver);
		sp.getMyprofileEdt().click();
		String actname=sp.getHeaderEdt().getText();
		if(actname.equals(name)) {
			System.out.println("Student is created");
		}
		else {
			System.out.println("Student is not created");
		}
		hp.getProfilelink().click();	
	}
}
