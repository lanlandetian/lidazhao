package com.oraclewdp.ddbookmarket.biz;

import java.util.List;

import com.oraclewdp.ddbookmarket.model.BigType;

public interface BizTypeBiz {

	boolean save(String name);

	List<BigType> findAllBigType();

}
