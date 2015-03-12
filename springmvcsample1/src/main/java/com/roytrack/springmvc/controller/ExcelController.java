package com.roytrack.springmvc.controller;

import com.roytrack.springmvc.view.ExcelView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by roytrack on 2015/1/13.
 */
@Controller
@RequestMapping("/excel")
public class ExcelController  {

    @RequestMapping("/e")
    public ModelAndView generateExcel(){
        ExcelView v=new ExcelView();
        Map m=new HashMap();
        m.put("str","str");
        m.put("bd",new BigDecimal("55.22"));
        v.setAttributesMap(m);
        return new ModelAndView(v);
    }

}
