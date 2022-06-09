package SoFaDog.AndroidAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	
	//Flag use to run Sample Test
	public boolean sampleTest = false;
	public static boolean SoFaDogCS = true;
	public static boolean SoFaDogCloud = false;
	
	//Initiate Android Driver, Appium Driver Service & Desired Capabilities
	public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;
	public static DesiredCapabilities cap;
	
	//Starts the Appium Server by checking that Server is already running or not by calling other Method
	public AppiumDriverLocalService startServer() {
		boolean flag = checkIfServerIsRunnning(4723);
		if(!flag)
		{	
			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					  .usingDriverExecutable(new File("/usr/local/bin/node"))
					  .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
					  .withIPAddress("127.0.0.1").usingPort(4723));
			service.start();
		}
		return service;
	}
	
	//Checks the Server running status and return boolean value to startServer Method
	public static boolean checkIfServerIsRunnning(int port) {	
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);		
			serverSocket.close();
		} 
		catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} 
		finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	//Path for Emulator with Terminal command
	public static void startEmulator() throws IOException, InterruptedException {		
		if(SoFaDogCS == false) 
		{	
			Runtime.getRuntime().exec("/Users/kamaljhinjer/Library/Android/sdk/emulator/emulator -avd Emulator_Pixel2XL -netdelay none -netspeed full");
		}
		else if(SoFaDogCS == true) 
		{
			//For Server, Active the respective path of Emulator
			Runtime.getRuntime().exec("/Users/mobile/Library/Android/sdk/emulator/emulator -avd Emulator_Pixel2XL -netdelay none -netspeed full");
		}	
			Thread.sleep(10000);
	}
	
	//Set Capabilities for Android driver and get the appName from global.properties file, pass appName here from Test Class & name of String Argument can be different in this Method and in Test Class
	public static void capabilities(String appName) throws IOException, InterruptedException{		
		//Path for global properties file
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/SoFaDog/AndroidAutomation/global.properties");
		Properties prop = new Properties();		//Create object of Properties class  
		prop.load(fis);							//Load global.properties file
		
		//Path to Android application File folder
		File appDir = new File("src");
		File app = new File(appDir, (String)prop.get(appName)); //Assign application file Directory & get appName from Properties class object 
		
		//Device name given in global.properties file
		String device = (String)prop.get("deviceName");
		if(device.contains("Emulator"))		//Start Emulator
		{
			startEmulator();
		}
		else 
		{
			System.out.print("Emulator not started through code");
		}
		
		//Path of Chrome Driver for WEBVIEW
		String chromeDriver = (System.getProperty("user.dir")+"/src/chromedriver/chromedriver");
		
		//Set Desired Capabilities
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);				//Get Device Name
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());			//Get Application Path
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");	//Set Android Automator to perform action in application
		cap.setCapability("chromedriverExecutable", chromeDriver);					//Get the Path of Chrome Driver
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180); 			//Set time in seconds to wait for next action, means timeout
	}
	
	@BeforeTest
	public void startService() throws IOException, InterruptedException {	
		System.out.println("Entered Before Test, Starting Server & Launching App");
		
		//Starts the Server before to <test> tag execution in xml file i.e. before to all classes given in xml file
		service=startServer();
		
		//This flag is to run the Sample Test and make it uncomment to run sampleApp
		//sampleTest = true;
		
		//Launch the desired Application by fetching the appName from Global Properties according which is according to string argument passed
		if(sampleTest == true) 
		{
			capabilities("sampleApp");	
		} 
		else 
		{
			capabilities("SoFaDogApp");
		}
	}
	
	@AfterTest
	public void stopService() {		
		System.out.println("Entered After Test & Stoping Server");
		
		//Stop the service after executing Tests in all Test Classes
		service.stop();
	}
	
	@BeforeClass
	public AndroidDriver<AndroidElement> startDriver() throws MalformedURLException {
		System.out.println("Execute Before Class & passing capabilities to driver every time the Test's Start in New Class");
		
		//Tell AndroidDriver where the Appium Server is listening to it
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		if(driver == null) 
		{
			System.out.println("Driver is Null");
		}
		return driver;	
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException {	
		Thread.sleep(10000);
		System.out.println("Execute After Class");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {	
		System.out.println("Executing Before Method, Starting Test");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Executing After Method and Confirming the Test was executed");
	}
	
	//Method for creating screenshot by getting the argument from Listener class which get the detail from ITestResult class
	public static void getScreenshot(String s) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Cast the type of action driver has to do and output is to give in the form of File
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"/Reports/"+s+".png"));
	}
	
}
