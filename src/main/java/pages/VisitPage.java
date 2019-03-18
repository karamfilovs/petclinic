package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisitPage extends BasePage{
    private static final Logger LOGGER = LoggerFactory.getLogger(VisitPage.class);
    private static final String PAGE_URL = "/petclinic/owners/10/pets/12/visits/new";
    public VisitPage(WebDriver driver) { super(driver); }

    /**
     * Clicks the Add Visit button
     */
    public void addPetVisit() {
        driver.findElement(By.linkText("Add Visit")).click();
    }

    /**
     *Verifies if we are located at the Add new visit page for pets
     */
    public void verifyNewVisitTitle() {
        WebElement titletext = driver.findElement(By.cssSelector("h2"));
        Assertions.assertEquals("New Visit",titletext.getText());
    }

    /**
     * Fills the new visit form
     * @param dateforvisit - sets the date for visit(should be in format YYYY/MM/DD)
     * @param descfield - disciption field for the visit
     */
    public void fillNewVisitInformation(String dateforvisit, String descfield) {
        WebElement date = driver.findElement(By.id("date"));
        date.clear();
        date.sendKeys(dateforvisit);
        date.submit();
        WebElement desc = driver.findElement(By.id("description"));
        desc.sendKeys(descfield);
    }

    /**
     * Clicks the button to add a new visit
     */
    public void addPetVisitButtonClick() {
        WebElement addvisitbutton = driver.findElement(By.cssSelector("div.form-actions button"));
        addvisitbutton.click();
    }

    public void verifyErrorMessage() {
        WebElement errormessage = driver.findElement(By.cssSelector("input#description + span"));
        Assertions.assertEquals("may not be empty",errormessage.getText());
    }
}
