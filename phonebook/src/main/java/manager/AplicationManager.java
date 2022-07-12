package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AplicationManager {

    WebDriver wd;
    HelperUser helperUser;// 1 познакомит их
    ContactHelper contactHelper;



    public void inIt() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        helperUser = new HelperUser(wd);//2 сказать чему он равен
        contactHelper=new ContactHelper(wd);

    }

    public void stop() {
       // wd.quit();
    }
    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public HelperUser getHelperUser()// 3 гетер
    {
        return helperUser;
    }
}

