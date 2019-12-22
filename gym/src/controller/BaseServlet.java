package controller;

import java.io.IOException;
import java.lang.reflect.Method;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {

 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if(action == null || action.isEmpty()){
            throw new RuntimeException("没有传递方法参数,请给出你想调用的方法");
        }
         
        Method method = null;
         
        try {
            method = getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new RuntimeException("没有找到你调用的方法：" + action + "，请检查该方法是否存在!");
        }
         
        try {
            method.invoke(this, request, response);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new RuntimeException(action + "该方法出现异常!");
        }
    }
}