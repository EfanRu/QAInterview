import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URL;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static utils.PropsHelper.getProps;

/**
 * Testing Web and automation java patterns.
 * @see <a href="https://www.selenium.dev/documentation/webdriver/getting_started/first_script/">Selenium dev</a>
 */
public class SeleniumDevTest {
    private final String seleniumDevUrl = "https://www.selenium.dev/selenium/web/web-form.html";

    /**
     * Test for check ChromeDriver is work.
     */
    @Test
    public void testSeleniumConnect() {
        WebDriver driver = new ChromeDriver();
        driver.get(seleniumDevUrl);

        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.quit();
    }

    /**
     * Test for check ChromeDriver connect to Selenoid is work.
     */
    @Test
    public void testSeleniumInSelenoid() throws IOException {
        final String selenoidUrl = getProps().getProperty("selenoid.webDriver.url");
        final String selenoidBrowserName = getProps().getProperty("selenoid.webDriver.browserName");
        final String selenoidBrowserVersion = getProps().getProperty("selenoid.webDriver.browserVersion");
        DesiredCapabilities caps = new DesiredCapabilities(selenoidBrowserName, selenoidBrowserVersion, Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(new URL(selenoidUrl), caps, false);
        driver.get(seleniumDevUrl);

        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.quit();
    }

    /**
     * Broken test. Fix it!
     * Test case:
     * Check that all active input fields are working correctly, and inactive ones do not accept input.
     * Task:
     * 1. Check that all input fields input text.
     * 2. How need fix this test?
     * 3. What checks would you add for input fields? Disable input? Read only inputs?
     * 4. Rewrite this test with patterns (PageObject, Facade and so on).
     * 5. Are you fixed quote from WebDriver? How did close him if test failed?
     */
    @Test
    public void brokenTestSelenium() {
        WebDriver driver = new ChromeDriver();
        driver.get(seleniumDevUrl);

        List<WebElement> textBoxList = driver.findElements(By.xpath("//*[@id=\"my-text-id\"]"));
        WebElement submitButton = driver.findElement(By.xpath("//button"));
        textBoxList.forEach(t -> t.sendKeys("Selenium"));
        submitButton.click();
        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);

        driver.quit();
    }
}
