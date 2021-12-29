package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import core.Token;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class TestStatusCode {

    private Token token = new Token();
    private Config config = new Config();
    private Utilities utilities = new Utilities();

    public void testStatusCode201(Object entity, String path) throws JsonProcessingException {
        String tokenPassword = token.getTokenPassword();
        config.executeConfigResourceServer();
        given()
            .auth().preemptive().oauth2(tokenPassword)
            .body(utilities.entityToJson(entity))
            .contentType(ContentType.JSON)
        .when()
            .post(path)
        .then()
            .log().all()
            .assertThat()
            .statusCode(201);
    }

    public void testStatusCode200(String path){
        String tokenPassword = token.getTokenPassword();
        config.executeConfigResourceServer();
        given()
            .auth().preemptive().oauth2(tokenPassword)
        .when()
            .get(path)
        .then()
            .log().all()
            .assertThat()
            .statusCode(200);
    }

    public void testStatusCode204(String path) {
        String tokenPassword = token.getTokenPassword();
        config.executeConfigResourceServer();
        given()
            .auth().preemptive().oauth2(tokenPassword)
        .when()
            .delete(path)
        .then()
            .log().all()
            .assertThat()
            .statusCode(204);
    }

    public void testStatusCode200(Object entity, String path) throws JsonProcessingException {
        String tokenPassword = token.getTokenPassword();
        config.executeConfigResourceServer();
        given()
            .auth().preemptive().oauth2(tokenPassword)
            .body(utilities.entityToJson(entity))
            .contentType(ContentType.JSON)
        .when()
            .put(path)
        .then()
            .log().all()
            .assertThat()
            .statusCode(200);
    }
}