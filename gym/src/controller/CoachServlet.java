package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Conversion;
import dao.CoachDao;
import model.Coach;

@WebServlet("/Coach")
public class CoachServlet extends BaseServlet{
	
	private CoachDao coachDao = new CoachDao();
	
    protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
			request.setAttribute("coachList", coachDao.getList());
	   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	request.getRequestDispatcher("/coach.jsp").forward(request, response);
    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        
        CoachDao memberDao = new CoachDao();
        try {
        	memberDao.delete(Integer.parseInt(id));
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.show(request, response);
    }
    
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Coach coach = new Coach();
        Conversion.convert(coach, request);
        CoachDao coachDao = new CoachDao();
        try {
        	coachDao.add(coach);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.show(request, response);
    }
    
    
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Coach coach = new Coach();
        Conversion.convert(coach, request);
        CoachDao coachDao = new CoachDao();
        try {
        	coachDao.update(coach);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.show(request, response);
    }
    
    protected void addedit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String id = request.getParameter("id");
        String type = request.getParameter("type");
        CoachDao coachDao = new CoachDao();
        if(type.equals("edit")) {
        	request.setAttribute("action", "Coach?action=update");       	
        	request.setAttribute("heading", "修改教练信息");
        	request.setAttribute("btname", "修改");
        	try {
        		Coach coach=coachDao.get(Integer.parseInt(id));
        		request.setAttribute("coach", coach);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else {
        	request.setAttribute("action", "Coach?action=add");
        	
        	request.setAttribute("heading", "添加教练");
            request.setAttribute("btname", "添加");
        }
        request.getRequestDispatcher("/addEditCoach.jsp").forward(request, response);
    	
    }
    


}