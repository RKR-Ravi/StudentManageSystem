package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectRoutingPage {
	
	WebDriver driver;
	public SubjectRoutingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@data-id='1']")
	private WebElement AddBtn;
	
	@FindBy(xpath = "//select[@id='grade']")
	private WebElement gradedropdown;
	
	@FindBy(xpath = "//select[@id='subject']")
	private WebElement subjectDropdown;
	
	@FindBy(xpath = "//select[@id='teacher']")
	private WebElement teacherdropdown;
	
	@FindBy(xpath = "//input[@id='fee']")
	private WebElement feeEdt;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	public WebElement getAddBtn() {
		return AddBtn;
	}

	public WebElement getGradedropdown() {
		return gradedropdown;
	}

	public WebElement getSubjectDropdown() {
		return subjectDropdown;
	}

	public WebElement getTeacherdropdown() {
		return teacherdropdown;
	}

	public WebElement getFeeEdt() {
		return feeEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
}
