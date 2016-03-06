package masterSpringMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HelloController {

    @Autowired
    private Twitter twitter;

    @RequestMapping("/")
    public String index(@RequestParam(value = "name",
                                    required = false, defaultValue = "")
                            String name,  Model model){

        SearchResults searchResults = twitter.searchOperations().search(name);
        List<String> tweets = searchResults
                            .getTweets()
                            .stream()
                            .map(Tweet::getText)
                            .collect(Collectors.toList());

        model.addAttribute("tweets", tweets);

        return "resultPage";
    }
}