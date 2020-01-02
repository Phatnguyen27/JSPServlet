package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Phongban;
import model.dao.PhongbanDAO;
import util.DefineUtil;

public class AdminIndexPhongbanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminIndexPhongbanController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PhongbanDAO phongbanDAO = new PhongbanDAO();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		int numberOfItems = phongbanDAO.getNumberOfItems();
		int numberOfPages = (int)Math.ceil((float)numberOfItems/DefineUtil.NUMBER_PER_PAGE);
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			
		}
		if(currentPage > numberOfPages || currentPage <1) currentPage =1;
		int offset = (currentPage -1)*DefineUtil.NUMBER_PER_PAGE;
		ArrayList<Phongban> phongbans = phongbanDAO.getItemsPagination(offset);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("phongban",phongbans );
		System.out.println(phongbans.size());
		RequestDispatcher rd = request.getRequestDispatcher("/admin/phongban/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		System.out.println(search);
		PhongbanDAO PhongbanDAO = new PhongbanDAO();
		ArrayList<Phongban> listSearch  = PhongbanDAO.searchItems(search);
		System.out.println(listSearch.size());
		if(listSearch.size()>0) {
			request.setAttribute("listSearch", listSearch);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/phongban/searchResult.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/admin/phongban/searchResult.jsp?msg=2");
		}
	}

}
