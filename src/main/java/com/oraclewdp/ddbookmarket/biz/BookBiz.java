package com.oraclewdp.ddbookmarket.biz;

import java.util.List;

import com.oraclewdp.ddbookmarket.model.Book;

public interface BookBiz {

	List<Book> findAll(int currentPage, String name, int sid);


	boolean save(Book book);


	int totalRow(String name, int sid);


	int delById(int id);


    Book findBookById(int id);

    boolean update(Book book);
}
