package com.oraclewdp.ddbookmarket.biz.impl;

import java.util.List;

import com.oraclewdp.ddbookmarket.biz.SmallTypeBiz;
import com.oraclewdp.ddbookmarket.dao.SmallTypeDao;
import com.oraclewdp.ddbookmarket.dao.impl.SmallTypeDaoJdbcImpl;
import com.oraclewdp.ddbookmarket.model.SmallType;

public class SmallTypeBizImpl implements SmallTypeBiz {

	@Override
	public boolean save(SmallType smallType) {
		SmallTypeDao smallTypeDao = new SmallTypeDaoJdbcImpl();
		return smallTypeDao.save(smallType);
	}

	@Override
	public List<SmallType> findAllByBid(int bid) {
		SmallTypeDao smallTypeDao = new SmallTypeDaoJdbcImpl();
		return smallTypeDao.findAllByBid(bid);
	}

	@Override
	public int findBidById(int sid) {
		SmallTypeDao smallTypeDao = new SmallTypeDaoJdbcImpl();
		return smallTypeDao.findBidById(sid);
	}

}
