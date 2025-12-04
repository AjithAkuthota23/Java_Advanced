package org.javaworks;

import org.javaworks.Spring.ConstructorInjection;
import org.javaworks.Spring.FieldInjection;
import org.javaworks.Spring.SetterInjection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.javaworks.Spring.HelloWorld;

/*
    Spring is a large, modular application framework for Java that solves common enterprise problems: wiring components, transaction management, declarative configuration, AOP, data access, web MVC, and more. In practice people most commonly use Spring Boot (opinionated setup) to get apps running quickly.

    Why use Spring? (Problems it solves)
    -> Loose coupling / easier testing — Spring’s IoC/DI (Inversion of Control / Dependency Injection) lets you program to interfaces and swap implementations easily (mocking in tests).
    -> Centralized configuration & lifecycle — Spring manages object creation, lifecycle, proxies, destruction, and configuration in a consistent container.
    -> Less boilerplate — You avoid new everywhere, manual lookups, and repetitive plumbing code (transactions, data sources, security).
    -> Cross-cutting concerns — AOP support (transactions, logging, security) applied declaratively.
    -> Productivity — Auto-configuration, starters, and opinionated defaults (Boot) speed development.
    -> Ecosystem — Spring Data, Security, MVC, Cloud support, etc.

    Dependency Injection (DI) — give objects their dependencies from the outside (container), instead of objects constructing their own dependencies.
 */

public class SpringMain {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        HelloWorld service = context.getBean(HelloWorld.class);
        ConstructorInjection constructorInjection = context.getBean(ConstructorInjection.class);
        SetterInjection setterInjection = context.getBean(SetterInjection.class);
        FieldInjection fieldInjection = context.getBean(FieldInjection.class);

        System.out.println(service.sayHello());
        constructorInjection.execute();
        setterInjection.execute();
        fieldInjection.execute();
    }
}
