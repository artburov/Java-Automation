package tests.burovGit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.MainPage;
import tests.BaseTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GitTestBurov_1Label extends BaseTest {


    private MainPage main;

    private final String title;
    private final String comment;
    private final String label;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Test issue", "Testing of addition a comment", "bug"},
                {"Test issue", "Testing of addition a comment", "documentation"},
                {"Test issue", "Testing of addition a comment", "question"},
        });
    }

    public GitTestBurov_1Label(String title, String comment, String label) {
        this.title = title;
        this.comment = comment;
        this.label = label;
    }


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
                .createIssue(this.title, this.comment, this.label)
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
