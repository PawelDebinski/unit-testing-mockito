package pl.pawel.unittesting.parttwo.spike;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pawel.unittesting.parttwo.controllers.ItemController;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class JsonAssertTest {

    // ten string symuluje otrzymany response z controllera w jsonie
    String actualResponse  = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {

        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {

        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {

        String expectedResponse = "{id:1,name:Ball,price:10}"; // jeżeli value ma puste pola to wtedy muszę robić jak wyżej np: \"Ball 2\"
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
