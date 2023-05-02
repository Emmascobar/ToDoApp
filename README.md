# SIMPLE TO DO APP
 
## How to configure

1) "To Do APP" used SQL database, so required configure an instance and schema in MySQL with the name "task_list", this will be database saving routes. Remember, these route will be the route that you need insert in your file="applicattionpropierty" too.

2) Run the program to give permission to the controller routes to make changes.

3) The Controller routes can be used and tested using templates provide by Thymeleaf (normally port 8080 on localhost), altought also can be use other HTTP request and test programme. 

## Routes:
- localhost:8080/index : Homepage.
- localhost:8080/tasks :  view all tasks list. In this page you can able also search, update or delete an existing task.
- localhost:8080/add-task : view the form to add a new task in database.
- localhost:8080/update-form/{id} : view an exist task to modificate it.
- localhost:8080/user-form : view the form to add a new user in database.

In futures updates will be possible add the suffix user/ or admin/ to each routes to give previous authentication and security to routes.


## Specifications
With the correct use of TO DO APP, you will be able to:
- Creater User: "Admins" and "Regular Users". 
- Create Task To Do: where you can assing a determinate task to a specific user. Is necesary user exist previously to will can asignate a new task.
- View all task on "Task list": where you can view determinate data of every task and user and you can use filters and sort every column, as well as, edit or eliminate the task you want.

Normally, a Specific User only can modificate or delete your own task, as well as, admins are the only can create new user. In this case for a little bit of time these optiones will be desativates. We're sorry for the inconvinience. I hope to add that and also other details as soon as posible.


## Main technologies used:
- Java / Spring / SpringBoot : to write the API code by using the libraries provided by both frameworks.
- JPA: to map and relate the API with the database.
- SQL: to review and administrate the database.
- Thymeleaf: to build a modern server-side Java template engine (View-Mode) for web in HTML.


## Information for Devs:
- The API code is written with the naming conventions, among others, we use PascalCase for the name of Models, and their homonyms in SQL with snake_case. It's suggested for future modifications follows the same convention to keep clean the project.
- The root model of the repository, controllers, models and services were correctly organized in different packages, giving the possibility to future updates and allow growth of the project, which will facilitate the development of the API architecture.

I am at your disposal for any questions that you may have about them.
Thanks for reading to the end!

## App done by:
- [Emmanuel Escobar](https://github.com/Emmascobar)
