package org.javaworks.Spring;

import org.springframework.stereotype.Component;

@Component("dieselengine")
public class QualifierExampleTwo implements Engine{

    @Override
    public String start() {
        return "test from dieselengine";
    }
}
