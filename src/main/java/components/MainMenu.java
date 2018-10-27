package components;

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

    @FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[1]")
    private WebElement homePageLink;

    @FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[2]")
    private WebElement findOwnersLink;

    @FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[3]")
    private WebElement veterinariansLink;

    @FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[4]")
    private WebElement errorLink;

    public MainMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigate to Find Owners page
     */
    public void clickFindOwnersLink() {
        LOGGER.info("Clicking on Find Owners link from main menu");
        click(findOwnersLink);
        waitForFullPageOrJsAjaxToLoad();
    }

    /**
     * Navigate to Veterinarians page
     */
    public void clickVeterinariansLink() {
        LOGGER.info("Clicking on Veterinarians link from main menu");
        click(veterinariansLink);
        waitForFullPageOrJsAjaxToLoad();
    }

    /**
     * Navigate to Home page
     */
    public void clickHomeLink() {
        LOGGER.info("Clicking on Home page link main menu");
        click(homePageLink);
        waitForFullPageOrJsAjaxToLoad();
    }

}
