package core;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

public class Config {

    private static final String BASE_URI_TOKEN  = "http://auth.modalgrpedidos.local";
    private static final int PORT_TOKEN = 8082;

    private static final String BASE_URI_DATA  = "http://api.modalgrpedidos.local";
    private static final int PORT_DATA = 8081;

    public void execute_config_authorization_server(){
        baseURI=BASE_URI_TOKEN;
        port=PORT_TOKEN;
    }

    public void execute_config_resource_server(){
        baseURI=BASE_URI_DATA;
        port=PORT_DATA;
    }
}
