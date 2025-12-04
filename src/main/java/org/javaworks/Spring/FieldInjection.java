package org.javaworks.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
    Why not preferred
    -> Harder to test (you need reflection or container).
    -> Hides dependencies (not explicit in constructor).
    -> Still common in small demos / quick prototypes.
 */

@Component
public class FieldInjection {
    @Autowired
    private EngineDependency engineDependency;

    public void execute(){
        System.out.println("Executing FieldInjection");
        System.out.println(engineDependency.start());
    }
}
