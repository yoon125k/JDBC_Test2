package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.dto.Product;
import static com.common.JDBCTemplate.*;

public class ProductDao {

	public List<Product> selectAll(Connection con) {

		List<Product> list = new ArrayList<Product>();

		PreparedStatement pstm = null;
		String sql = "SELECT * FROM PRODUCT2";

		ResultSet res = null;

		try {
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();

			while (res.next()) {
				Product p = new Product();

				p.setProduct_id(res.getString(1));
				p.setP_name(res.getString(2));
				p.setPrice(res.getInt(3));
				p.setDescription(res.getString(4));
				p.setStock(res.getInt(5));

				list.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		close(pstm);
		return list;

	}

	public Product selectOne(Connection con, String p_name) {
		PreparedStatement pstm = null;
		String sql = "SELECT * FROM PRODUCT2 WHERE P_NAME = ?";
		ResultSet rs = null;

		Product res = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p_name);
			rs = pstm.executeQuery();

			if (rs.next()) {
				res = new Product();
				res.setProduct_id(rs.getString(1));
				res.setP_name(rs.getString(2));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstm);
		return res;

	}

	public int insert(Connection con, Product dto) {

		PreparedStatement pstm = null;
		String sql = "INSERT INTO PRODUCT2 VALUES(?,?,?,?,?)";
		int res = 0;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getProduct_id());
			pstm.setString(2, dto.getP_name());
			pstm.setInt(3, dto.getPrice());
			pstm.setString(4, dto.getDescription());
			pstm.setInt(5, dto.getStock());

			res = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		close(pstm);
		return res;
	}
	
	public int update(Connection con, Product dto) {
		
		PreparedStatement pstm = null;
		String sql = "UPDATE PRODUCT2 SET P_NAME =? WHERE PRODUCT_ID=?";
		int res = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getP_name());
			pstm.setString(2, dto.getProduct_id());
			
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		close(pstm);
		}
		return res;
		
	}
	
	public int delete(Connection con, String product_id) {
		PreparedStatement pstm = null;
		String sql = "DELETE FROM PRODUCT2 WHERE PRODUCT_ID = ?";
		int res = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, product_id);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	
	}

}
