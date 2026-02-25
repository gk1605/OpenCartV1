package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homrepage;
import pageObjects.loginpage;
import testBase.Baseclass;

@Test(groups={"sanity","master"})
public class AccountLogin extends Baseclass{
	
public void logging()
{
	
	logger.info("***Starting login");
	try {
		
	
	Homrepage objhome1 =new Homrepage(driver);
	objhome1.clickmyacc();
	
	logger.info("***clicked on account");
	objhome1.clicklog();
	loginpage objlogin =new loginpage(driver);
	
	objlogin.setloginmail(pro.getProperty("email"));
	objlogin.setpassword(pro.getProperty("password"));
	Thread.sleep(3000);
	objlogin.setbutton();
	
	Thread.sleep(3000);
String message1 = objlogin.getconf();
if(message1.equals("My Account"))
{
	Assert.assertTrue(true);
	logger.info("login pass");
	Thread.sleep(3000);
	objlogin.setacc();
	Thread.sleep(3000);
	objlogin.setlogo();
	Thread.sleep(3000);
	objlogin.setlogoconf();
	objlogin.setback();
	
}
else
{
	
	logger.error("login  Failed");
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
}
