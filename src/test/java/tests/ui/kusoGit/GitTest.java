package tests.ui.kusoGit;

import org.junit.*;
import org.junit.runners.MethodSorters;
import pages.LoginPage;
import pages.MainPage;
import tests.ui.BaseTest;

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
                .findKusoRepo()
                .findPomFile();
    }

    @Test
    public void b_extendedGitTest() {
        main.validateUrl()
                .searchNeededRepo()
                .findKusoRepo()
                .listOfTabs()
                .openProjectsIssues()
                .clickOnNewIssueBtn()
                .inputTitle()
                .inputComment()
                .submitNewIssue()
                .openProjectsIssues()
                .verifyIssueTitle()
                .openProjectsIssues()
                .verifyIssueComment();
    }

    @After
    public void exit() {
        this.main.signOut();
    }
}