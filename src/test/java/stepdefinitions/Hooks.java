package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import drivers.DriverFactory;
import utils.ConfigReader;

public class Hooks {

    @Before
    public void setUp() {
        ConfigReader.loadProperties();
        DriverFactory.initializeDriver(ConfigReader.getProperty("browser"));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
