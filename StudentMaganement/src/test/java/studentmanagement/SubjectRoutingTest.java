package studentmanagement;

import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import ObjectRepository.AddTeacherPage;
import ObjectRepository.GradePage;
import ObjectRepository.HomePage;
import ObjectRepository.SubjectPage;
import ObjectRepository.SubjectRoutingPage;

public class SubjectRoutingTest extends BaseClass{
	
	@Test
	public void CreateSubjectRoutingTest() throws Throwable {
		wu.waitForPageToLoad(driver);
		HomePage hp=new HomePage(driver);
		hp.getGradelink().click();
		GradePage gp=new GradePage(driver);
		gp.getGradeNameEdt().sendKeys(eu.getDataFromExcel("Sheet1",5,1));
		gp.getAdmissionFeeEdt().sendKeys(eu.getDataFromExcel("Sheet1",5,2));
		gp.getHallchargeEdt().sendKeys(eu.getDataFromExcel("Sheet1",5,3));
		gp.getNextBtn().click();
		gp.getRangeEdt().click();
		gp.getRangeEdt().sendKeys(eu.getDataFromExcel("Sheet1",5,3));
		gp.getGradeEdt().click();
		gp.getGradeEdt().sendKeys(eu.getDataFromExcel("Sheet1",5,4));
		gp.getSubmitBtn().click();
		Thread.sleep(5000);
		SubjectPage sp=new SubjectPage(driver);
		wu.waitForElementPresent(driver,sp.getEnterSubEdt());
		sp.getEnterSubEdt();
		sp.getEnterSubEdt().sendKeys(eu.getDataFromExcel("Shet1",8,1));
		sp.getSubmitbtn().click();
		hp.getTeacherlink().click();
		hp.getAddteacherlink().click();
		AddTeacherPage atp=new AddTeacherPage(driver);
		atp.getIndexEdt().click();
		atp.getIndexEdt().sendKeys(eu.getDataFromExcel("Sheet1",10,0));
		atp.getFullnameEdt().click();
		atp.getFullnameEdt().sendKeys(eu.getDataFromExcel("Sheet1",10,1));
		atp.getInitialEdt().click();
		atp.getInitialEdt().sendKeys(eu.getDataFromExcel("Sheet1",10,2));
		atp.getAddressEdt().click();
		atp.getAddressEdt().sendKeys(eu.getDataFromExcel("Sheet1",10,3));
		atp.getGenderEdt().click();
		atp.getMaleEdt().click();
		atp.getPhoneEdt().click();
		atp.getPhoneEdt().sendKeys(eu.getDataFromExcel("Sheet1",10,5));
		atp.getEmailEdt().click();
		atp.getEmailEdt().sendKeys(eu.getDataFromExcel("Sheet1",10,4));
		atp.getChooseBtn().click();
		atp.getChooseBtn().sendKeys("‪C:\\Users\\hi\\Desktop\\download.jpeg");
		atp.getSubmitEdt().click();
		SubjectRoutingPage srp=new SubjectRoutingPage(driver);
		srp.getAddBtn().click();
		srp.getGradedropdown().click();
		wu.select(srp.getGradedropdown(),"Grade B");
		srp.getSubjectDropdown().click();
		wu.select(srp.getSubjectDropdown(),"Hindi");
		srp.getTeacherdropdown().click();
		wu.select(srp.getTeacherdropdown(),"ahanu");
		srp.getFeeEdt().sendKeys("100");
		srp.getSubmitBtn().click();
		hp.getProfilelink().click();
	}
}
