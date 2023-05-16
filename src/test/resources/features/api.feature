Feature: API

@METODOS
 Scenario: Ejecutar método GET
  Given abro la pagina PetStore
  And presiono boton findByStatus
 And presiono boton tryinout
 And presiono boton execute
 Then valido que el codigo de respuesta sea 200