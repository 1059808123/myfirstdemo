package com.learningspringboot.springbootlearning.model;

/**
 * @program: springbootlearning
 * @description: 订单实体类
 * @author: LiHongyan
 * @create: 2020-05-25 17:08
 **/
public class Order {
    private String coPlayerName;
    private String orderId;
    private String coPlayer;
    private String customer;
    private String price;
    private String time;
    private String allPrice;
    private String gameType;
    private int active;
    private String coPlayerImg;

    public String getCoPlayerImg() {
        return coPlayerImg;
    }

    public void setCoPlayerImg(String coPlayerImg) {
        this.coPlayerImg = coPlayerImg;
    }

    public String getCoPlayer() {
        return coPlayer;
    }

    public void setCoPlayer(String coPlayer) {
        this.coPlayer = coPlayer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String mprice) {
        this.price = mprice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(String allPrice) {
        this.allPrice = allPrice;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCoPlayerName() {
        return coPlayerName;
    }

    public void setCoPlayerName(String coPlayerName) {
        this.coPlayerName = coPlayerName;
    }
}
