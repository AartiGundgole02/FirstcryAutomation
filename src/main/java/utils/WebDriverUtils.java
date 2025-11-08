package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class WebDriverUtils {

	WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;

	// Constructor to initialize driver
	public WebDriverUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
	}

	public void selectValueFromList(By string, String textToSelect) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait until all list items are visible
			List<WebElement> listItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(string));

			boolean found = false;
			for (WebElement item : listItems) {
				String itemText = item.getText().trim();
				System.out.println("Found: " + itemText);

				// Match by exact or partial text
				if (itemText.equalsIgnoreCase(textToSelect)
						|| itemText.toLowerCase().contains(textToSelect.toLowerCase())) {
					item.click();
					System.out.println("✅ Selected: " + itemText);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("⚠️ No matching value found for: " + textToSelect);
			}

		} catch (Exception e) {
			System.out.println("❌ Error while selecting from list: " + e.getMessage());
		}
	}

	public void selectValueFromListByJs(By string, String textToSelect) {
		try {
			List<WebElement> listItems = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(string));

			boolean found = false;
			for (WebElement item : listItems) {
				String itemText = item.getText().trim();
				System.out.println("Found: " + itemText);

				if (itemText.equalsIgnoreCase(textToSelect)
						|| itemText.toLowerCase().contains(textToSelect.toLowerCase())) {
					found = true;

					js.executeScript("arguments[0].scrollIntoView(true);", item);
					try {
						wait.until(ExpectedConditions.elementToBeClickable(item)).click();
						System.out.println("✅ Clicked via Selenium: " + itemText);
					} catch (Exception e) {
						js.executeScript("arguments[0].click();", item);
						System.out.println("⚙️ Clicked via JS: " + itemText);
					}
					break;
				}
			}

			if (!found) {
				System.out.println("⚠️ No matching value found for: " + textToSelect);
			}

		} catch (TimeoutException e) {
			System.out.println("⏳ Timeout: No elements found for list " + string);
		} catch (Exception e) {
			System.out.println("❌ Error selecting from list: " + e.getMessage());
		}
	}
	
	public void hoverOverElement(By locator) {
	    try {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).perform();
	        System.out.println("🖱️ Hovered on element: " + locator);
	    } catch (Exception e) {
	        System.out.println("❌ Failed to hover on element: " + locator + " — " + e.getMessage());
	    }
	}
	

}
