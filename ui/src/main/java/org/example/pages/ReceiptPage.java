package org.example.pages;
import Drivers.PlaywrightPageProvider;
import lombok.Getter;
import org.springframework.stereotype.Component;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Component
public class ReceiptPage {

    private final PlaywrightPageProvider pageProvider;

    @Getter
    private final String ReceiptHeader = ".complete-header";

    public ReceiptPage(PlaywrightPageProvider pageProvider) {
        this.pageProvider = pageProvider;
    }

    public void verifyOrderCompleted() {
        assertThat(pageProvider.getPage().locator(ReceiptHeader))
                .containsText("Thank you for your order!");
    }

}