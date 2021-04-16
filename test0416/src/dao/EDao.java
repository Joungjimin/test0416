package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.EDto;

public class EDao {
	private static EDao dao = new EDao();
	
	private EDao() {
		DBConnection.initConnection();
	}
	public static EDao getInstance() {
		return dao;
	}
	
	//추가 
	public boolean addEmp(EDto dto) {
		String sql = " INSERT INTO EMPLOYEES "
				+ " VALUES(?,?,?,?,?,SYSDATE,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 addEmp success");
				
			psmt = conn.prepareStatement(sql);
			System.out.println("2/3 addEmp success");
			
			psmt.setString(1, dto.getEmId());
			psmt.setString(2, dto.getFirstName());
			psmt.setString(3, dto.getLastName());
			psmt.setString(4, dto.getEmail());
			psmt.setString(5, dto.getPhoneNum());
			
			psmt.setString(6, dto.getJobId());
			psmt.setInt(7, dto.getSalary());
			psmt.setInt(8, dto.getCommissionPct());
			psmt.setString(9, dto.getManagerId());
			psmt.setInt(10, dto.getDepartmentId());
			
			count = psmt.executeUpdate();
			System.out.println("3/3 addEmp success");
			
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("addEmp fail");
		} finally {
			DBClose.close(conn, psmt, null);			
		}
		
		return count>0?true:false;
	}
	//모두 출력
	public List<EDto> findAll(){
		String sql = " SELECT * "
				+ " FROM EMPLOYEES";
		 Connection conn = null;
	      PreparedStatement psmt = null;
	      ResultSet rs = null;
	      
	      List<EDto> list = new ArrayList<EDto>();
	      
	      
	      try {
	    	    conn = DBConnection.getConnection();
				System.out.println("1/4 findAll");
				psmt = conn.prepareStatement(sql);
				System.out.println("2/4 findAll");
				rs= psmt.executeQuery();
				System.out.println("3/4 findAll");


				
			while(rs.next()) {
				String emId1 = rs.getString(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				String phoneNum = rs.getString(5);
				String DATE = rs.getString(6);
				String jobId = rs.getString(7);
				int salary = rs.getInt(8);
				int commissionPct = rs.getInt(9);
				String managerId = rs.getString(10);
				int departmentId = rs.getInt(11);
				
				EDto dto = new EDto(emId1, firstName, lastName, email, phoneNum,
						jobId,salary,commissionPct,managerId,departmentId);		
				
				list.add(dto);
				
				}
			System.out.println("4/4 NmlistNmAll");
			
		} catch (SQLException e) {
			System.out.println("NmlistNmAll fail");
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		return list;	
	}
	//수정
	public boolean updateEmp(String emId,String phoneNum) {
		String sql = " UPDATE EMPLOYEES "
				+ " SET PHONE_NUMBER =?"
				+ " WHERE EMPLOYEE_ID=?";

		Connection conn = null;
		PreparedStatement psmt = null;		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 updateEmp success");
				
			psmt = conn.prepareStatement(sql);
			System.out.println("2/3 updateEmp success");
			
			psmt.setString(1, phoneNum);
			psmt.setString(2, emId);
			
			count = psmt.executeUpdate();
			System.out.println("3/3 updateEmp success");
			
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("updateEmp fail");
		} finally {
			DBClose.close(conn, psmt, null);			
		}
		
		return count>0?true:false;
	}
	
	public EDto searchEmp(String emId) {
		String sql = " SELECT * "
				+ " FROM EMPLOYEES "
				+ " WHERE EMPLOYEE_ID=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		EDto mem = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			System.out.println("1/6 searchEmp suc");
			
			psmt.setString(1, emId);
			
			
			System.out.println("2/6 searchEmp suc");
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String emId1 = rs.getString(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				String phoneNum = rs.getString(5);
				String DATE = rs.getString(6);
				String jobId = rs.getString(7);
				int salary = rs.getInt(8);
				int commissionPct = rs.getInt(9);
				String managerId = rs.getString(10);
				int departmentId = rs.getInt(11);
				
				mem = new EDto(emId1, firstName, lastName, email, phoneNum,
						jobId,salary,commissionPct,managerId,departmentId);				
			}
			
			System.out.println("3/6 searchEmp suc");
			
		} catch (Exception e) {
			System.out.println("searchEmp fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}
				
		return mem;
	}
}
