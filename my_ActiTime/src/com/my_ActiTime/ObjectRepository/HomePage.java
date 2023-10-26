package com.my_ActiTime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Declaration
	@FindBy (xpath="//div[.='Tasks']")
	private WebElement tasklnk;
	
	@FindBy (xpath="//div[.='Reports']")
	private WebElement reportlnk;
	
	@FindBy (xpath="//div[.='Users']")
	private WebElement userlnk;
	
	@FindBy (id="logoutLink")
	private WebElement logoutlnk;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getTasklnk() {
		return tasklnk;
	}

	public WebElement getReportlnk() {
		return reportlnk;
	}

	public WebElement getUserlnk() {
		return userlnk;
	}

	public WebElement getLogoutlnk() {
		return logoutlnk;
	}

}
