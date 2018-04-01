package bigs_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

	private Connection conn;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "bigsjy";
	private static final String URL = "jdbc:mysql://localhost/bigs_test";

	public ItemDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("클래스 적재 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}
	}
	
	public Item selectOne(int item_no) {
		String sql = "select * from items where item_no = ?;";
		PreparedStatement pstmt = null;
		Item it = new Item();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				it.setItem_no(rs.getInt("item_no"));
				it.setItem_name(rs.getString("item_name"));
				it.setItem_desc(rs.getString("item_desc"));
				it.setItem_desc2(rs.getString("item_desc2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return it;
	}
	
	public List<String> selectCol(String colname) {
		String sql = "select " + colname + " from items;";
		PreparedStatement pstmt = null;
		List<String> list = new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			while(re.next()) {
				list.add(re.getString(colname));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/*
	public static void main(String[] args) {
		ItemDAO itemdao = new ItemDAO();
		Item it = itemdao.selectOne(1);
		System.out.println(it.getItem_no());
		System.out.println(it.getItem_name());
		System.out.println(it.getItem_desc());
		System.out.println(it.getItem_desc2());
		
		List<String> l = itemdao.selectCol("item_name");
		for(int i=0; i<l.size(); i++) {
			System.out.println(l.get(i).toString());
		}
	}
	*/
	
}
