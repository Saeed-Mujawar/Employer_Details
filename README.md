<h1 align="center"> Employer Details</h1>

>### Framework  
* [SpringBoot](javatpoint.com/spring-boot-tutorial)
>### Language 
* [Java](https://www.java.com/en/download/help/whatis_java.html)
>## Data flow
In this project, we have four layers-
* **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer.
* **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
* **Repository** - This layer mainatains the h2-database thing on which CRUD operations are performed
* **Model** - This layer consists basically the class level things- the various classes required for the project and these classes consists the attributes to be stored.

>## Data Structure used in my project
This document outlines the steps to create a Job Search Portal 
Job model will have-
* Id
* title
* description
* location
* salary
* companyName
* employerName
* JobType
* appliedDate

NOTE : use H2 database

>## Project Summary
This project contains variou crud operations using inbuilt @CrudRepo methods ,custom get methods using our own custom finders (No implementations, correct queries should be fired based on method names) and write operations (update and delete) using Custom queries (using @Query) 
