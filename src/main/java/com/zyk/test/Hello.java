package com.zyk.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/hello")
@Slf4j
public class Hello {

    private Logger logger = LoggerFactory.getLogger(Hello.class);

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public ModelAndView say(Model model){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("哇卡卡卡");
        logger.info(">>>>>>>w zai he 是是是 <<<<<<<<<<<<");
        log.info("看到我了吗===============show me ............");
        modelAndView.setViewName("jspHi");
        model.addAttribute("name","张殷恺");
        modelAndView.addObject(model);
        return modelAndView;
    }

}
