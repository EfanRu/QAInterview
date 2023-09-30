import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MainTest {
    /**
     * Test for check ChromeDriver is work.
     * Test from <a href="https://www.selenium.dev/documentation/webdriver/getting_started/first_script/">Selenium dev</a>
     */
    @Test
    public void testSelenium() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);

        driver.quit();
    }

    /**
     * Test for check ChromeDriver connect to Selenoid is work.
     * Test from <a href="https://www.selenium.dev/documentation/webdriver/getting_started/first_script/">Selenium dev</a>
     */
    @Test
    public void testSeleniumInSelenoid() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities("chrome", "102.0", Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), caps, false);
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);

        driver.quit();
    }

    /**
     * Broken test. Fix it!
     * Task:
     * 1. Check that all input fields work according to their description.
     * 2. Create 1 bug report.
     * 3. How need fix this test?
     * 4. What checks would you add for input fields?
     * 5. Rewrite this test with patterns (PageObject, Facade and so on).
     * 6. Are you fixed quote from WebDriver? How did close him if test failed?
     */
    @Test
    public void brokenTestSelenium() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

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
