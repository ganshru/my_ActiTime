package com.my_ActiTime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.my_ActiTime.ObjectRepository.HomePage;
import com.my_ActiTime.ObjectRepository.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	FileLibrary f=new FileLibrary();
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("Database Connected Successfully", true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.readdatafromProperty("url");
		driver.get(url);
		Reporter.log("Browser Launched Successfully", true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String un = f.readdatafromProperty("username");
		lp.getUntbx().sendKeys(un);
		String pwd = f.readdatafromProperty("password");
		lp.getPwtbx().sendKeys(pwd);
		lp.getLgbtn().click();
		Reporter.log("Logged in Successfully", true);
	}
	
	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLogoutlnk().click();
		Reporter.log("Logged out Successfully", true);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Browser Closed Successfully", true);
	}
	
	@AfterSuite
	public void databaseDisconnection() {
		Reporter.log("Database Disconnected Successfully", true);
	}
	
}
