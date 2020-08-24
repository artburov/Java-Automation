package tests;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GitTest extends BaseTest {

    private LoginPage login;
    private MainPage main;
    private SearchResultPage result;
    private RepositoryPage repository;
    private LogoutPage logout;


    @Before
    public void init() {
        login = new LoginPage(this.driver);
        main = new MainPage(this.driver);
        result = new SearchResultPage(this.driver);
        repository = new RepositoryPage(this.driver);
        logout = new LogoutPage(this.driver);
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
                .findPomFile();

        log.info("Version of selenium-java is " + repository.repoSeleniumVersion());

        logout.signOut();
        log.info("Logout from Git was done on " +
                (new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")).format(new Date()));
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
                .verifyIssueTitile()
                .returnToIssueTab()
                .verifyIssueComment();

        logout.signOut();
        log.info("Logout from Git after an issue creation was done on " +
                (new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")).format(new Date()));
    }
}
