package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcSelect2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("작성자 id: ");
		String writerId = scanner.nextLine();
		
		
		Connection con = DBConnection.getInstance().getConnection();
		String sql = "select * from board_mst where writer_id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writerId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " | " 
			+ rs.getString(2) + " | " 
			+ rs.getString(3) + " | "
			+ rs.getInt(4) + " | "
			+ rs.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}









