package tests;

import models.Contacts;
import models.Users;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isSingOutPresent() != true) {
            Users users = new Users().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
            app.getHelperUser().openRegLogform();
            app.getHelperUser().fillLogRegForm(users);
            app.getHelperUser().submitLogin();
            Assert.assertTrue(app.getHelperUser().isSingOutPresent());
        }
    }

    @Test
    public void addNewContactSuccess() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contacts contact = Contacts.builder()
                .name("Ivan" + index)
                .lastName("Rivka" + index)
                .phone("231312133" + index)
                .email("sdsd" + index + "@gmail.com")
                .address("Tel aviv")
                .description("bulibulibum")
                .build();
        app.getContactHelper().openAddForm();
        app.getContactHelper().fillAddFrom(contact);
       // app.getContactHelper().save();
        app.getContactHelper().clickSaveByXY();

    }

}
