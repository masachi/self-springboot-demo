package com.masachi.controller;

import com.masachi.crawler.NotificationCrawler;
import com.masachi.model.Notification;
import com.masachi.model.NotificationList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by masachi on 2017/7/19.
 */
@Controller
@RequestMapping("/graduate")
public class NewsController {

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public NotificationList getNews(){
        NotificationList news = new NotificationList();
        NotificationCrawler crawler = new NotificationCrawler();
        ArrayList<Notification> body = new ArrayList<>();
        body = crawler.getNotification();

        if (body.size() != 0) {
            news.setCode(200);
            news.setMessage("");
            news.setBody(body);
        }
        else{
            news.setCode(500);
            news.setMessage("Internal Error");
            news.setBody(body);
        }

        return news;
    }
}
