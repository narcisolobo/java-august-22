# Week 1, Day 5 AM - Spring Boot, Routing, Route Variables

## Learning Objectives
- Spring Overview
- Introduction to Spring Boot
- Configuring and Setting Up Spring Boot
- Annotations and Routing
- Extracting Values from the Route

### What is the Spring Framework?
The Spring framework is an open-source collection of modules for creating applications in Java. Web applications created with the Spring MVC module primarily use dependency injection to achieve Inversion of Control (IoC). IoC is at the core of every module in the Spring framework. We will be using dependency injection throughout our web applications, especially with the use of Spring's annotations.

Further reading: [Intro to Inversion of Control and Dependency Injection with Spring](https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring)

### What is Spring Boot?
Spring Boot is a tool that makes developing applications with the Spring framework faster and easier. It autoconfigures our applications, resulting in a more opinionated architecture.

### Configuring and Setting Up Spring Boot
Before starting our first web app, we must first install Apache Maven. Follow the instructions on the platform for your OS.

[The platform has excellent instructions](https://login.codingdojo.com/m/315/9532/64268) for starting up a web app in Spring Boot. STS remembers your last configuration and most used dependencies, which is very helpful.

### Annotations
Spring has an extensive library of annotations which will help us at every level of our web applications, as you'll soon see. The first ones we'll use are `@RestController` and `@Controller`, which we will use to designate our controller classes' methods as route handlers.

The route handling methods in these classes will have appropriate annotations as well - `@RequestMapping`, `@GetMapping`, `@PostMapping`, `@PutMapping`, and `@DeleteMapping`.

The first thing you should do to make sure everything is wired up correctly is to create a handler method with a `@GetMapping` annotation, start up your server, and visit the route in your browser.

### Extracting Values from the Route
We will learn about two methods in which to extract values from the route. They are the annotations `@RequestParam` and `@PathVariable`. You can learn how to use them in the appropriate chapters in the Learn platform.

# Week 1, Day 5 PM - Rendering Views
Once we have a good handle on routing and route parameters, we will annotate our controllers with the `@Controller` annotation in order to render views to the client via jsp files.

Here are the steps to take:

1) Annotate your controller class with `@Controller`.
2) Edit your pom.xml file to include the jsp dependency:
   
```xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```
3) Create the WEB-INF directory in your `webapp` directory.
4) Add the location of your jsp files to your application.properties file:

    ```
    spring.mvc.view.prefix=/WEB-INF/
    ```
5) Create a new jsp file in the WEB-INF folder.
6) Return a string that matches that filename (with the .jsp extension) from one of your `@GetMapping` methods.
7) Start up your server and visit the route.