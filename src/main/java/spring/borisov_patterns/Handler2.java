package spring.borisov_patterns;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Handler2 implements Handler{
    @Override
    public void handle() {
        System.out.println("Handle something 2");
    }
}
