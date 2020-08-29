package tests;

import org.junit.*;
import org.junit.runners.MethodSorters;
import pages.LoginPage;
import pages.MainPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GitTest extends BaseTest {

    private MainPage main;


    @Before
    public void initialization() {
        main = new LoginPage(driver).positiveAuthentication();
    }

    @Ignore
    @Test
    public void negativeAuthTest() {
        LoginPage login = new LoginPage(driver);
        login.negativeAuthentication("TestUser", "TestPass");
        login.incorrectCredentialsMessage();
    }

    @Test
    public void a_gitRepositoryTest() {
        main.validateUrl()
                .searchNeededRepo()
                .findSpecifiedRepo()
                .findPomFile();
    }

    @Test
    public void b_extendedGitTest() {
        main.validateUrl()
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
                .verifyIssueComment();
    }

    @After
    public void exit() {
        this.main.signOut();
    }
}