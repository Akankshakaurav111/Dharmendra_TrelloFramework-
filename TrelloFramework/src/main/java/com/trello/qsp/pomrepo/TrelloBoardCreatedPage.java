package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardCreatedPage 
{
WebDriver driver;
public TrelloBoardCreatedPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//button[@aria-label='Show menu']")
private WebElement ShowMenuOpt;

public WebElement getShowMenuOpt() {
	return ShowMenuOpt;
}

public WebElement getCloseBoardLink() {
	return CloseBoardLink;
}

public WebElement getCloseOpt() {
	return CloseOpt;
}

public WebElement getPermanentDeleteOpt() {
	return PermanentDeleteOpt;
}

public WebElement getDeleteOpt() {
	return DeleteOpt;
}
@FindBy(xpath = "//a[contains(@class,'close-board')]")
private WebElement CloseBoardLink;

@FindBy(xpath = "//input[@data-testid='close-board-confirm-button']")
private WebElement CloseOpt;

@FindBy(xpath = "//button[@data-testid='close-board-delete-board-button']")
private WebElement PermanentDeleteOpt;

@FindBy(xpath = "//button[text()='Delete']")
private WebElement DeleteOpt;
}
