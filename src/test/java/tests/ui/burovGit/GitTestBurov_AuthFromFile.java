package tests.ui.burovGit;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import tests.ui.BaseTest;

import java.util.Collection;

import static helpers.FileReader.loadDataForAuthProvider;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GitTestBurov_AuthFromFile extends BaseTest {

    private LoginPage login;

    private final String userLogin;
    private final String userPassword;
    private final Boolean fromTxt;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return loadDataForAuthProvider();
    }


    public GitTestBurov_AuthFromFile(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.fromTxt = true;
    }

    @Before
    public void initialization() {
        login = new LoginPage(driver);
    }

    @Test
    public void negativeAuth() {
        login.authCredentialsFromFile(this.userLogin, this.userPassword, this.fromTxt)
                .incorrectCredentialsMessage();
    }

}


