package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Nhanvien;
import util.DBConnectionUntil;
import util.DefineUtil;
public class NhanvienDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	public ArrayList<Nhanvien> getItems() {
		ArrayList<Nhanvien> listItems = new ArrayList<>();
		conn  = DBConnectionUntil.getConnection();
		String sql = "SELECT * FROM nhanvien ORDER BY id DESC";
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Nhanvien objItem = new Nhanvien(rs.getString("name"));
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
	public int AddItem(Nhanvien nhanvien) {
		int result = 0;
		conn =DBConnectionUntil.getConnection();
		String sql = "INSERT INTO nhanvien(name) VALUES(?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, nhanvien.getName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn, rs);
		}
		return result;
	}

	public int EditItem(Nhanvien nhanvien) {
		int result = 0;
		conn =DBConnectionUntil.getConnection();
		String sql = "UPDATE nhanvien SET name =? WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, nhanvien.getName());
			pst.setInt(2, nhanvien.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn, rs);
		}
		return result;
	}
	public int DelItem(int id) {
		int result = 0;
		conn =DBConnectionUntil.getConnection();
		String sql = "DELETE FROM nhanvien WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn, rs);
		}
		return result;
	}
	public Nhanvien getItemById(int id) {
		Nhanvien nhanvien = null;
		conn  = DBConnectionUntil.getConnection();
		String sql = "SELECT * FROM nhanvien WHERE id =?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				nhanvien = new Nhanvien(rs.getString("name"));
				nhanvien.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUntil.close(pst, conn, rs);
		}
		return nhanvien;
	}
	public int getNumberOfItems() {
		int count=0;
		conn =DBConnectionUntil.getConnection();
		String sql = "SELECT COUNT(*) FROM nhanvien";
		try {
			st = conn.createStatement();
			rs= st.executeQuery(sql);
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

	public ArrayList<Nhanvien> getItemsPagination(int offset) {
		ArrayList<Nhanvien> listItems = new ArrayList<>();
		conn  = DBConnectionUntil.getConnection();
		String sql = "SELECT * FROM nhanvien LIMIT ?,?";
		
		try {
			pst =conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()) {
				Nhanvien objItem = new Nhanvien(rs.getString("name"));
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
	
	public ArrayList<Nhanvien> searchItems(String search) {
		ArrayList<Nhanvien> listItems = new ArrayList<>();
		conn  = DBConnectionUntil.getConnection();
		String sql = "SELECT * FROM nhanvien WHERE name LIKE ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + search + "%");
			rs = pst.executeQuery();
			while(rs.next()) {				
				Nhanvien objItem = new Nhanvien(rs.getString("name"));
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
