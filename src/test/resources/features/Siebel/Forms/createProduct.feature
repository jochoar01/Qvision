# language: es
@newProduct
Característica: Personalización de producto en la oferta

  Esquema del escenario:  Personalización producto individual
    Dado   que un usuario tiene una oferta creada
    Cuando crea un nuevo producto "<nombreDelProducto>" con tecnologia "<tipoTecnologia>" uso "<uso>"
    Y      realiza la personalizacion con  plan "<plan>"
    Entonces  el producto es personalizado

    Ejemplos:
      | nombreDelProducto   | tipoTecnologia | uso | plan |
      | Television_Hogares| HFC  | Residencial |   4   |




