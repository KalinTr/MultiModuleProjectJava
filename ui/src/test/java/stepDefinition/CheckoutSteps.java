package stepDefinition;

import Drivers.PlaywrightPageProvider;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.CheckoutFinalPage;
import org.example.pages.CheckoutPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@RequiredArgsConstructor
public class CheckoutSteps {
    private final PlaywrightPageProvider pageProvider;
    private final CheckoutPage checkoutPage;
    private final CheckoutFinalPage checkoutFinalPage;

    @When("the user enters his first name")
    public void theUserEntersHisFirstName() {
        pageProvider.getPage().locator(checkoutPage.FirstName).fill("Kalin");
        System.out.println("Entering first name");
    }

    @And("the user enters his last name")
    public void theUserEntersHisLastName() {
        pageProvider.getPage().locator(checkoutPage.LastName).fill("Trayanski");
        System.out.println("Entering last name");
    }

    @And("the user enters his postal code")
    public void theUserEntersHisPostalCode() {
        pageProvider.getPage().locator(checkoutPage.PostalCode).fill("1000");
    }

    @And("the user clicks the continue button")
    public void theUserClicksTheContinueButton() {
        pageProvider.getPage().locator(checkoutPage.ContinueButton).click();
    }

    @Then("the user should see final checkout page header is {string}")
    public void theUserShouldSeeFinalCheckoutPageHeaderValue(String pageHeader) {
        assertThat(pageProvider.getPage().locator(checkoutFinalPage.CheckoutFinalPageHeader)).containsText(pageHeader);
    }
}
