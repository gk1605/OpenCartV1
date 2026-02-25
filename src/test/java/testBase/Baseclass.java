package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Baseclass {

public static WebDriver driver;
public Logger logger; //log4j
public Properties pro;
	
	@BeforeClass(groups={"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		//loading config.properties file
		FileReader file= new FileReader("./src/test//resources//config.properties");
			pro=new Properties();
			pro.load(file);
			
		logger=LogManager.getLogger(this.getClass());
		
		if(pro.getProperty("execution_env").equalsIgnoreCase("remote"))
				{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if (os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("no matching os");
				return;
			}
			switch (br.toLowerCase())
			{
			case "chrome":capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			default: System.out.println("No matching browser");return;
			
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
			
			
				}
		
		if(pro.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome" : driver= new ChromeDriver();break;
			case "edge" : driver= new EdgeDriver();break;
			case "firefox" : driver= new FirefoxDriver();break;
			default :System.out.println("Invalid Browser");return;
			
			}
		}
		
		
		//docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub
		//docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-chrome
		
		
		
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pro.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	
	public String captureScreen(String tname) throws IOException {
	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = takesScreenshot.getScreenshotAs (OutputType. FILE);
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp +".png";
	File targetFile=new File(targetFilePath);
	sourceFile.renameTo(targetFile);
	return targetFilePath;
	}
	
	@AfterClass(groups={"sanity","regression","master"})
	public void close()
	{
		driver.quit();
	}
}
