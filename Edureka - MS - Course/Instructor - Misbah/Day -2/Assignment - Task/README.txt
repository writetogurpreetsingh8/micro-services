There are 6 different micro-services out of 1 is eureka-server!

How to execute ?

1) Start eureka-server 	= mvn spring-boot:run
2) Start stock-ms 		= mvn spring-boot:run
3) Start sunhome-ms 	= mvn spring-boot:run   -> http://localhost:8005/sunhome-ms/swagger-ui.html
4) Now Start remaining ms........

I have implemented Swagger in each ms but sunhome-ms is the main ms to go through all the functionality!
I am using in-memory database for inital data-set , stock-ms is responsible to create and store the data => http://localhost:8004/stock-ms/h2-console/

 
