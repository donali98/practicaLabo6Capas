package com.dona.practica.controller;

import java.util.List;

import com.dona.practica.domain.Contributor;
import com.dona.practica.domain.Importance;
import com.dona.practica.service.ImportanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
    @Autowired
    ImportanceService importanceService;

    @GetMapping(value="/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        List<Importance> importances = null;
        try{
            importances = importanceService.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        mav.addObject("importances", importances);
        mav.addObject("contributor", new Contributor());
        mav.setViewName("index");
        return mav;
    }

    @PostMapping("/saveContributor")
    public void saveContributor() {
        
    }
    
}