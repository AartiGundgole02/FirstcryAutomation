package drivers;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class DriverFactory {
	    private static WebDriver driver;

	    public static void initializeDriver(String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        }
	        driver.manage().window().maximize();
	    }

	    public static WebDriver getDriver() {
	        return driver;
	    }

	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

	

