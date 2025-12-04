package org.javaworks.Spring;

import org.springframework.stereotype.Component;

@Component
public class EngineDependency {
    public String start() {
        return "Engine started...";
    }
}
