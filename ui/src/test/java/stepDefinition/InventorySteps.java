package stepDefinition;

import Drivers.PlaywrightPageProvider;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import org.example.pages.CartPage;
import org.example.pages.InventoryPage;
import org.springframework.beans.factory.annotation.Value;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@RequiredArgsConstructor
public class InventorySteps {

    @Value("${ui.product.name}")
    private String productName;

    private final PlaywrightPageProvider pageProvider;
    private final InventoryPage inventoryPage;
    private final CartPage cartPage;

    @When("the user adds the desire product {string} to the cart")
    public void theUserAddsProductToTheCart(String productName) {
        inventoryPage.addProductToCart(productName);
    }

    @And("the user opens the cart")
    public void theUserOpensTheCart() {
        pageProvider.getPage()
                .locator(inventoryPage.Cart)
                .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
        pageProvider.getPage()
                .locator(inventoryPage.Cart)
                .click();
    }

    @Then("the user should see cart page header is {string}")
    public void theUserShouldSeePageHeaderIsYourCart(String cartHeaderValue) {
        assertThat(pageProvider.getPage().getByTestId(cartPage.CartHeader))
                .containsText(cartHeaderValue);
    }
}
