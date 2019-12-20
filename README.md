# This is a sample application that deals with Spring Web Flux and Reactive Redis Template. 

The application used Redis as a database. It has four different API by which you read, write and delete the data from the redis.

API 1:- /demo/employee This API will save the employee data in Redis.

Example:- $curl -X PUT -H "Content-Type: aplication/json" -d "{/"empName/":/"Arin/",/"empId/":/"101/",/"dept/":/"IT/"}" http://localhost:8080/demo/employee

API 2: /demo/employee/{empId}  

Example: $curl -X GET  http://localhost:8080/demo/employee/101

API 3: /demo/employee/all/details  This API will retrieve all the employee information from the redis.

Example: $curl -X GET http://localhost:8080/demo/employee/all/details

API 4: /demo/employee/{empId}/delete  This API will retrieve the employee information based on the Employee ID

Example: $curl -X DELETE http://localhost:8080/demo/employee/101/delete

