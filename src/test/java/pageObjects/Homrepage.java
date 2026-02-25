package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homrepage extends Basepage {
	WebDriver driver;
	
	public Homrepage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement myacc;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement RegLink;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement loginbut;
	
	
	public void clickmyacc()
	{
		myacc.click();
	}
	
	public void clickReg()
	{
		RegLink.click();
	}
	
	public void clicklog()
	{
		loginbut.click();
	}
}

