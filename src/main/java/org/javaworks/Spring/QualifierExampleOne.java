package org.javaworks.Spring;

import org.springframework.stereotype.Component;

@Component("petrolengine")
public class QualifierExampleOne implements   Engine {
    public String start(){
        return "test from petrolengine";
    }
}
