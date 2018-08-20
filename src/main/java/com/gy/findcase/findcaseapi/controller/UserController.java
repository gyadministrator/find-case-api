package com.gy.findcase.findcaseapi.controller;

import com.gy.findcase.findcaseapi.annotation.CurrentUser;
import com.gy.findcase.findcaseapi.entity.User;
import com.gy.findcase.findcaseapi.jwt.utils.AccessToken;
import com.gy.findcase.findcaseapi.jwt.utils.Audience;
import com.gy.findcase.findcaseapi.jwt.utils.JwtUtils;
import com.gy.findcase.findcaseapi.service.UserService;
import com.gy.findcase.findcaseapi.service.support.Items;
import com.gy.findcase.findcaseapi.utils.Md5Utils;
import com.gy.findcase.findcaseapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gy.findcase.findcaseapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/11 16:47
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户管理")
public class UserController {
    private final UserService userService;
    private final Audience audienceEntity;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserController(UserService userService, Audience audienceEntity) {
        this.userService = userService;
        this.audienceEntity = audienceEntity;
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public SimpleResponse login(@RequestBody User user) {
        logger.info("登录的用户为:" + user.toString());
        User u = this.userService.findByName(user.getAccount());
        String accessToken;
        Map<String, Object> map = new HashMap<>();
        if (u != null) {
            String pwd = u.getPassword();
            String md5Pwd = Md5Utils.MD5(user.getPassword() + u.getUserCode());
            if (pwd.equals(md5Pwd)) {
                accessToken = JwtUtils.createJWT(
                        u.getAccount(),
                        u.getUserCode(),
                        audienceEntity.getClientId(),
                        audienceEntity.getName(),
                        audienceEntity.getExpiresSecond() * 1000,
                        audienceEntity.getBase64Secret());
                //返回accessToken
                AccessToken accessTokenEntity = new AccessToken();
                accessTokenEntity.setAccess_token(accessToken);
                accessTokenEntity.setExpires_in(audienceEntity.getExpiresSecond());
                accessTokenEntity.setToken_type("bearer");

                if (accessToken != null) {
                    map.put("token", accessToken);
                    map.put("user", u);
                }
            }
        }
        return simpleResponse(200, map);
    }

    @ApiOperation(value = "添加用户")
    @PostMapping
    public SimpleResponse addUser(@RequestBody @Valid User user) {
        logger.info("添加用户---->" + user.toString());
        User u = this.userService.findByName(user.getAccount());
        if (u == null) {
            assert false;
            String pwd = Md5Utils.MD5(user.getPassword() + user.getUserCode());
            user.setPassword(pwd);
            user.setCreateTime(new Date());
            userService.save(user);
            return simpleResponse(200);
        } else {
            return simpleResponse(500, "", "此用户名已经存在");
        }
    }

    @ApiOperation(value = "修改用户")
    @PutMapping
    public SimpleResponse update(@RequestBody User user, @CurrentUser User u) {
        logger.info("修改用户---->" + user.toString());
        this.userService.update(user);
        return simpleResponse(200);
    }

    @ApiOperation(value = "查询用户")
    @GetMapping
    public SimpleResponse query() {
        Items<User> query = this.userService.query();
        List<User> items = query.getItems();
        return simpleResponse(200, items);
    }
}
