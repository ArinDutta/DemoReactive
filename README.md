# This is a sample application that deals with Spring Web Flux and Reactive Redis Template. 

The application used Redis as a database. It has four different API by which you read, write and delete the data from the redis.

# API to save employee data in Redis:- 
/demo/employee 
Example:- $curl -X PUT -H "Content-Type: aplication/json" -d "{/"empName/":/"Arin/",/"empId/":/"101/",/"dept/":/"IT/"}" http://localhost:8080/demo/employee

# API to retrieve  the employee details from Redis based on employee ID: 
/demo/employee/{empId}  
Example: $curl -X GET  http://localhost:8080/demo/employee/101

# API to retrieve all the employee information from the redis : 
/demo/employee/all/details  
Example: $curl -X GET http://localhost:8080/demo/employee/all/details

# API to delete employee details based on employee ID: 
/demo/employee/{empId}/delete  
Example: $curl -X DELETE http://localhost:8080/demo/employee/101/delete

