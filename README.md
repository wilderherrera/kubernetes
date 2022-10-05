## Instrucciones para compilacion
####  <h3> Corra el siguiente comando ```./gradlew clean build ```  para compilar el proyecto<h3>
##   Instrucciones para creacion de imagen Docker
####  <h3> Corra el siguiente comando ```docker build -t wilderherrera10/ms-users:v1 . ```  para crear la imagen de Docker
####  <h3> Corra el siguiente comando ```docker push wilderherrera10/ms-users:v1 ```  para cargar la imagen a DockerHub
##   Instrucciones para levantar el cluster k8s
#### ```cd kubernetes && kubectl apply -f . ```
### Dentro del folder ```kubernetes``` se encuentran 4 archivos yaml que permite crear los pods dentro del k8s ademas de las configuraciones necesarias para el acceso al microservicio.