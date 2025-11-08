package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverFactory;
import utils.WebDriverUtils;

public class HomePage extends BasePage {
	
	WebDriverUtils utils;
	
	WebDriverUtils util = new WebDriverUtils(driver);

    private By searchBox = By.xpath("//input[@class='input-text L14_9e']");
    private By searchList = By.xpath("//div[@id='searchlist']//ul//li");
    private By allCategoryPopup = By.xpath("//a[text()=' All Categories']");
    

    public HomePage(WebDriver driver) {
       super(driver); // ✅ explicitly call parent constructor
        utils = new WebDriverUtils(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public String searchProduct(String productName) throws InterruptedException {
    	driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        util.selectValueFromListByJs(searchList,productName);	
       
        return "Pass";
    }
    
    public String getProductTitle() {
    	String title = DriverFactory.getDriver().getTitle();
        System.out.println("Page Title: " + title);
		return "Pass";
    	
    }
}
