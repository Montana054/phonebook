package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login  extends TestBase
{
    @Test
    public void loginSuccessNew()
    {
        clickE(By.xpath("//*[@href='/login']"));
        type(By.xpath("//input[1]"),"noa@gmail.com");
        type(By.xpath("//input[2]"),"Nnoa12345$");
        clickE(By.xpath("//*[text()=' Login']"));
        // Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
    }
}
