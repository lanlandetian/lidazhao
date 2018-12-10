package com.oraclewdp.ddbookmarket.biz;

import java.util.List;

import com.oraclewdp.ddbookmarket.model.SmallType;

public interface SmallTypeBiz {

	boolean save(SmallType smallType);

	List<SmallType> findAllByBid(int bid);

    int findBidById(int sid);
}
