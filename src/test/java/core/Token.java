package core;

import static io.restassured.RestAssured.given;

public class Token {

    Config config;

    public Token(){
        config = new Config();
    }

    public String getTokenClientCredentials(){
        config.executeConfigAuthorizationServer();
        String token = given()
                .auth().preemptive().basic("modalgrcredentials", "modalgrcredentials123")
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
            .when()
                .post("/oauth/token")
            .then()
                .log().all()
                .extract()
                .path("access_token");

        return token;
    }

    public String getTokenPassword(){
        config.executeConfigAuthorizationServer();
        String token = given()
                .auth().preemptive().basic("modalgrtoken", "modalgrtoken123")
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "password")
                .formParam("username", "peterson161")
                .formParam("password", "838456")
            .when()
                .post("/oauth/token")
            .then()
                .log().all()
                .extract()
                .path("access_token");

        return token;
    }
}
