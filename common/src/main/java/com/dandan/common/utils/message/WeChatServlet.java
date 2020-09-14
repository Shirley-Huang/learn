package com.dandan.common.utils.message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class WeChatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
//            Map<String, String> map = MessageUtil.xmlToMap(request);
            Map<String, String> map = new HashMap<String, String>();
            String ToUserName = map.get("ToUserName");
            String FromUserName = map.get("FromUserName");
            request.getSession().setAttribute("openid",FromUserName);
            String CreateTime = map.get("CreateTime");
            String MsgType = map.get("MsgType");
            String message = null;
            if (MsgType.equals(WXConstants.MESSAGE_EVENT)) {
                //从集合中，获取是哪一种事件传入
                String eventType = map.get("Event");
                if (eventType.equals(WXConstants.MESSAGE_SUBSCRIBE)) {
                    message = MessageUtil.initNewsMessage(ToUserName, FromUserName);
                }
            }
            out.print(message); //返回转换后的XML字符串
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != out){
                out.close();
            }
        }


    }


}
