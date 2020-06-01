package com.ming.controller;

import com.alibaba.fastjson.JSON;
import com.ming.annotation.AutoIdempotent;
import com.ming.service.ITokenService;
import com.ming.utils.Constants;
import com.ming.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BusinessController {
    @Resource
    private ITokenService tokenService;

    /*@Resource
    private TestService testService;*/

    @PostMapping("/get/token")
    public String getToken() {
        String token = tokenService.createToken();
        if (StringUtils.isNotEmpty(token)) {
            ResultVO resultVO = new ResultVO();
            resultVO.setCode(Constants.CODE_SUCCESS);
            resultVO.setMessage(Constants.SUCCESS);
            resultVO.setData(token);
            return JSON.toJSONString(resultVO);
        }
        return StringUtils.EMPTY;
    }

    /*@AutoIdempotent
    @PostMapping("/test/Idempotence")
    public String testIdempotence() {
        String businessResult = testService.testIdempotence();
        if (StrUtil.isNotEmpty(businessResult)) {
            ResultVo successResult = ResultVo.getSuccessResult(businessResult);
            return JSONUtil.toJsonStr(successResult);
        }
        return StringUtils.EMPTY;
    }*/
}
