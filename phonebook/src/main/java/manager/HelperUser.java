package manager;

import models.Users;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {// так же берем конструктор от родителя
        super(wd);
    }

    public void openRegLogform() {
        click(By.xpath("//*[@href='/login']"));
    }

    public void fillLogRegForm(Users users) {
        type(By.xpath("//input[1]"), users.getEmail());
        type(By.xpath("//input[2]"), users.getPassword());
    }
    public void fillLogRegForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void submitLogin() {
        click(By.xpath("//*[text()=' Login']"));
    }

    public boolean isSingOutPresent() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void submitReg() {
        click(By.xpath("//button[2]"));
    }


    public void singOut() {
        click(By.xpath("//*[text()='Sign Out']"));
    }


    public boolean isAlertDisplayed()
    {

        Alert alert=new WebDriverWait(wd,
                10).until(ExpectedConditions.alertIsPresent());
        if(alert==null)
        {
            return false;
        }else{
            return true;
        }
    }

    public boolean isErrorWrongFormat() {
    Alert alert= new WebDriverWait(wd,10).until(ExpectedConditions.alertIsPresent());
    wd.switchTo().alert();
    String error= alert.getText();
        //System.out.println(error);
         // ok
           alert.accept();
//            //conect
//        alert.dismiss();
//        //send message
//        alert.sendKeys("hello");
        return error.contains("Wrong email or password format");
    }


    public void login(Users userLogin)
    {
        openRegLogform();
        fillLogRegForm(userLogin);
        submitLogin();
        Assert.assertTrue(isSingOutPresent());



    }
}
