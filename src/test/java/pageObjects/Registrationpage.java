package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;

public class Registrationpage extends Basepage {
	
static WebDriver driver;
	
	public Registrationpage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement fname;
	@FindBy(xpath="//html") WebElement body1;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lname;
	@FindBy(xpath="//input[@id='input-email']") WebElement eid ;
	@FindBy(xpath="//input[@id='input-password']") WebElement pass;
	@FindBy(xpath="//input[@name='agree']") WebElement agreee ;
	@FindBy(xpath="//button[normalize-space()='Continue']") WebElement butt;
	@FindBy(xpath="/html/body/div/main/div[2]/div/div/h1") WebElement confmess;
	
	
	
	
	public void setbody()
	{
		body1.sendKeys(Keys.PAGE_DOWN);
		
	}
	
	public void sefname(String firstname)
	{
		fname.sendKeys(firstname);
	}
	public void setlname(String lastname)
	{
		lname.sendKeys(lastname);
	}
	public void seteid(String email)
	{
		eid.sendKeys(email);
	}
	
	public void setpass(String password)
	{
		pass.sendKeys(password);
	}
	public void setagree()
	{
		agreee.click();
	}
	public void setreg()
	{
		//WebDriverWait mywait= new WebDriverWait(driver,Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(butt)).click();
		butt.click();
	}
	
	public String getconfmsg()
	{
		try
		{
			return (confmess.getText());
			
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}


}
