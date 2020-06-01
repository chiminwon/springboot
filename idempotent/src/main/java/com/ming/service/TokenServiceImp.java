package com.ming.service;

import com.ming.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class TokenServiceImp implements ITokenService {

    @Autowired
    private RedisService redisService;

    /**
     * 创建token
     *
     * @return
     */
    public String createToken() {
        String str = UUID.randomUUID().toString();
        StringBuilder token = new StringBuilder();
        try {
            token.append(Constants.TOKEN_PREFIX).append(str);
            redisService.setEx(token.toString(), token.toString(), 10000L);
            boolean notEmpty = StringUtils.isNotEmpty(token.toString());
            if (notEmpty) {
                return token.toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 检验token
     *
     * @param request
     * @return
     */
    public boolean checkToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader(Constants.TOKEN_NAME);
        if (StringUtils.isBlank(token)) {// header中不存在token
            token = request.getParameter(Constants.TOKEN_NAME);
            if (StringUtils.isBlank(token)) {// parameter中也不存在token
                throw new ServiceException(Constants.ILLEGAL_ARGUMENT);
            }
        }
        if (!redisService.exists(token)) {
            throw new ServiceException(Constants.REPETITIVE_OPERATION);
        }
        boolean remove = redisService.remove(token);
        if (!remove) {
            throw new ServiceException(Constants.REPETITIVE_OPERATION);
        }
        return true;
    }
}
