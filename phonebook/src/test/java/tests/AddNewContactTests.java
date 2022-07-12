package tests;

import models.Contacts;
import models.Users;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isSingOutPresent()) {
            app.getHelperUser().login(new Users().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));

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
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());

        app.getContactHelper().openAddForm();
        app.getContactHelper().fillAddFrom(contact);
     // app.getContactHelper().save();
        app.getContactHelper().clickSaveByXY();
Assert.assertTrue(app.getContactHelper().isContactByName(contact.getName()));
Assert.assertTrue(app.getContactHelper().isContactByPhone(contact.getPhone()));
    }

}
