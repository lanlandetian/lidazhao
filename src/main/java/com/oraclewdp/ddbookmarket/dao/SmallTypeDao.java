package com.oraclewdp.ddbookmarket.dao;

import java.util.List;

import com.oraclewdp.ddbookmarket.model.SmallType;

public interface SmallTypeDao {

	boolean save(SmallType smallType);

	List<SmallType> findAllByBid(int bid);

    int findBidById(int sid);
}
