@newProduct
Feature: Creación exitosa de producto

  Scenario: Creación de nuevo producto
    Given   Usuario elige  nuevo producto
    When    Usuario ingresa los datos del nuevo producto
    And     realiza la personalización del producto
    Then    El producto se crea exitosamente

