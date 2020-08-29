package tests;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.LoginPage;
import pages.MainPage;
import pages.RepositoryPage;
import pages.SearchResultPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GitTest extends BaseTest {

    private LoginPage login;
    private MainPage main;
    private SearchResultPage result;
    private RepositoryPage repository;


    @Before
    public void initialization() {
        login = new LoginPage(this.driver);
        main = new MainPage(this.driver);
        result = new SearchResultPage(this.driver);
        repository = new RepositoryPage(this.driver);
    }

    @Ignore
    @Test
    public void negativeAuthTest() {
        login.negativeAuthentication("TestUser", "TestPass");
        login.incorrectCredentialsMessage();
    }

    @Test
    public void a_gitRepositoryTest() {
        login.positiveAuthentication()
                .validateUrl()
                .searchNeededRepo()
                .findSpecifiedRepo()
                .findPomFile()
                .signOut();
    }

    @Test
    public void b_extendedGitTest() throws InterruptedException {
        login.positiveAuthentication()
                .validateUrl()
                .searchNeededRepo()
                .findSpecifiedRepo()
                .listOfTabs()
                .goToIssueTab()
                .clickOnNewIssueBtn()
                .inputTitle()
                .inputComment()
                .submitNewIssue()
                .returnToIssueTab()
                .verifyIssueTitle()
                .returnToIssueTab()
                .verifyIssueComment()
                .signOut();
    }
}