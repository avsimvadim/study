package spring.borisov_patterns;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Handler1 implements Handler{
    @Override
    public void handle() {
        System.out.println("Handle something 1");
    }
}
