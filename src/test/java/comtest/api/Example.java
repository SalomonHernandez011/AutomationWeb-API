package comtest.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example extends LogInApi {
    private  LogInApi logInApi;
    private  String bearer;
    private  String email;
    private  String id;
        @Test
        public void testApi () throws JsonProcessingException {
            logInApi = new LogInApi();
            bearer = logInApi.bearerGenerator();
            email = logInApi.extractEmail();
            id = logInApi.extractId();
            System.out.println(email);
            System.out.println(id);
            // Set base URI
            String apiUrl = "https://dev.parkerandace.com/api/v1/appointment/pet-parent/5d309ac4-e494-425f-a9da-8e7b478b8899/confirmed/past/false";

            // Set headers
            String acceptHeader = "*/*";

            // Send GET request and get response
            Response response = RestAssured.given()
                    .header("accept", acceptHeader)
                    .header("Authorization", "Bearer " + bearer)
                    .when()
                    .get(apiUrl);

//            // Extract response body as String
//            String responseBody = response.getBody().asString();

            // Check if response body is not empty or null
//            if (responseBody != null && !responseBody.isEmpty()) {
//                // Deserialize JSON into a Java object
//                ObjectMapper objectMapper = new ObjectMapper();
//                Object json = objectMapper.readValue(responseBody, Object.class);
//
//                // Serialize Java object back to JSON with indentation and formatting
//                String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
//
//                // Print the pretty-printed JSON
//                System.out.println("Response body (pretty-printed):");
//                System.out.println(prettyJson);
//                System.out.println("Response Status Code: " + response.getStatusCode());
//            } else {
//                System.out.println("Response body is empty or null.");
//            }

            int statusCode = response.getStatusCode();

            Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/,
                    "Correct status code returned");
        }
    }

