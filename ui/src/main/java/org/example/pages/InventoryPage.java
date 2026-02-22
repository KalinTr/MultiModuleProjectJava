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
    protected final String InventoryItem = ".inventory_item";
    protected final String InventoryItemName = ".inventory_item_name";

    public void addProductToCart(String productName) {
        var products = pageProvider.getPage().locator(InventoryItem).all();

        for (Locator product : products) {
            String name = product.locator(InventoryItemName).innerText();
            if (name.equals(productName)) {
                product.locator("button").click();
                break;
            }
        }
    }
}
