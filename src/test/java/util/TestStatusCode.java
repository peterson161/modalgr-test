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

    public int testStatusCode201(Object entity, String path) throws JsonProcessingException {
        String tokenPassword = token.getTokenPassword();
        config.executeConfigResourceServer();
        int id = given()
            .auth().preemptive().oauth2(tokenPassword)
            .body(utilities.entityToJson(entity))
            .contentType(ContentType.JSON)
        .when()
            .post(path)
        .then()
            .log().all()
            .assertThat()
            .statusCode(201)
            .extract()
            .path("id");

        return id;
    }

    public void testStatusCode200(String path){
        String tokenPassword = token.getTokenPassword();
        config.executeConfigResourceServer();
        given()
            //.auth().preemptive().oauth2(tokenPassword)
            .header("Authorization", "Bearer " + tokenPassword)
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