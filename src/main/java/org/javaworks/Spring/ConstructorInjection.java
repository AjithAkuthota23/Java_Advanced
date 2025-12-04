package org.javaworks.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 Constructor injection (recommended): immutable dependencies, clear required dependencies, safe for testing, works well with final fields.
 */
@Component
public class ConstructorInjection {
  public final EngineDependency engineDependency;

  @Autowired
  public ConstructorInjection(EngineDependency engineDependency) {
    this.engineDependency = engineDependency;
  }

  public void execute() {
      System.out.println("Executing ConstructorInjection");
      System.out.println(engineDependency.start());
  }
}
/*
    -> private final GreetingService greetingService; — dependency stored as final.
    -> Constructor with GreetingService param — Spring sees it and supplies a bean (by type).
    -> No @Autowired required in Spring 4.3+ for single constructor; you may annotate for clarity.
 */