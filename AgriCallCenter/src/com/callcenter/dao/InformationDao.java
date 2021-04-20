package com.callcenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.callcenter.dto.Information;
import com.callcenter.util.ConnectionUtil;

public class InformationDao {

	public static int insertInformation(Information information) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();

		PreparedStatement ps = null;


		String sql = "INSERT INTO informations(category,title,description) VALUES (?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, information.getCategory());
		ps.setString(2,information.getTitle());
		
		ps.setString(3,information.getDescription());
		
		
		int result = ps.executeUpdate();
		System.out.println("new information");
		ConnectionUtil.closeConnection(ps, conn);
		return result;
	}

	public static int deleteInformation(int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from informations WHERE infoId=?";
		ps = conn.prepareStatement(sql);

		ps.setInt(1, id);

		int result = ps.executeUpdate();
		return result;
	}

	public static ArrayList<Information> listAllInformations() throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		

		
		String sql = "SELECT * FROM informations ";

		ps = conn.prepareStatement(sql);
		
		rs = ps.executeQuery();

		ArrayList<Information> informationList = new ArrayList<Information>();
		while (rs.next()) {
			Information information = new Information();
			information.setInfoId(rs.getInt(1));
			information.setCategory(rs.getString(2));
			information.setTitle(rs.getString(3));
			information.setDescription(rs.getString(4));
			


			informationList.add(information);

		}
		return informationList;
	}

	public static Information findOne(int infoId) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		// int status = 1;
		String sql = "SELECT * FROM informations WHERE infoId=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, infoId);

		rs = ps.executeQuery();
		Information information = new Information();
		if (rs.next()) {

			information.setInfoId(rs.getInt(1));
			information.setCategory(rs.getString(2));
			information.setTitle(rs.getString(3));
			information.setDescription(rs.getString(4));


		}

		return information;
	}

	public static int updateInformation(Information information, int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE informations SET category=?,title=?,description=? WHERE infoId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, information.getCategory());
		ps.setString(2,information.getTitle());
		ps.setString(3,information.getDescription());
		ps.setInt(4, id);

		int result = ps.executeUpdate();
		return result;
	}

	public static ArrayList<Information> listAllInformationsByCategory(String category) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		

		
		String sql = "SELECT * FROM informations where category=?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, category);
		rs = ps.executeQuery();

		ArrayList<Information> informationList = new ArrayList<Information>();
		while (rs.next()) {
			Information information = new Information();
			information.setInfoId(rs.getInt(1));
			information.setCategory(rs.getString(2));
			information.setTitle(rs.getString(3));
			information.setDescription(rs.getString(4));
			


			informationList.add(information);

		}
		return informationList;
	}

	

	
}
