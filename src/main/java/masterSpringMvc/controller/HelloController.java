package masterSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {


    @RequestMapping("/")
    public String index(@RequestParam("name") String name,  Model model){
        model.addAttribute("message", "Hello "+name+" from the controller");
        return "resultPage";
    }

}