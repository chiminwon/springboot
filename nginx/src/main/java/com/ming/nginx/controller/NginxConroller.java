package com.ming.nginx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@RestController
public class NginxConroller {

    @Autowired
    Environment environment;

    @GetMapping("/getInfo")
    public String testBalance() {
        Date currentDate = new Date();
        return currentDate.toString() + " , " + getIp() + ":" + getPort();
    }

    private String getPort() {
        return environment.getProperty("local.server.port");
    }

    private String getIp() {
        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return localHost.getHostAddress();
    }
}
