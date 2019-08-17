@duo
Feature: Creación exitosa de personalición para un producto DUO

  Scenario: Creación exitosa de personalición para un producto DUO
    Given   Usuario elige  nuevo producto
    When    Usuario ingresa los datos del nuevo producto
    And     realiza la personalización del producto
    Then    El producto se crea exitosamente

