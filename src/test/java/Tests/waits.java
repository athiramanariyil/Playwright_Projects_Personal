package Tests;

import com.microsoft.playwright.Page;

public class waits {
    Page page;

    public waits(Page page) {
        //super();
        this.page=page;
    }


    public void waitForLoad(double l){

        page.waitForTimeout(l);
    }
}
