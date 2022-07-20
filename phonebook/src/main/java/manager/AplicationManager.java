package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class AplicationManager {

    //WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser helperUser;// 1 познакомит их
    ContactHelper contactHelper;

    Logger logger = LoggerFactory.getLogger(AplicationManager.class);

    public void inIt() {
        //wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        logger.info("tests start in ChromeDriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        logger.info(("The linc is -->" + wd.getCurrentUrl()));
        helperUser = new HelperUser(wd);//2 сказать чему он равен
        contactHelper = new ContactHelper(wd);

        wd.register(new MyListener());

    }

    public void stop() {
        wd.quit();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public HelperUser getHelperUser()// 3 гетер
    {
        return helperUser;
    }
}

