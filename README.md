# Maven, Hibernate, and Spring Framework

### This document provides a high-level understanding of Maven, Hibernate, and Spring, including why we use them, their core features, and how they integrate in Java applications.

## Maven
### What is Maven?
- Maven is a build automation and dependency management tool for Java projects.
- It simplifies project setup, building, packaging, dependency handling, and deployment.

### Why Maven is Used
- Dependency Management	Automatically downloads libraries (JARs) and manages versions.
- Build Automation	Compiles code, runs tests, packages JAR/WAR files.
- Standard Directory Structure	Makes projects predictable (src/main/java, src/test/java).
- Plugins	Used for building, testing, compiling, Docker building, etc.
- Easy Integration	Works with Spring, Hibernate, Jenkins, Docker, IntelliJ, Eclipse.

### How Maven Works
Maven is driven by a pom.xml file that defines:
- Project metadata
- Dependencies
- Build plugins
- Build lifecycle

Example:
```
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
</dependencies>
```
## Hibernate ORM
### What is Hibernate?
- Hibernate is a Java ORM (Object–Relational Mapping) framework that maps Java classes to database tables.
- It eliminates writing most SQL manually.

### Why Hibernate is Used
- Less SQL coding	Converts Java objects into tables/rows automatically.
- Portable (DB independent)	Same Java code works with MySQL, PostgreSQL, Oracle, etc.
- HQL / Criteria API	Database-independent query language.
- Caching	Faster performance using first & second level cache.
- Transaction management	Makes committing/rolling back easier.

### Common Hibernate Annotations
- @Entity: Represents a database table
- @Id: Primary key
- @GeneratedValue: Auto-increment ID
- @OneToOne, @OneToMany, @ManyToMany:	Relationships
- @Table(name="..."):	Custom table name

Example Entity:
```
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
```
## Spring Framework
### What is Spring?
Spring is a lightweight, modular framework for building Java enterprise applications with:
- Dependency Injection (DI)
- Inversion of Control (IoC)
- Web MVC
- AOP
- Security
- Data access
- Cloud & Microservices (via Spring Boot)

Why Spring is Used:
- Loose Coupling	Uses Dependency Injection to reduce tight coupling between classes.
- Scalable Applications	Perfect for large enterprise systems.
- Spring Boot	Rapid development with auto-configuration.
- Spring MVC	Build REST APIs easily.
- Spring Data JPA	Removes boilerplate Hibernate code.
- Highly testable	DI and mocks make unit testing easy.

Core Spring Features
1. Dependency Injection / IoC: Spring creates objects and injects their dependencies automatically.

Example:
```
@Component
public class HelloService {
    public void sayHello() {
        System.out.println("Hello from Spring!");
    }
}
```
2. Spring MVC: Build REST APIs and web applications.

3. Spring Data JPA: Works on top of Hibernate to simplify database operations.
- Integration: Spring + Hibernate + Maven
- Maven manages dependencies → Spring manages beans, DI → Hibernate manages database mapping.

