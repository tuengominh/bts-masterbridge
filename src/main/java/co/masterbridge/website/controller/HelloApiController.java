package co.masterbridge.website.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/api/hello")
public class HelloApiController {

    @RequestMapping(method = GET)
    public String hello() {
        return "Hello from Masterbridge!";
    }

    @RequestMapping(method = GET, path = "/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello " + name + "!";
    }
}
