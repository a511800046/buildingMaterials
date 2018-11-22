package com.common.base.service.impl;


import com.common.base.dao.BaseDao;
import com.common.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: web_interface
 * @description: 基层service实现类
 * @author: chengy
 * @create: 2018-07-10 11:08
 **/
@Service("baseService")
public class BaseServiceImpl implements BaseService {
    @Autowired
    private BaseDao baseDao;

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
