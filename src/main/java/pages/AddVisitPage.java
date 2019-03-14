package pages;

import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class AddVisitPage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddPetPage.class);
    private static final String PAGE_URL = "/petclinic/owners/visit/new";

    @FindBy(how = How.XPATH, using = "/html/body/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[2]/a" )
    private WebElement addVisitLink;

    @FindBy(how = How.XPATH, using = "//input[@id='date']" )
    private WebElement addDate;

    @FindBy(how = How.XPATH, using = "//input[@id='description']" )
    private WebElement addDescription;

    @FindBy(how = How.CSS, using = "div.form-actions button" )
    private WebElement addVisitButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/table[1]/thead/tr/th[1]" )
    private WebElement randomElement;

    @FindBy(how = How.XPATH, using = "/html/body/div/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]" )
    private WebElement visibleDate;


    public AddVisitPage(WebDriver driver) {
        super(driver);
    }


    public void clickAddVisitLink () {
        LOGGER.info("Clicking Add Visit link ");
        click(addVisitLink);
    }

    public void addDate (String text) {
        LOGGER.info("Adding a visit date" + text);
        typeText(addDate, text);
    }

    public void addDescription (String text) {
        LOGGER.info("Adding description" + text);
        typeText(addDescription, text);
    }

    public void clickAddVisitButton () {
        LOGGER.info("Clicking Add Visit button");
        click(addVisitButton);
    }

    public void clickRandom () {
        click(randomElement);
    }

    public void verifyVisitTextContains(String expectedText) {
        LOGGER.info("Verifying date is visible:" + expectedText);
        Assertions.assertTrue(visibleDate.isDisplayed());
    }
}
