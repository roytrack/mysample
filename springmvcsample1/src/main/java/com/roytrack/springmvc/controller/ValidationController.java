package com.roytrack.springmvc.controller;

import com.roytrack.springmvc.model.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by roytrack on 2015/1/21.
 */
@Controller
@RequestMapping("/validate")
public class ValidationController {

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@Valid Role role, BindingResult result,Model model){

        if(result.hasErrors()){
            model.addAttribute("entity",role);
            model.addAttribute("error",result.getAllErrors());
            return "base";
        }
        return "success";
    }
    @RequestMapping("/form")
    public String index(){
        return "validationForm";
    }

}
