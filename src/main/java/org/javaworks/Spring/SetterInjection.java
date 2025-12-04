package org.javaworks.Spring;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
    When to use
    -> Optional dependencies, or when you want to inject a dependency after construction.
    -> Less preferred for required fields.
 */

@Component
public class SetterInjection {
    public EngineDependency engineDependency;

    @Autowired
    public void setEngineDependency(EngineDependency engineDependency) {
        this.engineDependency=engineDependency;
    }

    public void execute(){
        System.out.println("Executing SetterInjection");
        System.out.println(engineDependency.start());
    }
}
