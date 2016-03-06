package masterSpringMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class HelloController {

    @Autowired
    private Twitter twitter;

    @RequestMapping("/")
    public String index(@RequestParam(value = "name",
                                    required = false, defaultValue = "")
                            String name,  Model model){

        SearchResults searchResults = twitter.searchOperations().search(name);
        boolean thereAreTweets = !searchResults.getTweets().isEmpty();
        if (thereAreTweets) {
            Tweet tweet = searchResults.getTweets().get(0);
            model.addAttribute("message", tweet.getText());
        } else {
            model.addAttribute("message", "No results");
        }
        return "resultPage";
    }

}