package components;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class MainMenu extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainMenu.class);

    @FindBy(how = How.XPATH, using = "//a[@class='navbar-brand']")
    private WebElement homeLogoLink;

    @FindBy(how = How.XPATH, using = "//a[@title='home page']")
    private WebElement homePageLink;

    @FindBy(how = How.XPATH, using = "//a[@title='find owners']")
    private WebElement findOwnersLink;

    @FindBy(how = How.XPATH, using = "//a[@title='veterinarians']")
    private WebElement veterinariansLink;

    @FindBy(how = How.XPATH, using = "//a[@title='trigger a RuntimeException to see how it is handled']")
    private WebElement errorLink;

    @FindBy(how = How.XPATH, using = "//div[@class='col-12 text-center']/img")
    private WebElement footerImage;


    public MainMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on Home link
     */
    public void clickLogoLink() {
        LOGGER.info("Clicking on Logo link main menu");
        click(homeLogoLink);
        waitForFullPageOrJsAjaxToLoad();
    }

    /**
     * Clicks on Home link
     */
    public void clickHomeLink() {
        LOGGER.info("Clicking on Home page link main menu");
        click(homePageLink);
        waitForFullPageOrJsAjaxToLoad();
    }

    /**
     * Clicks on Find Owners link  from main menu
     */
    public void clickFindOwnersLink() {
        LOGGER.info("Clicking on Find Owners link from main menu");
        click(findOwnersLink);
        waitForFullPageOrJsAjaxToLoad();
    }

    /**
     * Clicks on Veterinarians link
     */
    public void clickVeterinariansLink() {
        LOGGER.info("Clicking on Veterinarians link from main menu");
        click(veterinariansLink);
        waitForFullPageOrJsAjaxToLoad();
    }

    /**
     * Clicks on Error link from main menu
     */
    public void clickErrorLink() {
        LOGGER.info("Clicking on Error page link main menu");
        click(errorLink);
        waitForFullPageOrJsAjaxToLoad();
    }

    /**
     * Verifies Footer image content is displayed
     */
    public void verifyImagePresent() {
        LOGGER.info("Verifying image is present.");
        Assertions.assertTrue(footerImage.isDisplayed(), "Image is not displayed");
    }

    // add highlight checking of menu buttons + logo
    // add check for fav icon
    // add check for browser tab title

}
