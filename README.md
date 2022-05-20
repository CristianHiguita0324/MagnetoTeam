# Magneto Team Recruiter - Examen Mercado Libre

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.

Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.

Para eso te ha pedido crear un programa con un método o función con la siguiente firma (En alguno de los siguiente lenguajes: Java / Golang / C-C++ / Javascript (node) / Python / Ruby):

boolean isMutant(String[] dna); // Ejemplo Java

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: **(A,T,C,G)**, las cuales representa cada base nitrogenada del ADN.

//IMAGEN DNA

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.

Ejemplo (Caso mutante): **String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}; **

En este caso el llamado a la función isMutant(dna) devuelve “true”.

Desarrolla el algoritmo de la manera más eficiente posible.

# Solución Al Problema

**Nivel 1 y Nivel 2**

- Endpoint **mutant** determina si una secuencia de ADN es mutante o humano: LINK ENDPOINT

- Se puede usar el siguiente **CURL** para comprobar una cadena de ADN, ejemplo: CURL

- Adicional se puede usar la documentación de Sprintdocs para consumir los servicios: LINK SWAGGER
//IMAGEN SWAGGER

---

**Nivel 3**

- Endpoint **stats** obtiene las estadisticas de las verificaciones de ADN: LINK ENDPOINT

- Se puede usar el siguiente **CURL** para obtener las estadisticas, ejemplo: CURL

- Adicional se puede usar la documentación de Sprintdocs para consumir los servicios: LINK SWAGGER
//IMAGEN SWAGGER

- Endpoint de base de datos donde se puede consultar los registros guardados de las cadenas procesadas: LINK H2
//IMAGEN H2

# Stack Tecnologico Solución
- OpenJDK 18
- Spring Framework 2.6.7
- Apache Tomcat (Embebido)
- JPA (Persistencia de Datos)
- Base de Datos H2 (En Memoria)
- Maven (Gestión y Construcción de Proyectos)
- Docker (Para Despliegue en AWS)
- AWS Elastic Container Service (Alojamiento En Nube)

# Configuración y Ejecución
Se debe contar con una intalacion de la version 18 de OpenJDK o JAVA; Posterior a eso se debe clonar el proyecto de la rama main https://github.com/daecheve90/MagnetoTeam.git; Se debe ingresar a la raiz del proyecto y abrir una terminal.
//IMAGEN RAIZ
Y ejecutar el siguiente comando, para construir el .jar ejecutable y generar el reporte de pruebas unitarias.
- En LINUX: JAVA_HOME=/usr/lib/jvm/default /usr/lib/netbeans/java/maven/bin/mvn clean install
- En WINDOWS: COMANDO WINDOWS

//IMAGEN COMPILACION

Finalizada la compilación, se debe ingresar a la carpeta **/MagnetoTeam/target** dentro de esta, se encuenta el archivo **MagnetoTeam-1.0.jar** abrir una consola y correr el proyecto con el comando **java -jar MagnetoTeam-1.0.jar** se iniciara el proyecto, y evidenciara en la terminal que se encuentra corriendo.

//IMAGEN SPRING CORRIENDO

# Documentación Servicios
En el siguiente endpoint //LINK SWAGGER se puede visualizar la documentación de todos los servios web disponibles, sus métodos, parametros de entrada, ejemplos de objetos de respuesta, entre otros.

//IMAGEN SWAGGER GENERAL

# Cobertura Pruebas Unitarias
Cuando se compila y construye el proyecto, las pruebas unitarias se ejecutan automaticamente, generando una carpeta donde queda el reporte total; La ruta es la siguiente **MagnetoTeam/target/site/jacoco/index.html**
//IMAGEN RUTA JACOCO
//IMAGEN REPORTE
