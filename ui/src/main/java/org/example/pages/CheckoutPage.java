package org.example.pages;

import Drivers.PlaywrightPageProvider;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class CheckoutPage {

    private final PlaywrightPageProvider pageProvider;

    public CheckoutPage(PlaywrightPageProvider pageProvider) {
        this.pageProvider = pageProvider;
    }

    @Getter
    private final String CheckoutHeader = ".title";
    private final String FirstName = "#first-name";
    private final String LastName = "#last-name";
    private final String PostalCode = "#postal-code";
    private final String ContinueButton = "#continue";
    private final String FinishButton = "#finish";

    private void fillFirstName(String firstName) {
        pageProvider.getPage().locator(FirstName).fill(firstName);
    }

    private void fillLastName(String lastName) {
        pageProvider.getPage().locator(LastName).fill(lastName);
    }

    private void fillPostalCode(String postalCode) {
        pageProvider.getPage().locator(PostalCode).fill(postalCode);
    }

    private void clickContinue() {

        pageProvider.getPage().locator(ContinueButton).click();
    }

    public void clickFinish() {
        pageProvider.getPage().locator(FinishButton).click();
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillPostalCode(postalCode);
        clickContinue();
    }
}