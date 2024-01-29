Proyecto montado con Spring Boot y Java 17, con los siguientes frameworks / libraries / funcionalidades:

 - Spring Boot: versión 3. posibilidad de arrancar directamente con el plugin de maven o generar un war para despliegue en 
 tomcat o similar. Con 'actuator' activado.

 - Servicio completo RESTful con Spring 6 (Books)

 - Documentado servicio con Swagger 3

 - Capa de base de datos con h2

 - Spring Exception Handling en los controllers

 - Test de integración completos (mockeando el service)

 - Spring Security
 
 - El script de la base de datos se ejecuta automaticamente al ejecutar el proyecto el cual se encuentra en el resources/data.sql


Requisitos:

 - Maven (instalado y configurado)


Comandos

 - Arrancar directamente con el plugin de SpringBoot:
 
    ```
    mvn spring-boot:run
    ```
  
  
 - Generar war, ejecutando test unitarios (así como generar informes de jacoco):
 
    ```
    mvn clean package
    ```


Urls de acceso:

 - Swagger check -> http://localhost:8080/v3/api-docs?group=books-api

 - Swagger UI    -> http://localhost:8080/doc/swagger-ui.html

 - Spring Boot actuator endpoints:

     http://localhost:8080/auth/get/{email}

     http://localhost:8080/auth/save

     http://localhost:8080/auth/login
     
     http://localhost:8080/auth/saveFormatPassword
 
