package unRelated;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class automationPractice {

    Page page;
    BrowserContext context;
    @BeforeMethod
    public void basicSetup(){
        Playwright playwright= Playwright.create();
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page=context.newPage();
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
    }
@Test
    public void TestingPractice(){
        context.onDialog(dialog -> dialog.accept());
        page.locator("#alertbtn").click();
}


}
