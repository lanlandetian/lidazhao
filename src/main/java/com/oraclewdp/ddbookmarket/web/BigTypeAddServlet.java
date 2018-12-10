package com.oraclewdp.ddbookmarket.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.ddbookmarket.biz.BizTypeBiz;
import com.oraclewdp.ddbookmarket.biz.impl.BigTypeBizImpl;
@WebServlet("/bigTypeAdd")
public class BigTypeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BigTypeAddServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(request.getSession().getAttribute("hasLogined")==null||!(boolean)request.getSession().getAttribute("hasLogined")){
//			response.sendRedirect("login.jsp");
//			return;
//		}
		//把用户天蝎的用户名添加到数据库
		String name = request.getParameter("name");
		//
		BizTypeBiz bigTypeBiz = new BigTypeBizImpl();
		boolean ret = bigTypeBiz.save(name);
		if (ret) {
			response.sendRedirect("main.jsp");
		} else {
            request.setAttribute("name", name);
            request.getRequestDispatcher("/bigTypeAdd.jsp").forward(request, response);
		}
	}

}
