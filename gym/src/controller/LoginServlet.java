package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Conversion;
import dao.AdminsDao;
import dao.MemberDao;
import model.Admins;
@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//super.doPost(req, resp);
    	Admins admins=new Admins();
    	Conversion.convert(admins, req);
    	System.out.println(admins.getUsername());
    	
    	AdminsDao adminsDao=new AdminsDao();
    	MemberDao memberDao=new MemberDao();
    	
    	if(adminsDao.login(admins)){
    		try {
				req.setAttribute("memberList", memberDao.getList());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		HttpSession session=req.getSession();
    		session.setAttribute("username", admins.getUsername());
    		req.getRequestDispatcher("/member.jsp").forward(req, resp);
    	}else{
    		req.getRequestDispatcher("/login.jsp").forward(req, resp);
    	}
    }

}
