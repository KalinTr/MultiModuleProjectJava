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
    private final String Header = "title";
    private final String Cart = ".shopping_cart_link";
    private final String InventoryItem = ".inventory_item";
    private final String InventoryItemName = ".inventory_item_name";

    public void openCart() {
        pageProvider.getPage().locator(Cart).click();
    }

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
