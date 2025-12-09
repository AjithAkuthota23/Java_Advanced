package org.javaworks.Spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
| Scope               | Meaning                           | Used In          |
| --------------------| --------------------------------- | ---------------- |
| singleton (default) | one object for entire application | all apps         |
| prototype           | new object every time you request | stateful objects |
| request             | one object per HTTP request       | web applications |
| session             | one per user session              | web              |
| application         | one per ServletContext            | web              |
| websocket           | one per web socket                | web              |

 */

@Component
@Scope("singleton")
public class MessageServiceScope {
    public MessageServiceScope() {
        System.out.println("MessageServiceScope: Constructor called");
    }
}
