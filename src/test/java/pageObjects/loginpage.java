package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends Basepage{
	
WebDriver driver;
	
	public loginpage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-email']") WebElement lmail;
	@FindBy(xpath="//input[@id='input-password']") WebElement lpass;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement lbut ;
	@FindBy(xpath="//h1[normalize-space()='My Account']") WebElement conf ;
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement acc ;
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Logout']") WebElement logo ;
	@FindBy(xpath="//h1[normalize-space()='Account Logout']") WebElement logoconf ;
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement back ;
	
	
	
	public void setloginmail(String loginmail)
	{
		lmail.sendKeys(loginmail);
	}
	
	public void setpassword(String loginpass)
	{
		lpass.sendKeys(loginpass);
	}
	public void setbutton()
	{
		lbut.click();
	}
	public String getconf()
	{
		try
		{
			return (conf.getText());
			
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	public void setacc()
	{
		acc.click();
	}
	public void setlogo()
	{
		logo.click();
	}
	public String setlogoconf()
	{
		try
		{
			return (logoconf.getText());
			
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	public void setback()
	{
		back.click();
	}
}
