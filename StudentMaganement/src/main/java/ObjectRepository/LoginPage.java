package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtitlity.Paths;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@type='text']")
	private WebElement usernameEdt;
	
	@FindBy(id = "password")
	private WebElement passwordEdt;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void LoginToapp(String url,String username,String password) {
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();	
	}
	public void LoginToapp1(String URL2,String USERNAME2,String PASSWORD2) {
		driver.get(URL2);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(USERNAME2);
		passwordEdt.sendKeys(PASSWORD2);
		loginBtn.click();	
	}
	public void LoginToapp2(String URL1,String USERNAME1,String PASSWORD1) {
		driver.get(URL1);
		driver.manage().window().maximize();
		usernameEdt.click();
		usernameEdt.sendKeys(USERNAME1);
		passwordEdt.click();
		passwordEdt.sendKeys(PASSWORD1);
		loginBtn.click();	
	}

}
