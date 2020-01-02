package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Nhanvien;
import model.dao.NhanvienDAO;
import util.DefineUtil;

public class AdminIndexNhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminIndexNhanvienController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NhanvienDAO nhanvienDAO = new NhanvienDAO();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		int numberOfItems = nhanvienDAO.getNumberOfItems();
		int numberOfPages = (int)Math.ceil((float)numberOfItems/DefineUtil.NUMBER_PER_PAGE);
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			
		}
		if(currentPage > numberOfPages || currentPage <1) currentPage =1;
		int offset = (currentPage -1)*DefineUtil.NUMBER_PER_PAGE;
		ArrayList<Nhanvien> nhanviens = nhanvienDAO.getItemsPagination(offset);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("nhanvien",nhanviens );
		System.out.println(nhanviens.size());
		RequestDispatcher rd = request.getRequestDispatcher("/admin/nhanvien/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		System.out.println(search);
		NhanvienDAO NhanvienDAO = new NhanvienDAO();
		ArrayList<Nhanvien> listSearch  = NhanvienDAO.searchItems(search);
		System.out.println(listSearch.size());
		if(listSearch.size()>0) {
			request.setAttribute("listSearch", listSearch);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/nhanvien/searchResult.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/admin/nhanvien/searchResult.jsp?msg=2");
		}
	}

}
