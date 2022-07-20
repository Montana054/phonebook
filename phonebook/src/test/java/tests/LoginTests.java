package tests;

import manager.MyDataProvider;
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
    @Test(dataProvider = "validLoginData",dataProviderClass = MyDataProvider.class)
    public void loginSuccessNew(String email, String password)// для моделс
    {
        logger.info("Test start with email : "+email+" and password : " +password);
        Users users =new Users().withEmail(email).withPassword(password);
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
