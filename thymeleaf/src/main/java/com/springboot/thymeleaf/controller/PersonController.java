package com.springboot.thymeleaf.controller;

import com.springboot.thymeleaf.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Future
 */
@Controller
@RequestMapping("/")
public class PersonController {


    @RequestMapping("person")
    public String toPerson(Model model) {
        Person person = new Person();
        person.setName("张三丰");
        person.setAge(22);
        model.addAttribute("person",person);
        return "index";
    }
}
