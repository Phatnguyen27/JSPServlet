package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Nhanvien;
import model.dao.NhanvienDAO;

public class AdminAddNhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminAddNhanvienController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/nhanvien/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		NhanvienDAO nhanvienDAO = new NhanvienDAO();
		if(nhanvienDAO.AddItem(new Nhanvien(name)) > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/nhanvien/index?msg=1");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/nhanvien/index?msg=0");
			rd.forward(request, response);
		}
	}
}
