package com.dev.UIHome.Web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class WebController implements ErrorController {

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("data", " gonna be gorgeous !");
        return mav;
    }

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public ModelAndView error(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("error");
        Map<String, Object> error = errorAttributes.getErrorAttributes(new ServletRequestAttributes(request), true);
        mav.addObject("status", error.get("status"));
        mav.addObject("error", error.get("error"));
        mav.addObject("message", error.get("message"));
        mav.addObject("path", error.get("path"));
        mav.addObject("timestamp", error.get("timestamp"));
        return mav;
    }

    @Override
    public String getErrorPath() {
        return ("error");
    }
}
