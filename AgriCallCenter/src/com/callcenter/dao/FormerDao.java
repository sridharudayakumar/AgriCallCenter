package com.callcenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.callcenter.dto.Former;

import com.callcenter.util.ConnectionUtil;

public class FormerDao {
	public static int insertFormer(Former former) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();

		PreparedStatement ps = null;


		String sql = "INSERT INTO formers(formerName,phoneNo,address,query,status) VALUES (?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, former.getFormerName());
		ps.setLong(2,former.getPhoneNo());
		ps.setString(3,former.getAddress());
		ps.setString(4,former.getQuery());
		ps.setString(5,former.getStatus());
		
		int result = ps.executeUpdate();
		System.out.println("new former");
		ConnectionUtil.closeConnection(ps, conn);
		return result;
	}

	public static int deleteFormer(int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from formers WHERE formerId=?";
		ps = conn.prepareStatement(sql);

		ps.setInt(1, id);

		int result = ps.executeUpdate();
		return result;
	}

	public static ArrayList<Former> listAllFormers() throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//String status = "active";

		//String sql = "SELECT * FROM users where status=?";
		String sql = "SELECT * FROM formers ";

		ps = conn.prepareStatement(sql);
		//ps.setString(1, status);
		rs = ps.executeQuery();

		ArrayList<Former> formerList = new ArrayList<Former>();
		while (rs.next()) {
			Former former = new Former();
			former.setFormerId(rs.getInt(1));
			former.setFormerName(rs.getString(2));
			former.setPhoneNo(rs.getLong(3));
			former.setAddress(rs.getString(4));
			former.setQuery(rs.getString(5));
			former.setStatus(rs.getString(6));


			formerList.add(former);

		}
		return formerList;
	}

	public static Former findOne(int formerId) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		// int status = 1;
		String sql = "SELECT * FROM formers WHERE formerId=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, formerId);

		rs = ps.executeQuery();
		Former former = new Former();
		if (rs.next()) {

			former.setFormerId(rs.getInt(1));
			former.setFormerName(rs.getString(2));
			former.setPhoneNo(rs.getLong(3));
			former.setAddress(rs.getString(4));
			former.setQuery(rs.getString(5));
			former.setStatus(rs.getString(6));


		}

		return former;
	}

	public static int updateFormer(Former former, int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE formers SET formerName=?,phoneNo=?,address=?,query=?,status=? WHERE formerId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, former.getFormerName());
		ps.setLong(2,former.getPhoneNo());
		ps.setString(3,former.getAddress());
		ps.setString(4,former.getQuery());
		ps.setString(5,former.getStatus());
		
		ps.setInt(6, id);

		int result = ps.executeUpdate();
		return result;
	}

	public static ArrayList<Former> listAllPendingInquiries() throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String status = "Pending";

		String sql = "SELECT * FROM formers where status=?";
		//String sql = "SELECT * FROM formers ";

		ps = conn.prepareStatement(sql);
		ps.setString(1, status);
		rs = ps.executeQuery();

		ArrayList<Former> formerList = new ArrayList<Former>();
		while (rs.next()) {
			Former former = new Former();
			former.setFormerId(rs.getInt(1));
			former.setFormerName(rs.getString(2));
			former.setPhoneNo(rs.getLong(3));
			former.setAddress(rs.getString(4));
			former.setQuery(rs.getString(5));
			former.setStatus(rs.getString(6));


			formerList.add(former);

		}
		return formerList;
	}

	public static int updateFormerStatus(int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE formers SET status=? WHERE formerId=?";
		ps = conn.prepareStatement(sql);
		
		ps.setString(1,"Answered");
		
		ps.setInt(2, id);

		int result = ps.executeUpdate();
		return result;
	}

}
