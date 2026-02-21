package stepDefinition;

import Drivers.PlaywrightPageProvider;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.CartPage;

@RequiredArgsConstructor
public class CartSteps {

    private final PlaywrightPageProvider pageProvider;
    private final CartPage cartPage;

    @When("the user clicks checkout button")
    public void clickCheckoutButton() {
        System.out.println("Entering here");
        pageProvider.getPage().locator(cartPage.CheckoutButton).click();
    }
}
