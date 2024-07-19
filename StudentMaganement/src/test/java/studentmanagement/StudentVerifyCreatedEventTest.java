package studentmanagement;

import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import ObjectRepository.EventsPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.TeacherPage;

public class StudentVerifyCreatedEventTest extends BaseClass{
	
	@Test
	public void StudentVerificationEventTest() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.getEventlink().click();
		hp.getMyeventslink().click();
		EventsPage ep=new EventsPage(driver);
		ep.getCreateeventBtn().click();
		String title=eu.getDataFromExcel("Sheet1",13,0);
		ep.getTitleEdt().sendKeys(eu.getDataFromExcel("Sheet1",13,0));
		ep.getCategoryEdt().click();
		wu.select(ep.getCategoryEdt(),"All Teachers & Student");
		ep.getTime().click();
		ep.getFromdate().click();
		ep.getTodate().click();
		ep.getApplyBtn().click();
		ep.getNoteEdt().sendKeys(eu.getDataFromExcel("Sheet1",13,1));
		ep.getColorEdt().sendKeys(eu.getDataFromExcel("Sheet1",13,2));
		ep.getSubmitBtn().click();
		hp.getProfileImage().click();
		hp.getLogoutlink().click();
		LoginPage lp=new LoginPage(driver);
		String URL2=fu.getDataFromProperties("url");
		String USERNAME2=fu.getDataFromProperties("studentusername ");
		String PASSWORD2=fu.getDataFromProperties("studentpassword ");
		lp.LoginToapp(URL2, USERNAME2, PASSWORD2);
		TeacherPage tp=new TeacherPage(driver);
		tp.getNotificationIcon().click();
		tp.getEventlist().click();
		String actTitle=tp.getTitlename().getText();
		if(actTitle.equals(title)) {
			System.out.println("Event is shown in teacher profile");
		}
		else {
			System.out.println("Event is not shown in teacher profile");
		}
		tp.getCloseBtn().click();
		hp.getProfilelink().click();
	}
	
}

