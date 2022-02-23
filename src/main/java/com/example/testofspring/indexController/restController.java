package com.example.testofspring.indexController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import java.time.DayOfWeek;
import java.time.LocalDate;


@RestController
public class restController {
    @GetMapping("/first-mapping")
    public String firstMapping() {
        return "<b>Hello world<b>";
    }

    @GetMapping("/second-mapping")
    public String secondMapping() {
        return "This is the second mapping";
    }

    @GetMapping("/")
    public String index() {
        return "Hello and welcome to my spring project";
    }

    @GetMapping("/echo")
    public String parameter(@RequestParam String input) {
        return input + " " + " end of string";
    }

    @GetMapping("/isItFriday")
    public RedirectView fridayInnit() {
        LocalDate date = LocalDate.now();
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("https://youtu.be/U6n2NcJ7rLc?t=5");
            return redirectView;
        } else {
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("/no");
            return redirectView;
        }
    }

    @GetMapping("/no")
    public String no(){
        return "It is not friday";
    }

}