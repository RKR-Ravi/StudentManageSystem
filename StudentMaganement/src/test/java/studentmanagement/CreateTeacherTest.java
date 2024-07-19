package studentmanagement;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import GenericUtitlity.Paths;
import ObjectRepository.AddTeacherPage;
import ObjectRepository.HomePage;
import ObjectRepository.TeacherPage;

public class CreateTeacherTest extends BaseClass implements Paths{
	
	@Test
	public void CreateTeacherProTest() throws Throwable {
		wu.waitForPageToLoad(driver);
				HomePage hp=new HomePage(driver);
				hp.getTeacherlink().click();
				hp.getAddteacherlink().click();
				String index=eu.getDataFromExcel("sheet1", 10, 0);
				String fname=eu.getDataFromExcel("sheet1", 10, 1);
				String initialname=eu.getDataFromExcel("sheet1",10, 2);
				String address=eu.getDataFromExcel("sheet1", 10, 3);
				String phone=eu.getDataFromExcel("sheet1", 10, 5);
				String email=eu.getDataFromExcel("sheet1", 10, 4);
				AddTeacherPage atp=new AddTeacherPage(driver);
				atp.getIndexEdt().sendKeys(index);
				atp.getFullnameEdt().sendKeys(fname);
				atp.getInitialEdt().sendKeys(initialname);
				atp.getAddressEdt().sendKeys(address);
				atp.getPhoneEdt().sendKeys(phone);
				atp.getEmailEdt().sendKeys(email);
				WebElement gender=atp.getGenderEdt();
				wu.select(gender, "Male");
				wu.waitForElementPresent(driver,atp.getFileEdt());
				atp.getFileEdt().click();
				atp.getFileEdt().sendKeys("‪C:\\Users\\hi\\Desktop\\download (1).jpeg");

				atp.getSubmitEdt().click();
				TeacherPage tp=new TeacherPage(driver);
				hp.getTeacherlink().click();
				hp.getAllteacherlink().click();
				tp.getSearchfiled().click();
				tp.getSearchfiled().sendKeys(eu.getDataFromExcel("sheet1",10,2));
			String actName=tp.getNamefield().getText();
			if(actName.equals(fname)) {
				System.out.println("Teacher account is created");
			}
			else {
				System.out.println("Teacher account is not created");
			}	
			}
		}
