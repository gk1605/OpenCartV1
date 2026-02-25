package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homrepage;
import pageObjects.Registrationpage;
import testBase.Baseclass;


public class AccountRegistrationTC extends Baseclass{
	

	 @Test(groups={"regression","master"})
	public void checkregistration() throws InterruptedException
	{
		logger.info("***Starting TC");
		try {
			
		
		Homrepage objhome =new Homrepage(driver);
		Actions action =new Actions(driver);
		objhome.clickmyacc();
		
		logger.info("***clicked on account");
		objhome.clickReg();
		Registrationpage objregist =new Registrationpage(driver);
		objregist.sefname(randomeString().toUpperCase());
		objregist.setlname(randomeString().toUpperCase());
		objregist.seteid(randomeString()+"@gmail.com");
		objregist.setpass(randomeString().toUpperCase()+"@1");
		action.sendKeys(Keys.PAGE_DOWN).perform();
		//objregist.setbody();
		//objregist.setbody();
		//sThread.sleep(3000);
		objregist.setagree();
		Thread.sleep(3000);
		objregist.setreg();
		Thread.sleep(3000);
		
	String message = objregist.getconfmsg();
	if(message.equals("Your Account Has Been Created!"))
	{
		Assert.assertTrue(true);
		logger.info("pass");
		
	}
	else
	{
		
		logger.error("Test Failed");
		logger.debug("debug logs");
		Assert.assertTrue(false);
	}
		
		//Assert.assertEquals(message,"Your Account  Been Created!");
		}
		catch(Exception e)
		{
			logger.error(e);
			logger.debug("debug logs");
			Assert.fail();
		}
		logger.info("completed");
		
	}
	 public String randomeString()
	 {
		String gen = RandomStringUtils.randomAlphabetic(5); //5 represent no.of char and it creates random string
		return gen;
	 }

	 /*public String randomeNumber()
	 {
		String gennum = RandomStringUtils.randomNumeric(10); //5 represent no.of char and it creates random number
		return gennum;
	 }*/
}
