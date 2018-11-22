package com.business.system.dao;


import com.business.system.model.User;
import com.common.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: web_interface
 * @description: 登陆用户dao层
 * @author: chengy
 * @create: 2018-11-05 12:24
 **/

@Repository("infoUserDao")
public class InfoUserDao extends BaseDao {

    public Map findUserInfoByUserId(String userId) {
        String sql = "select * from info_user where user_id=?";
        return super.queryForMap(sql, new Object[]{userId});
    }

    public List findUserRoleByUserPrimaryKey(String userId) {
        String sql = "select * from info_role where user_id=?";
        return super.queryForList(sql, new Object[]{userId});
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
