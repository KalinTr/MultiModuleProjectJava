package hooks;

import Drivers.PlaywrightPageProvider;
import com.microsoft.playwright.Page;
import io.cucumber.java.Before;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UiHooks {

    public Page page;
    private final PlaywrightPageProvider pageProvider;

     @Before(value = "@ui", order = 1)
     public void preparePlaywrightInstance() {
         page = pageProvider.getPage();
     }
    // @After(value = "@ui", order = 1)
    // public void tearDownPlaywright() {
    //     pageProvider.close();
    // }
    // --- END OLD CODE ---
    // Cleanup is automatic: PlaywrightPageProvider implements DisposableBean.
    // Spring calls destroy() when the @ScenarioScope bean is disposed.
}
