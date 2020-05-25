package com.dona.practica.controller;

import java.util.List;

import javax.validation.Valid;

import com.dona.practica.domain.Contributor;
import com.dona.practica.domain.Importance;
import com.dona.practica.service.ContributorService;
import com.dona.practica.service.ImportanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    @Autowired
    ImportanceService importanceService;

    @Autowired
    ContributorService contributorService;

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
    public ModelAndView saveContributor(@Valid @ModelAttribute Contributor contributor, BindingResult result){
        ModelAndView modelAndView = new ModelAndView();

        if(result.hasErrors()){
            List<Importance> importances = null;
            try{
                importances = importanceService.findAll();
            }catch(Exception e){
                e.printStackTrace();
            }
            modelAndView.setViewName("index");
            modelAndView.addObject("importances", importances);
            modelAndView.addObject("contributor", contributor);
        }
        else{
            contributorService.save(contributor);
            modelAndView.setViewName("success");
        }
        return modelAndView;

    }
    @GetMapping("/contribuyentes")
    public ModelAndView contributors() {
        ModelAndView mav = new ModelAndView();
        List<Contributor> contributors = null;
        try {
            contributors = contributorService.getContributors();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("contributors", contributors);
        mav.setViewName("contributors");
        return mav;
    }
    
}