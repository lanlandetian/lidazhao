package com.oraclewdp.ddbookmarket.web;

import com.oraclewdp.ddbookmarket.biz.BookBiz;
import com.oraclewdp.ddbookmarket.biz.impl.BookBizImpl;
import com.oraclewdp.ddbookmarket.model.Book;
import com.oraclewdp.ddbookmarket.util.MyBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "DoBookEidServlet",value = "/doBookEdit")
@MultipartConfig
public class DoBookEidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if(request.getSession().getAttribute("hasLogined")==null||!(boolean)request.getSession().getAttribute("hasLogined")){
//            response.sendRedirect("login.jsp");
//            return;
//        }
        Book book = new Book();
        MyBeanUtils.populate(book, request.getParameterMap(),"yyyy-MM-dd");
        String newFile=null;
        Part part = request.getPart("photo");

        if (part.getHeader("Content-Disposition").contains("; filename=")) {
            if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().equals("")) {
                String es = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf(".") + 1);
                newFile = UUID.randomUUID() + "." + es;
                part.write(request.getServletContext().getRealPath("/upload/" + newFile));
            }
        }
        book.setPhoto(newFile);
        //2
        BookBiz bookBiz = new BookBizImpl();
        boolean ret = bookBiz.update(book);
        //3
        if (ret) {
            response.sendRedirect("bookList");
        } else {
            request.setAttribute("bid",request.getParameter("bid"));
            request.setAttribute("book", book);
            request.getRequestDispatcher("bookEdit.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
