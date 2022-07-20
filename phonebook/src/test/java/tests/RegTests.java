package tests;

import models.Users;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegTests extends TestBase {

    @BeforeMethod
    public void preConditions() {
        if (app.getHelperUser().isSingOutPresent()) {
            app.getHelperUser().singOut();
        }
    }

    @Test
    public void registrationSuccess() // для моделс

    {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        Users users=new Users().withEmail("sdsd3" + index + "@ww.com").withPassword("Za1234$4");
        logger.info("sdsd3" + index + "@ww.com");
        logger.info("INDEX-->"+index);

        app.getHelperUser().openRegLogform();
        app.getHelperUser().fillLogRegForm(users);
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isSingOutPresent());

    }

//    @Test
//    public void registrationSuccess() {
//        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
//
//        app.getHelperUser().openRegLogform();
//        app.getHelperUser().fillLogRegForm("sdsd3" + index + "@ww.com", "Za1234$4");
//        app.getHelperUser().submitReg();
//        Assert.assertTrue(app.getHelperUser().isSingOutPresent());
//
//    }
}
