package org.javaworks.Spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AccountServiceScope {
    public AccountServiceScope() {
        System.out.println("AccountServiceScope: New Object");
    }
}
