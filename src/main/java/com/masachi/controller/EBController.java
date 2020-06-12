package com.masachi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author masachi
 * @Date 2020/6/12 1:03 下午
 */
@RestController
public class EBController {

    @RequestMapping(value = "/feiming", method = RequestMethod.GET)
    public Object demonstration(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "ageFrom") Integer ageFrom,
            @RequestParam(value = "ageTo") Integer ageTo
    ) {
        return new HashMap<String, Object>(){{
            put("name", name);
            put("ageFrom", ageFrom);
            put("ageTo", ageTo);
        }};
    }
}
