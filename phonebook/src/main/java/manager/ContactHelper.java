package manager;

import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openAddForm() {
        click(By.xpath("//a[@href='/add']"));
    }


    public void fillAddFrom(Contacts contact)
    {
        type(By.xpath("//*[@placeholder='Name']"), contact.getName());
        type(By.xpath("//*[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//*[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//*[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//*[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//*[@placeholder='description']"), contact.getDescription());

    }

    public void save() {
        click(By.xpath("//*[text()='Save']"));
    }

    public void clickSaveByXY()
    {
        WebElement button=wd.findElement(By.xpath("//*[text()='Save']"));
        Rectangle rect = button.getRect();
        int offSetX=rect.getWidth()/2;
        int offSetY=rect.getHeight()/2;
        Actions actions=new Actions(wd);
        actions.moveToElement(button).release().perform();
        actions.moveByOffset(-offSetX,-offSetY).click().release().perform();
    }
}
