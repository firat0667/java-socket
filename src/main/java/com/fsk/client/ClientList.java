package com.fsk.client;

import lombok.*;

@Getter
@Setter
public class ClientList {
    private String message;
    private String name;
    private boolean isStop;
    private String address;
    private Integer port;

    public ClientList(String message, String name, String address, Integer port) {
        this.message = message;
        this.name = name;
        this.isStop = true;
        this.address = address;
        this.port = port;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
