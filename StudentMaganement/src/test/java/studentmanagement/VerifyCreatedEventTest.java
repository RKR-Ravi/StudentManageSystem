package studentmanagement;

import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import ObjectRepository.EventsPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.TeacherPage;

public class VerifyCreatedEventTest extends BaseClass{
	
	@Test
	public void TeacherVerifyCreatedEventTest() throws Throwable {
		wu.waitForPageToLoad(driver);
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
		wu.waitForElementPresent(driver,hp.getProfilelink());
		hp.getProfileImage().click();
		hp.getSignout().click();
		LoginPage lp=new LoginPage(driver);
		String URL1=fu.getDataFromProperties("url");
		String USERNAME1=fu.getDataFromProperties("TeacherUsername ");
		String PASSWORD1=fu.getDataFromProperties("teacherpassword ");
		
		lp.LoginToapp2(URL1, USERNAME1, PASSWORD1);
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
	}

}
