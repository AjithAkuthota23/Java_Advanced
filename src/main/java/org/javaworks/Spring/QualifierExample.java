package org.javaworks.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QualifierExample {
    public final Engine  engine;

    @Autowired
    public QualifierExample(@Qualifier("petrolengine") Engine engine) {
        this.engine = engine;
    }

    public void execute(){
        System.out.println(engine.start());
    }
}
