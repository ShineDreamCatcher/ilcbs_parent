package cn.tzs.service.impl;

import cn.tzs.dao.UserDao;
import cn.tzs.domain.User;
import cn.tzs.service.UserService;
import cn.tzs.utils.UtilFuns;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User findOne(String id) {
        return userDao.findOne(id);
    }

    // 授权操作 过滤器链 注解方式配置
    @RequiresPermissions("部门管理")
    public List<User> find(Specification<User> spec) {
        return userDao.findAll(spec);
    }

    public Page<User> findPage(Specification<User> spec, Pageable pageable) {
        return userDao.findAll(spec, pageable);
    }

    public void saveOrUpdate(User user) {
        if (UtilFuns.isEmpty(user.getId())){
            String uid = UUID.randomUUID().toString();
            user.setId(uid);
            user.getUserinfo().setId(uid);
        }else {

        }
        userDao.save(user);
    }

    public void saveOrUpdateAll(Collection<User> entitys) {
        for (User user : entitys) {
            saveOrUpdate(user);
        }
    }

    public void deleteById(String id) {
        userDao.delete(id);
    }

    public void delete(String[] ids) {
        for (String id : ids) {
            userDao.delete(id);
        }
    }
}
