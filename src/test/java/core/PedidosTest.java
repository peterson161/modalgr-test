package core;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONException;

import static io.restassured.RestAssured.*;

public class PedidosTest {

    public static void main(String[] args) {
        System.out.println(Token.getToken());
    }
}
