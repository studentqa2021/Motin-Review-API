package com.generic;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.SeleniumWait;
import io.github.bonigarcia.wdm.WebDriverManager;
public class OrangeHRMLogin {
	public void getLogin() {
		//open any browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		driver.manage().window().maximize();
		
		//Implicit Wait
		SeleniumWait.getImplicitWait(driver, 5);
	
		//go to application URL
		driver.navigate().to(Constants.URL);
		//put user
		//using highlighter to highlight element field
		HighLighter.getColor(driver,pf.getUser(),"red");
		
		//Explicit Wait (By variable.not hard coded data)
		SeleniumWait.getExplicitWait(driver,driver.findElement(By.xpath("//*[@name='user']")), 5);
		
		
		pf.getUser().click();
		pf.getUser().sendKeys(Constants.user);
		//put password
		
		
		HighLighter.getColor(driver,pf.getPassword(),"green");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.password);
		//login button click
		
		HighLighter.getColor(driver,pf.getLoginBtn(),"black");
		pf.getLoginBtn().click();
		//validate login ==> with java(if else condition)>>Best = Testng(Assert)
		boolean loginStatus = pf.getDashboard().isDisplayed();
				//Another way: testng or Junit==>
		//Hard assert = Assert(if test failed = stop there)
		Assert.assertTrue(loginStatus);//true = pass
		//SoftAssert = Softassert(if test failed then not stop there)
		//it is the important one
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(loginStatus);
		sf.assertAll();
		
		//close
		
	}
	}
	
		

