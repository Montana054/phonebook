package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preConditions() {
        if (app.getHelperUser().isSingOutPresent()) {
            app.getHelperUser().singOut();
        }
    }

    @Test
    public void loginSuccessNew() {
        app.getHelperUser().openRegLogform();
        app.getHelperUser().fillLogRegForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isSingOutPresent());
    }
}
