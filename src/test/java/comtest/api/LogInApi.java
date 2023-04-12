package comtest.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Map;
public class LogInApi {
    private static final String BASE_URL = "https://dev.parkerandace.com";
    private static final String ENDPOINT = "/api/v1/application/login";
    private static final String USERNAME = "parkertestingace+505668518@gmail.com";
    private static final String PASSWORD = "1234asdF@";
    private Response loginResponse; // Store login response for subsequent use

    // Method to send login request and return response
    public Response sendLoginRequest(String username, String password) {
        if (loginResponse == null) {
            // Set base URL
            RestAssured.baseURI = BASE_URL;

            // Set request body with username and password
            String requestBody = "{ \"userName\": \"" + username + "\", \"password\": \"" + password + "\" }";

            // Send POST request to generate Bearer token
            loginResponse = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post(ENDPOINT);

            JsonPath jsonPath = loginResponse.jsonPath();
            Map<String, Object> user = jsonPath.getMap("user");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Convert "user" Map object to JSON string
            String json = gson.toJson(user);

            // Print formatted JSON
            System.out.println(json);
        }
        return loginResponse;
    }

    // Method to extract field value from response
    public String extractField(Response response, String fieldName) {
        // Extract the field value from the response
        String fieldValue = response.jsonPath().getString(fieldName);

        // Print the field value to the console
        System.out.println(fieldName + ": " + fieldValue);

        return fieldValue;
    }

    public String bearerGenerator() {
        // Send login request and get response
        if (loginResponse == null) {
            sendLoginRequest(USERNAME, PASSWORD);
        }

        // Extract jwtToken from response
        String jwtToken = extractField(loginResponse, "jwtToken");

        return jwtToken;
    }
    public String extractEmail() {
        // Send login request if loginResponse is null
        if (loginResponse == null) {
            sendLoginRequest(USERNAME, PASSWORD);
        }

        // Extract the "user" object from the stored login response
        JsonPath jsonPath = loginResponse.jsonPath();
        Map<String, Object> user = jsonPath.getMap("user");

        // Extract the email from the "user" object
        String email = (String) user.get("email");

        return email;
    }
    public String extractId() {
        // Send login request if loginResponse is null
        if (loginResponse == null) {
            sendLoginRequest(USERNAME, PASSWORD);
        }

        // Extract the "user" object from the stored login response
        JsonPath jsonPath = loginResponse.jsonPath();
        Map<String, Object> user = jsonPath.getMap("user");

        // Extract the id from the "user" object
        String id = (String) user.get("id");

        return id;
    }
}