import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.geom.Area;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class eventHub {
Page page;

@BeforeMethod
public void basicSetup(){
    Playwright playwright = Playwright.create();
    Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
     page = browser.newPage();
}
    @Test(description="Login to app")
public void launchApp() {

        page.navigate("https://eventhub.rahulshettyacademy.com/login");
        page.getByPlaceholder("you@email.com").fill("athira@invalided.com");
        page.getByLabel("Password").fill("Qwerty@123");
        //page.pause();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();


        assertThat(page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Browse Events →"))).isVisible();
        Locator admin = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Admin"));
        admin.click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Manage Events")).first().click();
        page.getByLabel("Title").fill("AR Rahman Live Concert");
        page.getByPlaceholder("Describe the event…").fill("A live concert by AR Rahman and Team");
        page.getByLabel("category").selectOption("Concert");
        page.locator("#venue").fill("MARRIOT");
        page.getByPlaceholder("e.g. Bangalore").fill("kochi");
        page.getByLabel("Event Date & Time").fill("2026-10-24T18:00");
        page.getByLabel("Total Seats").fill("1");
        page.getByLabel("Price ($)").fill("1500");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("+ Add Event")).click();
        assertThat(page.getByText("Event created!")).isVisible();
        page.waitForTimeout(3000);
        page.pause();


    }

    @AfterMethod
    public void tearDown(){
    page.close();
    }

}
