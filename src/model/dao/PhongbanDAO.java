package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Phongban;
import util.DBConnectionUntil;
import util.DefineUtil;

public class PhongbanDAO {
	private Connection conn;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public int addItem(Phongban mov) {
		int result = 0;
		conn =DBConnectionUntil.getConnection();
		String sql = "INSERT INTO phongban(name) VALUES(?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, mov.getName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn);
		}
		return result;
	}

	public ArrayList<Phongban> getItems() {
		ArrayList<Phongban> items = new ArrayList<>();
		conn = DBConnectionUntil.getConnection();
		String sql="SELECT id, name FROM phongban ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Phongban item = new Phongban(name);
				item.setId(id);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn, rs);
		}
		
		return items;
	}
	public int delItem(int id) {
		int result = 0;
		conn = DBConnectionUntil.getConnection();
		String sql="DELETE FROM phongban WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn);
		}
		
		return result;
	}
	public int getNumberOfItems() {
		int count=0;
		conn =DBConnectionUntil.getConnection();
		String sql = "SELECT COUNT(*) FROM phongban";
		try {
			st= conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn, rs);
		}
		return count;
	}

	public ArrayList<Phongban> getItemsPagination(int offset) {
		ArrayList<Phongban> listItems = new ArrayList<>();
		conn  = DBConnectionUntil.getConnection();
		String sql = "SELECT * FROM phongban LIMIT ?,?";
		
		try {
			pst =conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()) {
				Phongban objItem = new Phongban(rs.getString("name"));
				objItem.setId(rs.getInt("id"));
				listItems.add(objItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn, rs);
		}
		return listItems;
	}

	public Phongban getItemById(int id) {
		Phongban phongban = null;
		conn  = DBConnectionUntil.getConnection();
		String sql = "SELECT * FROM phongban WHERE id =?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				phongban = new Phongban(rs.getString("name"));
				phongban.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn, rs);
		}
		return phongban;
	}

	public int editItem(Phongban phongban) {
		int result = 0;
		conn =DBConnectionUntil.getConnection();
		String sql = "UPDATE phongban SET name=? WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, phongban.getName());
			pst.setInt(2, phongban.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn, rs);
		}
		return result;
	}
	
	public ArrayList<Phongban> searchItems(String search) {
		ArrayList<Phongban> listItems = new ArrayList<>();
		conn  = DBConnectionUntil.getConnection();
		String sql = "SELECT * FROM phongban WHERE name LIKE ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + search + "%");
			rs = pst.executeQuery();
			while(rs.next()) {				
				Phongban objItem = new Phongban(rs.getString("name"));
				objItem.setId(rs.getInt("id"));
				listItems.add(objItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn, rs);
		}
		return listItems;
	}
}