# This is a sample application that deals with Spring Web Flux and Reactive Redis Template. It used Redis as a database. It has four different API by which you read, write and delete the data from the redis.

# API 1:- /demo/employee This API wills ave the data in Redis.
Example:- $curl -X PUT -H "Content-Type: aplication/json" -d "{/"empName/":/"Arin/",/"empId/":/"101/",/"dept/":/"IT/"}"
