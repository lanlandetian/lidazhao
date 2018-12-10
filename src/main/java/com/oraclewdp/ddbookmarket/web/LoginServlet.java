package com.oraclewdp.ddbookmarket.web;

import com.oraclewdp.ddbookmarket.biz.AdminBiz;
import com.oraclewdp.ddbookmarket.biz.impl.AdminBizImpl;
import com.oraclewdp.ddbookmarket.model.Admin;
import com.oraclewdp.ddbookmarket.util.MyBeanUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数值
		Admin admin=new Admin();
		//到数据库对比
		MyBeanUtils.populate(admin, request.getParameterMap());

		//如果验证码不正确流程不走
		String vcode = request.getParameter("vcode");
		String serverVcode = (String)request.getSession().getAttribute("validateCode");
	/*	//不区分大小写
		if(!serverVcode.equalsIgnoreCase(vcode)){
			request.setAttribute("msg","验证码错误");
			request.setAttribute("admin",admin);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}


		//进行校验
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		//违反的约束
		Set<ConstraintViolation<Admin>> validatResult = validator.validate(admin);
		if(validatResult.size()>0){//验证不通过
			Map<String,String> errors = new HashMap<>();
			for (ConstraintViolation<Admin> cv :
				 validatResult) {
				errors.put(cv.getPropertyPath().toString(),cv.getMessage());
			}
			request.setAttribute("errors",errors);
			request.setAttribute("admin",admin);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}*/

		Map<String,String> errors = new HashMap<>();
		if(!serverVcode.equalsIgnoreCase(vcode)){
			errors.put("vcode","验证码错误");
		}
		//进行校验
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		//违反的约束
		Set<ConstraintViolation<Admin>> validatResult = validator.validate(admin);
		if(validatResult.size()>0){//验证不通过
			for (ConstraintViolation<Admin> cv :validatResult) {
				errors.put(cv.getPropertyPath().toString(),cv.getMessage());
			}
		}
		if(errors.size()>0){
			request.setAttribute("errors",errors);
			request.setAttribute("admin",admin);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}


		AdminBiz adminBiz=new AdminBizImpl();
		boolean ret =adminBiz.findByNameAndPwd(admin);
		
		if (ret) {//为true转发到main.jsp页面
            //session范围、记录下已经成功登录
			request.getSession().setAttribute("hasLogined",true);
            request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			//把用户填的信息回填
			request.setAttribute("admin",admin);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
