package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import model.Cliente;
import model.Pedido;
import support.data.DataYaml;
import util.TestStatusCode;

import java.util.HashMap;
import java.util.Map;

public class PedidosSteps {

    private TestStatusCode testStatusCode;
    private Cliente cliente;
    private Pedido pedido;

    public PedidosSteps(){
        testStatusCode = new TestStatusCode();
        cliente = new Cliente();
        pedido = new Pedido();
    }

    private void setPedido(String numeroPedido, Long idCliente){
        cliente.setId(idCliente);
        pedido.setCliente(cliente);
        pedido.setNumero(numeroPedido);
        pedido.setFormaPagamento("a prazo");
    }

    private String getLastId(){
        Map map = new HashMap();
        map = DataYaml.getMapYamlValues("Pedidos", "pedido");
        return map.get("ultimo_id").toString();
    }

    private void setLastId(String id){
        Map map = new HashMap();
        map.put("ultimo_id", id);
        DataYaml.setMapYamlValues("Pedidos","pedido", map);
    }

    @Then("I perform POST operation sending a new order number {string} with client id {string} in {string}")
    public void iPerformPOSTOperationSendingANewOrderNumberWithClientIdIn(String orderNumber, String clientId, String path) throws JsonProcessingException {
        setPedido(orderNumber, Long.parseLong(clientId));
        int id = testStatusCode.testStatusCode201(pedido, path);
        setLastId(String.valueOf(id));
    }

    @Then("I perform PUT operation sending order number {string} with client id {string} on last order id in {string}")
    public void iPerformPUTOperationSendingOrderNumberWithClientIdOnLastOrderIdIn(String orderNumber, String clientId, String path) throws JsonProcessingException {
        setPedido(orderNumber, Long.parseLong(clientId));
        testStatusCode.testStatusCode200(pedido, path + "/" + getLastId());
    }

    @Given("I perform GET operation in {string}")
    public void iPerformGETOperationIn(String path) {
        testStatusCode.testStatusCode200(path);
    }

    @And("I perform GET operation for order id {string}")
    public void iPerformGETOperationForOrderId(String path) {
        testStatusCode.testStatusCode200(path);
    }

    @And("I perform GET operation for order number {string}")
    public void iPerformGETOperationForOrderNumber(String path) {
        testStatusCode.testStatusCode200(path);
    }

    @And("I perform GET operation for client name {string}")
    public void iPerformGETOperationForClientName(String path) {
        testStatusCode.testStatusCode200(path);
    }

    @Then("I perform GET operation for client identification {string}")
    public void iPerformGETOperationForClientIdentification(String path) {
        testStatusCode.testStatusCode200(path);
    }

    @Then("I perfom DELETE operation to last order inserted em {string}")
    public void iPerfomDELETEOperationToLastOrderInsertedEm(String path) {
        testStatusCode.testStatusCode204(path + "/" + getLastId());
        int lastId = Integer.parseInt(getLastId()) - 1;
        setLastId(String.valueOf(lastId));
    }
}
