package org.example.pages;

import Drivers.PlaywrightPageProvider;
import org.springframework.stereotype.Component;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Component
public class ReceiptPage {

    private final PlaywrightPageProvider pageProvider;

    public ReceiptPage(PlaywrightPageProvider pageProvider) {
        this.pageProvider = pageProvider;
    }

    public final String ReceiptHeader = ".complete-header";

    public void verifyOrderCompleted() {
        assertThat(pageProvider.getPage().locator(ReceiptHeader))
                .containsText("Thank you for your order!");
    }
}