package stepDefinition;

import Drivers.PlaywrightPageProvider;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import org.example.pages.InventoryPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@ScenarioScope
public class InventorySteps {

    @Value("${ui.product.name}")
    private String productName;

    private final PlaywrightPageProvider pageProvider;
    private final InventoryPage inventoryPage;

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
}
