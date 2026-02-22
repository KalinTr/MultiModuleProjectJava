package org.example.pages;
import Drivers.PlaywrightPageProvider;
import com.microsoft.playwright.Locator;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class InventoryPage {

    private final PlaywrightPageProvider pageProvider;

    public InventoryPage(PlaywrightPageProvider pageProvider) {

        this.pageProvider = pageProvider;
    }

    @Getter
    private final String header = "title";
    private final String cart = ".shopping_cart_link";
    private final String inventoryItem = ".inventory_item";
    private final String inventoryItemName = ".inventory_item_name";

    public void openCart() {

        pageProvider.getPage().locator(cart).click();
    }

    public void addProductToCart(String productName) {
        var products = pageProvider.getPage().locator(inventoryItem).all();

        for (Locator product : products) {
            String name = product.locator(inventoryItemName).innerText();
            if (name.equals(productName)) {
                product.locator("button").click();
                break;
            }
        }
    }
}
