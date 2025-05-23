# Usa una imagen base de Java 17
FROM openjdk:17-jdk-slim

# Copia todos los archivos del proyecto al contenedor
COPY . /app

# Establece el directorio de trabajo
WORKDIR /app

# Da permisos ejecutables al archivo mvnw
RUN chmod +x mvnw

# Compila el proyecto con Maven, saltando los tests
RUN ./mvnw clean install -DskipTests

# Expone el puerto 8080 (Render lo usará dinámicamente)
EXPOSE 8080

# Comando para iniciar la aplicación
CMD [\
java\, \-jar\, \target/saberproapp-0.0.1-SNAPSHOT.jar\]
