package pl.praktycznajava.springboottips.actuator;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

@Component
@WebEndpoint(id="isAppWorking")
public class IsAppWorkingEndpoint {

    @ReadOperation
    public String getHealth(){
        return "Aplikacja dziala :)";
    }
}



