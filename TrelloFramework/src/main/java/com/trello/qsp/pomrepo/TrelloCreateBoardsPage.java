package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloCreateBoardsPage 
{
WebDriver driver;
public TrelloCreateBoardsPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//span[text()='Create new board']")
private WebElement CreateNewBoardOpt;

public WebElement getCreateNewBoardOpt() {
	return CreateNewBoardOpt;
}

public WebElement getBoardTitleTextField() {
	return BoardTitleTextField;
}

public WebElement getCreateButton() {
	return CreateButton;
}

public WebElement getAccountIconOpt() {
	return AccountIconOpt;
}

public WebElement getLogoutOpt() {
	return LogoutOpt;
}
@FindBy(xpath = "//input[@data-testid='create-board-title-input']")
private WebElement BoardTitleTextField;

@FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
private WebElement CreateButton;

@FindBy(xpath = "//div[@data-testid='header-member-menu-avatar']")
private WebElement AccountIconOpt;

@FindBy(xpath = "//button[@data-testid='account-menu-logout']")
private WebElement LogoutOpt;

//@FindBy(xpath = "//button[text()='View all closed boards']")
//private WebElement ViewAllCloseBoard;
//
//public WebElement getViewAllCloseBoard() {
//	return ViewAllCloseBoard;
//}
//
//public WebElement getDeleteAllBoards() {
//	return DeleteAllBoards;
//}

//@FindBy(xpath = "//div[@tabindex='-1']/button[text()='Delete']")
//private WebElement LastDeleteOpt;
//
//public WebElement getLastDeleteOpt() {
//	return LastDeleteOpt;
//@FindBy(xpath = "((//button[@data-testid='close-board-delete-board-button'])[1]")
//private WebElement DeleteAllBoards;


}

