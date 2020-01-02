package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.PhongbanDAO;

public class AdminDelPhongbanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminDelPhongbanController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PhongbanDAO phongbanDAO = new PhongbanDAO();
		if(phongbanDAO.delItem(id) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/phongban/index?msg=3");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath()+"/admin/phongban/index?msg=0");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
