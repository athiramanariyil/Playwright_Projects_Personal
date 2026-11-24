package unRelated;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class automationPracticee2e {

    Page page;
    BrowserContext context;
    @BeforeMethod
    public void settingUp(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        page= context.newPage();
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public  void testingWeb(){
        page.locator("#mousehover").hover();
        page.getByRole(AriaRole.LINK , new Page.GetByRoleOptions().setName("top")).click();
        FrameLocator frame =page.frameLocator("#courses-iframe");
        System.out.println(frame.locator("//h3/span").textContent());
    }
    @AfterMethod
    public void Teardown(){
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
    }
}


