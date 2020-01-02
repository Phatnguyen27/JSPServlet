package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Phongban;
import model.dao.PhongbanDAO;


public class AdminAddPhongbanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddPhongbanController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/admin/phongban/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		PhongbanDAO phongbanDAO = new PhongbanDAO();
		Phongban objP = new Phongban(name);
		if(phongbanDAO.addItem(objP) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/phongban/index?msg=1");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath()+"/admin/phongban/add?msg=0");
			return;
		}
	}

}