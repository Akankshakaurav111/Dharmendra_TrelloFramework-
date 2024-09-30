package trello;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.trello.qsp.genericutility.BaseClass;
import com.trello.qsp.genericutility.ListenerClass;
import com.trello.qsp.pomrepo.TrelloCreateBoardsPage;
import com.trello.qsp.pomrepo.TrelloBoardCreatedPage;
import com.trello.qsp.pomrepo.TrelloHomePage;
import com.trello.qsp.pomrepo.TrelloLoginPage;
import com.trello.qsp.pomrepo.TrelloLogoutPage;
@Listeners(ListenerClass.class)
public class TrelloScenario extends BaseClass
{
	@Test
public void createAndDelete() throws IOException
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	
	TrelloHomePage homePage = new TrelloHomePage(driver);
	homePage.getLoginLink().click();
	
	
	TrelloLoginPage loginPage = new TrelloLoginPage(driver);
	loginPage.getUserNameTextField().sendKeys(fileutiles.readTheDataFromPropertyFile("email"));
	loginPage.getContinueButton().submit();
	loginPage.getPasswordTextField().sendKeys(fileutiles.readTheDataFromPropertyFile("password"));
	loginPage.getLoginButton().submit();
	
	
	
	TrelloCreateBoardsPage boardsPage = new TrelloCreateBoardsPage(driver);
	boardsPage.getCreateNewBoardOpt().click();
	boardsPage.getBoardTitleTextField().sendKeys(fileutiles.readTheDataFromPropertyFile("boardtitle"));
	wait.until(ExpectedConditions.visibilityOf(boardsPage.getCreateButton()));
	wait.until(ExpectedConditions.elementToBeClickable(boardsPage.getCreateButton())).click();
//	boardsPage.getViewAllCloseBoard().click();
//    boardsPage.getDeleteAllBoards().clear();
//	boardsPage.getLastDeleteOpt().click();
	
	
	TrelloBoardCreatedPage createBoardPage = new TrelloBoardCreatedPage(driver);
	createBoardPage.getShowMenuOpt().click();
	createBoardPage.getCloseBoardLink().click();
	createBoardPage.getCloseOpt().click();
	createBoardPage.getPermanentDeleteOpt().click();
	createBoardPage.getDeleteOpt().click();
	
	
	
	TrelloLogoutPage logoutPage = new TrelloLogoutPage(driver);	
	boardsPage.getAccountIconOpt().click();
	boardsPage.getLogoutOpt().click();
	logoutPage.getLastLogOutOpt().submit();
	Assert.assertEquals(driver.getTitle(), "Manage Your Team’s Projects From Anywhere | Trello","not verified");
}
}
