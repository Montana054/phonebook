package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {// так же берем конструктор от родителя
        super(wd);
    }

    public void openRegLogform()
    {
        click(By.xpath("//*[@href='/login']"));
    }

    public void fillLogRegForm(String email, String password)
    {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void submitLogin()
    {
        click(By.xpath("//*[text()=' Login']"));
    }

    public boolean isLoginRegSuccess()
    {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void submitReg()
    {
        click(By.xpath("//button[2]"));
    }
}
