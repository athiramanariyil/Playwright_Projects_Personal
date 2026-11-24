package Tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Booking;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.eventVerification;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class eventHub extends BaseTestFramework {
//Page page;

        String URL = "https://eventhub.rahulshettyacademy.com/login";

        @Test(description="Login to app")
        public void CreateEvent() {


                LoginPage login = new LoginPage(page, URL);
                DashBoardPage dash = login.loginTest();
                Locator loc = dash.verifyDash();
                assertThat(loc).isVisible();
                Locator success = dash.newEvent();
                assertThat(success).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(11000));
                //page.pause();
                eventVerification verify = dash.verifyEvent();
                Locator myEvent = verify.verifyEvent();
                assertThat(myEvent).isVisible();
                waits wait = new waits(page);
                wait.waitForLoad(3000);
                Booking booking=verify.seatVerification();
                Locator bookingMsg=booking.newBooking();
                assertThat(bookingMsg).isVisible();
                wait.waitForLoad(3000);


    }


}
