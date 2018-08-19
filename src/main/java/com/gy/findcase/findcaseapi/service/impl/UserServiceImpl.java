package com.gy.findcase.findcaseapi.service.impl;

import com.gy.findcase.findcaseapi.entity.User;
import com.gy.findcase.findcaseapi.jwt.utils.Audience;
import com.gy.findcase.findcaseapi.jwt.utils.JwtUtils;
import com.gy.findcase.findcaseapi.repository.UserRepository;
import com.gy.findcase.findcaseapi.service.UserService;
import com.gy.findcase.findcaseapi.service.support.Items;
import com.gy.findcase.findcaseapi.service.support.OrderType;
import com.gy.findcase.findcaseapi.service.support.PageQuery;
import com.gy.findcase.findcaseapi.service.support.QueryUtils;
import com.gy.findcase.findcaseapi.utils.Md5Utils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoyun
 * 2018/4/18 10:57
 * 描述:
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final Audience audienceEntity;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Audience audienceEntity) {
        this.userRepository = userRepository;
        this.audienceEntity = audienceEntity;
    }


    /**
     * @param userName 用户名
     * @return
     */
    @Override
    public User findByName(String userName) {
        return this.userRepository.findByAccount(userName);
    }

    @Override
    public String parseToken(String token) {
        String auth = token.substring(7, token.toString().length());
        Claims claims = JwtUtils.parseJWT(auth, audienceEntity.getBase64Secret());
        return (String) claims.get("loginUser");
    }

    @Override
    public void update(User user) {
        try {
            User u = this.queryById(user.getId());
            assert user.getAccount() != null;
            if (user.getAccount() != null) {
                u.setAccount(user.getAccount());
            }
            assert user.getImage() != null;
            if (user.getImage() != null) {
                u.setImage(user.getImage());
            }
            assert user.getPassword() != null;
            if (user.getPassword() != null) {
                String pwd = Md5Utils.MD5(user.getPassword() + user.getUserCode());
                u.setPassword(pwd);
            }
            assert user.getPhone() != null;
            if (user.getPhone() != null) {
                u.setPhone(user.getPhone());
            }
            this.userRepository.save(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String saveReturnId(User user) {
        this.userRepository.save(user);
        return user.getId();
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User saveReturnEntity(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteById(String s) {
        this.userRepository.deleteById(s);
    }

    @Override
    public User queryById(String s) throws Exception {
        return this.userRepository.getOne(s);
    }

    @Override
    public Items<User> query() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<User> all = this.userRepository.findAll(sort);
        long count = this.userRepository.count();
        return new Items<>(count, all);
    }

    @Override
    public PageQuery<User> query(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<User>().query(userRepository, currentPage, pageSize, orderType, sortField);
    }
}
