package com.my_ActiTime.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.my_ActiTime.GenericLibrary.BaseClass;
import com.my_ActiTime.GenericLibrary.FileLibrary;
import com.my_ActiTime.GenericLibrary.ListenerImplimentation;
import com.my_ActiTime.ObjectRepository.HomePage;
import com.my_ActiTime.ObjectRepository.TaskPage;

@Listeners(ListenerImplimentation.class)

public class createCustomer extends BaseClass {
	
	@Test
	public void  createCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasklnk().click();
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcustomer().click();
		FileLibrary f=new FileLibrary();
		String custname = f.readdatafromExcel("Sheet1", 5, 1);
		tp.getCustomername().sendKeys(custname);
		String custdesc = f.readdatafromExcel("Sheet1", 5, 2);
		tp.getCustomerdesc().sendKeys(custdesc);
		tp.getCreatecustomerbtn().click();
		
		String expecteddata = custname;
		String actualdata = driver.findElement(By.xpath("(//div[.='"+custname+"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(expecteddata, actualdata);
		s.assertAll();

		Reporter.log("Create Customer Successfully", true);
	}
}
