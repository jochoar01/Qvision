@newOffer
Feature: Creacion de oferta

  Scenario: Creacion y configuracion de una oferta
    Given   Usuario elige nueva oferta
    When    Usuario ingresa los datos necesarios de la oferta
    Then    La oferta se crea exitosamente


