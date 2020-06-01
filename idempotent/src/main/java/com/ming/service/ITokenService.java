package com.ming.service;

import javax.servlet.http.HttpServletRequest;

public interface ITokenService {

    /**
     * 创建Token
     * @return
     */
    String createToken();

    /**
     * 检验Token
     * @param request
     * @return
     * @throws Exception
     */
    boolean checkToken(HttpServletRequest request) throws Exception;
}
