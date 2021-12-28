package core;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import model.Cliente;
import model.Pedido;

import org.junit.Test;
import util.Utilities;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static io.restassured.RestAssured.*;

public class PedidosTest {

    private Utilities utilities = new Utilities();
    private Cliente cliente = new Cliente();
    private Pedido pedido = new Pedido();
    private Token token = new Token();
    private Config config = new Config();

    private void setPedido(){
        cliente.setId(2L);

        pedido.setCliente(cliente);
        pedido.setNumero("P" + LocalTime.now());
        pedido.setFormaPagamento("a prazo");
    }

    @Test
    public void testGivenATokenWhenGetThenStatusCode200() throws JsonProcessingException {
        String tokenPassword = token.getTokenPassword();
        config.execute_config_resource_server();
        given()
            .auth().preemptive().oauth2(tokenPassword)
        .when()
            .get("/pedidos/15")
        .then()
            .log().all()
            .assertThat()
            .statusCode(200);
    }

    @Test
    public void testGivenANewPedidoWhenPostThenStatusCode201() throws JsonProcessingException {
        setPedido();
        String tokenPassword = token.getTokenPassword();
        config.execute_config_resource_server();
        given()
            .auth().preemptive().oauth2(tokenPassword)
            //.header("Authorization", tokenPassword)
            .body(utilities.entityToJson(pedido))
                //.body("")
            .contentType(ContentType.JSON)
        .when()
            .post("/pedidos")
        .then()
            .log().all()
            .assertThat()
            .statusCode(201);
    }
}
