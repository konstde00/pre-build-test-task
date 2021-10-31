package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.Application;

@Controller
public class IndexController {
    @GetMapping("/start")
    public String start() {
        Application.build();
        return "Started working out data sources";
    }
}
