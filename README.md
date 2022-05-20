# Magneto Team Recruiter - Examen Mercado Libre

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.

Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.

Para eso te ha pedido crear un programa con un método o función con la siguiente firma (En alguno de los siguiente lenguajes: Java / Golang / C-C++ / Javascript (node) / Python / Ruby):

boolean isMutant(String[] dna); // Ejemplo Java

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: **(A,T,C,G)**, las cuales representa cada base nitrogenada del ADN.

![image](https://github.com/daecheve90/MagnetoTeam/blob/develop/Docs/dna.png)

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.

Ejemplo (Caso mutante): **String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}; **

En este caso el llamado a la función isMutant(dna) devuelve “true”.

Desarrolla el algoritmo de la manera más eficiente posible.

# Solución Al Problema

**Nivel 1 y Nivel 2**

- Endpoint **mutant** determina si una secuencia de ADN es mutante o humano: http://184.73.16.225:8080/mutant

- Se puede usar el siguiente **CURL** para comprobar una cadena de ADN, ejemplo: 

**curl -X 'POST' 'http://184.73.16.225:8080/mutant' -H 'accept: application/json' -H 'Content-Type: application/json' -d '[ "CTGCGA","CCGTGC","TTCTGT","AGCAGG","CCCCTA","TCACTG" ]'**

- Adicional se puede usar la documentación de Sprintdocs para consumir los servicios: http://184.73.16.225:8080/swagger-ui/index.html

![image](https://github.com/daecheve90/MagnetoTeam/blob/develop/Docs/mutant_swagger.png)

---

**Nivel 3**

- Endpoint **stats** obtiene las estadisticas de las verificaciones de ADN: http://184.73.16.225:8080/stats

- Se puede usar el siguiente **CURL** para obtener las estadisticas, ejemplo:

**curl -X 'GET' 'http://184.73.16.225:8080/stats' -H 'accept: application/json'**

- Adicional se puede usar la documentación de Sprintdocs para consumir los servicios: http://184.73.16.225:8080/swagger-ui/index.html

![image](https://github.com/daecheve90/MagnetoTeam/blob/develop/Docs/stats_swagger.png)

- Endpoint de base de datos donde se puede consultar los registros guardados de las cadenas procesadas: http://184.73.16.225:8080/h2-console/login.jsp?jsessionid=8ec3791a8876f5fb41b211d215c35f3f

Usar las siguientes credenciales:
- **JDBC URL:** jdbc:h2:mem:magnetoTeamDb
- **User Name:** daecheve
- **Password:** turtoise

![image](https://github.com/daecheve90/MagnetoTeam/blob/develop/Docs/h2_login.png)

![image](https://github.com/daecheve90/MagnetoTeam/blob/develop/Docs/h2.png)

# Stack Tecnologico Solución
- OpenJDK 18
- Spring Framework 2.6.7
- Apache Tomcat (Embebido)
- JPA (Persistencia de Datos)
- Base de Datos H2 (En Memoria)
- Maven (Gestión y Construcción de Proyectos)
- Docker (Para Despliegue en AWS)
- AWS Elastic Container Service (Alojamiento En Nube)

Se usa Arquitectura Limpia para construir la aplicación, con el objetivo de desacoplar los componentes, y que la logica de negocio no dependa del framework y del motor de la base de datos, por lo tanto se puede evidenciar 3 capas.

- **Infraestructure:** Capa donde se hacen las configuraciones iniciales del aplicativo, utilizando funciones propias de Spring, configuración del motor de persistencia JPA y entidades de base de datos.
- **Adapter:** Capa intermedia que sirve como puente entre la infraestructura y el core de negocio, se usa para realizar las traducciones necesarias; Capa no dependiente del framework
- **Core:** Capa raiz del aplicativo, donde se encuentra toda la logica de negocio, y su interaccion con las capas superiores se hacen por medio de interfaces; Capa no dependiente del framework

# Configuración y Ejecución
Se debe contar con una intalacion de la version 18 de OpenJDK o JAVA; Posterior a eso se debe clonar el proyecto de la rama main https://github.com/daecheve90/MagnetoTeam.git; Se debe ingresar a la raiz del proyecto y abrir una terminal.
//IMAGEN RAIZ
Y ejecutar el siguiente comando, para construir el .jar ejecutable y generar el reporte de pruebas unitarias.
- En LINUX: JAVA_HOME=/usr/lib/jvm/default ../Maven/bin/mvn clean install
- En WINDOWS: COMANDO WINDOWS

![image](https://github.com/daecheve90/MagnetoTeam/blob/develop/Docs/compilation_root.png)

Finalizada la compilación, se debe ingresar a la carpeta **/MagnetoTeam/target** dentro de esta, se encuenta el archivo **MagnetoTeam-1.0.jar** abrir una consola y correr el proyecto con el comando **java -jar MagnetoTeam-1.0.jar** se iniciara el proyecto, y evidenciara en la terminal que se encuentra corriendo.

![image](https://github.com/daecheve90/MagnetoTeam/blob/develop/Docs/spring_run.png)

# Documentación Servicios
En el siguiente endpoint http://184.73.16.225:8080/swagger-ui/index.html se puede visualizar la documentación de todos los servios web disponibles, sus métodos, parametros de entrada, ejemplos de objetos de respuesta, entre otros.

![image](https://github.com/daecheve90/MagnetoTeam/blob/develop/Docs/swagger.png)

# Cobertura Pruebas Unitarias
Cuando se compila y construye el proyecto, las pruebas unitarias se ejecutan automaticamente, generando una carpeta donde queda el reporte total; La ruta es la siguiente **MagnetoTeam/target/site/jacoco/index.html**

![image](https://github.com/daecheve90/MagnetoTeam/blob/develop/Docs/jacoco.png)
![image](https://github.com/daecheve90/MagnetoTeam/blob/develop/Docs/jacoco_report.png)

# Consideraciones Adicionales
- El API se encuentra expuesta, y cualquiera puede hacerle peticiones y obtener respuestas; En otras condiciones se podria implementar un servicio de autenticación y seguridad utilizando alguna herramienta como JWT, creando un servicio de login que devuelva un token que serviria de autenticacion para ser incluido en los Headers de la aplicación.
- En ambientes productivos, se podria monitorear el estado de carga de los servidores que contienen el Aplicativo, y llegado a superar cierto umbral, se podria empezar a negar peticiones con codigo HTTP 429, para asi evitar que el sevicio caiga, o hacer un ajuste a los servidores para obtener mas recursos, y asi cubrir la demanda.
