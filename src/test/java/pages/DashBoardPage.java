package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DashBoardPage {
    Page page;



    public DashBoardPage(Page page){
        this.page=page;
    }

    public Locator verifyDash(){

        Locator loc= page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Browse Events →"));
        return loc;
}

    public Locator newEvent(){
        Locator admin = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Admin"));
        admin.click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Manage Events")).first().click();
        page.getByLabel("Title").fill("AR Rahman Live Concert");
        page.getByPlaceholder("Describe the event…").fill("A live concert by AR Rahman and Team");
        page.getByLabel("category").selectOption("Concert");
        page.locator("#venue").fill("MARRIOT");
        page.getByPlaceholder("e.g. Bangalore").fill("kochi");
        page.getByLabel("Event Date & Time").fill("2026-11-30T18:00");
        page.getByLabel("Total Seats").fill("100");
        page.getByLabel("Price ($)").fill("1500");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("+ Add Event")).click();
        return page.getByText("Event created!");

    }
    public eventVerification verifyEvent(){
        page.getByTestId("nav-events").click();
        eventVerification check = new eventVerification(page);
        return check;

    }
}
