package masterSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {


    @RequestMapping("/profile")
    public String displayProfile(){
        return "profile/profilePage";
    }


    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveProfile(){
        return "redirect:/profile";
    }

}
