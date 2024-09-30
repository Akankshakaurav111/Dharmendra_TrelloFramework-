  package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage
{
WebDriver driver;
public TrelloLoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(id = "username")
private WebElement UserNameTextField;

public WebElement getUserNameTextField() {
	return UserNameTextField;
}

public WebElement getContinueButton() {
	return ContinueButton;
}

public WebElement getPasswordTextField() {
	return PasswordTextField;
}

public WebElement getLoginButton() {
	return LoginButton;
}
@FindBy(id = "login-submit")
private WebElement ContinueButton;

@FindBy(id = "password")
private WebElement PasswordTextField;

@FindBy(id = "login-submit")
private WebElement LoginButton;
}

