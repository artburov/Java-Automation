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

import java.util.Collection;
import java.util.List;

import static helpers.ExcelReader.readProviderDataFromExcel;
import static helpers.FileReader.loadDataForCreateIssuesProvider;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GitTestBurov_CreateIssuesFromFileTxtOrXlsx extends BaseTest {

    private MainPage main;

    private final String title;
    private final String comment;
    private final List<String> labels;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        System.setProperty("textFile", "false");
        String isTextFile = System.getProperty("textFile");

        if (isTextFile.equals("true")) {
            return loadDataForCreateIssuesProvider();
        } else {
            return readProviderDataFromExcel();
        }
    }

    public GitTestBurov_CreateIssuesFromFileTxtOrXlsx(String title, String comment, List<String> labels) {
        this.title = title;
        this.comment = comment;
        this.labels = labels;
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
                .createIssue(this.title, this.comment, this.labels)
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