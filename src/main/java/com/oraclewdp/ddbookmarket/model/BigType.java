package com.oraclewdp.ddbookmarket.model;

import java.io.Serializable;

public class BigType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
    private String name;
	public BigType() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
