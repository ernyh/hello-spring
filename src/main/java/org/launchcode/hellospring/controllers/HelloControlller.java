package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloControlller {

    //Handles requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello () {
//        return "hello spring!";
//    }

    //Handles requests at path /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye () {
        return "goodbye spring!";
    }

    //@GetMapping("hello")
    //updated to handle both get and post with request mapping
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    //@ResponseBody
    //handles requests /hello?name=LaunchCode
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String theGreeting = "hello " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    //handles requests of form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "hello " + name +"!";
    }

//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm (){
//        return "<html>" +
//                "<body>" +
//                "<form action = 'hello' >" + //submit request to /hello
//                //default form method is get and uses the get handler above
//                "<input type='text' name = 'name'>" +
//                "<input type='submit' value = 'greet me'> " +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    @GetMapping("form")
    // @ResponseBody remove because we are using form template in resources
    public String helloForm (){
        return "form";
    }

    @GetMapping ("hello-names")
    public String helloNames (Model model){
        List<String> theNames = new ArrayList<>();
        theNames.add ("Ernesto");
        theNames.add ("launchCode");
        theNames.add ("anotherName for the list");
        model.addAttribute("names", theNames);
        //return updated template
        return "hello-list";
    }

}
