package com.zyk.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class Say {
    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public ModelAndView say(Model model){
        log.info("sayHello ....");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("thHello");
        model.addAttribute("name","张殷恺");
        modelAndView.addObject(model);
        return modelAndView;
    }
}
