package stepDefinition;

import Drivers.PlaywrightPageProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    private final InventoryPage inventoryPage;

    @Given("the user navigate to the Login page")
    public void theUserNavigateToTheLoginPage() {
        pageProvider.getPage().navigate(baseUrl);
        System.out.println("Step 0: Website is opened");
    }

    @When("the user enter valid username")
    public void theUserEnterValidUsername() {
        pageProvider.getPage().locator(loginPage.UsernameField).fill(username);
        System.out.println("Step 2: The user enter username");
    }

    @And("the user enter valid password")
    public void theUserEnterValidPassword() {
        pageProvider.getPage().getByTestId(loginPage.PasswordField).fill(password);
        System.out.println("Step 3: The user enter password");
    }

    @And("the user click on the login button")
    public void theUserClickOnTheLoginButton() {
        pageProvider.getPage().getByTestId(loginPage.LoginButton).click();
        System.out.println("Step 4: Click the login button");
    }

    @Then("the user should see page header value is {string}")
    public void theUserShouldSeeHeaderValueIs(String headerValue) {
        assertThat(pageProvider.getPage().getByTestId(inventoryPage.Header)).containsText(headerValue);
    }
}
