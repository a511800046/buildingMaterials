package com.business.system.dao;


import com.business.system.model.Role;
import com.business.system.model.User;
import com.common.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: saleSystem
 * @description: 登陆用户dao层
 * @author: chengy
 * @create: 2018-11-05 12:24
 **/

@Repository("infoUserDao")
public class InfoUserDao extends BaseDao {

    public User findUserInfoByUserId(String userId) {
        String sql = "select * from info_user where user_id=?";
        return super.queryForModel(sql, new Object[]{userId}, User.class);
    }

    public Role findUserRoleByUserPrimaryKey(String userId) {
        String sql = "select * from info_role where user_id=?";
        return super.queryForModel(sql, new Object[]{userId}, Role.class);
    }

    public List findAllUserInfo() {
        String sql = "select * from info_user";
        return super.queryForList(sql);
    }

    public User saveUser(User user) {
        String sql = "insert into info_user(id,user_id,user_name,pass_word) values(sys_guid(),?,?,?)";
        super.updateOrInsert(sql, new Object[]{user.getUserId(), user.getUserName(), user.getPassWord()});
        return user;
    }
}
