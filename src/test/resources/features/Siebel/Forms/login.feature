# language: es
@manual
Característica: Realizar inicio de sesión en aplicación Siebel
  Como un usuario
  Quiero realizar login en la aplicación Siebel

  Esquema del escenario: Realizar inicio de sesion en Siebel
  Dado  Que estoy en el inicio de la aplicacion Siebel
  Cuando ingrese las credenciales de accceso "<usuario>" y "<contrasena>"
  Entonces el login será exitoso

  Ejemplos:
      | usuario   | contrasena |
      | parendon | 10Cibercafeopen2018 |




