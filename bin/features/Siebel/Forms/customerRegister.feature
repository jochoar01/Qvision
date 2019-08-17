@newClient
Feature: Registro de cliente

  Scenario: Creación exitosa de nuevo cliente
    Given   Usuario elige nuevo
    When    Usuario ingresa los datos del nuevo cliente
    Then    El usuario se crea exitosamente


