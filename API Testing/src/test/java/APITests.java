import com.jayway.jsonpath.JsonPath;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.zip.Adler32;

public class APITests {
    Playwright playwright = Playwright.create();
    APIRequestContext api = playwright.request().newContext();
    String token;

    @Test
    public void Login() {
        HashMap<Object, Object> m = new HashMap<>();
        m.put("email", "athira@invalid.com");
        m.put("password", "Qwerty@123");

        //Login -Post Method
        APIResponse res = api.post("https://api.eventhub.rahulshettyacademy.com/api/auth/login",
                RequestOptions.create().setData(m));
        Assert.assertTrue(res.ok());
        token = JsonPath.read(res.text(), "$.token");
        System.out.println(token);
    }

@Test
        public void createvent(){
        HashMap<Object, Object> payload = new HashMap<>();
        payload.put("title", "API EVENT");
        payload.put("description", "");
        payload.put("category", "Conference");
        payload.put("venue", "www");
        payload.put("city", "Thalassery");
        payload.put("eventDate", "2026-12-04T07:17:00.000Z");
        payload.put("price", 720);
        payload.put("totalSeats", 100);


        APIResponse eventres = api.post("https://api.eventhub.rahulshettyacademy.com/api/events", RequestOptions.create()
                .setHeader("Authorization", "Bearer " + token).setData(payload));
        System.out.println(eventres.ok());
        int id=JsonPath.read(eventres.text(),"$.data.id");
        System.out.println(id);

        //Get event

        APIResponse getEvent= api.get("https://api.eventhub.rahulshettyacademy.com/api/events?page=1&limit=12",
                RequestOptions.create().setQueryParam("page","1").setQueryParam("limit","12").setHeader("Authorization", "Bearer " + token));

        Assert.assertTrue(getEvent.ok());
       // System.out.println(getEvent.text());
        List<Integer> ids= JsonPath.read(getEvent.text(),"$.data[*].id");
        Assert.assertTrue(ids.contains(id));

        //Delete event
        APIResponse dltres=api.delete("https://api.eventhub.rahulshettyacademy.com/api/events/"+id,RequestOptions.create().setHeader("Authorization", "Bearer " + token));
        System.out.println(dltres.ok());
    APIResponse getEventdlt= api.get("https://api.eventhub.rahulshettyacademy.com/api/events?page=1&limit=12",
            RequestOptions.create().setQueryParam("page","1").setQueryParam("limit","12").setHeader("Authorization", "Bearer " + token));

    //Assert.assertTrue(getEvent.ok());
    // System.out.println(getEvent.text());
    List<Integer> idsnw= JsonPath.read(getEventdlt.text(),"$.data[*].id");
    Assert.assertFalse(idsnw.contains(id));
   //
    // JsonPath js= new JsonPath(getEventdlt.toString());

    }
}

