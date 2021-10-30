package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Application;

@Controller
public class InputController {

    @PostMapping("/giveInput")
    public String registerUser(@RequestParam("url") String url) {
        Application.addUrl(url);
        return "Input success. Info from this web-page will be worked out";
    }
}
