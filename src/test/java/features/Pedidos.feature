Feature:
  Verify results using Pedidos

  Scenario: Perform POST
    Then I perform POST operation sending a new order number "PED21:47" with client id "2" in "/pedidos"

  Scenario: Perform PUT
    Then I perform PUT operation sending order number "PED21:35" with client id "4" on last order id in "/pedidos"

  Scenario: Perform GET
    Given I perform GET operation in "/pedidos"
    And I perform GET operation for order id "/pedidos/8"
    And I perform GET operation for order number "/pedidos?numero=PED21:35"
    And I perform GET operation for client name "/pedidos?nomeCliente=Sueli"
    Then I perform GET operation for client identification "/pedidos?documentoCliente=59541672000238"

  Scenario: Perform DELETE
    Then I perfom DELETE operation to last order inserted em "/pedidos"