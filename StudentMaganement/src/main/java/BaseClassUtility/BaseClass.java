package BaseClassUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import DataBaseUtility.DataBaseUtility;
import GenericUtitlity.ExcelGenericUtility;
import GenericUtitlity.PropertiesFileUtility;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import WebDriverUtility.webDriverUtility;

public class BaseClass {
	 public ExcelGenericUtility eu= new ExcelGenericUtility();
	 public webDriverUtility wu=new webDriverUtility();
	 public DataBaseUtility du=new DataBaseUtility();
	 public PropertiesFileUtility fu=new PropertiesFileUtility();
	 public WebDriver driver=null;
	 public static WebDriver sdriver=null;
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("====connect to DB,ReportConfig===");
		du.getConnection();	
	}
//	@Parameters("BROWSER")
//	@BeforeClass
//	public void configBC(String browser) throws Throwable {
	@BeforeClass
	public void configBC() throws Throwable{
		System.out.println("===Launch Browser===");
		//String BROWSER= browser;
		String BROWSER=fu.getDataFromProperties("browser");
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		    sdriver=driver;
	}
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("===Login===");
		String URL=fu.getDataFromProperties("url");
		String USERNAME=fu.getDataFromProperties("adminUsername");
		String PASSWORD=fu.getDataFromProperties("adminpassword");
		String URL1=fu.getDataFromProperties("url");
		String USERNAME1=fu.getDataFromProperties("TeacherUsername ");
		String PASSWORD1=fu.getDataFromProperties("teacherpassword ");
		String URL2=fu.getDataFromProperties("url");
		String USERNAME2=fu.getDataFromProperties("studentusername ");
		String PASSWORD2=fu.getDataFromProperties("studentpassword ");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToapp(URL, USERNAME, PASSWORD);
	}
	@AfterMethod
	public void configAM() {
		System.out.println("===Logout===");
		HomePage hp=new HomePage(driver);
		hp.getProfileImage().click();
		hp.getSignout().click();
	}
	@AfterClass
	public void configAC() throws SQLException {
		System.out.println("===Close the Browser===");
		driver.quit();
	}
	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("===close DB,Reprot BackUp====");
		du.closeDbconnection();	
	}
}
