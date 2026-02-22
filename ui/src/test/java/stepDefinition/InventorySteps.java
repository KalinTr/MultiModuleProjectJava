package stepDefinition;

import Drivers.PlaywrightPageProvider;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.CheckoutPage;
import org.example.pages.InventoryPage;
import org.springframework.beans.factory.annotation.Value;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@RequiredArgsConstructor
public class InventorySteps {

    @Value("${ui.product.name}")
    private String productName;

    private final PlaywrightPageProvider pageProvider;
    private final InventoryPage inventoryPage;
    private final CheckoutPage checkoutPage;

    @When("the user navigates to the inventory screen")
    public void theUserNavigatesToTheInventoryScreen() {
        assertThat(pageProvider.getPage().getByTestId(inventoryPage.getHeader()))
                .containsText("Products");
    }

    @And("the user add product to the cart")
    public void theUserAddProductToTheCart() {
        inventoryPage.addProductToCart(productName);
    }

    @And("the user navigates to the cart")
    public void theUserNavigatesToTheCart() {
        inventoryPage.openCart();
    }
}