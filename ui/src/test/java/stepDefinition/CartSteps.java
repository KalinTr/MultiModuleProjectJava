package stepDefinition;

import Drivers.PlaywrightPageProvider;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.CartPage;
import org.example.pages.CheckoutPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@RequiredArgsConstructor
public class CartSteps {

    private final PlaywrightPageProvider pageProvider;
    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;

    @When("the user clicks checkout button")
    public void clickCheckoutButton() {
        System.out.println("Entering here");
        pageProvider.getPage().locator(cartPage.CheckoutButton).click();
    }

    @Then("the user should see checkout page header is {string}")
    public void theUserShouldSeeCheckoutPageHeaderValue(String pageHeader) {
        assertThat(pageProvider.getPage().locator(checkoutPage.CheckoutHeader))
                .containsText(pageHeader);
    }
}
