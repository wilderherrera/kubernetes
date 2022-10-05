## Instrucciones para compilacion
####  Corra el siguiente comando ```./gradlew clean build ```  para compilar el proyecto
##   Instrucciones para creacion de imagen Docker
####  Corra el siguiente comando ```docker build  . ```  para crear la imagen de Docker
####  Corra el siguiente comando ```docker push ```  para cargar la imagen a DockerHub
##   Instrucciones para levantar el cluster k8s
#### Cree el secret para la conexion del microservicio con la base de datos
#### ``` kubectl create secret generic ms-users-database-conection --from-literal=DATABASE_HOST=54.165.78.242 --from-literal=DATABASE_PASSWORD=root --from-literal=DATABASE_USER=root ```
#### Aplique los archivos de configuracion de kubernetes al cluster
#### ```cd kubernetes && kubectl apply -f . ```
#### Dentro del folder ```kubernetes``` se encuentran 4 archivos yaml que permite crear los pods dentro del k8s ademas de las configuraciones necesarias para el acceso al microservicio.
## Estrategias de log
#### Actualmente el microservicio cuenta con tres niveles de logs info,debug y trace usted puede activar el nivel requerido haciendo uso del siguiente endpoint
#### ```Post -> /actuator/loggers/com.ms.ms_user```
#### Body```{"configuredLevel": "trace"}```  Segun el nivel de logs requerido