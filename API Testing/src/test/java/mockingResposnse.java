import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class mockingResposnse {
    Page page;
   @BeforeMethod
   public void setups(){
       Playwright playwright = Playwright.create();
       Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      page = browser.newPage();

   }

    @Test
    public void testing(){

        page.route("**api/events**",
              route -> route.fulfill(new Route.FulfillOptions().setPath(Paths.get("C:\\Users\\DELL\\IdeaProjects\\PlayWrightJava\\resources\\mockingJson.JSON"))));
        page.navigate("https://eventhub.rahulshettyacademy.com/login");
        page.getByPlaceholder("you@email.com").fill("athira@invalided.com");
        page.getByLabel("Password").fill("Qwerty@123");
        //page.pause();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();

        page.locator("#nav-events").click();
        page.waitForTimeout(7000);

        



    }

    @Test
    Public void MockRequest(){

    }

}
