package com.masachi.controller;

import com.masachi.model.ResponseCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by masachi on 2017/7/19.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public ResponseCode index(){
        ResponseCode code = new ResponseCode();
        code.setCode(233);
        code.setMessage("23333");
        return code;
    }
}
