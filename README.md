tmgusers-app
============

CRUD Users with AngularJS and Spring

How to run a web app directly from the command line with jetty-runner: java -jar jetty-runner.jar tmgusers.war

- Web Url: http://localhost:8080/tmgusers
- Url RESTful: 
  - getting all users, GET : http://localhost:8080/tmgusers/api/user/list 
  - get/delete user by id, GET/DELETE : http://localhost:8080/tmgusers/api/user?id={id}
  - create/update user, POST/PUT : http://localhost:8080/tmgusers/api/user

Tools and technologies used :
  - Eclipse Project with Maven.
  - JDK 1.7
  - Spring
  - AngularJS
  - Bootstrap
  - JQuery
  - MyBatis
  - JUnit:
    - RestClientTest.java
    - TmgUsersServiceTest.java
