package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectPage {
	
	WebDriver driver;
	public SubjectPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="name")
    private WebElement enterSubEdt;
    @FindBy(xpath="//button[text()='Submit']")
    		
    private WebElement Submitbtn;
	public WebElement getEnterSubEdt() {
		return enterSubEdt;
	}
	public WebElement getSubmitbtn() {
		return Submitbtn;
	}


}
