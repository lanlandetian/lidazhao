package com.oraclewdp.ddbookmarket.biz.impl;

import com.oraclewdp.ddbookmarket.biz.AdminBiz;
import com.oraclewdp.ddbookmarket.dao.AdminDao;
import com.oraclewdp.ddbookmarket.dao.impl.AdminDaoJdbcImpl;
import com.oraclewdp.ddbookmarket.model.Admin;

public class AdminBizImpl implements AdminBiz {

    @Override
    public boolean findByNameAndPwd(Admin admin) {
        //Data access OBJECT:数据的增删改查
        AdminDao adminDao = new AdminDaoJdbcImpl();

        return adminDao.find(admin);
    }
}
