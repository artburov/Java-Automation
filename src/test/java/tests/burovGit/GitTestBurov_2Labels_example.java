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
public class GitTestBurov_2Labels_example extends BaseTest {


    private MainPage main;

    private final String title;
    private final String comment;
    private final String labelOne;
    private final String labelTwo;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Test issue", "Testing of addition a comment", "bug", "documentation"},
                {"Test issue", "Testing of addition a comment", "bug", "question"},
                {"Test issue", "Testing of addition a comment", "documentation", "question"},
        });
    }

    public GitTestBurov_2Labels_example(String title, String comment, String label1, String label2) {
        this.title = title;
        this.comment = comment;
        labelOne = label1;
        labelTwo = label2;
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
//                .createIssue(this.title, this.comment, this.labelOne, this.labelTwo)
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
