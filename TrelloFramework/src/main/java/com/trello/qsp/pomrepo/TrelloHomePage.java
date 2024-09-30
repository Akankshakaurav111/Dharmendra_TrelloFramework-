package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloHomePage 
{
WebDriver driver;
public TrelloHomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);//here we will take 4th initeElement
}

@FindBy(xpath = "//div[contains(@class,'Buttonsstyles__ButtonGroup')]/a[text()='Log in']")
private WebElement LoginLink;

public WebElement getLoginLink() 
{
	return LoginLink;
}
}
