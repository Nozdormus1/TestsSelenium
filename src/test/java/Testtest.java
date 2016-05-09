

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestTest extends TestSetup {
    private WebDriver driver;

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    //@Ignore
    public void test2() throws Exception {
        driver.get(appURL);
        driver.findElement(By.linkText("Flights")).click();
        if (oneWayDirection == true) {
            driver.findElement(By.id("flight-type-one-way")).click();
        } else {
            driver.findElement(By.id("flight-type-roundtrip")).click();
            driver.findElement(By.id("flight-returning")).clear();
            driver.findElement(By.id("flight-returning")).sendKeys(flightReturning);
        }
        driver.findElement(By.id("flight-origin")).clear();
        driver.findElement(By.id("flight-origin")).sendKeys(fromFlightName);
        driver.findElement(By.id("flight-destination")).clear();
        driver.findElement(By.id("flight-destination")).sendKeys(toFlightName);
        driver.findElement(By.id("flight-departing")).clear();
        driver.findElement(By.id("flight-departing")).sendKeys(flightDeparting);
        Select adultsDropdown = new Select(driver.findElement(By.id("flight-adults")));
        adultsDropdown.selectByVisibleText(numberOfAdults);
        Select childrenDropdown = new Select(driver.findElement(By.id("flight-children")));
        childrenDropdown.selectByVisibleText(numberOfChildren);
        driver.findElement(By.linkText("Advanced options")).click();
        Select preferredClassDropdown = new Select(driver.findElement(By.id("flight-advanced-preferred-class")));
        preferredClassDropdown.selectByVisibleText(valueOfPreferredClass);
        driver.findElement(By.id("search-button")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}