package com.learningspringboot.springbootlearning.service;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.learningspringboot.springbootlearning.mapper.CoplayerMapper;
import com.learningspringboot.springbootlearning.mapper.UserMapper;
import com.learningspringboot.springbootlearning.model.CoPlayer;
import com.learningspringboot.springbootlearning.model.User;
import com.learningspringboot.springbootlearning.utils.ApiReturnUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: springbootlearning
 * @description: websocket服务类
 * @author: LiHongyan
 * @create: 2020-05-07 21:38
 **/

@ServerEndpoint("/websocket/{userId}")
@Component
public class WebSocketServer {
    static Log log = LogFactory.get(WebSocketServer.class);


    public static  ICoPlayerService iCoPlayerService;
    public static CoplayerMapper coplayerMapper;
    public static UserMapper userMapper;
    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<WebSocketServer> webSocketMap = new CopyOnWriteArraySet<>();

    private static ConcurrentHashMap<String,WebSocketServer> websocketList = new ConcurrentHashMap<>();
    private Session session;
    private String userId="";
    private boolean isCoPlayer = false;

    @OnOpen
    public void onOpen(Session session, @PathParam("userId")String userId){
        this.session = session;
        websocketList.put(userId,this);
        log.info("websocketList->"+JSON.toJSONString(websocketList));
        webSocketMap.add(this);
        addOnlineCount();
        log.info("有新窗口开始监听:"+userId+",当前在线人数为" + getOnlineCount());
        this.userId = userId;

        try{
            this.isCoPlayer = iCoPlayerService.hasCoPlayer(userId);
            sendMessage(JSON.toJSONString(ApiReturnUtil.success("连接成功")));
        }catch (IOException e){
           log.error("websocket io 异常");
        }
    }

    @OnClose
    public void onClose(){
        if(websocketList.get(this.userId) != null){
            websocketList.remove(this.userId);
            webSocketMap.remove(this);
            subOnlineCount();
            log.info("用户退出:"+userId+",当前在线人数为:"+getOnlineCount());
        }
    }

    @OnMessage
    public void onMessage(String message, Session session){
        log.info("用户消息："+userId+",消息:"+message);
        if(StringUtils.isNotBlank(message)){


                try{
                    JSONObject jsonObject = JSON.parseObject(message);
                    String toUserId = jsonObject.getString("toUserId");
                    String contentText = jsonObject.getString("contentText");
                    String type = jsonObject.getString("type");
                    jsonObject.put("fromUserId",this.userId);
                    if(type.equals("createOrder")){
                        jsonObject.put("type","getOrder");
                        jsonObject.put("status","exist");
                        sendInfo(JSON.toJSONString(jsonObject),toUserId,this.userId);
                    }
                    if(type.equals("getOrderResponse")){
                        CoPlayer coPlayer = coplayerMapper.findCoplayer(this.userId);
                        User user = userMapper.selectById(this.userId);
                        jsonObject.put("userName",user.getUserName());
                        jsonObject.put("userAge",user.getUserAge());
                        jsonObject.put("coPlayerPhoto",user.getUserPhoto());
                        jsonObject.put("gender",user.getUserGender());
                       // jsonObject.put("tag",coPlayer.getTag());
                        sendInfo(JSON.toJSONString(jsonObject),toUserId,this.userId);
                    }
                    if(type.equals("chat")){
                        WebSocketServer socket = websocketList.get(toUserId);
                        if(socket != null){
                            socket.sendMessage(JSON.toJSONString(jsonObject));
                        }
                    }
//                    if(StringUtils.isNotBlank(toUserId) && StringUtils.isNotBlank(contentText)){
//                        WebSocketServer socketx = websocketList.get(toUserId);
//                        if(socketx != null){
//                            socketx.sendMessage(JSON.toJSONString(ApiReturnUtil.success(jsonObject)));
//                        }
//                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }


    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误:"+this.userId+",原因:"+error);
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }

    public static void  sendInfo(String message,String userId,String id) throws IOException{
        log.info("发送消息到:"+userId+"，消息:"+message);
        for(WebSocketServer item : webSocketMap){
            try{
                if(userId.equals("")){
                    if(item.isCoPlayer && item.userId != id) {

                        item.sendMessage(message);

                    }
                }else if(item.userId.equals(userId)){
                    item.sendMessage(message);
                }
            }catch (IOException e){
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    @Autowired
    public void  setiCoPlayerService(ICoPlayerService iCoPlayerService){
        WebSocketServer.iCoPlayerService = iCoPlayerService;
    }
    @Autowired(required = false)
    public void setCoPlayerMapper(CoplayerMapper coPlayerMapper){
        WebSocketServer.coplayerMapper = coPlayerMapper;
    }
    @Autowired(required = false)
    public void setUserMapper(UserMapper userMapper){
        WebSocketServer.userMapper = userMapper;
    }

}
