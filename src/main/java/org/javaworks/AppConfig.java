package org.javaworks;

import org.javaworks.Spring.HelloServiceConfig;
import org.javaworks.Spring.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    @Configuration is used to tell Spring:
    ➡ “This class contains methods that create Beans manually.”
    ➡ It replaces XML <bean> definitions.
    ➡ @Bean inside it creates objects and registers them in Spring container.
 */

@Configuration
public class AppConfig {

    @Bean
    public HelloServiceConfig helloService() {
        return new HelloServiceConfig();    // Object created here
    }
}
