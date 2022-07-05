package tests;

import models.Users;
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
    public void loginSuccessNew()// для моделс
    {
        Users users =new Users().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
        app.getHelperUser().openRegLogform();
        app.getHelperUser().fillLogRegForm(users);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isSingOutPresent());
    }

//    @Test
//    public void loginSuccessNew() {
//        app.getHelperUser().openRegLogform();
//        app.getHelperUser().fillLogRegForm("noa@gmail.com", "Nnoa12345$");
//        app.getHelperUser().submitLogin();
//        Assert.assertTrue(app.getHelperUser().isSingOutPresent());
//    }

    @Test
    public void loginNegariveTestWronPassword()
    {
        Users users= new Users().withEmail("noa@gmail.com").withPassword("Nnoa");
        app.getHelperUser().openRegLogform();
        app.getHelperUser().fillLogRegForm(users);
app.getHelperUser().submitLogin();
Assert.assertFalse(app.getHelperUser().isSingOutPresent());
Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
    }
}
