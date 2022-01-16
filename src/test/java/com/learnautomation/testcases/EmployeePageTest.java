package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.CustomDataProvider;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.EmployeePage;

public class EmployeePageTest extends BaseClass
{
	
	LoginPage login;
	HomePage home;
	EmployeePage empPage;
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setupDriver()
	{
		driver=getDriver();
	}
	@Test(dataProvider = "Login",dataProviderClass = CustomDataProvider.class,priority = 0)
	public void login(String uname,String pass) 
	{
		login=PageFactory.initElements(driver, LoginPage.class);
		
		System.out.println("Current URL before "+driver.getCurrentUrl());
		
		home= login.loginAsAdmin(uname, pass);
		
		System.out.println("Current URL after "+driver.getCurrentUrl());
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"URL pattern did not match");
	}
	
	
	@Test(dataProvider = "employee",dataProviderClass = CustomDataProvider.class,dependsOnMethods = "login")
	public void createEmployee(String FirstName,String LastName,String UserName, String Password, String Status)
	{
		empPage= home.clickOnAddEmp();
		empPage.createEmp(FirstName,LastName,UserName,Password,Status);
		String fullName=FirstName+" "+ LastName;
		Assert.assertEquals(empPage.getFullName(), fullName);
	}
	
	
}
