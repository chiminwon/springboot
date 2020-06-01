package com.ming.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisService {

    private RedisTemplate redisTemplate;
}
