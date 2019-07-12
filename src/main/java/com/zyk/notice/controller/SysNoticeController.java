package com.zyk.notice.controller;

import com.zyk.notice.entity.SysNotice;
import com.zyk.notice.service.SysNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping(value = "/notice")
@Slf4j
public class SysNoticeController {

    @Autowired
    private SysNoticeService sysNoticeService;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public ModelAndView fetchNotice(@PathVariable("id") Long id){
        log.info("============>>> id = "+id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("thNotice");
        modelAndView.addObject("id",id);
        SysNotice sysNotice = sysNoticeService.getSysNoticeById(id);
        if(sysNotice!=null){
            log.info("======== sys notice ======>>> "+sysNotice);
        }
        modelAndView.addObject("sysNotice",sysNotice.toString());
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView add(){
        log.info("============>>> add ");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("thNotice");
        int ret = sysNoticeService.addNotice();
        modelAndView.addObject("ret",ret);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") Long id){
        log.info("============>>> update ");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("thNotice");
        SysNotice sysNotice = sysNoticeService.selectByPrimaryKey(id);
        sysNotice.setNoticeContent(UUID.randomUUID().toString());
        SysNotice notice = sysNoticeService.updateByPrimaryKeySelective(sysNotice);
        modelAndView.addObject("sysNotice",notice.toString());
        return modelAndView;
    }

    @RequestMapping(value = "/cleanAllCache",method = RequestMethod.GET)
    public ModelAndView cleanAllCache(){
        log.info("============>>> cleanAllCache ");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jspHi");
        sysNoticeService.cleanAllCache();
        return modelAndView;
    }



}
