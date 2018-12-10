package com.oraclewdp.ddbookmarket.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.oraclewdp.ddbookmarket.biz.SmallTypeBiz;
import com.oraclewdp.ddbookmarket.biz.impl.SmallTypeBizImpl;
import com.oraclewdp.ddbookmarket.model.SmallType;
@WebServlet("/findAllSmallType")
public class FindAllSmallTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindAllSmallTypeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strBid = request.getParameter("bid");
		int bid = Integer.parseInt(strBid);
		String callBack = request.getParameter("callback");
		//
		SmallTypeBiz smallTypeBiz = new SmallTypeBizImpl();
		List<SmallType> ls = smallTypeBiz.findAllByBid(bid);
		//js
		//1.告诉客户
		response.setContentType("text/javascript;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray(ls);
		//服务器返回的js调用客户端你的函数，周JSON格式填冲
		//jsonp
		out.print(callBack+"("+jsonArray.toString()+")");
		out.flush();
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
