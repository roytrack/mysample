package com.roytrack.springmvc.interceptor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by roytrack on 2015/3/18.
 */
@Getter
@Setter
public class TimeBasedAccessInterceptor implements HandlerInterceptor {

  private int openTime;
  private int closeingTime;

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

    Calendar calendar = Calendar.getInstance();
    System.out.println("interceptor is work!!");
    int hour = calendar.get(calendar.HOUR_OF_DAY);
    if (openTime <= hour && hour < closeingTime) {
      return true;
    } else {
      response.getOutputStream().print("not open!");
      return false;
    }


  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }


}
