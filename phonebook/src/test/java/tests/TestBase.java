package tests;

import manager.AplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {


    protected static AplicationManager app = new AplicationManager();//инецилезация -ссылка на аликатион менеджер


    @BeforeSuite
    public void setUp() {
        app.inIt();// через апп

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}