package org.example.pages;

import Drivers.PlaywrightPageProvider;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

    private final PlaywrightPageProvider pageProvider;

    public LoginPage(PlaywrightPageProvider pageProvider) {
        this.pageProvider = pageProvider;
    }

    private final String UsernameField = "#user-name";
    private final String PasswordField = "#password";
    private final String LoginButton = "#login-button";

    public void enterUsername(String username) {

        pageProvider.getPage().locator(UsernameField).fill(username);
    }

    public void enterPassword(String password) {
        pageProvider.getPage().locator(PasswordField).fill(password);
    }

    public void clickLoginButton() {

        pageProvider.getPage().locator(LoginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}