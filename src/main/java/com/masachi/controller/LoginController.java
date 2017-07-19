package com.masachi.controller;

import com.masachi.impl.UserServiceImpl;
import com.masachi.model.ResponseCode;
import com.masachi.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;

/**
 * Created by masachi on 2017/7/19.
 */
@RestController
@RequestMapping("/graduate")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseCode login(@RequestBody String data){
        ResponseCode code = new ResponseCode();

        JSONObject object = JSONObject.fromObject(data);
        String username = object.getString("username");
        String password = object.getString("password");

        if(userService.getCurrentUser(username) == null){
            code.setCode(233);
            code.setMessage("No User");
        }
        else {

            if (userService.getCurrentUser(username).equals(string2MD5(password))) {
                code.setCode(200);
                code.setMessage("");
            } else {
                code.setCode(500);
                code.setMessage("Password Incorrect");
            }
        }

        return code;
    }

    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
