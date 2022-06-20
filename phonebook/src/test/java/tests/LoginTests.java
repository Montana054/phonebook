package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginSuccessNew() {
        app.getHelperUser().openRegLogform();
        app.getHelperUser().fillLogRegForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());
    }
}
