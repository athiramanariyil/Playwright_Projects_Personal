package unRelated;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UIValidations {
    Page page;
    BrowserContext context;
    @BeforeMethod
    public void bfr(){
        Playwright playwright= Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
         page= context.newPage();

            }

    @Test
    public  void Testing(){
        page.navigate("https://rahulshettyacademy.com/loginpagePractise/");
        Page newpage=context.waitForPage(()->page.locator(".blinkingText").first().click());
        newpage.waitForLoadState();
       String email= newpage.locator("//p[contains(@class,'red')]/strong/a").innerText();
       System.out.println(email);
       String para=page.locator("//p[contains(@class,'text-white')]").textContent();
       String[] cred=para.split("is");
       String user= cred[1].split(" ")[1];
        String pass = cred[2].replace(")", "");
        System.out.println(user);
        System.out.println(pass);
        page.getByLabel("username").fill(user);
        page.getByLabel("password").fill(pass);
        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("User")).click();
        page.waitForTimeout(3000);



    }
}
