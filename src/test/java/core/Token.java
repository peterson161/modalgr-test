package core;

import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class Token {

    public static String getToken(){

        Config config = new Config();
        config.execute();

        String token = given()
                .auth().preemptive().basic(config.userLogin.getLogin(), config.userLogin.getSenha())
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
            .when()
                .post("/oauth/token")
            .then()
                .extract()
                .path("access_token");

        return token;
    }
}
