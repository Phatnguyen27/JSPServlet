package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Nhanvien;
import model.dao.NhanvienDAO;

public class AdminEditNhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminEditNhanvienController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		NhanvienDAO nhanvienDAO = new NhanvienDAO();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/admin/nhanvien/index?msg=0");
			return;
		}
		Nhanvien nhanvien = nhanvienDAO.getItemById(id);
		
		if(nhanvien!=null) {
			request.setAttribute("nhanvien", nhanvien);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/nhanvien/edit.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/nhanvien/index?msg=0");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		NhanvienDAO nhanvienDAO = new NhanvienDAO();

		int id = Integer.parseInt(request.getParameter("id"));
		Nhanvien nhanvien = nhanvienDAO.getItemById(id);
		
		String name = request.getParameter("name");
		Nhanvien n = new Nhanvien(name);
		n.setId(nhanvien.getId());
		if(nhanvienDAO.EditItem(n) > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/nhanvien/index?msg=2");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/nhanvien/index?msg=0");
			rd.forward(request, response);
		}
	}
}
