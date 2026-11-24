package Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.impl.AssertionsTimeout;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTestFramework {
    Page page;
    @BeforeMethod
    public void basicSetup() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("resources/GlobalProperties.properties");
        prop.load(fis);
        String bname=prop.getProperty("browser");
        System.out.println(bname);

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page= browser.newPage();
       // AssertionsTimeout.setDefaultTimeout(10000);





    }

    @AfterMethod
    public void tearDown(){
        page.close();
    }
}