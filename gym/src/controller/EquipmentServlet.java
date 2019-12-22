package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Conversion;
import dao.CoachDao;
import dao.EquipmentDao;
import dao.MemberDao;
import model.Coach;
import model.Equipment;
import model.Member;

@WebServlet("/Equipment")
public class EquipmentServlet extends BaseServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EquipmentDao equipmentDao = new EquipmentDao();
	
    protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
			request.setAttribute("equipmentList", equipmentDao.getList());
	   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	request.getRequestDispatcher("/equipment.jsp").forward(request, response);
    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        
        try {
        	equipmentDao.delete(Integer.parseInt(id));
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.show(request, response);
    }
    
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Equipment equipment=new Equipment();
        Conversion.convert(equipment, request);

        try {
        	equipmentDao.add(equipment);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.show(request, response);
    }
    
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Equipment equipment = new Equipment();
        Conversion.convert(equipment, request);
        EquipmentDao equipmentDao = new EquipmentDao();
        try {
        	equipmentDao.update(equipment);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.show(request, response);
    }
    
    protected void addedit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String id = request.getParameter("id");
        String type = request.getParameter("type");
        EquipmentDao equipmentDao = new EquipmentDao();
        if(type.equals("edit")) {
        	request.setAttribute("action", "Equipment?action=update");       	
        	request.setAttribute("heading", "修改器材信息");
        	request.setAttribute("btname", "修改");
        	try {
        		Equipment equipment=equipmentDao.get(Integer.parseInt(id));
        		request.setAttribute("equipment", equipment);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else {
        	request.setAttribute("action", "Equipment?action=add");
        	
        	request.setAttribute("heading", "添加器材");
            request.setAttribute("btname", "添加");
        }
        request.getRequestDispatcher("/addEditEquipment.jsp").forward(request, response);
    	
    }


}