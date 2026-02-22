package org.example.pages;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class CartPage {
    @Getter
    private final String CheckoutButton = "#checkout";
}
