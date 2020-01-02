package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Phongban;
import model.dao.PhongbanDAO;

public class AdminEditPhongbanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminEditPhongbanController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PhongbanDAO phongbanDAO = new PhongbanDAO();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/admin/phongban/index?msg=0");
			return;
		}
		Phongban phongban = phongbanDAO.getItemById(id);
		if(phongban!=null) {
			request.setAttribute("phongban", phongban);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/phongban/edit.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/phongban/index?msg=0");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PhongbanDAO phongbanDAO = new PhongbanDAO();

		int id = Integer.parseInt(request.getParameter("id"));
		Phongban phongban = phongbanDAO.getItemById(id);
		
		String name = request.getParameter("name");  
		Phongban m = new Phongban(name);
		m.setId(phongban.getId());
		if(phongbanDAO.editItem(m) > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/phongban/index?msg=2");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/phongban/index?msg=0");
			rd.forward(request, response);
		}
	}
}
