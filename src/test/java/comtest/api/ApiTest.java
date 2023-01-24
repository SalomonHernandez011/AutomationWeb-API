package comtest.api;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;

import java.util.Base64;

import static io.restassured.RestAssured.given;

public class ApiTest {
    public static String clientId = "7etei17l08g8acku64d45fl0p7";
    public static String redirectUri = "https://qa.parkerandace.com/api/swagger-ui/oauth2-redirect.html";
    public static String scope = "some_scope";
    public static String username = "salomontesting+qa012@gmail.com";
    public static String password = "1234asdF@";

    public static String encode(String str1, String str2) {
        return new String(Base64.getEncoder().encode((str1 + ":" + str2).getBytes()));
    }

    public static Response getCode() {
        String authorization = encode(username, password);

        return
                given()
                        .header("authorization", "Basic " + authorization)
                        .contentType(ContentType.URLENC)
                        .formParam("response_type", "code")
                        .queryParam("client_id", clientId)
                        .queryParam("redirect_uri", redirectUri)
                        .queryParam("scope", scope)
                        .post("/oauth2/authorize")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }

    public static String parseForOAuth2Code(Response response) {
        return response.jsonPath().getString("code");
    }

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://qa.parkerandace.com/api/swagger-ui/index.html#/";
    }

    @Test
    public void iShouldGetCode() {
        Response response = getCode();
        String code = parseForOAuth2Code(response);

        Assertions.assertNotNull(code);
    }
}
