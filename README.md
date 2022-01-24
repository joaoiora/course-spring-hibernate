    # Spring & Hibernate Course for Beginners

Repository created to keep track of every code developed while taking the [Spring & Hibernate Course](https://www.udemy.com/course/spring-hibernate-tutorial/).

For each section of the course content, a project was created and sequentially identified. All projects are modules defined in the parent POM file, except for the Spring Boot ones.

Course Content:
- **Spring Core** - Inversion of Control, Dependency Injection, Bean Scopes and Lifecycle
  - Spring IoC & DI usage with XML configuration
    - [01-spring-core-ioc-di-xml](https://github.com/joaoiora/spring-hibernate-course/tree/main/01-spring-core-ioc-di-xml) 
  - Spring IoC & DI usage with Annotations
    - [02-spring-core-ioc-di-annotations](https://github.com/joaoiora/spring-hibernate-course/tree/main/02-spring-core-ioc-di-annotations) 
  - Spring IoC & DI usage with pure Java
    - [03-spring-core-ioc-di-java](https://github.com/joaoiora/spring-hibernate-course/tree/main/03-spring-core-ioc-di-java)
- **Spring MVC**
  - Views, Controllers and Form Validation
    - [04-spring-mvc](https://github.com/joaoiora/spring-hibernate-course/tree/main/04-spring-mvc)
- **Hibernate**
  - Spring Configuration, CRUD Features and Mappings examples.
    - [05-hibernate](https://github.com/joaoiora/spring-hibernate-course/tree/main/05-hibernate)
- **Spring MVC with Hibernate**
  - Using Hibernate on previous Spring MVC project
    - [06-spring-mvc-hibernate](https://github.com/joaoiora/spring-hibernate-course/tree/main/06-spring-mvc-hibernate)
  - Spring MVC + Hibernate with access to data from more than one datasource
    - [07-spring-mvc-hibernate-multi-datasource](https://github.com/joaoiora/spring-hibernate-course/tree/main/07-spring-mvc-hibernate-multi-datasource)
- **Spring AOP**
  - Introduction to Aspect-Oriented Programming and how to use expressions to execute code with `@Pointcut` expressions alongside `@Before` and `@Order` annotations
    - [08-spring-aop](https://github.com/joaoiora/spring-hibernate-course/tree/main/08-spring-aop)
  - Examples of `@Pointcut` expressions on `@Before` annotation for execution of `JoinPoint` methods.
    - [09-spring-aop-joinpoint](https://github.com/joaoiora/spring-hibernate-course/tree/main/09-spring-aop-joinpoint)
  - Examples of `@Pointcut` expressions alongside `@After`, `@AfterReturning` and `@AfterThrowing` annotations on `JoinPoint` methods.
    - [10-spring-aop-after-advices](https://github.com/joaoiora/spring-hibernate-course/tree/main/10-spring-aop-after-advices)
  - Examples of `@Pointcut` expressions on `@Around` annotation with `ProceedingJoinPoint` methods.
    - [11-spring-aop-around-advice](https://github.com/joaoiora/spring-hibernate-course/tree/main/11-spring-aop-around-advice)
  - Combined examples of AOP on a Spring MVC + Hibernate webapp
    - [12-spring-mvc-hibernate-aop](https://github.com/joaoiora/spring-hibernate-course/tree/main/12-spring-mvc-hibernate-aop)
- **Spring MVC + Spring Security**
  - a
    - [13-spring-mvc-security](https://github.com/joaoiora/spring-hibernate-course/tree/main/13-spring-mvc-security)
- **Spring REST**
  - Introduction to REST Controller mappings: `@RestController`, `@GetMapping`, `@PostMapping`) and `@ExceptionHandler`
    - [14-spring-resto](https://github.com/joaoiora/spring-hibernate-course/tree/main/14-spring-rest)
- **Spring CRM App with Hibernate + Security + MVC + REST**
  - CRM CRUD webapp using Hibernate for persistence and Spring Security for authentication and authorization of REST API queries
    - [15-spring-crm-rest](https://github.com/joaoiora/spring-hibernate-course/tree/main/15-spring-crm-rest)
- **Spring Boot**
  - Simple Spring Boot app with a Hello World REST Controller
    - [16-spring-boot-demo](https://github.com/joaoiora/spring-hibernate-course/tree/main/16-spring-boot-demo)
  - Spring Boot + Data CRUD with REST Controller
    - [17-spring-boot-crud](https://github.com/joaoiora/spring-hibernate-course/tree/main/17-spring-boot-crud)
  - Sprign Boot + Data using `@RepositoryRestResource` for exporting REST mappings.
    - [18-spring-boot-rest-crud](https://github.com/joaoiora/spring-hibernate-course/tree/main/18-spring-boot-rest-crud)
