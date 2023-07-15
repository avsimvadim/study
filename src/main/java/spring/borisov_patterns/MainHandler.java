package spring.borisov_patterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainHandler {

    @Autowired
    private List<Handler> handlers;

    public void handle() {
        handlers.forEach(handler -> handler.handle());
    }
}
