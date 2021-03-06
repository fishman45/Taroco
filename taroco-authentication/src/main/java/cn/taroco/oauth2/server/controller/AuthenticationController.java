package cn.taroco.oauth2.server.controller;

import cn.taroco.common.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuht
 * @date 2018年03月10日
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    /**
     * 认证页面
     *
     * @return ModelAndView
     */
    @GetMapping("/require")
    public ModelAndView require() {
        return new ModelAndView("ftl/login");
    }

    /**
     * 用户信息校验
     *
     * @param authentication 信息
     * @return 用户信息
     */
    @RequestMapping("/user")
    public Object user(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        return authentication.getPrincipal();
    }

    /**
     * 清除 accesstoken
     *
     * @param accesstoken accesstoken
     * @return true/false
     */
    @PostMapping("/removeToken")
    public Response removeToken(String accesstoken) {
        return Response.success(consumerTokenServices.revokeToken(accesstoken));
    }
}
