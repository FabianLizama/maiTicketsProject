# FingesoProject

Para iniciar el proyecto es necesario inicializar la base de datos, el backend y el frontend por separado, los pasos a seguir son los siguientes:

Instalar PostgreSQL v15.3

Crear la base de datos vacía con el archivo dbCreate.sql

Modificar el archivo:
\api\src\main\resources\application.properties

 	Ingresar el enlace de conexión a la base de datos según el puerto que se asignó al instalar PostgreSQL:
	spring.datasource.url = jdbc:postgresql://localhost:5432/maiticketsdb

 	Cambiar credenciales de conexión:
 	spring.datasource.username = postgres
	spring.datasource.password = 123

	Y el puerto donde se construirá el backend si es necesario:
 	server.port = 8081

Iniciar la clase principal del backend con ruta:
\api\src\main\java\xyz\yoandroide\persona\PersonaBackendApplication.java

Para iniciar el frontend se deben utilizar los siguientes comandos en una terminal ubicada dentro de /landing/:

npm install

npm run dev
