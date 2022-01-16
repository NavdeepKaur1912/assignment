package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.utility.Helper;

public class EmployeePage {

WebDriver driver;
	
	public EmployeePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By firstName= By.xpath("//input[@name='firstName']");
	By lastName= By.xpath("//input[@name='lastName']");
	By username = By.xpath("//input[@name='user_name']");
	By password = By.xpath("//input[@name='user_password']");
	By repass  = By.xpath("//input[@name='re_password']");
	By chkLogin = By.xpath("//input[@name='chkLogin']");
	By btnSave = By.xpath("//input[@value='Save']");
	By Status = By.xpath("//select[@name='status']");
	By headerName = By.xpath("//div[@id='profile-pic']/h1");
	
	
	public void createEmp(String firstname,String lastname,String user,String pwd,String status) 
	{
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(chkLogin).click();
		driver.findElement(username).sendKeys((user+"_100"));
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(repass).sendKeys(pwd);
		Helper.clickDropDown(driver, Status, "Enabled");
		driver.findElement(btnSave).click();
	}
	public String getFullName()
	{
		 return driver.findElement(headerName).getText();
	}
}
