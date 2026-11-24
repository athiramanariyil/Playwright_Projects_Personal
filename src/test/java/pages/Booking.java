package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Booking {
    Page page;

    public Booking(Page page) {
        this.page=page;
    }

    public Locator newBooking(){
        page.getByPlaceholder("Your full name").fill("Athira");
        page.getByPlaceholder("you@email.com").fill("athira@invalidid.com");
        page.getByPlaceholder("+91 98765 43210").fill("9048956124");
      Locator confirmBooking= page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm Booking"));
      return confirmBooking;
    }
}
