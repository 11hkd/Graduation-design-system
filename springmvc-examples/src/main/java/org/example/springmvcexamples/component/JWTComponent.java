package org.example.springmvcexamples.component;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JWTComponent {

    @Value("${my:secretkey}")
    private String secretkey;

    public String encode(){

    }

}
