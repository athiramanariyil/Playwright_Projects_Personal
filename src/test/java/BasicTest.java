import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest
{

    @Test
    public void launchBrowser(){
        Playwright playwright= Playwright.create();
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://sauce-demo.myshopify.com/");
        System.out.println(page.title());
        Assert.assertTrue(page.title().contentEquals("Sauce Demo"));

    }

}
