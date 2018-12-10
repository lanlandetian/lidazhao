package com.oraclewdp.ddbookmarket.dao;

import java.util.List;

import com.oraclewdp.ddbookmarket.model.BigType;

public interface BigTypeDao {

	boolean asve(String name);

	List<BigType> findAll();

}
