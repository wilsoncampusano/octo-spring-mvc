package masterSpringMvc.controller.profile;

import masterSpringMvc.date.USLocalDateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
public class ProfileController {

    @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale){
        return USLocalDateFormatter.getPattern(locale);
    }

    @RequestMapping("/profile")
    public String displayProfile(ProfileForm profileForm){
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile",method = RequestMethod.POST, params = "addTaste")
    public String addTaste(ProfileForm profileForm){
        profileForm.getTastes().add(null);
        return "profile/profilePage";
    }

    @RequestMapping(value="/profile" , method = RequestMethod.POST, params = "removeTaste")
    public String removeTaste(ProfileForm profileForm, HttpServletRequest request){
        int index = Integer.valueOf(request.getParameter("removeTaste")).intValue();
        profileForm.getTastes().remove(index);
        return "/profile/profilePage";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveProfile(@Valid  ProfileForm profileForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("=======ERROR======");
            return "profile/profilePage";
        }

        return "redirect:/profile";
    }
}