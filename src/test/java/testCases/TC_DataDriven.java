package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import freemarker.log.Logger;import pageObjects.Homrepage;
import pageObjects.loginpage;
import testBase.Baseclass;
import utilities.DataProviders;

import pageObjects.Homrepage;
import pageObjects.Registrationpage;

public class TC_DataDriven extends Baseclass {
	
	
	@Test(dataProvider="LoginData1",dataProviderClass=DataProviders.class,groups="datadriven")
	public void logindttc(String email,String pwd, String exp) throws InterruptedException
	{
       try {
    	   logger.info("Started");
		Homrepage objhome2 =new Homrepage(driver);
		objhome2.clickmyacc();
		
	
		objhome2.clicklog();
		loginpage objlogin2 =new loginpage(driver);
		
		objlogin2.setloginmail(email);
		objlogin2.setpassword(pwd);
		Thread.sleep(3000);
		objlogin2.setbutton();
		
		Thread.sleep(3000);
	String message1 = objlogin2.getconf();
	boolean confirm =message1.equals("My Account");
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(confirm==true)
		{
			objlogin2.setacc();
			objlogin2.setlogo();
			Thread.sleep(3000);
			objlogin2.setlogoconf();
			objlogin2.setback();
			logger.info("success");
			Assert.assertTrue(true);
			 
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	else
	{
		if(confirm==true)
		{
			objlogin2.setacc();
			objlogin2.setlogo();
			Thread.sleep(3000);
			objlogin2.setlogoconf();
			objlogin2.setback();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);

		}
		
		
	}
	
       }
       catch(Exception e)
       {
    	   logger.error(e);
   		Assert.fail();
       }

	}

}
