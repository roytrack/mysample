package com.roytrack.pay.controller;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Charge;
import com.roytrack.pay.model.FrontModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roytrack on 2015/4/14.
 */
@Controller
public class PayController {

    @RequestMapping("/index")
    public String index(){
        return "a";
    }

    @RequestMapping("/charge")
    public void charge( @RequestBody FrontModel model ){
        Pingpp.apiKey="sk_test_5G8afHb94qb54yLGGOyvzTKSx";
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        //某些渠道需要添加extra参数，具体参数详见接口文档
        chargeMap.put("amount", model.getTotal());
        chargeMap.put("currency", "cny");
        chargeMap.put("subject",  model.getSubject());
        chargeMap.put("body",  "Your Body");
        chargeMap.put("order_no",  model.getOrder_id());
        chargeMap.put("channel",  "alipay");
        chargeMap.put("client_ip",  "127.0.0.1");
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", "app_vjXTaLiL8az5i1iL");
        chargeMap.put("app", app);
        try {
            //发起交易请求
            Charge charge = Charge.create(chargeMap);
            System.out.println(charge);
        } catch (PingppException e) {
            e.printStackTrace();
        }
    }
}
