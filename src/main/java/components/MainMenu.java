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

    @FindBy(how = How.XPATH, using = "//a[@title='home']")
    private WebElement homePageLink;

    @FindBy(how = How.XPATH, using = "//a[@title='find owners']")
    private WebElement findOwnersLink;

    @FindBy(how = How.XPATH, using = "//a[@title='veterinarians']")
    private WebElement veterinariansLink;

    @FindBy(how = How.XPATH, using = "//a[@title='trigger a RuntimeException to see how it is handled']")
    private WebElement errorLink;


    public MainMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
     * Clicks on Home link
     */
    public void clickHomeLink() {
        LOGGER.info("Clicking on Home page link main menu");
        click(homePageLink);
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


}
