package tests.burovGit;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import tests.BaseTest;

import java.util.*;

import static helpers.FileReader.loadDataForProvider;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GitTestBurov_AuthFromFile extends BaseTest {

    private LoginPage login;

    private final String userLogin;
    private final String userPassword;
    private final Boolean fromTxt;
    private final boolean fromXls;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        Map<String, String> testData = loadDataForProvider();
        Object[][] result = new Object[testData.keySet().size()][2];
        List<String> logins = new ArrayList<>(testData.keySet());
        for (int i = 0; i < testData.keySet().size(); i++) {
            result[i][0] = logins.get(i);
            result[i][1] = testData.get(logins.get(i));
        }
//        testData.forEach((key, value) -> {
//
//        });

        return Arrays.asList(result);
    }


    public GitTestBurov_AuthFromFile(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.fromTxt = true;
        this.fromXls = false;
    }

    @Before
    public void initialization() {
        login = new LoginPage(driver);
    }

    @Test
    public void negativeAuth() {
        login.authCredentialsFromFile(this.userLogin, this.userPassword, this.fromTxt )
                .incorrectCredentialsMessage();
    }

}


