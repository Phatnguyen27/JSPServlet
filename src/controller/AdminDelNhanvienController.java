package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.NhanvienDAO;

public class AdminDelNhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminDelNhanvienController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		NhanvienDAO nhanvienDAO = new NhanvienDAO();
		if(nhanvienDAO.DelItem(id) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/nhanvien/index?msg=3");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath()+"/admin/nhanvien/index?msg=0");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
