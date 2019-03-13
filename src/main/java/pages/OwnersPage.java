package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OwnersPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwnersPage.class);
    private static final String PAGE_URL = "/petclinic/owners";


    @FindBy(how = How.XPATH, using = "//table[@id='owners']//tr[2]//td[1]/a")
    private WebElement ownerName;

    @FindBy(how = How.XPATH, using = "//a[@class='btn']")
    private WebElement pdfButton;

    @FindBy(how = How.ID, using = "//input")
    private WebElement searchField;

    @FindBy(how = How.ID, using = "owners")
    private WebElement ownersTable;

    public OwnersPage(WebDriver driver) {
        super(driver);
    }


    /**
     *
     */
    public void clickPdfButton(){
        LOGGER.info("Clicking PDF export button");
        click(pdfButton);
    }

    /**
     *
     * @param text
     */
    public void search(String text){
        LOGGER.info("Searching owners by:" + text);
        typeText(searchField, text);
    }

    /**
     * Verifies table rows count
     * @param expectedRowCount number of rows
     */
    public void verifyTableTotalRows(int expectedRowCount){
        Assertions.assertEquals(expectedRowCount, getTableRows(ownersTable).size() - 1, "Expected rows count does not match");
    }

    /**
     * Clicks on owner name inside table
     */
    public void clickOwnerName(){
        LOGGER.info("Clicking on random owner name");
        click(ownerName);
    }

    /**
     * Verifying table contains text
     * @param expectedText text
     */
    public void verifyTableTextContains(String expectedText) {
        LOGGER.info("Verifying table contains text:" + expectedText);
        Assertions.assertTrue(ownersTable.getText().contains(expectedText), "Table does not contain expected text");
    }
}
