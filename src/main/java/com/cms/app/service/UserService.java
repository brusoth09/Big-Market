package com.cms.app.service;

import com.cms.app.dao.UserDao;
import com.cms.app.model.Role;
import com.cms.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by burusothman on 8/31/16.
 */
@Service("userService")
public class UserService {

    @Autowired
    UserDao userDao;


    public void save(User user) {
        userDao.save(user);

        Role role = new Role();
        role.setUsername(user.getUsername());
        role.setRole("ROLE_USER");
        userDao.saveRole(role);
    }
    public List<User> getAllUsers() {
        List<User> list = userDao.list();
        return list;
    }
}
