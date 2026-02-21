package org.example.pages;

import Drivers.PlaywrightPageProvider;
import com.microsoft.playwright.Locator;
import org.springframework.stereotype.Component;

@Component
public class InventoryPage {

    private final PlaywrightPageProvider pageProvider;

    public InventoryPage(PlaywrightPageProvider pageProvider) {
        this.pageProvider = pageProvider;
    }
    public final String Header = "title";
    public final String Cart = ".shopping_cart_link";

    public void addProductToCart(String productName) {
        var products = pageProvider.getPage().locator(".inventory_item").all();

        for (Locator product : products) {
            String name = product.locator(".inventory_item_name").innerText();
            if (name.equals(productName)) {
                product.locator("button").click();
                break;
            }
        }
    }
}
