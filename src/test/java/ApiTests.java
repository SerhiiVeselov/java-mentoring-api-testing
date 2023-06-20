import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @Test
    public void getUsers() {
        String endpoint = "https://jsonplaceholder.typicode.com/users";
        given().
        when().
                get(endpoint).
        then().
                log().
                    body().
                    assertThat().
                        statusCode(200);
    }

    @Test
    public void verifyHeader() {
        String endpoint = "https://jsonplaceholder.typicode.com/users";
        given().
        when().
                get(endpoint).
        then().
                log().
                    headers().
                    assertThat().
                        statusCode(200).
                        header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void verifyUsersArray() {
        String endpoint = "https://jsonplaceholder.typicode.com/users";
        given().
        when().
                get(endpoint).
        then().
                log().
                    body().
                    assertThat().
                        statusCode(200).
                        body("records.size()", equalTo(10));
    }
}
