package com.oraclewdp.ddbookmarket.biz;

import com.oraclewdp.ddbookmarket.model.Admin;

public interface AdminBiz {
    boolean findByNameAndPwd(Admin admin);
}
