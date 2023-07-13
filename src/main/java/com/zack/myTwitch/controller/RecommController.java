package com.zack.myTwitch.controller;

import com.zack.myTwitch.entity.db.Item;
import com.zack.myTwitch.service.RecommException;
import com.zack.myTwitch.service.RecommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class RecommController {
    @Autowired
    private RecommService recommService;

    @RequestMapping(value = "/recommendation", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<Item>> recommendation(HttpServletRequest request) throws ServletException {
        HttpSession session = request.getSession(false);
        Map<String, List<Item>> itemMap;
        try {
            if (session == null) {
                itemMap = recommService.recommendItemsByDefault();
            } else {
                String userId = (String) session.getAttribute("user_id");
                itemMap = recommService.recommendItemsByUser(userId);
            }
        } catch (RecommException errMsg) {
            throw new ServletException(errMsg);
        }

        return itemMap;
    }

}
