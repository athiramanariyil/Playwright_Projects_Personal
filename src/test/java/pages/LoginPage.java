package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    Page page;
    String url;
    public LoginPage(Page page, String url) {
        this.page=page;
        this.url=url;
    }

    public DashBoardPage loginTest() {
        page.navigate(url);
        page.getByPlaceholder("you@email.com").fill("athira@invalided.com");
        page.getByLabel("Password").fill("Qwerty@123");
        //page.pause();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
        DashBoardPage dash = new DashBoardPage(page);
        return dash;


    }
}
