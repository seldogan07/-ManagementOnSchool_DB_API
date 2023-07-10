package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ManagementOnSchoolsAuth {

    public static String generateToken(){

        String payload = "{ \"password\": \"12345678\", \"username\": \"Project09Admin\"}";
        Response response =  given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("https://managementonschools.com/app/auth/login");
        return response.jsonPath().getString("token");
    }

}
