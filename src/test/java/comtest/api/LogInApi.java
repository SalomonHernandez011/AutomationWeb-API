package comtest.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

public class LogInApi {
    @BeforeMethod(alwaysRun = true)
    // Method to send login request and return response
    public Response sendLoginRequest(String username, String password) {
        // Set base URL
        RestAssured.baseURI = "https://dev.parkerandace.com";

        // Set request body with username and password
        String requestBody = "{ \"userName\": \"" + username + "\", \"password\": \"" + password + "\" }";

        // Send POST request to generate Bearer token
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/api/v1/application/login");

        return response;
    }

    // Method to extract jwtToken from response
    public String extractJwtToken(Response response) {
        // Check if response body is not null or empty
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        // Extract the jwtToken from the response
        String jwtToken = response.jsonPath().getString("jwtToken");

        // Print the jwtToken to the console
        System.out.println("Bearer Token: " + jwtToken);

        return jwtToken;
    }

    public String bearerGenerator() {
        // Send login request and get response
        Response response = sendLoginRequest("parkertestingace+505668518@gmail.com", "1234asdF@");

        // Extract jwtToken from response
        String jwtToken = extractJwtToken(response);

        return jwtToken;
    }
    // Method to extract ID from response
    public String extractId(Response response) {
        // Extract the ID from the response
        String id = response.jsonPath().getString("id");

        // Print the ID to the console
        System.out.println("ID: " + id);

        return id;
    }
    public String extractFirstName(Response response) {
        // Extract the firstName from the response
        String firstName = response.jsonPath().getString("firstName");

        // Print the firstName to the console
        System.out.println("First Name: " + firstName);

        return firstName;
    }
    // Method to extract email from response
    public String extractEmail(Response response) {
        // Extract the email from the response
        String email = response.jsonPath().getString("email");

        // Print the email to the console
        System.out.println("Email: " + email);

        return email;
    }
}
