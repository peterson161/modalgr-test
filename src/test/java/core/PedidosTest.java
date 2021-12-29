package core;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.Cliente;
import model.Pedido;

import org.junit.Test;
import util.TestStatusCode;

import java.time.LocalTime;

public class PedidosTest {

    private static final String PATH = "/pedidos";

    private Cliente cliente = new Cliente();
    private Pedido pedido = new Pedido();
    private TestStatusCode testStatusCode = new TestStatusCode();

    private void setPedido(){
        cliente.setId(3L);

        pedido.setCliente(cliente);
        pedido.setNumero("PED11:12:27.136");
        pedido.setFormaPagamento("a prazo");
    }

    @Test
    public void testGivenATokenWhenGetThenStatusCode200() {
        testStatusCode.testStatusCode200(PATH + "/4");
    }

    @Test
    public void testGivenANewPedidoWhenPostThenStatusCode201() throws JsonProcessingException {
        setPedido();
        testStatusCode.testStatusCode201(pedido, PATH);
    }

    @Test
    public void testGivenATokenWhenGetThenStatusCode204(){
        testStatusCode.testStatusCode204(PATH + "/14");
    }

    @Test
    public void testGivenAPedidoWhenPutThenStatusCode200() throws JsonProcessingException {
        setPedido();
        testStatusCode.testStatusCode200(pedido, PATH + "/17");
    }
}
