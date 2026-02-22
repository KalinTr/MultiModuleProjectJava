package org.example.pages;

import Drivers.PlaywrightPageProvider;
import org.springframework.stereotype.Component;

@Component
public class CheckoutPage {

    private final PlaywrightPageProvider pageProvider;

    public CheckoutPage(PlaywrightPageProvider pageProvider) {
        this.pageProvider = pageProvider;
    }

    public final String CheckoutHeader = ".title";
    public final String FirstName = "#first-name";
    public final String LastName = "#last-name";
    public final String PostalCode = "#postal-code";
    public final String ContinueButton = "#continue";
    public final String FinishButton = "#finish";
    public final String CompleteHeader = ".complete-header";

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