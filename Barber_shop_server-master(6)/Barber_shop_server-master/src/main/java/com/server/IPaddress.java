package com.server;


public enum IPaddress {
    IPPORT("http://192.168.0.102:8080");
    private IPaddress(String color){
        this.ip = color;
    }

    private String ip;

    public String getAddress(){
        return this.ip;
    }

    public String toString(){
        return this.ip;
    }
}
