package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.example.pages.CheckoutPage;
import org.example.pages.ReceiptPage;

@RequiredArgsConstructor
public class CheckoutSteps {

    private final CheckoutPage checkoutPage;
    private final ReceiptPage receiptPage;

    @And("the user fill in the required information for checkout")
    public void fillInCheckoutInformation() {
        checkoutPage.fillCheckoutInformation("John", "Doe", "1000");
    }

    @And("the user finishes the order")
    public void theUserConfirms() {
        checkoutPage.clickFinish();
    }
    @Then("receipt for successful order submission is displayed")
    public void receiptForSuccessfulOrderSubmissionIsDisplayed() {
        receiptPage.verifyOrderCompleted();
    }
}