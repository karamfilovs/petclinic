package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
    private static final String PAGE_URL = "/";

    @FindBy(how = How.XPATH, using = "//img[@class='img-responsive']")
    private WebElement image;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to current page
     */
    public void gotoPage() {
        LOGGER.info("Navigate to:" + BASE_URL + PAGE_URL);
        navigateTo(PAGE_URL);
    }

    /**
     * Verifies image content is displayed
     */
    public void verifyImagePresent() {
        LOGGER.info("Verifying image is present.");
        Assertions.assertTrue(image.isDisplayed(), "Image is not displayed");
    }

}
