package com.ming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EChartsContoller {

    @GetMapping("/echarts")
    public String echarts() {
        return "echarts";
    }
}
