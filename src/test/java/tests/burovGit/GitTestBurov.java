package tests.burovGit;

import org.junit.*;
import org.junit.runners.MethodSorters;
import pages.LoginPage;
import pages.MainPage;
import tests.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GitTestBurov extends BaseTest {

    private MainPage main;


    @Before
    public void initialization() {
        main = new LoginPage(driver).positiveAuthentication();
    }

    @Test
    public void a_burovLabelTest() {
        main.validateUrl()
                .searchBurovRepo()
                .openProjectsIssues()
                .clickOnNewIssueBtn()
                .createIssue("Test issue", "Testing of addition a comment", "bug")
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
