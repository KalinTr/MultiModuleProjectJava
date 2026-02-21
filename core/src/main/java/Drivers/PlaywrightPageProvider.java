package Drivers;

import com.microsoft.playwright.*;
import io.cucumber.spring.ScenarioScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Scenario-scoped provider that creates Playwright Page on first use (pgw approach).
 * Injected into step definitions - no explicit preparePlaywrightInstance() needed.
 *
 * --- OLD CODE (kept for reference) ---
 * private static final ThreadLocal<PlaywrightInstanceProvider> INSTANCE = ThreadLocal.withInitial(PlaywrightInstanceProvider::new);
 * private Playwright playwright;
 * private Browser browser;
 * private BrowserContext browserContext;
 * private Page page;
 *
 * public static PlaywrightInstanceProvider getInstance() {
 *     return INSTANCE.get();
 * }
 *
 * public Page preparePlaywrightInstance() {
 *     if (browserContext != null) {
 *         return page != null ? page : browserContext.newPage();
 *     }
 *     playwright = Playwright.create();
 *     playwright.selectors().setTestIdAttribute("data-qid");
 *     browser = launchBrowser(playwright);
 *     browserContext = createBrowserContext(browser);
 *     page = browserContext.newPage();
 *     configurePageHandlers(page);
 *     return page;
 * }
 *
 * // In UiHooks @Before:
 * PlaywrightInstanceProvider.getInstance().preparePlaywrightInstance();
 *
 * // In LoginSteps:
 * PlaywrightInstanceProvider.getInstance().getPage().navigate(...);
 * --- END OLD CODE ---
 */
@Component
@ScenarioScope
public class PlaywrightPageProvider {

    @Value("${ui.headless}")
    private boolean isHeadless;

    private Page page;

    public Page getPage() {
        if (page == null) {
            initBrowser();
        }
        return page;
    }

    private void initBrowser() {
        Playwright playwright = Playwright.create();
        playwright.selectors().setTestIdAttribute("data-test");

        Browser browser = launchBrowser(playwright);
        page = browser.newPage();
    }

    private Browser launchBrowser(Playwright playwright) {
        return playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(isHeadless)
                .setTimeout(30000));
    }
}
