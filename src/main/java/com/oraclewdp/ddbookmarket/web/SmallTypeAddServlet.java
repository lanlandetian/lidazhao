package com.oraclewdp.ddbookmarket.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.ddbookmarket.biz.SmallTypeBiz;
import com.oraclewdp.ddbookmarket.biz.impl.SmallTypeBizImpl;
import com.oraclewdp.ddbookmarket.model.SmallType;
import com.oraclewdp.ddbookmarket.util.MyBeanUtils;

@WebServlet("/smallTypeAdd")
public class SmallTypeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SmallTypeAddServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(request.getSession().getAttribute("hasLogined")==null||!(boolean)request.getSession().getAttribute("hasLogined")){
//			response.sendRedirect("login.jsp");
//			return;
//		}
    	//1
		SmallType smallType = new SmallType();
		MyBeanUtils.populate(smallType, request.getParameterMap());
		//2
		SmallTypeBiz smallTypeBiz = new SmallTypeBizImpl();
		boolean ret = smallTypeBiz.save(smallType);
		//3
		if(ret) {
			response.sendRedirect("main.jsp");
		}else {
			request.setAttribute("smallType", smallType);
			request.getRequestDispatcher("/smallTypeAdd.jsp").forward(request,response);
		}
	}

}
