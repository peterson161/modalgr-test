package core;

import model.UserLogin;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

public class Config {

    private static final String BASE_URI  = "http://auth.modalgrpedidos.local";
    private static final int PORT = 8082;
    public UserLogin userLogin = new UserLogin();
    public void execute(){
        userLogin.setLogin("modalgrcredentials");
        userLogin.setSenha("modalgrcredentials123");
        baseURI=BASE_URI;
        port=PORT;
    }
}
