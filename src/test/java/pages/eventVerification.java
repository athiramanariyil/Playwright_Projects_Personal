package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class eventVerification  {
    Page page;

    public  eventVerification(Page page){
        this.page=page;
    }
    public Locator verifyEvent(){

       Locator myevent= page.getByText("AR Rahman Live Concert");
       return myevent;

    }
    public Booking seatVerification(){
        Locator event = page.locator("div.p-4.flex.flex-col.flex-1");
        Locator eventCard = event.filter(new Locator.FilterOptions().setHasText("AR Rahman Live Concert"));
        String Seats = eventCard.locator("//span[contains(@class,'text-xs')]").innerText();
        System.out.println(Seats);
        int seatno = Integer.parseInt(Seats.split(" ")[0]);
        // page.pause();
        eventCard.getByTestId("book-now-btn").click();
        Booking booking = new Booking(page);
        return booking;
    }
}
