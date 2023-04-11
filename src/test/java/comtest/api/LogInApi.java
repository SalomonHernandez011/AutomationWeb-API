package comtest.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

public class LogInApi {
    @BeforeMethod(alwaysRun = true)
    public String bearerGenerator() {

            // Set base URL
            RestAssured.baseURI = "https://dev.parkerandace.com";

            // Set request body with username and password
            String requestBody = "{ \"userName\": \"parkertestingace+505668518@gmail.com\", \"password\": \"1234asdF@\" }";

            // Send POST request to generate Bearer token
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post("/api/v1/application/login");

            // Check if response body is not null or empty
            String responseBody = response.getBody().asString();
            System.out.println(responseBody);

            // Extract the jwtToken from the response
            String jwtToken = response.jsonPath().getString("jwtToken");

            // Print the jwtToken to the console
            System.out.println("Bearer Token: " + jwtToken);
                    return jwtToken;
        }

}
