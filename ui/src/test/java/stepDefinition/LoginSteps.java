package stepDefinition;

import Drivers.PlaywrightPageProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.springframework.beans.factory.annotation.Value;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@RequiredArgsConstructor
public class LoginSteps {

    @Value("${ui.base.url}")
    private String baseUrl;

    @Value("${ui.username}")
    private String username;

    @Value("${ui.password}")
    private String password;

    private final PlaywrightPageProvider pageProvider;
    private final LoginPage loginPage;

    @Given("the user navigates to the Login page")
    public void theUserNavigateToTheLoginPage() {
        pageProvider.getPage().navigate(baseUrl);
    }

    @And("the user login with credentials")
    public void theUserLoginWithCredentials() {
        loginPage.login(username, password);
    }
}