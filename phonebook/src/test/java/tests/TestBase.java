package tests;

import manager.AplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {


    protected static AplicationManager app = new AplicationManager();//инецилезация -ссылка на аликатион менеджер
Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m)
    {
        logger.info("start test --->"+m.getName());
    }
    @BeforeSuite
    public void setUp() {
        app.inIt();// через апп

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}