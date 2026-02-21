package stepDefinition;

import Drivers.PlaywrightPageProvider;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.CheckoutFinalPage;
import org.example.pages.ReceiptPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@RequiredArgsConstructor
public class CheckoutFinalSteps {
    private final PlaywrightPageProvider pageProvider;
    private final CheckoutFinalPage checkoutFinalPage;
    private final ReceiptPage receiptPage;

    @When("the user clicks on the finish button")
    public void theUserClicksOnTheFinishButton() {
        pageProvider.getPage().locator(checkoutFinalPage.FinishButton).click();
    }

    @Then("confirmation receipt should be displayed to the user")
    public void confirmationReceiptShouldBeDisplayed() {
        assertThat(pageProvider.getPage().locator(receiptPage.Receipt))
                .containsText("Thank you for your order!");
    }
}
