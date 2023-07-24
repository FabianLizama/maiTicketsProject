# FingesoProject

Para iniciar el proyecto es necesario inicializar la base de datos, el backend y el frontend por separado, los pasos a seguir son los siguientes:

## Base de Datos
Instalar PostgreSQL v15.3

Crear la base de datos vacía con el archivo dbCreate.sql
Las tablas se crearán y se llenarán con la base de datos de prueba automáticamente, para cancelar la carga de datos se puede cambiar la siguiente linea de código en el archivo:
```sh
\api\src\main\resources\application.properties
```
```sh
spring.jpa.defer-datasource-initialization=true
```

## Backend

Modificar el archivo:

```sh
\api\src\main\resources\application.properties
```
 Ingresar el enlace de conexión a la base de datos según el puerto que se asignó al instalar PostgreSQL:
```sh
spring.datasource.url = jdbc:postgresql://localhost:5432/maiticketsdb
```
Cambiar credenciales de conexión:
```sh
spring.datasource.username = postgres
spring.datasource.password = 123
```
Y el puerto donde se construirá el backend si es necesario:
```sh
server.port = 8081
```
Iniciar la clase principal del backend con ruta:
```sh
\api\src\main\java\xyz\yoandroide\persona\PersonaBackendApplication.java
```

## Frontend
Para iniciar el frontend se deben utilizar los siguientes comandos en una terminal ubicada dentro de /landing/:
```sh
npm install
```
```sh
npm run dev
```
